package gregtech.common.blocks.wood;

import com.google.common.collect.Lists;
import gregtech.api.GregTechAPI;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.blocks.wood.BlockRubberLog.LogVariant;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Random;

public class BlockRubberLeaves extends BlockLeaves {

    public static final PropertyEnum<LogVariant> VARIANT = PropertyEnum.create("variant", LogVariant.class);

    public BlockRubberLeaves() {
        setDefaultState(this.blockState.getBaseState()
            .withProperty(VARIANT, LogVariant.RUBBER_WOOD)
            .withProperty(CHECK_DECAY, Boolean.TRUE)
            .withProperty(DECAYABLE, Boolean.TRUE));
        setUnlocalizedName("gt.leaves");
        this.setCreativeTab(GregTechAPI.TAB_GREGTECH);
        this.leavesFancy = true;
   }

    @Override
    public EnumType getWoodType(int meta) {
        return null;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, DECAYABLE, CHECK_DECAY, VARIANT);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState()
            .withProperty(CHECK_DECAY, meta / 8 >= 1)
            .withProperty(DECAYABLE, meta % 8 / 4 == 1)
            .withProperty(VARIANT, LogVariant.values()[meta % 8 % 4 % LogVariant.values().length]);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return (state.getValue(CHECK_DECAY) ? 8 : 0) +
            (state.getValue(DECAYABLE) ? 4 : 0) +
            state.getValue(VARIANT).ordinal();
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(MetaBlocks.SAPLING);
    }

    @Override
    public int damageDropped(IBlockState state) {
        return state.getValue(VARIANT).ordinal();
    }

    @Override
    protected ItemStack getSilkTouchDrop(IBlockState state) {
        return new ItemStack(this, 1, state.getValue(VARIANT).ordinal());
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(this, 1, state.getValue(VARIANT).ordinal());
    }

    @Nonnull
    @Override
    public List<ItemStack> onSheared(@Nonnull ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        return Lists.newArrayList(new ItemStack(this, 1, world.getBlockState(pos).getValue(VARIANT).ordinal()));
    }
}