package gregtech.api.capability.impl;

import gregtech.api.capability.GregtechCapabilities;
import gregtech.api.capability.IElectricItem;
import gregtech.api.capability.IEnergyContainer;
import gregtech.api.metatileentity.MTETrait;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.util.GTUtility;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.items.IItemHandlerModifiable;

import java.util.function.Predicate;

public class EnergyContainerHandler extends MTETrait implements IEnergyContainer {

    private final long maxCapacity;
    private long energyStored;

    private final long maxInputVoltage;
    private final long maxInputAmperage;

    private final long maxOutputVoltage;
    private final long maxOutputAmperage;

    private Predicate<EnumFacing> sideInputCondition;
    private Predicate<EnumFacing> sideOutputCondition;

    public EnergyContainerHandler(MetaTileEntity tileEntity, long maxCapacity, long maxInputVoltage, long maxInputAmperage, long maxOutputVoltage, long maxOutputAmperage) {
        super(tileEntity);
        this.maxCapacity = maxCapacity;
        this.maxInputVoltage = maxInputVoltage;
        this.maxInputAmperage = maxInputAmperage;
        this.maxOutputVoltage = maxOutputVoltage;
        this.maxOutputAmperage = maxOutputAmperage;
    }

    public void setSideInputCondition(Predicate<EnumFacing> sideInputCondition) {
        this.sideInputCondition = sideInputCondition;
    }

    public void setSideOutputCondition(Predicate<EnumFacing> sideOutputCondition) {
        this.sideOutputCondition = sideOutputCondition;
    }

    public static EnergyContainerHandler emitterContainer(MetaTileEntity tileEntity, long maxCapacity, long maxOutputVoltage, long maxOutputAmperage) {
        return new EnergyContainerHandler(tileEntity, maxCapacity, 0L, 0L, maxOutputVoltage, maxOutputAmperage);
    }

    public static EnergyContainerHandler receiverContainer(MetaTileEntity tileEntity, long maxCapacity, long maxInputVoltage, long maxInputAmperage) {
        return new EnergyContainerHandler(tileEntity, maxCapacity, maxInputVoltage, maxInputAmperage, 0L, 0L);
    }

    @Override
    public String getName() {
        return "EnergyContainer";
    }

    @Override
    public int getNetworkID() {
        return TraitNetworkIds.TRAIT_ID_ENERGY_CONTAINER;
    }

    @Override
    public <T> T getCapability(Capability<T> capability) {
        if(capability == GregtechCapabilities.CAPABILITY_ENERGY_CONTAINER) {
            return GregtechCapabilities.CAPABILITY_ENERGY_CONTAINER.cast(this);
        }
        return null;
    }

    @Override
    public NBTTagCompound serializeNBT() {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setLong("EnergyStored", energyStored);
        return compound;
    }

    @Override
    public void deserializeNBT(NBTTagCompound compound) {
        this.energyStored = compound.getLong("EnergyStored");
        notifyEnergyListener(true);
    }

    @Override
    public long getCurrentEnergyStored() {
        return this.energyStored;
    }

    public void setEnergyStored(long energyStored) {
        this.energyStored = energyStored;
        if(!metaTileEntity.getWorld().isRemote) {
            metaTileEntity.markDirty();
            notifyEnergyListener(false);
        }
    }

    protected void notifyEnergyListener(boolean isInitialChange) {
        if(metaTileEntity instanceof IEnergyChangeListener) {
            ((IEnergyChangeListener) metaTileEntity).onEnergyChanged(this, isInitialChange);
        }
    }

    public boolean dischargeOrRechargeEnergyContainers(IItemHandlerModifiable itemHandler, int slotIndex) {
        ItemStack stackInSlot = itemHandler.getStackInSlot(slotIndex);
        if(stackInSlot.isEmpty()) {
            return false;
        }
        IElectricItem electricItem = stackInSlot.getCapability(GregtechCapabilities.CAPABILITY_ELECTRIC_ITEM, null);
        if(electricItem == null || !electricItem.canProvideChargeExternally()) {
            return false;
        }
        int machineTier = GTUtility.getTierByVoltage(Math.max(getInputVoltage(), getOutputVoltage()));
        if(getEnergyCanBeInserted() > 0) {
            double chargePercent = getCurrentEnergyStored() / (getEnergyCapacity() * 1.0);
            if(chargePercent <= 0.5) {
                long dischargedBy = electricItem.discharge(getEnergyCanBeInserted(), machineTier, false, true, false);
                addEnergy(dischargedBy);
                return dischargedBy > 0L;

            } 
            else if (chargePercent >= 0.9) {
                long chargedBy = electricItem.charge(getCurrentEnergyStored(), machineTier, false, false);
                removeEnergy(chargedBy);
                return chargedBy > 0L;
            }
        }
        return false;
    }

