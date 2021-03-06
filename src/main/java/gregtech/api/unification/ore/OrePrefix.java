package gregtech.api.unification.ore;

import com.google.common.base.Preconditions;

import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.MaterialIconType;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.type.*;
import gregtech.api.unification.stack.MaterialStack;
import gregtech.api.util.GTUtility;
import gregtech.api.recipes.ModHandler;

import net.minecraft.client.resources.I18n;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.Validate;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

import static gregtech.api.GTValues.M;
import static gregtech.api.unification.material.type.DustMaterial.MatFlags.*;
import static gregtech.api.unification.material.type.GemMaterial.MatFlags.GENERATE_LENSE;
import static gregtech.api.unification.material.type.IngotMaterial.MatFlags.*;
import static gregtech.api.unification.material.type.SolidMaterial.MatFlags.*;
import static gregtech.api.unification.ore.OrePrefix.Conditions.isToolMaterial;
import static gregtech.api.unification.ore.OrePrefix.Flags.*;

public enum OrePrefix {

    //oreSand("Sand Ores", -1, null, MaterialIconType.ore, ENABLE_UNIFICATION | DISALLOW_RECYCLING, mat -> mat.hasFlag(GENERATE_ORE)), // In case of an Sand-Ores Mod. Ore -> Material is a Oneway Operation!
    oreGravel("Gravel Ores", -1, null, MaterialIconType.ore, ENABLE_UNIFICATION | DISALLOW_RECYCLING, mat -> mat.hasFlag(GENERATE_ORE)), // In case of an Gravel-Ores Mod. Ore -> Material is a Oneway Operation!
    
    oreStone("Stone Ores", -1, null, MaterialIconType.ore, ENABLE_UNIFICATION | DISALLOW_RECYCLING, mat -> mat.hasFlag(GENERATE_ORE)), // In case of an Gravel-Ores Mod. Ore -> Material is a Oneway Operation!

    oreNetherrack("Netherrack Ores", -1, null, MaterialIconType.ore, ENABLE_UNIFICATION | DISALLOW_RECYCLING, (mat) -> mat instanceof DustMaterial && mat.hasFlag(GENERATE_ORE)), // Prefix of the Nether-Ores Mod. Causes Ores to double. Ore -> Material is a Oneway Operation!
    //oreNether("Nether Ores", -1, null, MaterialIconType.ore, ENABLE_UNIFICATION | DISALLOW_RECYCLING, null), // Prefix of the Nether-Ores Mod. Causes Ores to double. Ore -> Material is a Oneway Operation!

    oreEndstone("Endstone Ores", -1, null, MaterialIconType.ore, ENABLE_UNIFICATION | DISALLOW_RECYCLING, (mat) -> mat.hasFlag(GENERATE_ORE)), // In case of an End-Ores Mod. Ore -> Material is a Oneway Operation!
    //oreEnd("End Ores", -1,null,  MaterialIconType.ore, ENABLE_UNIFICATION | DISALLOW_RECYCLING, null), // In case of an End-Ores Mod. Ore -> Material is a Oneway Operation!
    
    oreSandstone("Sandstone Ores", -1, null, MaterialIconType.ore, ENABLE_UNIFICATION | DISALLOW_RECYCLING, (mat) -> mat.hasFlag(GENERATE_ORE)), // In case of an End-Ores Mod. Ore -> Material is a Oneway Operation!
    //oreRedSandstone("Red Sandstone Ores", -1, null, MaterialIconType.ore, ENABLE_UNIFICATION | DISALLOW_RECYCLING, (mat) -> mat.hasFlag(GENERATE_ORE)), // In case of an End-Ores Mod. Ore -> Material is a Oneway Operation!

    ore("Ores", -1, null, MaterialIconType.ore, ENABLE_UNIFICATION | DISALLOW_RECYCLING, (mat) -> mat.hasFlag(GENERATE_ORE)),
    
