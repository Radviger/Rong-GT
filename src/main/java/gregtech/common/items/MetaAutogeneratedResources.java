package gregtech.common.items;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gregtech.api.items.materialitem.MaterialMetaItem;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.type.Material;
import gregtech.api.unification.ore.OrePrefix;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;

public class MetaAutogeneratedResources extends MaterialMetaItem {
	
	public MetaAutogeneratedResources() {
        super(OrePrefix.dustTiny, OrePrefix.dustSmall, OrePrefix.dust, OrePrefix.dustImpure, OrePrefix.dustPure,
            OrePrefix.crushed, OrePrefix.crushedPurified, OrePrefix.crushedCentrifuged, OrePrefix.gem, OrePrefix.nugget,
            OrePrefix.ingot, OrePrefix.ingotHot, OrePrefix.plateDense);
        
        registerPurifyRecipes();
    }
	
	public final Map<OrePrefix, OrePrefix> purifyMap = new HashMap<>();
	
	private void registerPurifyRecipes() {
        purifyMap.put(OrePrefix.crushed, OrePrefix.crushedCentrifuged);
        purifyMap.put(OrePrefix.dustImpure, OrePrefix.dust);
    }
	
	@Override
    public boolean onEntityItemUpdate(EntityItem itemEntity) {
        int damage = itemEntity.getItem().getMetadata();
        if (damage >= this.metaItemOffset || itemEntity.getEntityWorld().isRemote)
            return false;
        Material material = Material.MATERIAL_REGISTRY.getObjectById(damage % 1000);
        OrePrefix prefix = this.orePrefixes[(damage / 1000)];
        if (!purifyMap.containsKey(prefix))
            return false;
        BlockPos blockPos = new BlockPos(itemEntity);
        IBlockState blockState = itemEntity.getEntityWorld().getBlockState(blockPos);
        int waterLevel = blockState.getBlock() instanceof BlockCauldron ?
            blockState.getValue(BlockCauldron.LEVEL) : 0;
        if(waterLevel == 0)
            return false;
        itemEntity.getEntityWorld().setBlockState(blockPos,
            blockState.withProperty(BlockCauldron.LEVEL, waterLevel - 1));
        ItemStack replacementStack = OreDictUnifier.get(purifyMap.get(prefix), material,
            itemEntity.getItem().getCount());
        itemEntity.setItem(replacementStack);
        return false;
    }

    @Override
    protected void addMaterialTooltip(ItemStack itemStack, OrePrefix prefix, Material material, List<String> lines, ITooltipFlag tooltipFlag) {
        if (prefix == OrePrefix.dustImpure || prefix == OrePrefix.dustPure) {
            lines.add(I18n.format("metaitem.dust.tooltip.purify"));
        }
}

}