    @Override
    public void update() {
        if (getMetaTileEntity().getWorld().isRemote)
            return;
        if(getCurrentEnergyStored() >= getOutputVoltage() && getOutputVoltage() > 0 && getOutputAmperage() > 0) {
            long outputVoltage = getOutputVoltage();
            long outputAmperes = Math.min(getCurrentEnergyStored() / outputVoltage, getOutputAmperage());
            if(outputAmperes == 0) return;
            long amperesUsed = 0;
            for(EnumFacing side : EnumFacing.VALUES) {
                if(!outputsEnergy(side)) continue;
                TileEntity tileEntity = metaTileEntity.getWorld().getTileEntity(metaTileEntity.getPos().offset(side));
                EnumFacing oppositeSide = side.getOpposite();
                if(tileEntity != null && tileEntity.hasCapability(GregtechCapabilities.CAPABILITY_ENERGY_CONTAINER, oppositeSide)) {
                    IEnergyContainer energyContainer = tileEntity.getCapability(GregtechCapabilities.CAPABILITY_ENERGY_CONTAINER, oppositeSide);
                    if(energyContainer == null || !energyContainer.inputsEnergy(oppositeSide)) continue;
                    amperesUsed += energyContainer.acceptEnergyFromNetwork(oppositeSide, outputVoltage, outputAmperes - amperesUsed);
                    if(amperesUsed == outputAmperes) break;
                }
            }
            if(amperesUsed > 0) {
                setEnergyStored(getCurrentEnergyStored() - amperesUsed * outputVoltage);
            }
        }
    }

    @Override
    public long acceptEnergyFromNetwork(EnumFacing side, long voltage, long amperage) {
        long canAccept = getEnergyCapacity() - getCurrentEnergyStored();
        if(voltage > 0L && amperage > 0L && (side == null || inputsEnergy(side))) {
            if(voltage > getInputVoltage()) {
                GTUtility.doOvervoltageExplosion(metaTileEntity, voltage);
                return Math.min(amperage, getInputAmperage());
            }
            if(canAccept >= voltage) {
                long amperesAccepted = Math.min(canAccept / voltage, Math.min(amperage, getInputAmperage()));
                if(amperesAccepted > 0) {
                    setEnergyStored(getCurrentEnergyStored() + voltage * amperesAccepted);
                    return amperesAccepted;
                }
            }
        }
        return 0;
    }

    @Override
    public long getEnergyCapacity() {
        return this.maxCapacity;
    }

    @Override
    public boolean inputsEnergy(EnumFacing side) {
        return !outputsEnergy(side) && getInputVoltage() > 0 && (sideInputCondition == null || sideInputCondition.test(side));
    }

    @Override
    public boolean outputsEnergy(EnumFacing side) {
        return getOutputVoltage() > 0 && (sideOutputCondition == null || sideOutputCondition.test(side));
    }

    @Override
    public long changeEnergy(long energyToAdd) {
        long oldEnergyStored = getCurrentEnergyStored();
        long newEnergyStored = (maxCapacity - oldEnergyStored < energyToAdd) ? maxCapacity : (oldEnergyStored + energyToAdd);
        if(newEnergyStored < 0)
            newEnergyStored = 0;
        setEnergyStored(newEnergyStored);
        return newEnergyStored - oldEnergyStored;
    }

    @Override
    public long getOutputVoltage() {
        return this.maxOutputVoltage;
    }

    @Override
    public long getOutputAmperage() {
        return this.maxOutputAmperage;
    }

    @Override
    public long getInputAmperage() {
        return this.maxInputAmperage;
    }

    @Override
    public long getInputVoltage() {
        return this.maxInputVoltage;
    }

    public interface IEnergyChangeListener {
        void onEnergyChanged(IEnergyContainer container, boolean isInitialChange);
    }
}