    crushedCentrifuged("Centrifuged Ores", -1, null, MaterialIconType.crushedCentrifuged, ENABLE_UNIFICATION | DISALLOW_RECYCLING, (mat) -> mat.hasFlag(GENERATE_ORE)),
    crushedPurified("Purified Ores", -1, null, MaterialIconType.crushedPurified, ENABLE_UNIFICATION | DISALLOW_RECYCLING, (mat) -> mat.hasFlag(GENERATE_ORE)),
    crushed("Crushed Ores", -1, null, MaterialIconType.crushed, ENABLE_UNIFICATION | DISALLOW_RECYCLING, (mat) -> mat.hasFlag(GENERATE_ORE)),
    
    cluster("Native Ore Clusters", -1, null, MaterialIconType.cluster, ENABLE_UNIFICATION | DISALLOW_RECYCLING, (mat) -> mat.hasFlag(GENERATE_ORE)),
    
    //Mekanism
    shard("Crystallised Shards", -1, null, MaterialIconType.shard, ENABLE_UNIFICATION | DISALLOW_RECYCLING, (mat) -> mat.hasFlag(GENERATE_ORE)),
    clump("Clumps", -1, null, MaterialIconType.clump, ENABLE_UNIFICATION | DISALLOW_RECYCLING, (mat) -> mat.hasFlag(GENERATE_ORE)),
    crystal("Crystals", -1, null, MaterialIconType.crystal, ENABLE_UNIFICATION | DISALLOW_RECYCLING, (mat) -> mat.hasFlag(GENERATE_ORE)),
    dustDirty("Dirty Dusts", -1, null, MaterialIconType.dustDirty, ENABLE_UNIFICATION | DISALLOW_RECYCLING, (mat) -> mat.hasFlag(GENERATE_ORE)),
    
    ingotHot("Hot Ingots", M, null, MaterialIconType.ingotHot, ENABLE_UNIFICATION | DISALLOW_RECYCLING, mat -> (mat instanceof IngotMaterial) && ((IngotMaterial) mat).blastFurnaceTemperature > 1750), // A hot Ingot, which has to be cooled down by a Vacuum Freezer.
    ingot("Ingots", M, null, MaterialIconType.ingot, ENABLE_UNIFICATION | DISALLOW_RECYCLING, mat -> mat instanceof IngotMaterial), // A regular Ingot. Introduced by Eloraam

    gem("Gemstones", M, null, MaterialIconType.gem, ENABLE_UNIFICATION, mat -> mat instanceof GemMaterial), // A regular Gem worth one Dust. Introduced by Eloraam

    dustTiny("Tiny Dusts", M / 9, null, MaterialIconType.dustTiny, ENABLE_UNIFICATION | DISALLOW_RECYCLING, mat -> mat instanceof DustMaterial), // 1/9th of a Dust.
    dustSmall("Small Dusts", M / 4, null, MaterialIconType.dustSmall, ENABLE_UNIFICATION | DISALLOW_RECYCLING, mat -> mat instanceof DustMaterial), // 1/4th of a Dust.
    dustImpure("Impure Dusts", M, null, MaterialIconType.dustImpure, ENABLE_UNIFICATION | DISALLOW_RECYCLING, mat -> mat.hasFlag(GENERATE_ORE)), // Dust with impurities. 1 Unit of Main Material and 1/9 - 1/4 Unit of secondary Material
    dustPure("Purified Dusts", M, null, MaterialIconType.dustPure, ENABLE_UNIFICATION | DISALLOW_RECYCLING, mat -> mat.hasFlag(GENERATE_ORE)),
    dust("Dusts", M, null, MaterialIconType.dust, ENABLE_UNIFICATION | DISALLOW_RECYCLING, mat -> mat instanceof DustMaterial), // Pure Dust worth of one Ingot or Gem. Introduced by Alblaka.

    nugget("Nuggets", M / 9, null, MaterialIconType.nugget, ENABLE_UNIFICATION | DISALLOW_RECYCLING, mat -> mat instanceof IngotMaterial), // A Nugget. Introduced by Eloraam

    plate("Plates", M, null, MaterialIconType.plate, ENABLE_UNIFICATION, mat -> mat instanceof DustMaterial && mat.hasFlag(GENERATE_PLATE)), // Regular Plate made of one Ingot/Dust. Introduced by Calclavia
    plateDense("Dense Plates", M * 9, null, MaterialIconType.plateDense, ENABLE_UNIFICATION, mat -> mat.hasFlag(GENERATE_PLATE | GENERATE_DENSE) && !mat.hasFlag(NO_SMASHING)), // 9 Plates combined in one Item.

