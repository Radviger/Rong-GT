package gregtech.api.metatileentity;

import codechicken.lib.raytracer.CuboidRayTraceResult;
import codechicken.lib.render.CCRenderState;
import codechicken.lib.render.pipeline.ColourMultiplier;
import codechicken.lib.render.pipeline.IVertexOperation;
import codechicken.lib.vec.Matrix4;
import gregtech.api.capability.impl.FilteredFluidHandler;
import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.capability.impl.RecipeLogicSteam;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.resources.TextureArea;
import gregtech.api.gui.widgets.ImageWidget;
import gregtech.api.gui.widgets.LabelWidget;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.render.OrientedOverlayRenderer;
import gregtech.api.render.SimpleSidedCubeRenderer;
import gregtech.api.render.SimpleSidedCubeRenderer.RenderSide;
import gregtech.api.render.Textures;
import gregtech.api.util.GTUtility;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.ArrayUtils;

public abstract class SteamMetaTileEntity extends MetaTileEntity {

    public final TextureArea BRONZE_BACKGROUND_TEXTURE;
    public final TextureArea BRONZE_SLOT_BACKGROUND_TEXTURE;

    protected final OrientedOverlayRenderer renderer;
    protected RecipeLogicSteam workableHandler;
    protected FluidTank steamFluidTank;

    public SteamMetaTileEntity(ResourceLocation metaTileEntityId, RecipeMap<?> recipeMap, OrientedOverlayRenderer renderer) {
        super(metaTileEntityId);
        this.workableHandler = new RecipeLogicSteam(this, recipeMap, steamFluidTank, 1.0);
        this.renderer = renderer;
        BRONZE_BACKGROUND_TEXTURE = getFullGuiTexture("%s_gui");
        BRONZE_SLOT_BACKGROUND_TEXTURE = getFullGuiTexture("slot_%s");
    }

    @SideOnly(Side.CLIENT)
    private SimpleSidedCubeRenderer getBaseRenderer() {
    	if(isBrickedCasing()) {
            return Textures.STEAM_BRICKED_CASING_BRONZE;
        } 
    	else {
            return Textures.STEAM_CASING_BRONZE;
        }
    }

    @Override
    public boolean onWrenchClick(EntityPlayer playerIn, EnumHand hand, EnumFacing facing, CuboidRayTraceResult hitResult) {
        if(!playerIn.isSneaking()) {
            EnumFacing currentVentingSide = workableHandler.getVentingSide();
            if(currentVentingSide == facing ||
                getFrontFacing() == facing) return false;
            workableHandler.setVentingSide(facing);
            return true;
        }
        return super.onWrenchClick(playerIn, hand, facing, hitResult);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public TextureAtlasSprite getParticleTexture() {
        return getBaseRenderer().getSpriteOnSide(RenderSide.TOP);
    }

    @Override
    public void renderMetaTileEntity(CCRenderState renderState, Matrix4 translation, IVertexOperation[] pipeline) {
        IVertexOperation[] colouredPipeline = ArrayUtils.add(pipeline, new ColourMultiplier(GTUtility.convertRGBtoOpaqueRGBA_CL(getPaintingColorForRendering())));
        getBaseRenderer().render(renderState, translation, colouredPipeline);
        renderer.render(renderState, translation, pipeline, getFrontFacing(), workableHandler.isActive());
        Textures.PIPE_OUT_OVERLAY.renderSided(workableHandler.getVentingSide(), renderState, translation, pipeline);
    }

    protected boolean isBrickedCasing() {
        return false;
    }

    @Override
    public FluidTankList createImportFluidHandler() {
        this.steamFluidTank = new FilteredFluidHandler(getSteamCapacity())
            .setFillPredicate(ModHandler::isSteam);
        return new FluidTankList(false, steamFluidTank);
    }

    public int getSteamCapacity() {
        return 16000;
    }
    
    protected TextureArea getFullGuiTexture(String pathTemplate) {
        return TextureArea.fullImage(String.format("textures/gui/steam/%s/%s.png",
            "bronze", pathTemplate.replace("%s", "bronze")));
    }

    public ModularUI.Builder createUITemplate(EntityPlayer player) {
        return ModularUI.builder(BRONZE_BACKGROUND_TEXTURE, 176, 166)
            .widget(new LabelWidget(6, 6, getMetaFullName()))
            .widget(new ImageWidget(79, 42, 18, 18, getFullGuiTexture("not_enough_steam_%s"))
                .setPredicate(() -> workableHandler.notEnoughEnergy()))
            .bindPlayerInventory(player.inventory, BRONZE_SLOT_BACKGROUND_TEXTURE);
    }
}
