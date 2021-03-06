package gregtech.loaders.recipes;


import static gregtech.common.blocks.BlockBoilerCasing.BoilerCasingType.*;
import static gregtech.common.blocks.BlockFireboxCasing.FireboxCasingType.*;
import static gregtech.common.blocks.BlockMachineCasing.MachineCasingType.*;
import static gregtech.common.blocks.BlockMetalCasing.MetalCasingType.*;
import static gregtech.common.blocks.BlockMultiblockCasing.MultiblockCasingType.ASSEMBLER_CASING;
import static gregtech.common.blocks.BlockMultiblockCasing.MultiblockCasingType.GRATE_CASING;
import static gregtech.common.blocks.BlockTurbineCasing.TurbineCasingType.*;
import static gregtech.common.blocks.BlockWireCoil.CoilType.*;
import static gregtech.loaders.recipes.CraftingComponent.*;

import java.util.Arrays;

import gregtech.api.GTValues;
import gregtech.api.items.OreDictNames;
import gregtech.api.metatileentity.ITieredMetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.MarkerMaterials.Tier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.blocks.BlockMetalCasing.MetalCasingType;
import gregtech.common.blocks.BlockMultiblockCasing.MultiblockCasingType;
import gregtech.common.blocks.BlockWireCoil.CoilType;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.items.MetaItems;
import gregtech.common.metatileentities.MetaTileEntities;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class MetaTileEntityRecipeLoader {
	
	public static void init() {
		
        ModHandler.addShapedRecipe("casing_lv", MetaBlocks.MACHINE_CASING.getItemVariant(LV), "PPP", "PwP", "PPP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Steel));
        ModHandler.addShapedRecipe("casing_mv", MetaBlocks.MACHINE_CASING.getItemVariant(MV), "PPP", "PwP", "PPP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Aluminium));
        ModHandler.addShapedRecipe("casing_hv", MetaBlocks.MACHINE_CASING.getItemVariant(HV), "PPP", "PwP", "PPP", 'P', new UnificationEntry(OrePrefix.plate, Materials.StainlessSteel));
        ModHandler.addShapedRecipe("casing_ev", MetaBlocks.MACHINE_CASING.getItemVariant(EV), "PPP", "PwP", "PPP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Titanium));
        ModHandler.addShapedRecipe("casing_iv", MetaBlocks.MACHINE_CASING.getItemVariant(IV), "PPP", "PwP", "PPP", 'P', new UnificationEntry(OrePrefix.plate, Materials.TungstenSteel));
        ModHandler.addShapedRecipe("casing_luv", MetaBlocks.MACHINE_CASING.getItemVariant(LuV), "PPP", "PwP", "PPP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Iridium));
        ModHandler.addShapedRecipe("casing_uv", MetaBlocks.MACHINE_CASING.getItemVariant(UV), "PPP", "PwP", "PPP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Darmstadtium));
    
        ModHandler.addShapedRecipe("casing_primitive_bricks", MetaBlocks.METAL_CASING.getItemVariant(PRIMITIVE_BRICKS, 1), "XX", "XX", 'X', MetaItems.FIRECLAY_BRICK);
        ModHandler.addShapedRecipe("casing_coke_bricks", MetaBlocks.METAL_CASING.getItemVariant(COKE_BRICKS, 1), "XX", "XX", 'X', MetaItems.COKE_OVEN_BRICK);
        ModHandler.addShapedRecipe("casing_bronze_bricks", MetaBlocks.METAL_CASING.getItemVariant(BRONZE_BRICKS, 3), "PhP", "PBP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Bronze), 'B', new ItemStack(Blocks.BRICK_BLOCK));
        ModHandler.addShapedRecipe("casing_steel_solid", MetaBlocks.METAL_CASING.getItemVariant(STEEL_SOLID, 3), "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Steel), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Steel));
        ModHandler.addShapedRecipe("casing_titanium_stable", MetaBlocks.METAL_CASING.getItemVariant(TITANIUM_STABLE, 3), "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Titanium), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Titanium));
        ModHandler.addShapedRecipe("casing_invar_heatproof", MetaBlocks.METAL_CASING.getItemVariant(INVAR_HEATPROOF, 3), "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Invar), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Invar));
        ModHandler.addShapedRecipe("casing_aluminium_frostproof", MetaBlocks.METAL_CASING.getItemVariant(ALUMINIUM_FROSTPROOF, 3), "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Aluminium), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Aluminium));
        ModHandler.addShapedRecipe("casing_stainless_clean", MetaBlocks.METAL_CASING.getItemVariant(STAINLESS_CLEAN, 3), "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.StainlessSteel), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.StainlessSteel));
        ModHandler.addShapedRecipe("casing_tungstensteel_robust", MetaBlocks.METAL_CASING.getItemVariant(TUNGSTENSTEEL_ROBUST, 3), "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.TungstenSteel), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.TungstenSteel));
        
        ModHandler.addShapedRecipe("casing_steel_turbine_casing", MetaBlocks.TURBINE_CASING.getItemVariant(STEEL_TURBINE_CASING, 3), "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Magnalium), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Steel));
        ModHandler.addShapedRecipe("casing_stainless_turbine_casing", MetaBlocks.TURBINE_CASING.getItemVariant(STAINLESS_TURBINE_CASING, 3), "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.StainlessSteel), 'F', MetaBlocks.TURBINE_CASING.getItemVariant(STEEL_TURBINE_CASING));
        ModHandler.addShapedRecipe("casing_titanium_turbine_casing", MetaBlocks.TURBINE_CASING.getItemVariant(TITANIUM_TURBINE_CASING, 3), "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Titanium), 'F', MetaBlocks.TURBINE_CASING.getItemVariant(STEEL_TURBINE_CASING));
        ModHandler.addShapedRecipe("casing_tungstensteel_turbine_casing", MetaBlocks.TURBINE_CASING.getItemVariant(TUNGSTENSTEEL_TURBINE_CASING, 3), "PhP", "PFP", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.TungstenSteel), 'F', MetaBlocks.TURBINE_CASING.getItemVariant(STEEL_TURBINE_CASING));

        ModHandler.addShapedRecipe("casing_bronze_pipe", MetaBlocks.BOILER_CASING.getItemVariant(BRONZE_PIPE, 3), "PIP", "IFI", "PIP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Bronze), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Bronze), 'I', new UnificationEntry(OrePrefix.pipeMedium, Materials.Bronze));
        ModHandler.addShapedRecipe("casing_steel_pipe", MetaBlocks.BOILER_CASING.getItemVariant(STEEL_PIPE, 3), "PIP", "IFI", "PIP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Steel), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Steel), 'I', new UnificationEntry(OrePrefix.pipeMedium, Materials.Steel));
        ModHandler.addShapedRecipe("casing_titanium_pipe", MetaBlocks.BOILER_CASING.getItemVariant(TITANIUM_PIPE, 3), "PIP", "IFI", "PIP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Titanium), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Titanium), 'I', new UnificationEntry(OrePrefix.pipeMedium, Materials.Titanium));
        ModHandler.addShapedRecipe("casing_tungstensteel_pipe", MetaBlocks.BOILER_CASING.getItemVariant(TUNGSTENSTEEL_PIPE, 3), "PIP", "IFI", "PIP", 'P', new UnificationEntry(OrePrefix.plate, Materials.TungstenSteel), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.TungstenSteel), 'I', new UnificationEntry(OrePrefix.pipeMedium, Materials.TungstenSteel));
        ModHandler.addShapedRecipe("casing_bronze_firebox", MetaBlocks.BOILER_FIREBOX_CASING.getItemVariant(BRONZE_FIREBOX, 3), "PSP", "SFS", "PSP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Bronze), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Bronze), 'S', new UnificationEntry(OrePrefix.stick, Materials.Bronze));
        ModHandler.addShapedRecipe("casing_steel_firebox", MetaBlocks.BOILER_FIREBOX_CASING.getItemVariant(STEEL_FIREBOX, 3), "PSP", "SFS", "PSP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Steel), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Steel), 'S', new UnificationEntry(OrePrefix.stick, Materials.Steel));
        ModHandler.addShapedRecipe("casing_titanium_firebox", MetaBlocks.BOILER_FIREBOX_CASING.getItemVariant(TITANIUM_FIREBOX, 3), "PSP", "SFS", "PSP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Titanium), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Titanium), 'S', new UnificationEntry(OrePrefix.stick, Materials.Titanium));
        ModHandler.addShapedRecipe("casing_tungstensteel_firebox", MetaBlocks.BOILER_FIREBOX_CASING.getItemVariant(TUNGSTENSTEEL_FIREBOX, 3), "PSP", "SFS", "PSP", 'P', new UnificationEntry(OrePrefix.plate, Materials.TungstenSteel), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.TungstenSteel), 'S', new UnificationEntry(OrePrefix.stick, Materials.TungstenSteel));

        ModHandler.addShapedRecipe("casing_bronze_gearbox", MetaBlocks.TURBINE_CASING.getItemVariant(BRONZE_GEARBOX, 3), "PhP", "GFG", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Bronze), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Bronze), 'G', new UnificationEntry(OrePrefix.gear, Materials.Bronze));
        ModHandler.addShapedRecipe("casing_steel_gearbox", MetaBlocks.TURBINE_CASING.getItemVariant(STEEL_GEARBOX, 3), "PhP", "GFG", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Steel), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Steel), 'G', new UnificationEntry(OrePrefix.gear, Materials.Steel));
        ModHandler.addShapedRecipe("casing_titanium_gearbox", MetaBlocks.TURBINE_CASING.getItemVariant(TITANIUM_GEARBOX, 3), "PhP", "GFG", "PwP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Steel), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Titanium), 'G', new UnificationEntry(OrePrefix.gear, Materials.Titanium));

        ModHandler.addShapedRecipe("casing_grate_casing", MetaBlocks.MULTIBLOCK_CASING.getItemVariant(GRATE_CASING, 3), "PVP", "PFP", "PMP", 'P', new ItemStack(Blocks.IRON_BARS, 1), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.Steel), 'M', MetaItems.ELECTRIC_MOTOR_MV, 'V', new UnificationEntry(OrePrefix.rotor, Materials.Steel));
        ModHandler.addShapedRecipe("casing_assembler_casing", MetaBlocks.MULTIBLOCK_CASING.getItemVariant(ASSEMBLER_CASING, 3), "PVP", "PFP", "PMP", 'P', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Elite), 'F', new UnificationEntry(OrePrefix.frameGt, Materials.TungstenSteel), 'M', MetaItems.ELECTRIC_MOTOR_IV, 'V', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Elite));

        for(CoilType coilType : CoilType.values()) {
            if(coilType.getMaterial() != null) {
                ItemStack outputStack = MetaBlocks.WIRE_COIL.getItemVariant(coilType);
                ModHandler.addShapedRecipe(String.format("heating_coil_%s", coilType.getName()), outputStack, "XXX", "XwX", "XXX", 'X',
                    new UnificationEntry(OrePrefix.wireGtDouble, coilType.getMaterial()));
            }
        }
        
        ModHandler.addShapedRecipe("wire_coil_fusion", MetaBlocks.WIRE_COIL.getItemVariant(FUSION_COIL), "CIC", "CPC", "CIC", 'P', MetaBlocks.WIRE_COIL.getItemVariant(SUPERCONDUCTOR), 'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Master), 'I', new UnificationEntry(OrePrefix.plate, Materials.Iridium));
        ModHandler.addShapedRecipe("fusion_casing", MetaBlocks.MULTIBLOCK_CASING.getItemVariant(MultiblockCasingType.FUSION_CASING), "ThT", "THT", "TwT", 'H', MetaTileEntities.HULL[GTValues.LuV].getStackForm(), 'T', new UnificationEntry(OrePrefix.plate, Materials.Tritanium));
        ModHandler.addShapedRecipe("fusion_casing_mk2", MetaBlocks.MULTIBLOCK_CASING.getItemVariant(MultiblockCasingType.FUSION_CASING_MK2), "EhE", "AHA", "EwE", 'H', MetaBlocks.MULTIBLOCK_CASING.getItemVariant(MultiblockCasingType.FUSION_CASING), 'A', new UnificationEntry(OrePrefix.plate, Materials.Americium), 'E', new UnificationEntry(OrePrefix.plate, Materials.Europium));

        //TODO: Change plastics so it doesn't only use one plastic
        ModHandler.addShapedRecipe("hull_lv", MetaTileEntities.HULL[GTValues.LV].getStackForm(), "PHP", "CMC", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(LV), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tin), 'H', new UnificationEntry(OrePrefix.plate, Materials.Steel), 'P', new UnificationEntry(OrePrefix.plate, Materials.WroughtIron));
        ModHandler.addShapedRecipe("hull_mv", MetaTileEntities.HULL[GTValues.MV].getStackForm(), "PHP", "CMC", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(MV), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Copper), 'H', new UnificationEntry(OrePrefix.plate, Materials.Aluminium), 'P', new UnificationEntry(OrePrefix.plate, Materials.Polyethylene));
        ModHandler.addShapedRecipe("hull_hv", MetaTileEntities.HULL[GTValues.HV].getStackForm(), "PHP", "CMC", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(HV), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Gold), 'H', new UnificationEntry(OrePrefix.plate, Materials.StainlessSteel), 'P', new UnificationEntry(OrePrefix.plate, Materials.PolyvinylChloride));
        ModHandler.addShapedRecipe("hull_ev", MetaTileEntities.HULL[GTValues.EV].getStackForm(), "PHP", "CMC", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(EV), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Aluminium), 'H', new UnificationEntry(OrePrefix.plate, Materials.Titanium), 'P', new UnificationEntry(OrePrefix.plate, Materials.AcrylonitrileButadieneStyrene));
        ModHandler.addShapedRecipe("hull_iv", MetaTileEntities.HULL[GTValues.IV].getStackForm(), "PHP", "CMC", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(IV), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tungsten), 'H', new UnificationEntry(OrePrefix.plate, Materials.TungstenSteel), 'P', new UnificationEntry(OrePrefix.plate, Materials.Acrylic));
        ModHandler.addShapedRecipe("hull_luv", MetaTileEntities.HULL[GTValues.LuV].getStackForm(), "PHP", "CMC", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(LuV), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.VanadiumGallium), 'H', new UnificationEntry(OrePrefix.plate, Materials.Chrome), 'P', new UnificationEntry(OrePrefix.plate, Materials.CarbonFibreReinforcedPolymer));
        ModHandler.addShapedRecipe("hull_uv", MetaTileEntities.HULL[GTValues.UV].getStackForm(), "PHP", "CMC", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(UV), 'C', new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.NaquadahAlloy), 'H', new UnificationEntry(OrePrefix.plate, Materials.Darmstadtium), 'P', new UnificationEntry(OrePrefix.plate, Materials.Polychlorotrifluoroethylene));
        
        ModHandler.addShapedRecipe("transformer_mv", MetaTileEntities.TRANSFORMER[GTValues.MV].getStackForm(), "KBB", "CM ", "KBB", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Copper), 'B', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tin), 'K', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Intermediate));
        ModHandler.addShapedRecipe("transformer_hv", MetaTileEntities.TRANSFORMER[GTValues.HV].getStackForm(), "KBB", "CM ", "KBB", 'M', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Gold), 'B', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Copper), 'K', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Advanced));
        ModHandler.addShapedRecipe("transformer_ev", MetaTileEntities.TRANSFORMER[GTValues.EV].getStackForm(), "KBB", "CM ", "KBB", 'M', MetaTileEntities.HULL[GTValues.EV].getStackForm(), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Aluminium), 'B', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Gold), 'K', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Elite));
        ModHandler.addShapedRecipe("transformer_iv", MetaTileEntities.TRANSFORMER[GTValues.IV].getStackForm(), "KBB", "CM ", "KBB", 'M', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tungsten), 'B', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Aluminium), 'K', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Master));
        ModHandler.addShapedRecipe("transformer_luv", MetaTileEntities.TRANSFORMER[GTValues.LuV].getStackForm(), "KBB", "CM ", "KBB", 'M', MetaTileEntities.HULL[GTValues.LuV].getStackForm(), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.VanadiumGallium), 'B', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tungsten), 'K', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Expert));

        ModHandler.addShapedRecipe("energy_output_hatch_lv", MetaTileEntities.ENERGY_OUTPUT_HATCH[GTValues.LV].getStackForm(), " MC", 'M', MetaTileEntities.HULL[GTValues.LV].getStackForm(), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tin));
        ModHandler.addShapedRecipe("energy_output_hatch_mv", MetaTileEntities.ENERGY_OUTPUT_HATCH[GTValues.MV].getStackForm(), " MC", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Copper));
        ModHandler.addShapedRecipe("energy_output_hatch_hv", MetaTileEntities.ENERGY_OUTPUT_HATCH[GTValues.HV].getStackForm(), " MC", 'M', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Gold));
        ModHandler.addShapedRecipe("energy_output_hatch_ev", MetaTileEntities.ENERGY_OUTPUT_HATCH[GTValues.EV].getStackForm(), " MC", 'M', MetaTileEntities.HULL[GTValues.EV].getStackForm(), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Aluminium));
        ModHandler.addShapedRecipe("energy_output_hatch_iv", MetaTileEntities.ENERGY_OUTPUT_HATCH[GTValues.IV].getStackForm(), " MC", 'M', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tungsten));
        ModHandler.addShapedRecipe("energy_output_hatch_luv", MetaTileEntities.ENERGY_OUTPUT_HATCH[GTValues.LuV].getStackForm(), " MC", 'M', MetaTileEntities.HULL[GTValues.LuV].getStackForm(), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.VanadiumGallium));
        ModHandler.addShapedRecipe("energy_output_hatch_uv", MetaTileEntities.ENERGY_OUTPUT_HATCH[GTValues.UV].getStackForm(), " MC", 'M', MetaTileEntities.HULL[GTValues.UV].getStackForm(), 'C', new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.NaquadahAlloy));

        ModHandler.addShapedRecipe("energy_input_hatch_lv", MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.LV].getStackForm(), "CM ", 'M', MetaTileEntities.HULL[GTValues.LV].getStackForm(), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tin));
        ModHandler.addShapedRecipe("energy_input_hatch_mv", MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.MV].getStackForm(), "CM ", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Copper));
        ModHandler.addShapedRecipe("energy_input_hatch_hv", MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.HV].getStackForm(), "CM ", 'M', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Gold));
        ModHandler.addShapedRecipe("energy_input_hatch_ev", MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.EV].getStackForm(), "CM ", 'M', MetaTileEntities.HULL[GTValues.EV].getStackForm(), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Aluminium));
        ModHandler.addShapedRecipe("energy_input_hatch_iv", MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.IV].getStackForm(), "CM ", 'M', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tungsten));
        ModHandler.addShapedRecipe("energy_input_hatch_luv", MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.LuV].getStackForm(), "CM ", 'M', MetaTileEntities.HULL[GTValues.LuV].getStackForm(), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.VanadiumGallium));
        ModHandler.addShapedRecipe("energy_input_hatch_uv", MetaTileEntities.ENERGY_INPUT_HATCH[GTValues.UV].getStackForm(), "CM ", 'M', MetaTileEntities.HULL[GTValues.UV].getStackForm(), 'C', new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.NaquadahAlloy));

        //TODO: Change the glass
        ModHandler.addShapedRecipe("fluid_import_hatch_lv", MetaTileEntities.FLUID_IMPORT_HATCH[GTValues.LV].getStackForm(), "G", "M", 'M', MetaTileEntities.HULL[GTValues.LV].getStackForm(), 'G', new ItemStack(Blocks.GLASS));
        ModHandler.addShapedRecipe("fluid_import_hatch_mv", MetaTileEntities.FLUID_IMPORT_HATCH[GTValues.MV].getStackForm(), "G", "M", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'G', new ItemStack(Blocks.GLASS));
        ModHandler.addShapedRecipe("fluid_import_hatch_hv", MetaTileEntities.FLUID_IMPORT_HATCH[GTValues.HV].getStackForm(), "G", "M", 'M', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'G', new ItemStack(Blocks.GLASS));
        ModHandler.addShapedRecipe("fluid_import_hatch_ev", MetaTileEntities.FLUID_IMPORT_HATCH[GTValues.EV].getStackForm(), "G", "M", 'M', MetaTileEntities.HULL[GTValues.EV].getStackForm(), 'G', new ItemStack(Blocks.GLASS));
        ModHandler.addShapedRecipe("fluid_import_hatch_iv", MetaTileEntities.FLUID_IMPORT_HATCH[GTValues.IV].getStackForm(), "G", "M", 'M', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'G', new ItemStack(Blocks.GLASS));
        ModHandler.addShapedRecipe("fluid_import_hatch_luv", MetaTileEntities.FLUID_IMPORT_HATCH[GTValues.LuV].getStackForm(), "G", "M", 'M', MetaTileEntities.HULL[GTValues.LuV].getStackForm(), 'G', new ItemStack(Blocks.GLASS));
        ModHandler.addShapedRecipe("fluid_import_hatch_uv", MetaTileEntities.FLUID_IMPORT_HATCH[GTValues.UV].getStackForm(), "G", "M", 'M', MetaTileEntities.HULL[GTValues.UV].getStackForm(), 'G', new ItemStack(Blocks.GLASS));

        ModHandler.addShapedRecipe("fluid_export_hatch_lv", MetaTileEntities.FLUID_EXPORT_HATCH[GTValues.LV].getStackForm(), "M", "G", 'M', MetaTileEntities.HULL[GTValues.LV].getStackForm(), 'G', new ItemStack(Blocks.GLASS, 1));
        ModHandler.addShapedRecipe("fluid_export_hatch_mv", MetaTileEntities.FLUID_EXPORT_HATCH[GTValues.MV].getStackForm(), "M", "G", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'G', new ItemStack(Blocks.GLASS, 1));
        ModHandler.addShapedRecipe("fluid_export_hatch_hv", MetaTileEntities.FLUID_EXPORT_HATCH[GTValues.HV].getStackForm(), "M", "G", 'M', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'G', new ItemStack(Blocks.GLASS, 1));
        ModHandler.addShapedRecipe("fluid_export_hatch_ev", MetaTileEntities.FLUID_EXPORT_HATCH[GTValues.EV].getStackForm(), "M", "G", 'M', MetaTileEntities.HULL[GTValues.EV].getStackForm(), 'G', new ItemStack(Blocks.GLASS, 1));
        ModHandler.addShapedRecipe("fluid_export_hatch_iv", MetaTileEntities.FLUID_EXPORT_HATCH[GTValues.IV].getStackForm(), "M", "G", 'M', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'G', new ItemStack(Blocks.GLASS, 1));
        ModHandler.addShapedRecipe("fluid_export_hatch_luv", MetaTileEntities.FLUID_EXPORT_HATCH[GTValues.LuV].getStackForm(), "M", "G", 'M', MetaTileEntities.HULL[GTValues.LuV].getStackForm(), 'G', new ItemStack(Blocks.GLASS));
        ModHandler.addShapedRecipe("fluid_export_hatch_uv", MetaTileEntities.FLUID_EXPORT_HATCH[GTValues.UV].getStackForm(), "M", "G", 'M', MetaTileEntities.HULL[GTValues.UV].getStackForm(), 'G', new ItemStack(Blocks.GLASS));
        
        //TODO: Change these chests, preferably in CraftTweaker tbh
        ModHandler.addShapedRecipe("item_import_bus_lv", MetaTileEntities.ITEM_IMPORT_BUS[GTValues.LV].getStackForm(), "C", "M", 'M', MetaTileEntities.HULL[GTValues.LV].getStackForm(), 'C', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("item_import_bus_mv", MetaTileEntities.ITEM_IMPORT_BUS[GTValues.MV].getStackForm(), "C", "M", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'C', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("item_import_bus_hv", MetaTileEntities.ITEM_IMPORT_BUS[GTValues.HV].getStackForm(), "C", "M", 'M', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'C', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("item_import_bus_ev", MetaTileEntities.ITEM_IMPORT_BUS[GTValues.EV].getStackForm(), "C", "M", 'M', MetaTileEntities.HULL[GTValues.EV].getStackForm(), 'C', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("item_import_bus_iv", MetaTileEntities.ITEM_IMPORT_BUS[GTValues.IV].getStackForm(), "C", "M", 'M', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'C', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("item_import_bus_luv", MetaTileEntities.ITEM_IMPORT_BUS[GTValues.LuV].getStackForm(), "C", "M", 'M', MetaTileEntities.HULL[GTValues.LuV].getStackForm(), 'C', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("item_import_bus_uv", MetaTileEntities.ITEM_IMPORT_BUS[GTValues.UV].getStackForm(), "C", "M", 'M', MetaTileEntities.HULL[GTValues.UV].getStackForm(), 'C', OreDictNames.chestWood);

        ModHandler.addShapedRecipe("item_export_bus_lv", MetaTileEntities.ITEM_EXPORT_BUS[GTValues.LV].getStackForm(), "M", "C", 'M', MetaTileEntities.HULL[GTValues.LV].getStackForm(), 'C', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("item_export_bus_mv", MetaTileEntities.ITEM_EXPORT_BUS[GTValues.MV].getStackForm(), "M", "C", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'C', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("item_export_bus_hv", MetaTileEntities.ITEM_EXPORT_BUS[GTValues.HV].getStackForm(), "M", "C", 'M', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'C', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("item_export_bus_ev", MetaTileEntities.ITEM_EXPORT_BUS[GTValues.EV].getStackForm(), "M", "C", 'M', MetaTileEntities.HULL[GTValues.EV].getStackForm(), 'C', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("item_export_bus_iv", MetaTileEntities.ITEM_EXPORT_BUS[GTValues.IV].getStackForm(), "M", "C", 'M', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'C', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("item_export_bus_luv", MetaTileEntities.ITEM_EXPORT_BUS[GTValues.LuV].getStackForm(), "M", "C", 'M', MetaTileEntities.HULL[GTValues.LuV].getStackForm(), 'C', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("item_export_bus_uv", MetaTileEntities.ITEM_EXPORT_BUS[GTValues.UV].getStackForm(), "M", "C", 'M', MetaTileEntities.HULL[GTValues.UV].getStackForm(), 'C', OreDictNames.chestWood);

        ModHandler.addShapedRecipe("battery_buffer_lv_1x1", MetaTileEntities.BATTERY_BUFFER[GTValues.LV][0].getStackForm(), "WTW", "WMW", 'M', MetaTileEntities.HULL[GTValues.LV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtSingle, Materials.Tin), 'T', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("battery_buffer_mv_1x1", MetaTileEntities.BATTERY_BUFFER[GTValues.MV][0].getStackForm(), "WTW", "WMW", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtSingle, Materials.Copper), 'T', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("battery_buffer_hv_1x1", MetaTileEntities.BATTERY_BUFFER[GTValues.HV][0].getStackForm(), "WTW", "WMW", 'M', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtSingle, Materials.Gold), 'T', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("battery_buffer_ev_1x1", MetaTileEntities.BATTERY_BUFFER[GTValues.EV][0].getStackForm(), "WTW", "WMW", 'M', MetaTileEntities.HULL[GTValues.EV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtSingle, Materials.Aluminium), 'T', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("battery_buffer_iv_1x1", MetaTileEntities.BATTERY_BUFFER[GTValues.IV][0].getStackForm(), "WTW", "WMW", 'M', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtSingle, Materials.Tungsten), 'T', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("battery_buffer_luv_1x1", MetaTileEntities.BATTERY_BUFFER[GTValues.LuV][0].getStackForm(), "WTW", "WMW", 'M', MetaTileEntities.HULL[GTValues.LuV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtSingle, Materials.VanadiumGallium), 'T', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("battery_buffer_uv_1x1", MetaTileEntities.BATTERY_BUFFER[GTValues.UV][0].getStackForm(), "WTW", "WMW", 'M', MetaTileEntities.HULL[GTValues.UV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtSingle, Materials.NaquadahAlloy), 'T', OreDictNames.chestWood);

        ModHandler.addShapedRecipe("battery_buffer_lv_2x2", MetaTileEntities.BATTERY_BUFFER[GTValues.LV][1].getStackForm(), "WTW", "WMW", 'M', MetaTileEntities.HULL[GTValues.LV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Tin), 'T', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("battery_buffer_mv_2x2", MetaTileEntities.BATTERY_BUFFER[GTValues.MV][1].getStackForm(), "WTW", "WMW", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Copper), 'T', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("battery_buffer_hv_2x2", MetaTileEntities.BATTERY_BUFFER[GTValues.HV][1].getStackForm(), "WTW", "WMW", 'M', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Gold), 'T', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("battery_buffer_ev_2x2", MetaTileEntities.BATTERY_BUFFER[GTValues.EV][1].getStackForm(), "WTW", "WMW", 'M', MetaTileEntities.HULL[GTValues.EV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Aluminium), 'T', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("battery_buffer_iv_2x2", MetaTileEntities.BATTERY_BUFFER[GTValues.IV][1].getStackForm(), "WTW", "WMW", 'M', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Tungsten), 'T', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("battery_buffer_luv_2x2", MetaTileEntities.BATTERY_BUFFER[GTValues.LuV][1].getStackForm(), "WTW", "WMW", 'M', MetaTileEntities.HULL[GTValues.LuV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.VanadiumGallium), 'T', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("battery_buffer_uv_2x2", MetaTileEntities.BATTERY_BUFFER[GTValues.UV][1].getStackForm(), "WTW", "WMW", 'M', MetaTileEntities.HULL[GTValues.UV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.NaquadahAlloy), 'T', OreDictNames.chestWood);

        ModHandler.addShapedRecipe("battery_buffer_lv_3x3", MetaTileEntities.BATTERY_BUFFER[GTValues.LV][2].getStackForm(), "WTW", "WMW", 'M', MetaTileEntities.HULL[GTValues.LV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtOctal, Materials.Tin), 'T', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("battery_buffer_mv_3x3", MetaTileEntities.BATTERY_BUFFER[GTValues.MV][2].getStackForm(), "WTW", "WMW", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtOctal, Materials.Copper), 'T', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("battery_buffer_hv_3x3", MetaTileEntities.BATTERY_BUFFER[GTValues.HV][2].getStackForm(), "WTW", "WMW", 'M', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtOctal, Materials.Gold), 'T', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("battery_buffer_ev_3x3", MetaTileEntities.BATTERY_BUFFER[GTValues.EV][2].getStackForm(), "WTW", "WMW", 'M', MetaTileEntities.HULL[GTValues.EV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtOctal, Materials.Aluminium), 'T', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("battery_buffer_iv_3x3", MetaTileEntities.BATTERY_BUFFER[GTValues.IV][2].getStackForm(), "WTW", "WMW", 'M', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtOctal, Materials.Tungsten), 'T', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("battery_buffer_luv_3x3", MetaTileEntities.BATTERY_BUFFER[GTValues.LuV][2].getStackForm(), "WTW", "WMW", 'M', MetaTileEntities.HULL[GTValues.LuV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtOctal, Materials.VanadiumGallium), 'T', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("battery_buffer_uv_3x3", MetaTileEntities.BATTERY_BUFFER[GTValues.UV][2].getStackForm(), "WTW", "WMW", 'M', MetaTileEntities.HULL[GTValues.UV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtOctal, Materials.NaquadahAlloy), 'T', OreDictNames.chestWood);

        ModHandler.addShapedRecipe("battery_buffer_lv_4x4", MetaTileEntities.BATTERY_BUFFER[GTValues.LV][3].getStackForm(), "WTW", "WMW", 'M', MetaTileEntities.HULL[GTValues.LV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.Tin), 'T', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("battery_buffer_mv_4x4", MetaTileEntities.BATTERY_BUFFER[GTValues.MV][3].getStackForm(), "WTW", "WMW", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.Copper), 'T', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("battery_buffer_hv_4x4", MetaTileEntities.BATTERY_BUFFER[GTValues.HV][3].getStackForm(), "WTW", "WMW", 'M', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.Gold), 'T', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("battery_buffer_ev_4x4", MetaTileEntities.BATTERY_BUFFER[GTValues.EV][3].getStackForm(), "WTW", "WMW", 'M', MetaTileEntities.HULL[GTValues.EV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.Aluminium), 'T', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("battery_buffer_iv_4x4", MetaTileEntities.BATTERY_BUFFER[GTValues.IV][3].getStackForm(), "WTW", "WMW", 'M', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.Tungsten), 'T', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("battery_buffer_luv_4x4", MetaTileEntities.BATTERY_BUFFER[GTValues.LuV][3].getStackForm(), "WTW", "WMW", 'M', MetaTileEntities.HULL[GTValues.LuV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.VanadiumGallium), 'T', OreDictNames.chestWood);
        ModHandler.addShapedRecipe("battery_buffer_uv_4x4", MetaTileEntities.BATTERY_BUFFER[GTValues.UV][3].getStackForm(), "WTW", "WMW", 'M', MetaTileEntities.HULL[GTValues.UV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.NaquadahAlloy), 'T', OreDictNames.chestWood);

        ModHandler.addShapedRecipe("charger_lv", MetaTileEntities.CHARGER[GTValues.LV].getStackForm(), "WTW", "WMW", "BCB", 'M', MetaTileEntities.HULL[GTValues.LV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.Tin), 'T', OreDictNames.chestWood, 'B', MetaItems.BATTERY_RE_LV_LITHIUM, 'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Basic));
        ModHandler.addShapedRecipe("charger_mv", MetaTileEntities.CHARGER[GTValues.MV].getStackForm(), "WTW", "WMW", "BCB", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.Copper), 'T', OreDictNames.chestWood, 'B', MetaItems.BATTERY_RE_MV_LITHIUM, 'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Intermediate));
        ModHandler.addShapedRecipe("charger_hv", MetaTileEntities.CHARGER[GTValues.HV].getStackForm(), "WTW", "WMW", "BCB", 'M', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.Gold), 'T', OreDictNames.chestWood, 'B', MetaItems.BATTERY_RE_HV_LITHIUM, 'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Advanced));
        ModHandler.addShapedRecipe("charger_ev", MetaTileEntities.CHARGER[GTValues.EV].getStackForm(), "WTW", "WMW", "BCB", 'M', MetaTileEntities.HULL[GTValues.EV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.Aluminium), 'T', OreDictNames.chestWood, 'B', new UnificationEntry(OrePrefix.battery, MarkerMaterials.Tier.Master), 'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Elite));
        ModHandler.addShapedRecipe("charger_iv", MetaTileEntities.CHARGER[GTValues.IV].getStackForm(), "WTW", "WMW", "BCB", 'M', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.Tungsten), 'T', OreDictNames.chestWood, 'B', MetaItems.ENERGY_LAPOTRONIC_ORB, 'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Master));
        ModHandler.addShapedRecipe("charger_luv", MetaTileEntities.CHARGER[GTValues.LuV].getStackForm(), "WTW", "WMW", "BCB", 'M', MetaTileEntities.HULL[GTValues.LuV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.VanadiumGallium), 'T', OreDictNames.chestWood, 'B', MetaItems.ENERGY_LAPOTRONIC_ORB2, 'C', new UnificationEntry(OrePrefix.circuit, Tier.Expert));
        ModHandler.addShapedRecipe("charger_uv", MetaTileEntities.CHARGER[GTValues.UV].getStackForm(), "WTW", "WMW", "BCB", 'M', MetaTileEntities.HULL[GTValues.UV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.NaquadahAlloy), 'T', OreDictNames.chestWood, 'B', MetaItems.ENERGY_LAPOTRONIC_ORB3, 'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Ultimate));

        ModHandler.addShapedRecipe("rotor_holder_hv", MetaTileEntities.ROTOR_HOLDER[0].getStackForm(), "WHW", "WRW", "WWW", 'H', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.Gold), 'R', new UnificationEntry(OrePrefix.gear, Materials.StainlessSteel));
        ModHandler.addShapedRecipe("rotor_holder_iv", MetaTileEntities.ROTOR_HOLDER[1].getStackForm(), "WHW", "WRW", "WWW", 'H', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Materials.YttriumBariumCuprate), 'R', new UnificationEntry(OrePrefix.gear, Materials.Chrome));
        ModHandler.addShapedRecipe("rotor_holder_uv", MetaTileEntities.ROTOR_HOLDER[2].getStackForm(), "WHW", "WRW", "WWW", 'H', MetaTileEntities.HULL[GTValues.UV].getStackForm(), 'W', new UnificationEntry(OrePrefix.wireGtHex, Tier.Superconductor), 'R', new UnificationEntry(OrePrefix.gear, Materials.HSSS));

        // STEAM MACHINES
        ModHandler.addShapedRecipe("bronze_hull", MetaBlocks.MACHINE_CASING.getItemVariant(BRONZE_HULL), "PBP", "PhP", "PBP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Bronze), 'B', new UnificationEntry(OrePrefix.plate, Materials.Brass));
        ModHandler.addShapedRecipe("bronze_bricks_hull", MetaBlocks.MACHINE_CASING.getItemVariant(BRONZE_BRICKS_HULL), "PRP", "PhP", "BBB", 'P', new UnificationEntry(OrePrefix.plate, Materials.Bronze), 'B', new ItemStack(Blocks.BRICK_BLOCK), 'R', new UnificationEntry(OrePrefix.plate, Materials.Brass));
        ModHandler.addShapedRecipe("steel_hull", MetaBlocks.MACHINE_CASING.getItemVariant(STEEL_HULL), "PPP", "PhP", "PPP", 'P', new UnificationEntry(OrePrefix.plate, Materials.Steel));
        ModHandler.addShapedRecipe("steel_bricks_hull", MetaBlocks.MACHINE_CASING.getItemVariant(STEEL_BRICKS_HULL), "PPP", "PhP", "BBB", 'P', new UnificationEntry(OrePrefix.plate, Materials.Steel), 'B', new ItemStack(Blocks.BRICK_BLOCK));

        ModHandler.addShapedRecipe("steam_boiler_coal_bronze", MetaTileEntities.STEAM_BOILER_COAL_BRONZE.getStackForm(), "PRP", "P P", "BFB", 'F', OreDictNames.craftingFurnace, 'P', new UnificationEntry(OrePrefix.plate, Materials.Bronze), 'B', new ItemStack(Blocks.BRICK_BLOCK), 'R', new UnificationEntry(OrePrefix.plate, Materials.Brass));
        ModHandler.addShapedRecipe("steam_boiler_lava_bronze", MetaTileEntities.STEAM_BOILER_LAVA_BRONZE.getStackForm(), "PPP", "GGG", "RMR", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(BRONZE_BRICKS_HULL), 'P', new UnificationEntry(OrePrefix.plate, Materials.Bronze), 'G', new ItemStack(Blocks.GLASS, 1), 'R', new UnificationEntry(OrePrefix.plate, Materials.Brass));
 
        ModHandler.addShapedRecipe("steam_furnace_bronze", MetaTileEntities.STEAM_FURNACE_BRONZE.getStackForm(), "XXX", "XMX", "XFX", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(BRONZE_BRICKS_HULL), 'X', new UnificationEntry(OrePrefix.pipeSmall, Materials.Bronze), 'F', new ItemStack(Blocks.FURNACE));
        ModHandler.addShapedRecipe("steam_macerator_bronze", MetaTileEntities.STEAM_MACERATOR_BRONZE.getStackForm(), "DXD", "XMX", "PXP", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(BRONZE_HULL), 'X', new UnificationEntry(OrePrefix.pipeSmall, Materials.Bronze), 'P', new ItemStack(Blocks.PISTON), 'D', new UnificationEntry(OrePrefix.gem, Materials.Flint));
        ModHandler.addShapedRecipe("steam_extractor_bronze", MetaTileEntities.STEAM_EXTRACTOR_BRONZE.getStackForm(), "XXX", "PMG", "XXX", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(BRONZE_HULL), 'X', new UnificationEntry(OrePrefix.pipeSmall, Materials.Bronze), 'P', new ItemStack(Blocks.PISTON), 'G', new ItemStack(Blocks.GLASS));
        ModHandler.addShapedRecipe("steam_hammer_bronze", MetaTileEntities.STEAM_HAMMER_BRONZE.getStackForm(), "XPX", "XMX", "XAX", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(BRONZE_HULL), 'X', new UnificationEntry(OrePrefix.pipeSmall, Materials.Bronze), 'P', new ItemStack(Blocks.PISTON), 'A', new ItemStack(Blocks.ANVIL));
        ModHandler.addShapedRecipe("steam_compressor_bronze", MetaTileEntities.STEAM_COMPRESSOR_BRONZE.getStackForm(), "XXX", "PMP", "XXX", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(BRONZE_HULL), 'X', new UnificationEntry(OrePrefix.pipeSmall, Materials.Bronze), 'P', new ItemStack(Blocks.PISTON));
        ModHandler.addShapedRecipe("steam_alloy_smelter_bronze", MetaTileEntities.STEAM_ALLOY_SMELTER_BRONZE.getStackForm(), "XXX", "FMF", "XXX", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(BRONZE_BRICKS_HULL), 'X', new UnificationEntry(OrePrefix.pipeSmall, Materials.Bronze), 'F', new ItemStack(Blocks.FURNACE));
        
        ModHandler.addShapedRecipe("bronze_primitive_blast_furnace", MetaTileEntities.PRIMITIVE_BLAST_FURNACE.getStackForm(), "PFP", "FwF", "PFP", 'P', MetaBlocks.METAL_CASING.getItemVariant(PRIMITIVE_BRICKS), 'F', OreDictNames.craftingFurnace);
        ModHandler.addShapedRecipe("coke_oven", MetaTileEntities.COKE_OVEN.getStackForm(), "PIP", "IwI", "PIP", 'P', MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.COKE_BRICKS), 'I', new UnificationEntry(OrePrefix.plate, Materials.Iron));
        ModHandler.addShapelessRecipe("coke_oven_hatch", MetaTileEntities.COKE_OVEN_HATCH.getStackForm(), MetaBlocks.METAL_CASING.getItemVariant(MetalCasingType.COKE_BRICKS), MetaTileEntities.BRONZE_TANK.getStackForm());
        ModHandler.addShapedRecipe("electric_blast_furnace", MetaTileEntities.ELECTRIC_BLAST_FURNACE.getStackForm(), "FFF", "CMC", "WCW", 'M', MetaBlocks.METAL_CASING.getItemVariant(INVAR_HEATPROOF), 'F', OreDictNames.craftingFurnace, 'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Basic), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tin));
        ModHandler.addShapedRecipe("vacuum_freezer", MetaTileEntities.VACUUM_FREEZER.getStackForm(), "PPP", "CMC", "WCW", 'M', MetaBlocks.METAL_CASING.getItemVariant(ALUMINIUM_FROSTPROOF), 'P', MetaItems.ELECTRIC_PUMP_HV, 'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Elite), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Gold));
        ModHandler.addShapedRecipe("implosion_compressor", MetaTileEntities.IMPLOSION_COMPRESSOR.getStackForm(), "OOO", "CMC", "WCW", 'M', MetaBlocks.METAL_CASING.getItemVariant(STEEL_SOLID), 'O', new UnificationEntry(OrePrefix.stone, Materials.Obsidian), 'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Advanced), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Aluminium));
        ModHandler.addShapedRecipe("distillation_tower", MetaTileEntities.DISTILLATION_TOWER.getStackForm(), "CBC", "FMF", "CBC", 'M', MetaBlocks.MACHINE_CASING.getItemVariant(EV), 'B', new UnificationEntry(OrePrefix.pipeLarge, Materials.StainlessSteel), 'C', new UnificationEntry(OrePrefix.circuit, Tier.Elite), 'F', MetaItems.ELECTRIC_PUMP_EV);
        ModHandler.addShapedRecipe("cracking_unit", MetaTileEntities.CRACKER.getStackForm(), "CEC", "PHP", "CEC", 'C', MetaBlocks.WIRE_COIL.getItemVariant(CUPRONICKEL), 'E', MetaItems.ELECTRIC_PUMP_HV, 'P', new UnificationEntry(OrePrefix.circuit, Tier.Elite), 'H', MetaTileEntities.HULL[GTValues.HV].getStackForm());
        ModHandler.addShapedRecipe("pyrolyse_oven", MetaTileEntities.PYROLYSE_OVEN.getStackForm(), "WEP", "EME", "WCP", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'W', MetaItems.ELECTRIC_PISTON_MV, 'P', new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Cupronickel), 'E', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Intermediate), 'C', MetaItems.ELECTRIC_PUMP_MV);
        ModHandler.addShapedRecipe("diesel_engine", MetaTileEntities.DIESEL_ENGINE.getStackForm(), "PCP", "EME", "GWG", 'M', MetaTileEntities.HULL[GTValues.EV].getStackForm(), 'P', MetaItems.ELECTRIC_PISTON_EV, 'E', MetaItems.ELECTRIC_MOTOR_EV, 'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Elite), 'W', new UnificationEntry(OrePrefix.wireGtSingle, Materials.TungstenSteel), 'G', new UnificationEntry(OrePrefix.gear, Materials.Titanium));
        ModHandler.addShapedRecipe("engine_intake_casing", MetaBlocks.MULTIBLOCK_CASING.getItemVariant(MultiblockCasingType.ENGINE_INTAKE_CASING), "PhP", "RFR", "PwP", 'R', new UnificationEntry(OrePrefix.pipeMedium, Materials.Titanium), 'F', MetaBlocks.METAL_CASING.getItemVariant(TITANIUM_STABLE), 'P', new UnificationEntry(OrePrefix.rotor, Materials.Titanium));
        ModHandler.addShapedRecipe("multi_furnace", MetaTileEntities.MULTI_FURNACE.getStackForm(), "PPP", "ASA", "CAC", 'P', Blocks.FURNACE, 'A', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Advanced), 'S', MetaBlocks.METAL_CASING.getItemVariant(INVAR_HEATPROOF), 'C', new UnificationEntry(OrePrefix.cableGtSingle, Materials.AnnealedCopper));
    	ModHandler.addShapedRecipe("assembly_line", MetaTileEntities.ASSEMBLY_LINE.getStackForm(), "CRC", "SAS", "CRC", 'A', MetaTileEntities.HULL[GTValues.IV].getStackForm(), 'R', MetaItems.ROBOT_ARM_IV, 'C', MetaBlocks.MULTIBLOCK_CASING.getItemVariant(MultiblockCasingType.ASSEMBLER_CASING), 'S', new UnificationEntry(OrePrefix.circuit, Tier.Master));

        
        ModHandler.addShapedRecipe("large_steam_turbine", MetaTileEntities.LARGE_STEAM_TURBINE.getStackForm(), "PSP", "SAS", "CSC", 'S', new UnificationEntry(OrePrefix.gear, Materials.Steel), 'P', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Advanced), 'A', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'C', new UnificationEntry(OrePrefix.pipeLarge, Materials.Steel));
        ModHandler.addShapedRecipe("large_gas_turbine", MetaTileEntities.LARGE_GAS_TURBINE.getStackForm(), "PSP", "SAS", "CSC", 'S', new UnificationEntry(OrePrefix.gear, Materials.StainlessSteel), 'P', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Elite), 'A', MetaTileEntities.HULL[GTValues.EV].getStackForm(), 'C', new UnificationEntry(OrePrefix.pipeLarge, Materials.StainlessSteel));
        ModHandler.addShapedRecipe("large_plasma_turbine", MetaTileEntities.LARGE_PLASMA_TURBINE.getStackForm(), "PSP", "SAS", "CSC", 'S', new UnificationEntry(OrePrefix.gear, Materials.TungstenSteel), 'P', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Master), 'A', MetaTileEntities.HULL[GTValues.UV].getStackForm(), 'C', new UnificationEntry(OrePrefix.pipeLarge, Materials.TungstenSteel));

        ModHandler.addShapedRecipe("large_bronze_boiler", MetaTileEntities.LARGE_BRONZE_BOILER.getStackForm(), "PSP", "SAS", "PSP", 'P', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tin), 'S', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Basic), 'A', MetaBlocks.METAL_CASING.getItemVariant(BRONZE_BRICKS));
        ModHandler.addShapedRecipe("large_steel_boiler", MetaTileEntities.LARGE_STEEL_BOILER.getStackForm(), "PSP", "SAS", "PSP", 'P', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Copper), 'S', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Intermediate), 'A', MetaBlocks.METAL_CASING.getItemVariant(STEEL_SOLID));
        ModHandler.addShapedRecipe("large_titanium_boiler", MetaTileEntities.LARGE_TITANIUM_BOILER.getStackForm(), "PSP", "SAS", "PSP", 'P', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Gold), 'S', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Advanced), 'A', MetaBlocks.METAL_CASING.getItemVariant(TITANIUM_STABLE));
        ModHandler.addShapedRecipe("large_tungstensteel_boiler", MetaTileEntities.LARGE_TUNGSTENSTEEL_BOILER.getStackForm(), "PSP", "SAS", "PSP", 'P', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Aluminium), 'S', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Elite), 'A', MetaBlocks.METAL_CASING.getItemVariant(TUNGSTENSTEEL_ROBUST));

        ModHandler.addShapedRecipe("bedrock_drill", MetaTileEntities.BEDROCK_DRILL.getStackForm(), "WWW", "EME", "ABC", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'W', new UnificationEntry(OrePrefix.frameGt, Materials.Aluminium), 'E', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Intermediate), 'A', MetaItems.ELECTRIC_MOTOR_MV, 'B', MetaItems.ROBOT_ARM_MV, 'C', MetaItems.ELECTRIC_PISTON_MV);
        
        //Generators
        ModHandler.addShapedRecipe("diesel_generator_lv", MetaTileEntities.DIESEL_GENERATOR[0].getStackForm(), "PCP", "EME", "GWG", 'M', MetaTileEntities.HULL[GTValues.LV].getStackForm(), 'P', MetaItems.ELECTRIC_PISTON_LV, 'E', MetaItems.ELECTRIC_MOTOR_LV, 'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Basic), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tin), 'G', new UnificationEntry(OrePrefix.gear, Materials.Steel));
        ModHandler.addShapedRecipe("diesel_generator_mv", MetaTileEntities.DIESEL_GENERATOR[1].getStackForm(), "PCP", "EME", "GWG", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'P', MetaItems.ELECTRIC_PISTON_MV, 'E', MetaItems.ELECTRIC_MOTOR_MV, 'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Intermediate), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Copper), 'G', new UnificationEntry(OrePrefix.gear, Materials.Aluminium));
        ModHandler.addShapedRecipe("diesel_generator_hv", MetaTileEntities.DIESEL_GENERATOR[2].getStackForm(), "PCP", "EME", "GWG", 'M', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'P', MetaItems.ELECTRIC_PISTON_HV, 'E', MetaItems.ELECTRIC_MOTOR_HV, 'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Advanced), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Gold), 'G', new UnificationEntry(OrePrefix.gear, Materials.StainlessSteel));

        ModHandler.addShapedRecipe("gas_turbine_lv", MetaTileEntities.GAS_TURBINE[0].getStackForm(), "CRC", "RMR", "EWE", 'M', MetaTileEntities.HULL[GTValues.LV].getStackForm(), 'E', MetaItems.ELECTRIC_MOTOR_LV, 'R', new UnificationEntry(OrePrefix.rotor, Materials.Tin), 'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Basic), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tin));
        ModHandler.addShapedRecipe("gas_turbine_mv", MetaTileEntities.GAS_TURBINE[1].getStackForm(), "CRC", "RMR", "EWE", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'E', MetaItems.ELECTRIC_MOTOR_MV, 'R', new UnificationEntry(OrePrefix.rotor, Materials.Bronze), 'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Intermediate), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Copper));
        ModHandler.addShapedRecipe("gas_turbine_hv", MetaTileEntities.GAS_TURBINE[2].getStackForm(), "CRC", "RMR", "EWE", 'M', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'E', MetaItems.ELECTRIC_MOTOR_HV, 'R', new UnificationEntry(OrePrefix.rotor, Materials.Steel), 'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Advanced), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Gold));

        ModHandler.addShapedRecipe("steam_turbine_lv", MetaTileEntities.STEAM_TURBINE[0].getStackForm(), "PCP", "RMR", "EWE", 'M', MetaTileEntities.HULL[GTValues.LV].getStackForm(), 'E', MetaItems.ELECTRIC_MOTOR_LV, 'R', new UnificationEntry(OrePrefix.rotor, Materials.Tin), 'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Basic), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Tin), 'P', new UnificationEntry(OrePrefix.pipeSmall, Materials.Bronze));
        ModHandler.addShapedRecipe("steam_turbine_mv", MetaTileEntities.STEAM_TURBINE[1].getStackForm(), "PCP", "RMR", "EWE", 'M', MetaTileEntities.HULL[GTValues.MV].getStackForm(), 'E', MetaItems.ELECTRIC_MOTOR_MV, 'R', new UnificationEntry(OrePrefix.rotor, Materials.Bronze), 'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Intermediate), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Copper), 'P', new UnificationEntry(OrePrefix.pipeSmall, Materials.Steel));
        ModHandler.addShapedRecipe("steam_turbine_hv", MetaTileEntities.STEAM_TURBINE[2].getStackForm(), "PCP", "RMR", "EWE", 'M', MetaTileEntities.HULL[GTValues.HV].getStackForm(), 'E', MetaItems.ELECTRIC_MOTOR_HV, 'R', new UnificationEntry(OrePrefix.rotor, Materials.Steel), 'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Advanced), 'W', new UnificationEntry(OrePrefix.cableGtSingle, Materials.Gold), 'P', new UnificationEntry(OrePrefix.pipeSmall, Materials.StainlessSteel));

        //MACHINES TODO: add the rest
        registerMachineRecipe(MetaTileEntities.ALLOY_SMELTER, "ECE", "CMC", "WCW", 'M', HULL, 'E', CIRCUIT, 'W', CABLE, 'C', COIL_HEATING_DOUBLE);
        registerMachineRecipe(MetaTileEntities.ASSEMBLER, "ACA", "VMV", "WCW", 'M', HULL, 'V', CONVEYOR, 'A', ROBOT_ARM, 'C', CIRCUIT, 'W', CABLE);
        registerMachineRecipe(MetaTileEntities.BENDER, "PwP", "CMC", "EWE", 'M', HULL, 'E', MOTOR, 'P', PISTON, 'C', CIRCUIT, 'W', CABLE);
        registerMachineRecipe(MetaTileEntities.CANNER, "WPW", "CMC", "GGG", 'M', HULL, 'P', PUMP, 'C', CIRCUIT, 'W', CABLE, 'G', TANK);
        registerMachineRecipe(MetaTileEntities.COMPRESSOR, " C ", "PMP", "WCW", 'M', HULL, 'P', PISTON, 'C', CIRCUIT, 'W', CABLE);
        registerMachineRecipe(MetaTileEntities.CUTTER, "WCG", "VMB", "CWE", 'M', HULL, 'E', MOTOR, 'V', CONVEYOR, 'C', CIRCUIT, 'W', CABLE, 'G', TANK, 'B', OreDictNames.craftingDiamondBlade);
        registerMachineRecipe(MetaTileEntities.ELECTRIC_FURNACE, "ECE", "CMC", "WCW", 'M', HULL, 'E', CIRCUIT, 'W', CABLE, 'C', COIL_HEATING);
        registerMachineRecipe(MetaTileEntities.EXTRACTOR, "GCG", "EMP", "WCW", 'M', HULL, 'E', PISTON, 'P', PUMP, 'C', CIRCUIT, 'W', CABLE, 'G', TANK);
        registerMachineRecipe(MetaTileEntities.EXTRUDER, "CCE", "XMP", "CCE", 'M', HULL, 'X', PISTON, 'E', CIRCUIT, 'P', PIPE, 'C', COIL_HEATING_DOUBLE);
        registerMachineRecipe(MetaTileEntities.LATHE, "WCW", "EMG", "CWP", 'M', HULL, 'E', MOTOR, 'P', PISTON, 'C', CIRCUIT, 'W', CABLE, 'G', new UnificationEntry(OrePrefix.gem, Materials.Opal));
        registerMachineRecipe(MetaTileEntities.MACERATOR, "PEG", "WWM", "CCW", 'M', HULL, 'E', MOTOR, 'P', PISTON, 'C', CIRCUIT, 'W', CABLE, 'G', GRINDER);
        registerMachineRecipe(MetaTileEntities.WIREMILL, "EWE", "CMC", "EWE", 'M', HULL, 'E', MOTOR, 'C', CIRCUIT, 'W', CABLE);
        registerMachineRecipe(MetaTileEntities.CENTRIFUGE, "CEC", "WMW", "CEC", 'M', HULL, 'E', MOTOR, 'C', CIRCUIT, 'W', CABLE);
        registerMachineRecipe(MetaTileEntities.ELECTROLYZER, "IGI", "IMI", "CWC", 'M', HULL, 'C', CIRCUIT, 'W', CABLE, 'I', WIRE, 'G', TANK);
        registerMachineRecipe(MetaTileEntities.THERMAL_CENTRIFUGE, "CEC", "OMO", "WEW", 'M', HULL, 'E', MOTOR, 'C', CIRCUIT, 'W', CABLE, 'O', COIL_HEATING_DOUBLE);
        registerMachineRecipe(MetaTileEntities.ORE_WASHER, "RGR", "CEC", "WMW", 'M', HULL, 'R', ROTOR, 'E', MOTOR, 'C', CIRCUIT, 'W', CABLE, 'G', TANK);
        registerMachineRecipe(MetaTileEntities.CHEMICAL_REACTOR, "GRG", "WEW", "CMC", 'M', HULL, 'R', ROTOR, 'E', MOTOR, 'C', CIRCUIT, 'W', CABLE, 'G', TANK);
        registerMachineRecipe(MetaTileEntities.BREWERY, "GPG", "WMW", "CBC", 'M', HULL, 'P', PUMP, 'B', Blocks.BREWING_STAND, 'C', CIRCUIT, 'W', CABLE, 'G', TANK);
        registerMachineRecipe(MetaTileEntities.FLUID_SOLIDIFIER, "PGP", "WMW", "CBC", 'M', HULL, 'P', PUMP, 'C', CIRCUIT, 'W', CABLE, 'G', Blocks.GLASS, 'B', TANK);
        registerMachineRecipe(MetaTileEntities.DISTILLERY, "GBG", "CMC", "WPW", 'M', HULL, 'P', PUMP, 'B', new UnificationEntry(OrePrefix.stick, Materials.Blaze), 'C', CIRCUIT, 'W', CABLE, 'G', TANK);
        registerMachineRecipe(MetaTileEntities.CHEMICAL_BATH, "VGW", "PGV", "CMC", 'M', HULL, 'P', PUMP, 'V', CONVEYOR, 'C', CIRCUIT, 'W', CABLE, 'G', TANK);
        registerMachineRecipe(MetaTileEntities.POLARIZER, "ZSZ", "WMW", "ZSZ", 'M', HULL, 'S', STICK_ELECTROMAGNETIC, 'Z', COIL_ELECTRIC, 'W', CABLE);
        registerMachineRecipe(MetaTileEntities.AUTOCLAVE, "IGI", "IMI", "CPC", 'M', HULL, 'P', PUMP, 'C', CIRCUIT, 'I', PLATE, 'G', TANK);
        registerMachineRecipe(MetaTileEntities.MIXER, "GRG", "GEG", "CMC", 'M', HULL, 'E', MOTOR, 'R', ROTOR, 'C', CIRCUIT, 'G', TANK);
        registerMachineRecipe(MetaTileEntities.LASER_ENGRAVER, "PEP", "CMC", "WCW", 'M', HULL, 'E', EMITTER, 'P', PISTON, 'C', CIRCUIT, 'W', CABLE);
        registerMachineRecipe(MetaTileEntities.PRESS, "WPW", "CMC", "WPW", 'M', HULL, 'P', PISTON, 'C', CIRCUIT, 'W', CABLE);
        registerMachineRecipe(MetaTileEntities.FORGE_HAMMER, "WPW", "CMC", "WAW", 'M', HULL, 'P', PISTON, 'C', CIRCUIT, 'W', CABLE, 'A', Blocks.ANVIL);
        registerMachineRecipe(MetaTileEntities.FLUID_HEATER, "OGO", "PMP", "WCW", 'M', HULL, 'P', PUMP, 'O', COIL_HEATING_DOUBLE, 'C', CIRCUIT, 'W', CABLE, 'G', TANK);
        registerMachineRecipe(MetaTileEntities.PLASMA_ARC_FURNACE, "WGW", "CMC", "TPT", 'M', HULL, 'P', PLATE, 'C', CIRCUIT, 'W', CABLE_QUAD, 'T', PUMP, 'G', new UnificationEntry(OrePrefix.block, Materials.Molybdenum));
        registerMachineRecipe(MetaTileEntities.PUMP, "WGW", "GMG", "TGT", 'M', HULL, 'W', CIRCUIT, 'G', PUMP, 'T', PISTON);
        registerMachineRecipe(MetaTileEntities.AIR_COLLECTOR, "WFW", "PHP", "WCW", 'W', Blocks.IRON_BARS, 'F', MetaItems.FLUID_FILTER, 'P', PUMP, 'H', HULL, 'C', CIRCUIT);
        registerMachineRecipe(MetaTileEntities.RECYCLER, "PCP", "DFD", "PHP", 'P', PISTON, 'C', CIRCUIT, 'F', HULL, 'H', new ItemStack(Blocks.FURNACE), 'D', MOTOR);
        registerMachineRecipe(MetaTileEntities.MASS_FABRICATOR, "EFE", "CHC", "EFE", 'H', HULL, 'E', CIRCUIT, 'C', CABLE_QUAD, 'F', FIELD_GENERATOR);
        registerMachineRecipe(MetaTileEntities.REPLICATOR, "EFE", "VHV", "ECE", 'H', HULL, 'E', EMITTER, 'C', CABLE_QUAD, 'F', FIELD_GENERATOR, 'V', CIRCUIT);
        registerMachineRecipe(MetaTileEntities.MAGIC_ENERGY_ABSORBER, "PCP", "PHP", "PCP", 'H', HULL, 'P', SENSOR, 'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Magic));
        registerMachineRecipe(MetaTileEntities.LIGHTNING_HARVESTER, "CSF", "STS", "FEC", 'C', CIRCUIT, 'E', BATTERY, 'T', TRANSFORMER, 'F', FIELD_GENERATOR, 'S', SENSOR);
        
        registerMachineRecipe(MetaTileEntities.QUANTUM_CHEST, "CPC", "PHP", "CFC", 'C', CIRCUIT, 'P', PLATE, 'F', FIELD_GENERATOR, 'H', HULL);
        registerMachineRecipe(MetaTileEntities.QUANTUM_TANK, "CFC", "PHP", "CPC", 'C', CIRCUIT, 'P', PLATE, 'F', FIELD_GENERATOR, 'H', HULL);

        ModHandler.addShapedRecipe("wooden_tank", MetaTileEntities.WOODEN_TANK.getStackForm(), "XYX", "Y Y", "XYX", 'X', new UnificationEntry(OrePrefix.plank, Materials.Wood), 'Y', new UnificationEntry(OrePrefix.blockGlass));
        ModHandler.addShapedRecipe("bronze_tank", MetaTileEntities.BRONZE_TANK.getStackForm(), "XYX", "Y Y", "XYX", 'X', new UnificationEntry(OrePrefix.plate, Materials.Bronze), 'Y', new UnificationEntry(OrePrefix.blockGlass));
        ModHandler.addShapedRecipe("steel_tank", MetaTileEntities.STEEL_TANK.getStackForm(), "XYX", "Y Y", "XYX", 'X', new UnificationEntry(OrePrefix.plate, Materials.Steel), 'Y', new UnificationEntry(OrePrefix.blockGlass));
        ModHandler.addShapedRecipe("stainless_steel_tank", MetaTileEntities.STAINLESS_STEEL_TANK.getStackForm(), "XYX", "Y Y", "XYX", 'X', new UnificationEntry(OrePrefix.plate, Materials.StainlessSteel), 'Y', new UnificationEntry(OrePrefix.blockGlass));
        ModHandler.addShapedRecipe("titanium_tank", MetaTileEntities.TITANIUM_TANK.getStackForm(), "XYX", "Y Y", "XYX", 'X', new UnificationEntry(OrePrefix.plate, Materials.Titanium), 'Y', new UnificationEntry(OrePrefix.blockGlass));
        ModHandler.addShapedRecipe("tungsten_steel_tank", MetaTileEntities.TUNGSTENSTEEL_TANK.getStackForm(), "XYX", "Y Y", "XYX", 'X', new UnificationEntry(OrePrefix.plate, Materials.TungstenSteel), 'Y', new UnificationEntry(OrePrefix.blockGlass));
        ModHandler.addShapedRecipe("iridium_tank", MetaTileEntities.IRIDIUM_TANK.getStackForm(), "XYX", "Y Y", "XYX", 'X', new UnificationEntry(OrePrefix.plate, Materials.Iridium), 'Y', new UnificationEntry(OrePrefix.blockGlass));
        ModHandler.addShapedRecipe("adamantine_tank", MetaTileEntities.ADAMANTINE_TANK.getStackForm(), "XYX", "Y Y", "XYX", 'X', new UnificationEntry(OrePrefix.plate, Materials.Adamantine), 'Y', new UnificationEntry(OrePrefix.blockGlass));

        ModHandler.addShapedRecipe("tesla_coil", MetaTileEntities.TESLA_COIL.getStackForm(), "XXX", "YHY", "XXX", 'X', new UnificationEntry(OrePrefix.wireGtQuadruple, Materials.Copper), 'Y', MetaItems.EMITTER_MV, 'H', MetaTileEntities.HULL[GTValues.MV].getStackForm());
    }
	
	public static <T extends MetaTileEntity & ITieredMetaTileEntity> void registerMachineRecipe(T[] metaTileEntities, Object... recipe) {
        for (T metaTileEntity : metaTileEntities) {
            ModHandler.addShapedRecipe(metaTileEntity.getMetaName(), metaTileEntity.getStackForm(), prepareRecipe(metaTileEntity.getTier(), Arrays.copyOf(recipe, recipe.length)));
        }
	}

	 private static Object[] prepareRecipe(int tier, Object... recipe) {
		 for (int i = 3; i < recipe.length; i++) {
			 if (recipe[i] instanceof CraftingComponent) {
				 recipe[i] = ((CraftingComponent)recipe[i]).getIngredient(tier);
				 }
		 }
	 return recipe;
	 }
}
