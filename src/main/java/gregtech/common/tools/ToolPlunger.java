package gregtech.common.tools;

import gregtech.api.items.metaitem.MetaItem.MetaValueItem;
import gregtech.common.items.behaviors.PlungerBehaviour;
import net.minecraft.item.ItemStack;

public class ToolPlunger extends ToolBase {

    @Override
    public void onStatsAddedToTool(MetaValueItem metaValueItem) {
        metaValueItem.addStats(new PlungerBehaviour(2));
    }

    @Override
    public int getToolDamagePerBlockBreak(ItemStack stack) {
        return 1;
    }

    @Override
    public int getToolDamagePerContainerCraft(ItemStack stack) {
        return 4;
    }

    @Override
    public float getBaseDamage(ItemStack stack) {
        return 2.0F;
    }

}