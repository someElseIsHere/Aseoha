package com.code.aseoha.client.renderers.console;

import com.code.aseoha.aseoha;
import com.code.aseoha.client.models.consoles.BattleConsole;
import com.code.aseoha.client.models.consoles.BrackolinConsole;
import com.code.aseoha.tileentities.consoles.BattleConsoleTile;
import com.code.aseoha.tileentities.consoles.BrackolinConsoleTile;
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

import static com.code.aseoha.client.renderers.exteriors.BrackolinRender.TEXT;

public class BattleConsoleRender extends TileEntityRenderer<BattleConsoleTile> {

	public static final ResourceLocation TEXTURE = new ResourceLocation(aseoha.MODID, "textures/consoles/battle.png");
	public static final BattleConsole MODEL = new BattleConsole();

	public BattleConsoleRender(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(rendererDispatcherIn);
	}

	@Override
	public void render(BattleConsoleTile tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		matrixStackIn.pushPose();
		float scale = 0.0625F;
		matrixStackIn.scale((float) 1.15, (float) 1.15, (float) 1.15);
		matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(180));
		matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180));
		matrixStackIn.translate(-0.5, -1.68, 0.5);
		tileEntityIn.getControl(MonitorControl.class).ifPresent((monitor) -> {
			matrixStackIn.pushPose();
			matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(120));
			matrixStackIn.mulPose(Vector3f.XN.rotationDegrees(58));
//			matrixStackIn.mulPose(Vector3f.XN.rotation(53));
			matrixStackIn.translate(-0.125, 0.576, 0.40);
			matrixStackIn.scale((float) 0.97, (float) 0.86, (float) 1);
			TEXT.renderText(matrixStackIn, bufferIn, combinedLightIn, Helper.getConsoleText(tileEntityIn));
			matrixStackIn.popPose();
		});
		MODEL.render(tileEntityIn, scale, matrixStackIn, bufferIn.getBuffer(RenderType.entityTranslucent(TEXTURE)), combinedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		matrixStackIn.popPose();
		matrixStackIn.pushPose();
		matrixStackIn.translate(0.2, 1.25, 0.55);
		matrixStackIn.scale(0.5f, 0.5f, 0.5f);
		matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-120));
		matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(110));
		matrixStackIn.scale((float) 0.5, (float) 0.5, (float) 0.5);
		matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(90));
		Minecraft.getInstance().getItemRenderer().renderStatic(tileEntityIn.getSonicItem(), ItemCameraTransforms.TransformType.NONE, combinedLightIn, combinedOverlayIn, matrixStackIn, bufferIn);
		matrixStackIn.popPose();
	}
}