    foil("Foils", M / 4, null, MaterialIconType.foil, ENABLE_UNIFICATION, mat -> mat instanceof IngotMaterial && mat.hasFlag(GENERATE_FOIL)), // Foil made of 1/4 Ingot/Dust.

    //stickLong("Long Sticks/Rods", M, null, MaterialIconType.stickLong, ENABLE_UNIFICATION, mat -> mat instanceof SolidMaterial && mat.hasFlag(GENERATE_LONG_ROD)), // Stick made of an Ingot.
    stick("Sticks/Rods", M / 2, null, MaterialIconType.stick, ENABLE_UNIFICATION, mat -> mat instanceof SolidMaterial && mat.hasFlag(GENERATE_ROD)), // Stick made of half an Ingot. Introduced by Eloraam

    screw("Screws", M / 9, null, MaterialIconType.screw, ENABLE_UNIFICATION, mat -> mat instanceof IngotMaterial && mat.hasFlag(GENERATE_SCREW)),

    ring("Rings", M / 4, null, MaterialIconType.ring, ENABLE_UNIFICATION, mat -> mat instanceof SolidMaterial && mat.hasFlag(GENERATE_RING)), // consisting out of 1/2 Stick.

    spring("Springs", M, null, MaterialIconType.spring, ENABLE_UNIFICATION, mat -> mat instanceof IngotMaterial && mat.hasFlag(GENERATE_SPRING)), // consisting out of 2 Sticks.
    
    wireFine("Fine Wires", M / 8, null, MaterialIconType.wireFine, ENABLE_UNIFICATION, mat -> mat instanceof IngotMaterial && mat.hasFlag(GENERATE_FINE_WIRE)), // consisting out of 1/8 Ingot or 1/4 Wire.

    rotor("Rotors", M * 4 + M / 4, null, MaterialIconType.rotor, ENABLE_UNIFICATION, mat -> mat instanceof IngotMaterial && mat.hasFlag(GENERATE_ROTOR)), // consisting out of 4 Plates, 1 Ring and 1 Screw.

    gearSmall("Small Gears", M, null, MaterialIconType.gearSmall, ENABLE_UNIFICATION, mat -> mat instanceof IngotMaterial && mat.hasFlag(GENERATE_SMALL_GEAR)),
    gear("Gears", M * 4, null, MaterialIconType.gear, ENABLE_UNIFICATION, mat -> mat instanceof SolidMaterial && mat.hasFlag(GENERATE_GEAR)),

    lens("Lenses", (M * 3) / 4, null, MaterialIconType.lens, ENABLE_UNIFICATION, mat -> mat.hasFlag(GENERATE_LENSE)), // 3/4 of a Plate used to shape a Lense.

    toolHeadFile("File Heads", M * 2, null, MaterialIconType.toolHeadFile, ENABLE_UNIFICATION, isToolMaterial), // made of 2 Ingots.
    toolHeadHammer("Hammer Heads", M * 6, null, MaterialIconType.toolHeadHammer, ENABLE_UNIFICATION, isToolMaterial), // made of 6 Ingots.
    toolHeadSaw("Saw Blades", M * 2, null, MaterialIconType.toolHeadSaw, ENABLE_UNIFICATION, isToolMaterial), // made of 2 Ingots.
    toolHeadBuzzSaw("Buzzsaw Blades", M * 4, null, MaterialIconType.toolHeadBuzzSaw, ENABLE_UNIFICATION, isToolMaterial), // made of 4 Ingots.
    toolHeadScrewdriver("Screwdriver Tips", M, null, MaterialIconType.toolHeadScrewdriver, ENABLE_UNIFICATION, isToolMaterial), // made of 1 Ingot.
    toolHeadWrench("Wrench Tips", M * 4, null, MaterialIconType.toolHeadWrench, ENABLE_UNIFICATION, isToolMaterial), // made of 4 Ingots.

    turbineBlade("Turbine Blades", M * 4, null, MaterialIconType.turbineBlade, ENABLE_UNIFICATION, isToolMaterial), // made of 4 Ingots.

