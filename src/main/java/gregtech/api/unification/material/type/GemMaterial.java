package gregtech.api.unification.material.type;

import com.google.common.collect.ImmutableList;
import gregtech.api.unification.Element;
import gregtech.api.unification.material.MaterialIconSet;
import gregtech.api.unification.material.type.DustMaterial.MatFlags;
import gregtech.api.unification.stack.MaterialStack;

import static gregtech.api.util.GTUtility.createFlag;

public class GemMaterial extends SolidMaterial {

    public static final class MatFlags {    
        /**
         * If this material is crystallisable
         */
        public static final long CRYSTALLISABLE = createFlag(34);

        public static final long GENERATE_LENSE = createFlag(37);
        
        static {
            Material.MatFlags.registerMaterialFlagsHolder(MatFlags.class, GemMaterial.class);
        }

    }

    public GemMaterial(int metaItemSubId, String name, int materialRGB, MaterialIconSet materialIconSet, int harvestLevel, ImmutableList<MaterialStack> materialComponents, long materialGenerationFlags, Element element, float toolSpeed, float attackDamage, int toolDurability) {
        super(metaItemSubId, name, materialRGB, materialIconSet, harvestLevel, materialComponents, materialGenerationFlags, element, toolSpeed, attackDamage, toolDurability);
    }

    public GemMaterial(int metaItemSubId, String name, int materialRGB, MaterialIconSet materialIconSet, int harvestLevel, ImmutableList<MaterialStack> materialComponents, long materialGenerationFlags, float toolSpeed, float attackDamage, int toolDurability) {
        super(metaItemSubId, name, materialRGB, materialIconSet, harvestLevel, materialComponents, materialGenerationFlags, null, toolSpeed, attackDamage, toolDurability);
    }

    public GemMaterial(int metaItemSubId, String name, int materialRGB, MaterialIconSet materialIconSet, int harvestLevel, ImmutableList<MaterialStack> materialComponents, long materialGenerationFlags) {
        super(metaItemSubId, name, materialRGB, materialIconSet, harvestLevel, materialComponents, materialGenerationFlags, null, 0, 0, 0);
    }

    @Override
    protected long verifyMaterialBits(long generationBits) {
        if((generationBits & MatFlags.GENERATE_LENSE) > 0) {
            generationBits |= DustMaterial.MatFlags.GENERATE_PLATE;
        }
        return super.verifyMaterialBits(generationBits);
    }
    
    @Override
    public boolean shouldGenerateFluid() {
        return true;
    }
}