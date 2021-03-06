package gregtech.common.items;

import java.util.List;

import gregtech.api.items.materialitem.MaterialMetaItem;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.toolitem.ToolMetaItem;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MetaItems {
	
	public static List<MetaItem<?>> ITEMS = MetaItem.getMetaItems();
	
	public static MetaItem<?>.MetaValueItem CARBON_FIBRE;
	
    public static MetaItem<?>.MetaValueItem COVER_SOLAR_PANEL_LV;
    public static MetaItem<?>.MetaValueItem COVER_SOLAR_PANEL_MV;
    public static MetaItem<?>.MetaValueItem COVER_SOLAR_PANEL_HV;
    public static MetaItem<?>.MetaValueItem COVER_SOLAR_PANEL_EV;
    public static MetaItem<?>.MetaValueItem COVER_SOLAR_PANEL_IV;
    public static MetaItem<?>.MetaValueItem COVER_SOLAR_PANEL_LuV;
    public static MetaItem<?>.MetaValueItem COVER_SOLAR_PANEL_UV;
    
    public static MetaItem<?>.MetaValueItem QUANTUM_EYE;
    public static MetaItem<?>.MetaValueItem QUANTUM_STAR;
    public static MetaItem<?>.MetaValueItem GRAVI_STAR;

    public static MetaItem<?>.MetaValueItem SHAPE_EMPTY;

    public static MetaItem<?>.MetaValueItem SHAPE_MOLD_PLATE;
    public static MetaItem<?>.MetaValueItem SHAPE_MOLD_GEAR;
    public static MetaItem<?>.MetaValueItem SHAPE_MOLD_INGOT;
    public static MetaItem<?>.MetaValueItem SHAPE_MOLD_BLOCK;
    public static MetaItem<?>.MetaValueItem SHAPE_MOLD_NUGGET;
    public static MetaItem<?>.MetaValueItem SHAPE_MOLD_GEAR_SMALL;
    
    public static MetaItem<?>.MetaValueItem COMPRESSED_CLAY;
    public static MetaItem<?>.MetaValueItem COMPRESSED_FIRECLAY;
    public static MetaItem<?>.MetaValueItem FIRECLAY_BRICK;
    public static MetaItem<?>.MetaValueItem COKE_OVEN_BRICK;

    public static MetaItem<?>.MetaValueItem WOODEN_FORM_EMPTY;
    public static MetaItem<?>.MetaValueItem WOODEN_FORM_BRICK;
    
    public static MetaItem<?>.MetaValueItem SHAPE_EXTRUDER_PLATE;
    public static MetaItem<?>.MetaValueItem SHAPE_EXTRUDER_ROD;
    public static MetaItem<?>.MetaValueItem SHAPE_EXTRUDER_SCREW;
    public static MetaItem<?>.MetaValueItem SHAPE_EXTRUDER_RING;
    public static MetaItem<?>.MetaValueItem SHAPE_EXTRUDER_HAMMER;
    public static MetaItem<?>.MetaValueItem SHAPE_EXTRUDER_SAW;
    public static MetaItem<?>.MetaValueItem SHAPE_EXTRUDER_FILE;
    public static MetaItem<?>.MetaValueItem SHAPE_EXTRUDER_CELL;
    public static MetaItem<?>.MetaValueItem SHAPE_EXTRUDER_WIRE;
    public static MetaItem<?>.MetaValueItem SHAPE_EXTRUDER_PIPE_TINY;
    public static MetaItem<?>.MetaValueItem SHAPE_EXTRUDER_PIPE_SMALL;
    public static MetaItem<?>.MetaValueItem SHAPE_EXTRUDER_PIPE_MEDIUM;
    public static MetaItem<?>.MetaValueItem SHAPE_EXTRUDER_PIPE_LARGE;
    public static MetaItem<?>.MetaValueItem SHAPE_EXTRUDER_BLOCK;
    public static MetaItem<?>.MetaValueItem SHAPE_EXTRUDER_GEAR;
    
    public static MetaItem<?>.MetaValueItem SPRAY_EMPTY;
    public static MetaItem<?>.MetaValueItem[] SPRAY_CAN_DYES = new MetaItem.MetaValueItem[16];

    public static MetaItem<?>.MetaValueItem BATTERY_HULL_LV;
    public static MetaItem<?>.MetaValueItem BATTERY_HULL_MV;
    public static MetaItem<?>.MetaValueItem BATTERY_HULL_HV;
    
    public static MetaItem<?>.MetaValueItem BATTERY_SU_LV_SULFURIC_ACID;
    public static MetaItem<?>.MetaValueItem BATTERY_SU_LV_MERCURY;
    public static MetaItem<?>.MetaValueItem BATTERY_RE_LV_CADMIUM;
    public static MetaItem<?>.MetaValueItem BATTERY_RE_LV_LITHIUM;
    public static MetaItem<?>.MetaValueItem BATTERY_RE_LV_SODIUM;
    public static MetaItem<?>.MetaValueItem BATTERY_SU_MV_SULFURIC_ACID;
    public static MetaItem<?>.MetaValueItem BATTERY_SU_MV_MERCURY;
    public static MetaItem<?>.MetaValueItem BATTERY_RE_MV_CADMIUM;
    public static MetaItem<?>.MetaValueItem BATTERY_RE_MV_LITHIUM;
    public static MetaItem<?>.MetaValueItem BATTERY_RE_MV_SODIUM;
    public static MetaItem<?>.MetaValueItem BATTERY_SU_HV_SULFURIC_ACID;
    public static MetaItem<?>.MetaValueItem BATTERY_SU_HV_MERCURY;
    public static MetaItem<?>.MetaValueItem BATTERY_RE_HV_CADMIUM;
    public static MetaItem<?>.MetaValueItem BATTERY_RE_HV_LITHIUM;
    public static MetaItem<?>.MetaValueItem BATTERY_RE_HV_SODIUM;
    
    public static MetaItem<?>.MetaValueItem ENERGY_LAPOTRONIC_ORB;
    public static MetaItem<?>.MetaValueItem ENERGY_LAPOTRONIC_ORB2;
    public static MetaItem<?>.MetaValueItem ENERGY_LAPOTRONIC_ORB3;
    
    public static MetaItem<?>.MetaValueItem ELECTRIC_MOTOR_LV;
    public static MetaItem<?>.MetaValueItem ELECTRIC_MOTOR_MV;
    public static MetaItem<?>.MetaValueItem ELECTRIC_MOTOR_HV;
    public static MetaItem<?>.MetaValueItem ELECTRIC_MOTOR_EV;
    public static MetaItem<?>.MetaValueItem ELECTRIC_MOTOR_IV;
    public static MetaItem<?>.MetaValueItem ELECTRIC_MOTOR_LuV;
    public static MetaItem<?>.MetaValueItem ELECTRIC_MOTOR_UV;

    public static MetaItem<?>.MetaValueItem ELECTRIC_PUMP_LV;
    public static MetaItem<?>.MetaValueItem ELECTRIC_PUMP_MV;
    public static MetaItem<?>.MetaValueItem ELECTRIC_PUMP_HV;
    public static MetaItem<?>.MetaValueItem ELECTRIC_PUMP_EV;
    public static MetaItem<?>.MetaValueItem ELECTRIC_PUMP_IV;
    public static MetaItem<?>.MetaValueItem ELECTRIC_PUMP_LuV;
    public static MetaItem<?>.MetaValueItem ELECTRIC_PUMP_UV;
    
    public static MetaItem<?>.MetaValueItem CONVEYOR_MODULE_LV;
    public static MetaItem<?>.MetaValueItem CONVEYOR_MODULE_MV;
    public static MetaItem<?>.MetaValueItem CONVEYOR_MODULE_HV;
    public static MetaItem<?>.MetaValueItem CONVEYOR_MODULE_EV;
    public static MetaItem<?>.MetaValueItem CONVEYOR_MODULE_IV;
    public static MetaItem<?>.MetaValueItem CONVEYOR_MODULE_LuV;
    public static MetaItem<?>.MetaValueItem CONVEYOR_MODULE_UV;

    public static MetaItem<?>.MetaValueItem ELECTRIC_PISTON_LV;
    public static MetaItem<?>.MetaValueItem ELECTRIC_PISTON_MV;
    public static MetaItem<?>.MetaValueItem ELECTRIC_PISTON_HV;
    public static MetaItem<?>.MetaValueItem ELECTRIC_PISTON_EV;
    public static MetaItem<?>.MetaValueItem ELECTRIC_PISTON_IV;
    public static MetaItem<?>.MetaValueItem ELECTRIC_PISTON_LuV;
    public static MetaItem<?>.MetaValueItem ELECTRIC_PISTON_UV;

    public static MetaItem<?>.MetaValueItem ROBOT_ARM_LV;
    public static MetaItem<?>.MetaValueItem ROBOT_ARM_MV;
    public static MetaItem<?>.MetaValueItem ROBOT_ARM_HV;
    public static MetaItem<?>.MetaValueItem ROBOT_ARM_EV;
    public static MetaItem<?>.MetaValueItem ROBOT_ARM_IV;
    public static MetaItem<?>.MetaValueItem ROBOT_ARM_LuV;
    public static MetaItem<?>.MetaValueItem ROBOT_ARM_UV;

    public static MetaItem<?>.MetaValueItem FIELD_GENERATOR_HV;
    public static MetaItem<?>.MetaValueItem FIELD_GENERATOR_EV;
    public static MetaItem<?>.MetaValueItem FIELD_GENERATOR_IV;
    public static MetaItem<?>.MetaValueItem FIELD_GENERATOR_LuV;
    public static MetaItem<?>.MetaValueItem FIELD_GENERATOR_UV;

    public static MetaItem<?>.MetaValueItem EMITTER_LV;
    public static MetaItem<?>.MetaValueItem EMITTER_MV;
    public static MetaItem<?>.MetaValueItem EMITTER_HV;
    public static MetaItem<?>.MetaValueItem EMITTER_EV;
    public static MetaItem<?>.MetaValueItem EMITTER_IV;
    public static MetaItem<?>.MetaValueItem EMITTER_LuV;
    public static MetaItem<?>.MetaValueItem EMITTER_UV;

    public static MetaItem<?>.MetaValueItem SENSOR_LV;
    public static MetaItem<?>.MetaValueItem SENSOR_MV;
    public static MetaItem<?>.MetaValueItem SENSOR_HV;
    public static MetaItem<?>.MetaValueItem SENSOR_EV;
    public static MetaItem<?>.MetaValueItem SENSOR_IV;
    public static MetaItem<?>.MetaValueItem SENSOR_LuV;
    public static MetaItem<?>.MetaValueItem SENSOR_UV;

    public static MetaItem<?>.MetaValueItem WIRING_BASIC;
    public static MetaItem<?>.MetaValueItem WIRING_INTERMEDIATE;
    public static MetaItem<?>.MetaValueItem WIRING_ADVANCED;
    public static MetaItem<?>.MetaValueItem WIRING_ELITE;
    public static MetaItem<?>.MetaValueItem WIRING_MASTER;
    public static MetaItem<?>.MetaValueItem WIRING_EXPERT;
    public static MetaItem<?>.MetaValueItem WIRING_ULTIMATE;
    public static MetaItem<?>.MetaValueItem WIRING_MAGIC;

    public static MetaItem<?>.MetaValueItem SOC_BASIC;
    public static MetaItem<?>.MetaValueItem SOC_INTERMEDIATE;
    public static MetaItem<?>.MetaValueItem SOC_ADVANCED;
    public static MetaItem<?>.MetaValueItem SOC_ELITE;
    public static MetaItem<?>.MetaValueItem SOC_MASTER;
    public static MetaItem<?>.MetaValueItem SOC_EXPERT;
    public static MetaItem<?>.MetaValueItem SOC_ULTIMATE;
    public static MetaItem<?>.MetaValueItem SOC_MAGIC;
    
    public static MetaItem<?>.MetaValueItem BOARD_BASIC;
    public static MetaItem<?>.MetaValueItem BOARD_INTERMEDIATE;
    public static MetaItem<?>.MetaValueItem BOARD_ADVANCED;
    public static MetaItem<?>.MetaValueItem BOARD_ELITE;
    public static MetaItem<?>.MetaValueItem BOARD_MASTER;
    public static MetaItem<?>.MetaValueItem BOARD_EXPERT;
    public static MetaItem<?>.MetaValueItem BOARD_ULTIMATE;   
    public static MetaItem<?>.MetaValueItem BOARD_MAGIC;
    
    public static MetaItem<?>.MetaValueItem GLASS_TUBE;
    public static MetaItem<?>.MetaValueItem CIRCUIT_VACUUM_TUBE_LV;
    public static MetaItem<?>.MetaValueItem PHENOLIC_BOARD;
    
    public static MetaItem<?>.MetaValueItem CIRCUIT_BASIC_LV;
    public static MetaItem<?>.MetaValueItem CIRCUIT_INTERMEDIATE_MV;
    public static MetaItem<?>.MetaValueItem CIRCUIT_ADVANCED_HV;
    public static MetaItem<?>.MetaValueItem CIRCUIT_ELITE_EV;
    public static MetaItem<?>.MetaValueItem CIRCUIT_MASTER_IV;
    public static MetaItem<?>.MetaValueItem CIRCUIT_EXPERT_LuV;
    public static MetaItem<?>.MetaValueItem CIRCUIT_ULTIMATE_UV;
    public static MetaItem<?>.MetaValueItem CIRCUIT_MAGIC;
    
    public static MetaItem<?>.MetaValueItem FLUID_FILTER;

    public static MetaItem<?>.MetaValueItem DYNAMITE;
    
    public static MetaItem<?>.MetaValueItem COMPONENT_SAW_BLADE_DIAMOND;
    public static MetaItem<?>.MetaValueItem COMPONENT_GRINDER_DIAMOND;
    public static MetaItem<?>.MetaValueItem COMPONENT_GRINDER_TUNGSTEN;
    
    public static MetaItem<?>.MetaValueItem UPGRADE_MUFFLER;
    
    public static MetaItem<?>.MetaValueItem ITEM_FILTER;
    public static MetaItem<?>.MetaValueItem ORE_DICTIONARY_FILTER;
  
    public static MetaItem<?>.MetaValueItem COVER_ACTIVITY_DETECTOR;
    public static MetaItem<?>.MetaValueItem COVER_FLUID_DETECTOR;
    public static MetaItem<?>.MetaValueItem COVER_ITEM_DETECTOR;
    public static MetaItem<?>.MetaValueItem COVER_ENERGY_DETECTOR;
    public static MetaItem<?>.MetaValueItem COVER_PLAYER_DETECTOR;
    public static MetaItem<?>.MetaValueItem COVER_SCREEN;
    public static MetaItem<?>.MetaValueItem COVER_CRAFTING;
    public static MetaItem<?>.MetaValueItem COVER_DRAIN;
    public static MetaItem<?>.MetaValueItem COVER_SHUTTER;
    public static MetaItem<?>.MetaValueItem COVER_MACHINE_CONTROLLER;

    public static MetaItem<?>.MetaValueItem INTEGRATED_CIRCUIT;

    public static MetaItem<?>.MetaValueItem FLUID_CELL;

    public static MetaItem<?>.MetaValueItem BOTTLE_PURPLE_DRINK;
    
    public static MetaItem<?>.MetaValueItem FOAM_SPRAYER;
    
    public static MetaItem<?>.MetaValueItem ENERGY_CRYSTAL;
    public static MetaItem<?>.MetaValueItem LAPOTRON_CRYSTAL;
    public static MetaItem<?>.MetaValueItem ENERGIUM_DUST;
    
    public static MetaItem<?>.MetaValueItem FUEL_BINDER;
    public static MetaItem<?>.MetaValueItem SUPER_FUEL_BINDER;
    public static MetaItem<?>.MetaValueItem MAGIC_FUEL_BINDER;
    
    public static MetaItem<?>.MetaValueItem THERMITE_DUST;
    
    public static MetaItem<?>.MetaValueItem TURBINE_ROTOR;
    
    public static MetaItem<?>.MetaValueItem RUBBER_DROP;
    
    public static ToolMetaItem<?>.MetaToolValueItem SAW;
    public static ToolMetaItem<?>.MetaToolValueItem HARD_HAMMER;
    public static ToolMetaItem<?>.MetaToolValueItem SOFT_HAMMER;
    public static ToolMetaItem<?>.MetaToolValueItem WRENCH;
    public static ToolMetaItem<?>.MetaToolValueItem FILE;
    public static ToolMetaItem<?>.MetaToolValueItem SCREWDRIVER;
    public static ToolMetaItem<?>.MetaToolValueItem MORTAR;
    public static ToolMetaItem<?>.MetaToolValueItem WIRE_CUTTER;
    public static ToolMetaItem<?>.MetaToolValueItem PLUNGER;
    public static ToolMetaItem<?>.MetaToolValueItem WRENCH_LV;
    public static ToolMetaItem<?>.MetaToolValueItem WRENCH_MV;
    public static ToolMetaItem<?>.MetaToolValueItem WRENCH_HV;
    public static ToolMetaItem<?>.MetaToolValueItem BUZZSAW;
    public static ToolMetaItem<?>.MetaToolValueItem SCREWDRIVER_LV;
    public static ToolMetaItem<?>.MetaToolValueItem KNIFE;

    public static void init() {
    	MetaItems1 first = new MetaItems1();
    	first.setRegistryName("meta_item");
        MetaAutogeneratedResources second = new MetaAutogeneratedResources();
        second.setRegistryName("meta_resource");
        MetaAutogeneratedParts third = new MetaAutogeneratedParts();
        third.setRegistryName("meta_component");
        if(Loader.isModLoaded("thaumcraft")) {
        	MetaThaumcraftComponents fourth = new MetaThaumcraftComponents();
        	fourth.setRegistryName("meta_thaumcraft_components");
        }
        if(Loader.isModLoaded("mekanism")) {
        	MetaMekanismComponents fifth = new MetaMekanismComponents();
        	fifth.setRegistryName("meta_mekanism_components");
        }                
        MetaTools tools = new MetaTools();
        tools.setRegistryName("meta_tool");
    }
    
    public static void registerOreDict() {
        for (MetaItem<?> item : ITEMS) {
            if (item instanceof MaterialMetaItem) {
                ((MaterialMetaItem)item).registerOreDict();
            }
        }
    }
    
    public static void registerRecipes() {
        for (MetaItem<?> item : ITEMS) {
            if (item instanceof MetaItems1)
                ((MetaItems1)item).registerRecipes();
        }
    }
    
    @SideOnly(Side.CLIENT)
    public static void registerModels() {
        for (MetaItem<?> item : ITEMS) {
            item.registerModels();
        }
    }

    @SideOnly(Side.CLIENT)
    public static void registerColors() {
        for (MetaItem<?> item : ITEMS) {
            item.registerColor();
        }
    }
}