    glass("Glasses", -1, Materials.Glass, null, SELF_REFERENCING | DISALLOW_RECYCLING, null),
    paneGlass("Glass Panes", -1, MarkerMaterials.Color.Colorless, null, SELF_REFERENCING | DISALLOW_RECYCLING, null),
    blockGlass("Glass Blocks", -1, MarkerMaterials.Color.Colorless, null, SELF_REFERENCING | DISALLOW_RECYCLING, null),

    blockWool("Wool Blocks", -1, MarkerMaterials.Color.Colorless, null, SELF_REFERENCING | DISALLOW_RECYCLING, null),

    block("Storage Blocks", M * 9, null, MaterialIconType.block, ENABLE_UNIFICATION, null), // Storage Block consisting out of 9 Ingots/Gems/Dusts. Introduced by CovertJaguar

    craftingTool("Crafting Tools", -1, null, null, DISALLOW_RECYCLING, null), // Special Prefix used mainly for the Crafting Handler.
    craftingLens("Crafting Ingredients", -1, null, null, DISALLOW_RECYCLING, null), // Special Prefix used mainly for the Crafting Handler.

    log("Logs", -1, null, null, DISALLOW_RECYCLING, null), // Prefix used for Logs. Usually as "logWood". Introduced by Eloraam
    plank("Planks", -1, null, null, DISALLOW_RECYCLING, null), // Prefix for Planks. Usually "plankWood". Introduced by Eloraam
    stone("Stones", -1, Materials.Stone, null, SELF_REFERENCING | DISALLOW_RECYCLING, null), // Prefix to determine which kind of Rock this is.
    cobblestone("Cobblestones", -1, Materials.Stone, null, SELF_REFERENCING | DISALLOW_RECYCLING, null),
    rock("Rocks", -1, Materials.Stone, null, SELF_REFERENCING | DISALLOW_RECYCLING, null), // Prefix to determine which kind of Rock this is.
    stoneCobble("Cobblestones", -1, Materials.Stone, null, SELF_REFERENCING | DISALLOW_RECYCLING, null),

    book("Books", -1, null, null, DISALLOW_RECYCLING, null), // Used for Books of any kind.
    paper("Papers", -1, null, null, DISALLOW_RECYCLING, null), // Used for Papers of any kind.
    dye("Dyes", -1, null, null, DISALLOW_RECYCLING, null), // Used for the 16 dyes. Introduced by Eloraam
    stainedClay("Stained Clays", -1, MarkerMaterials.Color.Colorless, null, SELF_REFERENCING | DISALLOW_RECYCLING, null), // Used for the 16 colors of Stained Clay. Introduced by Forge
    
    frameGt("Frame Boxes", (long) (M * 1.375), null, null, ENABLE_UNIFICATION, material -> material instanceof IngotMaterial && material.hasFlag(GENERATE_ROD | GENERATE_PLATE)),
    
    pipeTiny("Tiny Pipes", M / 2, null, MaterialIconType.pipeTiny, ENABLE_UNIFICATION, null),
    pipeSmall("Small Pipes", M, null, MaterialIconType.pipeSmall, ENABLE_UNIFICATION, null),
    pipeMedium("Medium Pipes", M * 3, null, MaterialIconType.pipeMedium, ENABLE_UNIFICATION, null),
    pipeLarge("Large pipes", M * 6, null, MaterialIconType.pipeLarge, ENABLE_UNIFICATION, null),

    pipe("Pipes", -1, null, null, DISALLOW_RECYCLING, null),

    wireGtHex("Hex wires", M * 8, null, null, ENABLE_UNIFICATION, null),
    wireGtOctal("Octal wires", M * 4, null, null, ENABLE_UNIFICATION, null),
    wireGtQuadruple("Quadruple wires", M * 2, null, null, ENABLE_UNIFICATION, null),
    wireGtDouble("Double wires", M, null, null, ENABLE_UNIFICATION, null),
    wireGtSingle("Single wires", M / 2, null, null, ENABLE_UNIFICATION, null),

