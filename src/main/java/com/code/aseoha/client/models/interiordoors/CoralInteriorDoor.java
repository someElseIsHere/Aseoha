package com.code.aseoha.client.models.interiordoors;// Made with Blockbench 4.10.2
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.code.aseoha.client.models.exteriors.CoralExterior;
import com.code.aseoha.client.renderers.exteriors.CoralRenderer;
import com.code.aseoha.enums.EnumDoorTypes;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;
import net.tardis.mod.cap.Capabilities;
import net.tardis.mod.client.TRenderTypes;
import net.tardis.mod.client.models.interiordoors.AbstractInteriorDoorModel;
import net.tardis.mod.client.renderers.boti.BOTIRenderer;
import net.tardis.mod.client.renderers.boti.PortalInfo;
import net.tardis.mod.client.renderers.entity.DoorRenderer;
import net.tardis.mod.entity.DoorEntity;
import net.tardis.mod.enums.EnumDoorState;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.misc.IDoorType;

public class CoralInteriorDoor extends AbstractInteriorDoorModel {
	private final ModelRenderer base;
	private final ModelRenderer sides;
	private final ModelRenderer side3;
	private final ModelRenderer doorsleft;
	private final ModelRenderer handle;
	private final ModelRenderer doorsright;
	private final ModelRenderer handle2;
	private final ModelRenderer corners;
	private final ModelRenderer roof;
	private final ModelRenderer box;
	private final ModelRenderer box2;
	private final ModelRenderer box3;
	private final ModelRenderer box4;
	private final ModelRenderer lamp;
	private final ModelRenderer soto;

