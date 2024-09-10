package com.code.aseoha.client.renderers.console;

import com.code.aseoha.aseoha;
import com.code.aseoha.client.models.consoles.BrackolinConsole;
import com.code.aseoha.client.models.consoles.CustardConsoleModel;
import com.code.aseoha.tileentities.consoles.BrackolinConsoleTile;
import com.code.aseoha.tileentities.consoles.CustardConsoleTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.tardis.mod.controls.MonitorControl;
import net.tardis.mod.helper.Helper;
import org.jetbrains.annotations.NotNull;

import static com.code.aseoha.client.renderers.exteriors.BrackolinRender.TEXT;

public class CustardConsoleRender extends TileEntityRenderer<CustardConsoleTile> {

	public static final ResourceLocation TEXTURE = new ResourceLocation(aseoha.MODID, "textures/console/custard.png");
	public static final CustardConsoleModel MODEL = new CustardConsoleModel();

	public CustardConsoleRender(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@Override
	public void render(@NotNull CustardConsoleTile tileEntityIn, float partialTicks, @NotNull MatrixStack matrixStackIn, @NotNull IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		matrixStackIn.pushPose();
		float scale = 0.0625F;
		matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180));
//		matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180));
//		matrixStackIn.translate(-0.5, -1.68, 0.5);
		matrixStackIn.translate(0.5, 0.5,0.5);
		matrixStackIn.popPose();
		MODEL.render(tileEntityIn, scale, matrixStackIn, bufferIn.getBuffer(RenderType.entityTranslucent(TEXTURE )), combinedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		matrixStackIn.pushPose();

//		matrixStackIn.scale(0.5f,0.5f,0.5f);
//		matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-120));
//		matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(110));
//		matrixStackIn.scale((float) 0.5, (float) 0.5, (float) 0.5);
//		matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(90));
		Minecraft.getInstance().getItemRenderer().renderStatic(tileEntityIn.getSonicItem(), ItemCameraTransforms.TransformType.NONE, combinedLightIn, combinedOverlayIn, matrixStackIn, bufferIn);
		matrixStackIn.popPose();
	}
}