    cableGtHex("Hex cables", M * 8, null, null, ENABLE_UNIFICATION, null),
    cableGtOctal("Octal cables", M * 4, null, null, ENABLE_UNIFICATION, null),
    cableGtQuadruple("Quadruple cables", M * 2, null, null, ENABLE_UNIFICATION, null),
    cableGtDouble("Double cables", M, null, null, ENABLE_UNIFICATION, null),
    cableGtSingle("Single cables", M / 2, null, null, ENABLE_UNIFICATION, null),

    /* Electric Components.
     *
	 * usual Materials for this are:
	 * Primitive (Tier 1)
	 * Basic (Tier 2)
	 * Good (Tier 3)
	 * Advanced (Tier 4)
	 * Data (Tier 5)
	 * Elite (Tier 6)
	 * Master (Tier 7)
	 * Ultimate (Tier 8)
	 * Infinite
	 */
    batterySingleUse("Single Use Batteries", -1, null, null, DISALLOW_RECYCLING, null),
    battery("Reusable Batteries", -1, null, null, DISALLOW_RECYCLING, null), // Introduced by Calclavia
    circuit("Circuits", -1, null, null, ENABLE_UNIFICATION | DISALLOW_RECYCLING, null), // Introduced by Calclavia
    chipset("Chipsets", -1, null, null, ENABLE_UNIFICATION | DISALLOW_RECYCLING, null); // Introduced by Buildcraft

    public static class Flags {
        public static final long ENABLE_UNIFICATION = GTUtility.createFlag(0);
        public static final long SELF_REFERENCING = GTUtility.createFlag(1);
        public static final long FLUID_CONTAINER = GTUtility.createFlag(2);
        public static final long DISALLOW_RECYCLING = GTUtility.createFlag(3);
    }

	public static class Conditions {
		public static Predicate<Material> isToolMaterial = mat -> mat instanceof SolidMaterial && ((SolidMaterial) mat).toolDurability > 0;
	}