	public CoralInteriorDoor() {
		texWidth = 64;
		texHeight = 64;

		base = new ModelRenderer(this);
		base.setPos(0.075F, 25.0F, 0.5F);


		sides = new ModelRenderer(this);
		sides.setPos(-0.075F, 0.0F, -0.5F);
		base.addChild(sides);


		side3 = new ModelRenderer(this);
		side3.setPos(-10.6F, 0.0F, -10.5F);
		sides.addChild(side3);
		setRotationAngle(side3, 0.0F, 3.1416F, 0.0F);
		side3.texOffs(23, 0).addBox(-17.6F, -30.0F, -5.5F, 1.0F, 29.0F, 1.0F, 0.0F, false);

		doorsleft = new ModelRenderer(this);
		doorsleft.setPos(6.2769F, -18.8308F, -5.0385F);
		sides.addChild(doorsleft);
		setRotationAngle(doorsleft, 0.0F, 1.5708F, 0.0F);
		doorsleft.texOffs(1, 14).addBox(-5.0385F, 16.8308F, -0.2769F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		doorsleft.texOffs(21, 0).addBox(-6.3385F, -12.0692F, -0.5769F, 2.0F, 31.0F, 2.0F, -0.7F, false);
		doorsleft.texOffs(0, 0).addBox(-6.3385F, -12.0692F, -1.1769F, 2.0F, 31.0F, 2.0F, -0.7F, false);
		doorsleft.texOffs(17, 35).addBox(-5.0385F, -11.1692F, -0.2769F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		doorsleft.texOffs(17, 35).addBox(-5.0385F, -4.1692F, -0.2769F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		doorsleft.texOffs(0, 14).addBox(-5.0385F, 2.8308F, -0.2769F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		doorsleft.texOffs(17, 35).addBox(-5.0385F, 9.8308F, -0.2769F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		doorsleft.texOffs(54, 14).addBox(-5.0385F, -4.1692F, 0.1231F, 5.0F, 22.0F, 0.0F, 0.0F, false);
		doorsleft.texOffs(32, 18).addBox(-4.5385F, -11.1692F, -1.0769F, 2.0F, 8.0F, 2.0F, -0.8F, false);
		doorsleft.texOffs(0, 0).addBox(-2.5385F, -11.1692F, -1.0769F, 2.0F, 8.0F, 2.0F, -0.8F, false);
		doorsleft.texOffs(54, 0).addBox(-5.0385F, -10.1692F, -0.1769F, 5.0F, 6.0F, 0.0F, 0.0F, false);
		doorsleft.texOffs(31, 0).addBox(-5.0385F, -3.1692F, -2.5769F, 5.0F, 6.0F, 3.0F, 0.0F, false);
		doorsleft.texOffs(21, 0).addBox(-6.5385F, -13.4692F, -0.1769F, 2.0F, 32.0F, 2.0F, -0.9F, false);

		handle = new ModelRenderer(this);
		handle.setPos(-4.5385F, 1.9308F, 0.5231F);
		doorsleft.addChild(handle);


		doorsright = new ModelRenderer(this);
		doorsright.setPos(6.2545F, -19.0455F, 6.7727F);
		sides.addChild(doorsright);
		setRotationAngle(doorsright, 0.0F, 1.5708F, 0.0F);
		doorsright.texOffs(1, 14).addBox(0.7727F, 17.0455F, -0.2545F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		doorsright.texOffs(19, 0).addBox(-0.2273F, -10.9545F, -0.2545F, 1.0F, 29.0F, 1.0F, 0.0F, false);
		doorsright.texOffs(17, 35).addBox(0.7727F, -10.9545F, -0.2545F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		doorsright.texOffs(17, 35).addBox(0.7727F, -3.9545F, -0.2545F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		doorsright.texOffs(0, 14).addBox(0.7727F, 3.0455F, -0.2545F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		doorsright.texOffs(17, 35).addBox(0.7727F, 10.0455F, -0.2545F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		doorsright.texOffs(54, 36).addBox(0.7727F, -3.9545F, 0.1455F, 5.0F, 22.0F, 0.0F, 0.0F, false);
		doorsright.texOffs(32, 18).addBox(1.2727F, -10.9545F, -1.0545F, 2.0F, 8.0F, 2.0F, -0.8F, false);
		doorsright.texOffs(0, 0).addBox(3.2727F, -10.9545F, -1.0545F, 2.0F, 8.0F, 2.0F, -0.8F, false);
		doorsright.texOffs(1, 35).addBox(-0.0273F, -7.9545F, -1.0545F, 7.0F, 2.0F, 2.0F, -0.8F, false);
		doorsright.texOffs(1, 35).addBox(5.5727F, -7.9545F, -1.0545F, 7.0F, 2.0F, 2.0F, -0.8F, false);
		doorsright.texOffs(53, 0).addBox(0.7727F, -10.9545F, -0.1545F, 5.0F, 7.0F, 0.0F, 0.0F, false);
		doorsright.texOffs(21, 0).addBox(5.0839F, -11.8545F, -0.5881F, 2.0F, 31.0F, 2.0F, -0.7F, false);
		doorsright.texOffs(0, 0).addBox(5.0839F, -11.8545F, -1.1881F, 2.0F, 31.0F, 2.0F, -0.7F, false);

		handle2 = new ModelRenderer(this);
		handle2.setPos(0.0F, 2.1455F, 0.8455F);
		doorsright.addChild(handle2);


		corners = new ModelRenderer(this);
		corners.setPos(-0.075F, 0.0F, -0.5F);
		base.addChild(corners);
		corners.texOffs(27, 0).addBox(7.0F, -30.0F, -7.0F, 1.0F, 29.0F, 1.0F, 0.0F, false);
		corners.texOffs(19, 0).addBox(7.0F, -30.0F, 7.0F, 1.0F, 29.0F, 1.0F, 0.0F, false);
		corners.texOffs(23, 0).addBox(6.5F, -30.0F, 6.5F, 1.0F, 29.0F, 1.0F, 0.0F, false);
		corners.texOffs(23, 0).addBox(6.5F, -30.0F, -6.5F, 1.0F, 29.0F, 1.0F, 0.0F, false);

		roof = new ModelRenderer(this);
		roof.setPos(13.125F, -32.3143F, 0.0F);
		base.addChild(roof);
		roof.texOffs(0, 47).addBox(-7.5F, 0.3143F, -7.5F, 3.0F, 2.0F, 15.0F, 0.0F, false);

		box = new ModelRenderer(this);
		box.setPos(0.7F, 3.3143F, -1.0F);
		roof.addChild(box);


		box2 = new ModelRenderer(this);
		box2.setPos(0.4F, 32.3143F, -0.5F);
		roof.addChild(box2);
		setRotationAngle(box2, 0.0F, -1.5708F, 0.0F);


		box3 = new ModelRenderer(this);
		box3.setPos(1.5F, 32.3143F, 0.5F);
		roof.addChild(box3);
		setRotationAngle(box3, 0.0F, 3.1416F, 0.0F);
		box3.texOffs(0, 46).addBox(8.1F, -32.7F, -7.5F, 2.0F, 2.0F, 16.0F, -0.9F, false);
		box3.texOffs(14, 59).addBox(8.1F, -32.5F, -7.5F, 2.0F, 3.0F, 2.0F, -0.9F, false);
		box3.texOffs(14, 59).addBox(8.1F, -32.5F, 6.5F, 2.0F, 3.0F, 2.0F, -0.9F, false);
		box3.texOffs(0, 46).addBox(8.1F, -31.3F, -7.5F, 2.0F, 2.0F, 16.0F, -0.9F, false);
		box3.texOffs(18, 37).addBox(8.0F, -32.5F, -7.5F, 2.0F, 3.0F, 16.0F, -0.9F, false);

		box4 = new ModelRenderer(this);
		box4.setPos(-1.5F, 32.3143F, 3.5F);
		roof.addChild(box4);
		setRotationAngle(box4, 0.0F, 1.5708F, 0.0F);


		lamp = new ModelRenderer(this);
		lamp.setPos(-0.5F, -1.6857F, -0.5F);
		roof.addChild(lamp);


		soto = new ModelRenderer(this);
		soto.setPos(0.0F, 0.0F, 0.0F);
		base.addChild(soto);
		soto.texOffs(29, 18).addBox(8.0F, -30.0F, -7.0F, 1.0F, 30.0F, 14.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		base.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void renderBones(DoorEntity door, MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay) {
		matrixStack.pushPose();
		matrixStack.translate(0.0, -0.2, 0.0);
		matrixStack.scale(1.1F, 1.1F, 1.1F);
		matrixStack.mulPose(Vector3f.YP.rotationDegrees(90));
		EnumDoorState state = door.getOpenState();
		switch (state) {
			case ONE:
				this.doorsright.yRot = (float) Math.toRadians(150.0);
				this.doorsleft.yRot = (float) Math.toRadians(EnumDoorTypes.CORAL.getRotationForState(EnumDoorState.CLOSED));
				break;
			case BOTH:
				this.doorsright.yRot = (float) Math.toRadians(150.0);
				this.doorsleft.yRot = (float) Math.toRadians(EnumDoorTypes.CORAL.getRotationForState(EnumDoorState.BOTH));
				break;
			case CLOSED:
				this.doorsright.yRot = (float) Math.toRadians(EnumDoorTypes.CORAL.getRotationForState(EnumDoorState.CLOSED));
				this.doorsleft.yRot = (float) Math.toRadians(EnumDoorTypes.CORAL.getRotationForState(EnumDoorState.CLOSED));
		}
		this.base.render(matrixStack, buffer, packedLight, packedOverlay);
		matrixStack.popPose();
	}

	public void renderBoti(DoorEntity door, MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay) {
		if (Minecraft.getInstance().level != null && door.getOpenState() != EnumDoorState.CLOSED) {
			Minecraft.getInstance().level.getCapability(Capabilities.TARDIS_DATA).ifPresent((data) -> {
				PortalInfo info = new PortalInfo();
				info.setWorldShell(data.getBotiWorld());
				info.setPosition(door.position());
				info.setTranslate((matrix) -> {
					DoorRenderer.applyTranslations(matrix, door.yRot - 180.0F, door.getDirection());
					matrix.translate(0.0, 1.0, -1.05);
					matrix.mulPose(Vector3f.ZN.rotationDegrees(180.0F));
				});
				info.setTranslatePortal((matrix) -> {
					matrix.translate(0.0, -0.75, 1.0);
					matrix.mulPose(Vector3f.YP.rotationDegrees(WorldHelper.getAngleFromFacing(data.getBotiWorld().getPortalDirection())));
					matrix.translate(-0.5, 0.0, -0.5);
				});
				info.setRenderPortal((matrix, buf) -> {
					matrix.pushPose();
					this.soto.render(matrix, buf.getBuffer(TRenderTypes.getTardis(this.getTexture())), packedLight, packedOverlay);
					matrix.popPose();
				});
				info.setRenderDoor((matrix, buf) -> {
					matrix.pushPose();
					matrix.mulPose(Vector3f.ZP.rotationDegrees(180.0F));
					matrix.translate(0.0, 1.5, 0.0);
					matrix.scale(0.25F, 0.25F, 0.25F);
					this.doorsleft.render(matrix, buf.getBuffer(TRenderTypes.getTardis(this.getTexture())), packedLight, packedOverlay);
					matrix.popPose();
				});
				BOTIRenderer.addPortal(info);
			});
		}
		//		if (Minecraft.getInstance().level != null && door.getOpenState() != EnumDoorState.CLOSED) {
//			Minecraft.getInstance().level.getCapability(Capabilities.TARDIS_DATA).ifPresent((data) -> {
//				matrixStack.pushPose();
//				PortalInfo info = new PortalInfo();
//				info.setPosition(door.position());
//				info.setWorldShell(data.getBotiWorld());
//				info.setTranslate((matrix) -> {
//					matrix.scale(1.0F, 1.0F, .95F);
//					matrix.translate(-1.01, -1.7, -.36);
////					matrix.mulPose(Vector3f.YP.rotation(45.0F));
//					DoorRenderer.applyTranslations(matrix, door.yRot - 90.0F, door.getDirection());
//				});
//				info.setTranslatePortal((matrix) -> {
//					matrix.mulPose(Vector3f.ZN.rotationDegrees(180.0F));
//					matrix.mulPose(Vector3f.YP.rotationDegrees(WorldHelper.getAngleFromFacing(data.getBotiWorld().getPortalDirection())-90));
//					matrix.translate(-1, 0, .52);
//				});
//				info.setRenderPortal((matrix, impl) -> {
//					matrix.pushPose();
//					matrix.translate(-0.05, -0.2, -0.5);
//					matrix.scale(1.1F, 1.1F, 1.1F);
//					this.soto.render(matrix, impl.getBuffer(RenderType.entityCutout(this.getTexture())), packedLight, packedOverlay);
//					matrix.popPose();
//				});
//				BOTIRenderer.addPortal(info);
//				matrixStack.popPose();
//			});
//		}

	}

	public ResourceLocation getTexture(){return CoralRenderer.TEXTURE;}
}