    static {
    	
        ingotHot.heatDamage = 3.0F;
        ingotHot.maxStackSize = 16;

        rotor.maxStackSize = 16;
        gear.maxStackSize = 16;

        toolHeadFile.maxStackSize = 1;
        toolHeadHammer.maxStackSize = 1;
        toolHeadSaw.maxStackSize = 1;
        toolHeadBuzzSaw.maxStackSize = 1;
        toolHeadScrewdriver.maxStackSize = 1;
        toolHeadWrench.maxStackSize = 1;
        
        plateDense.maxStackSize = 8;
        
        craftingLens.setMarkerPrefix(true);
        dye.setMarkerPrefix(true);
        batterySingleUse.setMarkerPrefix(true);
        battery.setMarkerPrefix(true);
        circuit.setMarkerPrefix(true);
        chipset.setMarkerPrefix(true);

        gem.setIgnored(Materials.Diamond);
        gem.setIgnored(Materials.Emerald);
        gem.setIgnored(Materials.Lapis);
        gem.setIgnored(Materials.NetherQuartz);

        gem.setIgnored(Materials.Coal);
        gem.setIgnored(Materials.Charcoal);
        gem.setIgnored(Materials.NetherStar);
        gem.setIgnored(Materials.EnderPearl);
        gem.setIgnored(Materials.EnderEye);
        gem.setIgnored(Materials.Flint);

        dust.setIgnored(Materials.Redstone);
        dust.setIgnored(Materials.Glowstone);
        dust.setIgnored(Materials.Gunpowder);
        dust.setIgnored(Materials.Sugar);
        dust.setIgnored(Materials.Blaze);
        stick.setIgnored(Materials.Wood);
        stick.setIgnored(Materials.Bone);
        stick.setIgnored(Materials.Blaze);
        stick.setIgnored(Materials.Paper);
        ingot.setIgnored(Materials.Iron);
        ingot.setIgnored(Materials.Gold);
        ingot.setIgnored(Materials.Wood);
        ingot.setIgnored(Materials.Paper);
        nugget.setIgnored(Materials.Wood);
        nugget.setIgnored(Materials.Gold);
        nugget.setIgnored(Materials.Paper);
        nugget.setIgnored(Materials.Iron);
        plate.setIgnored(Materials.Paper);

        block.setIgnored(Materials.Iron);
        block.setIgnored(Materials.Gold);
        block.setIgnored(Materials.Lapis);
        block.setIgnored(Materials.Emerald);
        block.setIgnored(Materials.Redstone);
        block.setIgnored(Materials.Diamond);
        block.setIgnored(Materials.Coal);
        block.setIgnored(Materials.Glass);
        block.setIgnored(Materials.Stone);
        block.setIgnored(Materials.Glowstone);
        block.setIgnored(Materials.Endstone);
        block.setIgnored(Materials.Wheat);
        block.setIgnored(Materials.Oilsands);
        block.setIgnored(Materials.Wood);;
        block.setIgnored(Materials.RawRubber);
        block.setIgnored(Materials.Clay);
        block.setIgnored(Materials.Bone);
        block.setIgnored(Materials.NetherQuartz);
        block.setIgnored(Materials.Ice);
        block.setIgnored(Materials.Netherrack);
        block.setIgnored(Materials.Blaze);
        block.setIgnored(Materials.Bedrock);
        block.setIgnored(Materials.Brick);
        block.setIgnored(Materials.NetherQuartz);

        //oreSand.addSecondaryMaterial(new MaterialStack(Materials.SiliconDioxide, dustTiny.materialAmount));
        oreGravel.addSecondaryMaterial(new MaterialStack(Materials.Flint, gem.materialAmount));

        oreNetherrack.addSecondaryMaterial(new MaterialStack(Materials.Netherrack, dust.materialAmount));
        //oreNether.addSecondaryMaterial(new MaterialStack(Materials.Netherrack, dust.materialAmount));

        oreEndstone.addSecondaryMaterial(new MaterialStack(Materials.Endstone, dust.materialAmount));
        //oreEnd.addSecondaryMaterial(new MaterialStack(Materials.Endstone, dust.materialAmount));
        
        //oreSandstone.addSecondaryMaterial(new MaterialStack(Materials.SiliconDioxide, dust.materialAmount));

        oreStone.addSecondaryMaterial(new MaterialStack(Materials.Stone, dust.materialAmount));

        crushed.addSecondaryMaterial(new MaterialStack(Materials.Stone, dust.materialAmount));

        toolHeadWrench.addSecondaryMaterial(new MaterialStack(Materials.Steel, ring.materialAmount + screw.materialAmount * 2));
    }

    public final String categoryName;

    public final boolean isUnificationEnabled;
    public final boolean isSelfReferencing;
    public final boolean isRecyclingDisallowed;
    public final boolean isFluidContainer;

    public final @Nullable Predicate<Material> generationCondition;
    public final @Nullable MaterialIconType materialIconType;

    public final long materialAmount;

    /**
     * Contains a default material type for self-referencing OrePrefix
     * For self-referencing prefixes, it is always guaranteed for it to be not null
     *
     * NOTE: Ore registrations with self-referencing OrePrefix still can occur with other materials
     */
    public @Nullable Material materialType;

    private final List<IOreRegistrationHandler> oreProcessingHandlers = new ArrayList<>();
    private final Set<Material> ignoredMaterials = new HashSet<>();
    private final Set<Material> generatedMaterials = new HashSet<>();
    
    private boolean isMarkerPrefix = false;

    public byte maxStackSize = 64;
    public final List<MaterialStack> secondaryMaterials = new ArrayList<>();
    public float heatDamage = 0.0F; // Negative for Frost Damage

    OrePrefix(String categoryName, long materialAmount, Material material, MaterialIconType materialIconType, long flags, Predicate<Material> condition) {
        this.categoryName = categoryName;
        this.materialAmount = materialAmount;
        this.isSelfReferencing = (flags & SELF_REFERENCING) != 0;
        this.isUnificationEnabled = (flags & ENABLE_UNIFICATION) != 0;
        this.isRecyclingDisallowed = (flags & DISALLOW_RECYCLING) != 0;
        this.isFluidContainer = (flags & FLUID_CONTAINER) != 0;
        this.materialIconType = materialIconType;
        this.generationCondition = condition;
        if(isSelfReferencing) {
            Preconditions.checkNotNull( material, "Material is null for self-referencing OrePrefix");
            this.materialType = material;
        }
    }

    public void addSecondaryMaterial(MaterialStack secondaryMaterial) {
        Preconditions.checkNotNull(secondaryMaterial, "secondaryMaterial");
        secondaryMaterials.add(secondaryMaterial);
    }
    
    public void setMarkerPrefix(boolean isMarkerPrefix) {
        this.isMarkerPrefix = isMarkerPrefix;
    }

    public long getMaterialAmount(Material material) {
        if(this == block) {
            //glowstone and nether quartz blocks use 4 gems (dusts)
            if(material == Materials.Glowstone ||
                material == Materials.NetherQuartz ||
                material == Materials.Brick ||
                material == Materials.Clay)
                return M * 4;
            //glass, ice and obsidian gain only one dust
            else if(material == Materials.Glass ||
                material == Materials.Ice ||
                material == Materials.Obsidian)
                return M;
        }
        return materialAmount;
    }

    public static OrePrefix getPrefix(String prefixName) {
        return getPrefix(prefixName, null);
    }

    public static OrePrefix getPrefix(String prefixName, @Nullable OrePrefix replacement) {
        try {
            return Enum.valueOf(OrePrefix.class, prefixName);
        } catch (IllegalArgumentException invalidPrefixName) {
            return replacement;
        }
    }

    public boolean doGenerateItem(Material material) {
        return !isSelfReferencing && generationCondition != null && !isIgnored(material) && generationCondition.test(material);
    }

    public boolean addProcessingHandler(IOreRegistrationHandler... processingHandler) {
        Preconditions.checkNotNull(processingHandler);
        Validate.noNullElements(processingHandler);
        return oreProcessingHandlers.addAll(Arrays.asList(processingHandler));
    }

    public <T extends Material> void addProcessingHandler(Class<T> materialFilter, BiConsumer<OrePrefix, T> handler) {
        addProcessingHandler((orePrefix, material) -> {
            if(materialFilter.isAssignableFrom(material.getClass())) {
                //noinspection unchecked
                handler.accept(orePrefix, (T) material);
            }
        });
    }

    public void processOreRegistration(@Nullable Material material) {
        if(this.isSelfReferencing && material == null) {
            material = materialType; //append default material for self-referencing OrePrefix
        }
        if(material != null) {
            generatedMaterials.add(material);
        }
    }

    public static void runMaterialHandlers() {
        for(OrePrefix orePrefix : values()) {
            orePrefix.runGeneratedMaterialHandlers();
        }
    }

    private static final ThreadLocal<OrePrefix> currentProcessingPrefix = new ThreadLocal<>();
    private static final ThreadLocal<Material> currentMaterial = new ThreadLocal<>();

    public static OrePrefix getCurrentProcessingPrefix() {
        return currentProcessingPrefix.get();
    }

    public static Material getCurrentMaterial() {
        return currentMaterial.get();
    }

    private void runGeneratedMaterialHandlers() {
        currentProcessingPrefix.set(this);
        for(Material registeredMaterial : generatedMaterials) {
            currentMaterial.set(registeredMaterial);
            for(IOreRegistrationHandler registrationHandler : oreProcessingHandlers) {
                registrationHandler.processMaterial(this, registeredMaterial);
            }
            currentMaterial.set(null);
        }
        //clear generated materials for next pass
        generatedMaterials.clear();
        currentProcessingPrefix.set(null);
    }

    @SideOnly(Side.CLIENT)
    public String getLocalNameForItem(Material material) {
        String specfiedUnlocalized = "item." + material.toString() + "." + this.name();
        if (I18n.hasKey(specfiedUnlocalized)) return I18n.format(specfiedUnlocalized);
        String unlocalized = "item.material.oreprefix." + this.name();
        String matLocalized = material.getLocalizedName();
        String formatted = I18n.format(unlocalized, matLocalized);
        return formatted.equals(unlocalized) ? matLocalized : formatted;
    }

    public boolean isIgnored(Material material) {
        return ignoredMaterials.contains(material);
    }

    public void setIgnored(Material material) {
        ignoredMaterials.add(material);
    }
    
    public boolean isMarkerPrefix() {
        return isMarkerPrefix;
    }
}