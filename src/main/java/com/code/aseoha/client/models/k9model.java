package com.code.aseoha.client.models;// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import com.code.aseoha.entities.k9;
import net.minecraft.util.math.vector.Vector3f;

public class k9model <T extends k9> extends EntityModel<T> {
	private final ModelRenderer head;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer body;
	private final ModelRenderer base;
	private final ModelRenderer base2;
	private final ModelRenderer side1;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer side2;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer tail;

	public k9model() {
		texWidth = 128;
		texHeight = 128;

		head = new ModelRenderer(this);
		head.setPos(0.0F, 23.5F, 0.0F);
		head.texOffs(0, 11).addBox(-2.0F, -9.0F, -9.0F, 4.0F, 4.0F, 1.0F, 0.0F, false);
		head.texOffs(8, 38).addBox(-1.0F, -5.0F, -8.5F, 2.0F, 2.0F, 0.0F, 0.0F, false);
		head.texOffs(0, 0).addBox(-2.5F, -14.0F, -13.75F, 5.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.25F, -12.0F, -11.0F);
		head.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.7854F, 0.0F);
		cube_r1.texOffs(10, 11).addBox(1.0F, -5.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(1.5F, -14.0F, -12.25F);
		head.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, -0.7854F, 0.0F);
		cube_r2.texOffs(13, 6).addBox(0.0F, -1.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(-3.0F, -12.0F, -13.75F);
		head.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, -0.7854F, 0.0F);
		cube_r3.texOffs(10, 11).addBox(1.0F, -5.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(-1.5F, -14.0F, -12.25F);
		head.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.7854F, 0.0F);
		cube_r4.texOffs(12, 6).addBox(0.0F, -1.0F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(-0.5F, -10.75F, -13.75F);
		head.addChild(cube_r5);
		setRotationAngle(cube_r5, -0.3054F, 0.0F, 0.0F);
		cube_r5.texOffs(0, 7).addBox(-2.0F, -3.0F, -1.0F, 5.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setPos(-0.5F, -8.25F, -11.5F);
		head.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0873F, 0.0F, 0.0F);
		cube_r6.texOffs(42, 51).addBox(-2.0F, -3.0F, -6.0F, 5.0F, 3.0F, 7.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setPos(0.0F, -6.25F, -9.75F);
		head.addChild(cube_r7);
		setRotationAngle(cube_r7, -0.7854F, 0.0F, 0.0F);
		cube_r7.texOffs(38, 0).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 4.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setPos(0.0F, 24.0F, 0.0F);


		base = new ModelRenderer(this);
		base.setPos(0.75F, -3.25F, 0.0F);
		body.addChild(base);
		base.texOffs(32, 17).addBox(-6.25F, 2.25F, -7.5F, 11.0F, 1.0F, 15.0F, 0.0F, false);

		base2 = new ModelRenderer(this);
		base2.setPos(3.25F, -2.75F, 0.0F);
		body.addChild(base2);
		base2.texOffs(0, 0).addBox(-8.75F, 1.25F, -8.0F, 11.0F, 1.0F, 16.0F, 0.0F, false);
		base2.texOffs(0, 17).addBox(-7.25F, -6.75F, -8.0F, 8.0F, 5.0F, 16.0F, 0.0F, false);
		base2.texOffs(0, 55).addBox(-5.25F, -7.75F, -3.0F, 4.0F, 1.0F, 6.0F, 0.0F, false);
		base2.texOffs(50, 33).addBox(-7.75F, -1.75F, -7.75F, 9.0F, 3.0F, 1.0F, 0.0F, false);
		base2.texOffs(14, 38).addBox(-7.75F, -1.75F, 6.75F, 9.0F, 3.0F, 1.0F, 0.0F, false);

		side1 = new ModelRenderer(this);
		side1.setPos(3.25F, -2.75F, 0.0F);
		body.addChild(side1);


		cube_r8 = new ModelRenderer(this);
		cube_r8.setPos(0.0F, 0.0F, 2.0F);
		side1.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.0F, -0.2618F);
		cube_r8.texOffs(50, 38).addBox(1.5F, 1.75F, -8.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setPos(0.0F, 0.0F, -2.0F);
		side1.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 0.0F, -0.2618F);
		cube_r9.texOffs(0, 38).addBox(1.5F, -6.25F, -4.0F, 1.0F, 5.0F, 12.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setPos(0.0F, 0.0F, 0.0F);
		side1.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.0F, -0.2618F);
		cube_r10.texOffs(0, 38).addBox(0.5F, -6.25F, 6.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);
		cube_r10.texOffs(32, 17).addBox(0.5F, -6.25F, -8.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setPos(-0.25F, 0.0F, 2.0F);
		side1.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 0.0F, -0.2618F);
		cube_r11.texOffs(39, 0).addBox(2.5F, -1.25F, -8.0F, 0.0F, 4.0F, 12.0F, 0.0F, false);

		side2 = new ModelRenderer(this);
		side2.setPos(-3.25F, -2.75F, 0.0F);
		body.addChild(side2);
		setRotationAngle(side2, 0.0F, 3.1416F, 0.0F);


		cube_r12 = new ModelRenderer(this);
		cube_r12.setPos(0.0F, 0.0F, 2.0F);
		side2.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 0.0F, -0.2618F);
		cube_r12.texOffs(28, 50).addBox(1.5F, 1.75F, -8.0F, 1.0F, 1.0F, 12.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setPos(0.0F, 0.0F, -2.0F);
		side2.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, 0.0F, -0.2618F);
		cube_r13.texOffs(36, 33).addBox(1.5F, -6.25F, -4.0F, 1.0F, 5.0F, 12.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setPos(0.0F, 0.0F, 0.0F);
		side2.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, 0.0F, -0.2618F);
		cube_r14.texOffs(0, 17).addBox(0.5F, -6.25F, 6.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);
		cube_r14.texOffs(8, 17).addBox(0.5F, -6.25F, -8.0F, 2.0F, 9.0F, 2.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setPos(-0.5F, 0.0F, 2.0F);
		side2.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, 0.0F, -0.2618F);
		cube_r15.texOffs(39, 0).addBox(2.5F, -1.25F, -8.0F, 0.0F, 4.0F, 12.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setPos(-0.5F, 16.5F, 9.0F);
		tail.texOffs(52, 0).addBox(0.0F, -2.0F, -1.0F, 1.0F, 1.0F, 8.0F, 0.0F, false);
	}
//	private final ModelRenderer base;
//	private final ModelRenderer tail_r1;
//	private final ModelRenderer cube_r1;
//	private final ModelRenderer cube_r2;
//	private final ModelRenderer cube_r3;
//	private final ModelRenderer cube_r4;
//	private final ModelRenderer cube_r5;
//	private final ModelRenderer cube_r6;
//	private final ModelRenderer cube_r7;
//	private final ModelRenderer cube_r8;
//	private final ModelRenderer cube_r9;
//	private final ModelRenderer cube_r10;
//	private final ModelRenderer cube_r11;
//	private final ModelRenderer cube_r12;
//	private final ModelRenderer cube_r13;
//	private final ModelRenderer cube_r14;
//	private final ModelRenderer cube_r15;
//	private final ModelRenderer cube_r16;
//	private final ModelRenderer cube_r17;
//	private final ModelRenderer cube_r18;
//	private final ModelRenderer head;
//	private final ModelRenderer cube_r19;
//	private final ModelRenderer cube_r20;
//	private final ModelRenderer cube_r21;
//	private final ModelRenderer cube_r22;
//	private final ModelRenderer cube_r23;
//	private final ModelRenderer cube_r24;
//	private final ModelRenderer cube_r25;
//	private final ModelRenderer cube_r26;
//	private final ModelRenderer cube_r27;
//	private final ModelRenderer cube_r28;
//	private final ModelRenderer cube_r29;
//	private final ModelRenderer cube_r30;
//	private final ModelRenderer cube_r31;
//	private final ModelRenderer cube_r32;
//	private final ModelRenderer cube_r33;
//	private final ModelRenderer cube_r34;
//	private final ModelRenderer cube_r35;
//	private final ModelRenderer cube_r36;
//	private final ModelRenderer cube_r37;
//	private final ModelRenderer cube_r38;
//	private final ModelRenderer cube_r39;
//	private final ModelRenderer cube_r40;
//	private final ModelRenderer lear;
//	private final ModelRenderer cube_r41;
//	private final ModelRenderer cube_r42;
//	private final ModelRenderer cube_r43;
//	private final ModelRenderer cube_r44;
//	private final ModelRenderer cube_r45;
//	private final ModelRenderer cube_r46;
//	private final ModelRenderer lear2;
//	private final ModelRenderer cube_r47;
//	private final ModelRenderer cube_r48;
//	private final ModelRenderer cube_r49;
//	private final ModelRenderer cube_r50;
//	private final ModelRenderer cube_r51;
//	private final ModelRenderer cube_r52;
//
//	public k9model() {
//		texWidth = 128;
//		texHeight = 128;
//
//		base = new ModelRenderer(this);
//		base.setPos(0.0F, 24.0F, 0.0F);
//		base.texOffs(0, 0).addBox(-5.0F, -1.0F, -8.0F, 10.0F, 1.0F, 16.0F, 0.0F, false);
//		base.texOffs(59, 49).addBox(-5.0F, -5.0F, -8.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
//		base.texOffs(109, 0).addBox(-4.0F, -3.0F, -7.8F, 8.0F, 2.0F, 1.0F, 0.0F, false);
//		base.texOffs(108, 76).addBox(-4.0F, -4.0F, -7.7F, 8.0F, 2.0F, 1.0F, 0.0F, false);
//		base.texOffs(108, 72).addBox(-4.0F, -5.0F, -7.5F, 8.0F, 2.0F, 1.0F, 0.0F, false);
//		base.texOffs(108, 68).addBox(-4.0F, -6.0F, -7.3F, 8.0F, 2.0F, 1.0F, 0.0F, false);
//		base.texOffs(108, 61).addBox(-4.0F, -7.0F, -7.2F, 8.0F, 2.0F, 1.0F, 0.0F, false);
//		base.texOffs(108, 57).addBox(-4.0F, -8.0F, -7.1F, 8.0F, 2.0F, 1.0F, 0.0F, false);
//		base.texOffs(108, 53).addBox(-4.0F, -8.8F, -7.0F, 8.0F, 2.0F, 1.0F, 0.0F, false);
//		base.texOffs(37, 0).addBox(-5.4F, -9.4F, -8.4F, 2.0F, 5.0F, 2.0F, -0.6F, false);
//		base.texOffs(104, 41).addBox(-5.0F, -9.4F, -8.4F, 10.0F, 2.0F, 2.0F, -0.61F, false);
//		base.texOffs(0, 36).addBox(3.4F, -9.4F, -8.4F, 2.0F, 5.0F, 2.0F, -0.6F, false);
//		base.texOffs(59, 43).addBox(4.0F, -5.0F, -8.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
//		base.texOffs(0, 25).addBox(3.4F, -9.4F, 6.4F, 2.0F, 5.0F, 2.0F, -0.6F, false);
//		base.texOffs(0, 18).addBox(-5.1F, -9.4F, -6.6F, 10.0F, 2.0F, 15.0F, -0.61F, false);
//		base.texOffs(104, 36).addBox(-4.95F, -9.7F, 6.0F, 10.0F, 2.0F, 2.0F, -0.6F, false);
//		base.texOffs(63, 106).addBox(-4.95F, -10.2F, 5.4F, 10.0F, 2.0F, 2.0F, -0.6F, false);
//		base.texOffs(100, 105).addBox(-4.95F, -10.8F, 4.9F, 10.0F, 2.0F, 2.0F, -0.6F, false);
//		base.texOffs(0, 105).addBox(-4.95F, -11.5F, 4.4F, 10.0F, 2.0F, 2.0F, -0.6F, false);
//		base.texOffs(102, 100).addBox(-4.95F, -12.2F, 4.2F, 10.0F, 2.0F, 2.0F, -0.6F, false);
//		base.texOffs(102, 89).addBox(-4.95F, -12.9F, 4.0F, 10.0F, 2.0F, 2.0F, -0.6F, false);
//		base.texOffs(102, 84).addBox(-4.95F, -13.5F, 3.8F, 10.0F, 2.0F, 2.0F, -0.66F, false);
//		base.texOffs(0, 36).addBox(-4.95F, -13.5F, -5.3F, 10.0F, 2.0F, 11.0F, -0.68F, false);
//		base.texOffs(75, 19).addBox(-2.45F, -13.9F, -1.0F, 5.0F, 2.0F, 4.0F, -0.68F, false);
//		base.texOffs(60, 79).addBox(0.95F, -13.6F, -0.2F, 1.0F, 2.0F, 1.0F, -0.2F, false);
//		base.texOffs(60, 83).addBox(0.25F, -13.6F, -0.2F, 1.0F, 2.0F, 1.0F, -0.2F, false);
//		base.texOffs(83, 8).addBox(-0.45F, -13.6F, -0.2F, 1.0F, 2.0F, 1.0F, -0.2F, false);
//		base.texOffs(83, 4).addBox(-1.15F, -13.6F, -0.2F, 1.0F, 2.0F, 1.0F, -0.2F, false);
//		base.texOffs(78, 38).addBox(-1.85F, -13.6F, -0.2F, 1.0F, 2.0F, 1.0F, -0.2F, false);
//		base.texOffs(9, 76).addBox(-1.85F, -13.6F, 0.5F, 1.0F, 2.0F, 1.0F, -0.2F, false);
//		base.texOffs(43, 81).addBox(-1.15F, -13.6F, 0.5F, 1.0F, 2.0F, 1.0F, -0.2F, false);
//		base.texOffs(77, 82).addBox(-0.45F, -13.6F, 0.5F, 1.0F, 2.0F, 1.0F, -0.2F, false);
//		base.texOffs(83, 0).addBox(0.25F, -13.6F, 0.5F, 1.0F, 2.0F, 1.0F, -0.2F, false);
//		base.texOffs(43, 77).addBox(0.95F, -13.6F, 0.5F, 1.0F, 2.0F, 1.0F, -0.2F, false);
//		base.texOffs(45, 24).addBox(-1.85F, -13.6F, 1.2F, 1.0F, 2.0F, 1.0F, -0.2F, false);
//		base.texOffs(17, 68).addBox(-1.15F, -13.6F, 1.2F, 1.0F, 2.0F, 1.0F, -0.2F, false);
//		base.texOffs(25, 78).addBox(-0.45F, -13.6F, 1.2F, 1.0F, 2.0F, 1.0F, -0.2F, false);
//		base.texOffs(26, 74).addBox(0.25F, -13.6F, 1.2F, 1.0F, 2.0F, 1.0F, -0.2F, false);
//		base.texOffs(10, 61).addBox(0.95F, -13.6F, 1.2F, 1.0F, 2.0F, 1.0F, -0.2F, false);
//		base.texOffs(45, 18).addBox(4.0F, -5.0F, 7.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
//		base.texOffs(36, 18).addBox(-5.4F, -9.4F, 6.4F, 2.0F, 5.0F, 2.0F, -0.6F, false);
//		base.texOffs(9, 25).addBox(-5.0F, -5.0F, 7.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
//		base.texOffs(85, 84).addBox(-4.8F, -2.0F, -7.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);
//		base.texOffs(0, 84).addBox(-4.5F, -2.7F, -7.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);
//		base.texOffs(17, 74).addBox(-4.2F, -3.4F, -7.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);
//		base.texOffs(92, 69).addBox(-3.9F, -3.9F, -6.4F, 1.0F, 1.0F, 13.0F, 0.1F, false);
//		base.texOffs(92, 53).addBox(-4.0F, -5.0F, -6.5F, 1.0F, 1.0F, 13.0F, 0.0F, false);
//		base.texOffs(69, 34).addBox(-4.2F, -6.0F, -7.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);
//		base.texOffs(68, 82).addBox(-4.5F, -7.0F, -7.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);
//		base.texOffs(51, 79).addBox(-4.7F, -8.0F, -7.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);
//		base.texOffs(27, 39).addBox(-5.4F, -9.4F, -8.1F, 2.0F, 2.0F, 16.0F, -0.61F, false);
//		base.texOffs(102, 25).addBox(-5.0F, -10.2F, -8.4F, 10.0F, 2.0F, 2.0F, -0.6F, false);
//		base.texOffs(20, 50).addBox(-4.5F, -11.0F, -8.1F, 9.0F, 2.0F, 2.0F, -0.6F, false);
//		base.texOffs(102, 19).addBox(-4.5F, -12.6F, -7.4F, 9.0F, 2.0F, 3.0F, -0.6F, false);
//		base.texOffs(52, 98).addBox(-4.5F, -13.4F, -7.0F, 9.0F, 2.0F, 3.0F, -0.6F, false);
//		base.texOffs(77, 100).addBox(-4.5F, -11.8F, -7.8F, 9.0F, 2.0F, 3.0F, -0.6F, false);
//		base.texOffs(0, 101).addBox(-0.5F, -11.2F, 5.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
//
//		tail_r1 = new ModelRenderer(this);
//		tail_r1.setPos(1.0F, -10.4F, 5.6F);
//		base.addChild(tail_r1);
//		setRotationAngle(tail_r1, -0.7854F, 0.0F, 0.0F);
//		tail_r1.texOffs(0, 113).addBox(-2.0F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, -0.9F, false);
//
//		cube_r1 = new ModelRenderer(this);
//		cube_r1.setPos(-3.55F, -8.55F, -1.85F);
//		base.addChild(cube_r1);
//		setRotationAngle(cube_r1, 0.0F, -3.1416F, 0.0F);
//		cube_r1.texOffs(37, 0).addBox(-0.55F, -4.45F, -7.05F, 2.0F, 2.0F, 11.0F, -0.6F, false);
//
//		cube_r2 = new ModelRenderer(this);
//		cube_r2.setPos(-3.55F, -7.75F, -1.65F);
//		base.addChild(cube_r2);
//		setRotationAngle(cube_r2, 0.0F, -3.1416F, 0.0F);
//		cube_r2.texOffs(91, 38).addBox(-0.55F, -4.45F, -7.05F, 2.0F, 2.0F, 12.0F, -0.6F, false);
//
//		cube_r3 = new ModelRenderer(this);
//		cube_r3.setPos(-3.65F, -7.05F, -1.45F);
//		base.addChild(cube_r3);
//		setRotationAngle(cube_r3, 0.0F, -3.1416F, 0.0F);
//		cube_r3.texOffs(22, 58).addBox(-0.55F, -4.45F, -7.05F, 2.0F, 2.0F, 13.0F, -0.6F, false);
//
//		cube_r4 = new ModelRenderer(this);
//		cube_r4.setPos(-3.75F, -6.35F, -0.95F);
//		base.addChild(cube_r4);
//		setRotationAngle(cube_r4, 0.0F, -3.1416F, 0.0F);
//		cube_r4.texOffs(53, 0).addBox(-0.55F, -4.45F, -7.05F, 2.0F, 2.0F, 14.0F, -0.6F, false);
//
//		cube_r5 = new ModelRenderer(this);
//		cube_r5.setPos(-3.85F, -5.75F, -0.45F);
//		base.addChild(cube_r5);
//		setRotationAngle(cube_r5, 0.0F, -3.1416F, 0.0F);
//		cube_r5.texOffs(49, 43).addBox(-0.55F, -4.45F, -7.05F, 2.0F, 2.0F, 15.0F, -0.61F, false);
//
//		cube_r6 = new ModelRenderer(this);
//		cube_r6.setPos(3.95F, -4.95F, 0.05F);
//		base.addChild(cube_r6);
//		setRotationAngle(cube_r6, 0.0F, 3.1416F, 0.0F);
//		cube_r6.texOffs(34, 77).addBox(-0.85F, 2.95F, -6.95F, 1.0F, 1.0F, 14.0F, 0.0F, false);
//		cube_r6.texOffs(75, 3).addBox(-0.55F, 2.25F, -6.95F, 1.0F, 1.0F, 14.0F, 0.0F, false);
//		cube_r6.texOffs(0, 68).addBox(-0.25F, 1.55F, -6.95F, 1.0F, 1.0F, 14.0F, 0.0F, false);
//		cube_r6.texOffs(57, 63).addBox(-0.25F, -1.05F, -6.95F, 1.0F, 1.0F, 14.0F, 0.0F, false);
//		cube_r6.texOffs(74, 66).addBox(-0.55F, -2.05F, -6.95F, 1.0F, 1.0F, 14.0F, 0.0F, false);
//		cube_r6.texOffs(74, 50).addBox(-0.75F, -3.05F, -6.95F, 1.0F, 1.0F, 14.0F, 0.0F, false);
//		cube_r6.texOffs(35, 20).addBox(-1.45F, -4.45F, -8.05F, 2.0F, 2.0F, 16.0F, -0.61F, false);
//
//		cube_r7 = new ModelRenderer(this);
//		cube_r7.setPos(3.85F, -4.85F, 0.55F);
//		base.addChild(cube_r7);
//		setRotationAngle(cube_r7, 0.0F, 3.1416F, 0.0F);
//		cube_r7.texOffs(86, 21).addBox(-0.05F, 0.95F, -5.95F, 1.0F, 1.0F, 13.0F, 0.1F, false);
//
//		cube_r8 = new ModelRenderer(this);
//		cube_r8.setPos(3.95F, -4.95F, 0.55F);
//		base.addChild(cube_r8);
//		setRotationAngle(cube_r8, 0.0F, 3.1416F, 0.0F);
//		cube_r8.texOffs(18, 90).addBox(-0.05F, -0.05F, -5.95F, 1.0F, 1.0F, 13.0F, 0.0F, false);
//
//		cube_r9 = new ModelRenderer(this);
//		cube_r9.setPos(3.65F, -8.55F, -1.85F);
//		base.addChild(cube_r9);
//		setRotationAngle(cube_r9, 0.0F, 3.1416F, 0.0F);
//		cube_r9.texOffs(36, 95).addBox(-1.45F, -4.45F, -7.05F, 2.0F, 2.0F, 11.0F, -0.6F, false);
//
//		cube_r10 = new ModelRenderer(this);
//		cube_r10.setPos(3.65F, -7.75F, -1.65F);
//		base.addChild(cube_r10);
//		setRotationAngle(cube_r10, 0.0F, 3.1416F, 0.0F);
//		cube_r10.texOffs(92, 0).addBox(-1.45F, -4.45F, -7.05F, 2.0F, 2.0F, 12.0F, -0.6F, false);
//
//		cube_r11 = new ModelRenderer(this);
//		cube_r11.setPos(3.75F, -7.05F, -1.45F);
//		base.addChild(cube_r11);
//		setRotationAngle(cube_r11, 0.0F, 3.1416F, 0.0F);
//		cube_r11.texOffs(40, 61).addBox(-1.45F, -4.45F, -7.05F, 2.0F, 2.0F, 13.0F, -0.6F, false);
//
//		cube_r12 = new ModelRenderer(this);
//		cube_r12.setPos(3.85F, -6.35F, -0.95F);
//		base.addChild(cube_r12);
//		setRotationAngle(cube_r12, 0.0F, 3.1416F, 0.0F);
//		cube_r12.texOffs(56, 17).addBox(-1.45F, -4.45F, -7.05F, 2.0F, 2.0F, 14.0F, -0.6F, false);
//
//		cube_r13 = new ModelRenderer(this);
//		cube_r13.setPos(3.95F, -5.75F, -0.45F);
//		base.addChild(cube_r13);
//		setRotationAngle(cube_r13, 0.0F, 3.1416F, 0.0F);
//		cube_r13.texOffs(0, 50).addBox(-1.45F, -4.45F, -7.05F, 2.0F, 2.0F, 15.0F, -0.61F, false);
//
//		cube_r14 = new ModelRenderer(this);
//		cube_r14.setPos(-0.75F, -12.9605F, -1.6772F);
//		base.addChild(cube_r14);
//		setRotationAngle(cube_r14, -0.1745F, 0.0F, 0.0F);
//		cube_r14.texOffs(90, 19).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, -0.4F, false);
//		cube_r14.texOffs(91, 53).addBox(0.6F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, -0.4F, false);
//
//		cube_r15 = new ModelRenderer(this);
//		cube_r15.setPos(-0.75F, -12.8605F, -1.6772F);
//		base.addChild(cube_r15);
//		setRotationAngle(cube_r15, -0.1745F, 0.0F, 0.0F);
//		cube_r15.texOffs(17, 90).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, -0.35F, false);
//		cube_r15.texOffs(24, 90).addBox(0.6F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, -0.35F, false);
//
//		cube_r16 = new ModelRenderer(this);
//		cube_r16.setPos(0.05F, -13.1F, -1.6F);
//		base.addChild(cube_r16);
//		setRotationAngle(cube_r16, -0.1745F, 0.0F, 0.0F);
//		cube_r16.texOffs(69, 50).addBox(-2.5F, -1.0F, -2.0F, 5.0F, 3.0F, 4.0F, -0.68F, false);
//
//		cube_r17 = new ModelRenderer(this);
//		cube_r17.setPos(0.0F, -4.5F, 7.05F);
//		base.addChild(cube_r17);
//		setRotationAngle(cube_r17, 0.0F, 3.1416F, 0.0F);
//		cube_r17.texOffs(108, 46).addBox(-4.0F, 1.5F, -0.85F, 8.0F, 2.0F, 1.0F, 0.0F, false);
//		cube_r17.texOffs(106, 15).addBox(-4.0F, -3.5F, -0.15F, 8.0F, 2.0F, 1.0F, 0.0F, false);
//		cube_r17.texOffs(102, 94).addBox(-4.0F, -2.5F, -0.25F, 8.0F, 2.0F, 1.0F, 0.0F, false);
//		cube_r17.texOffs(48, 39).addBox(-4.0F, 0.5F, -0.75F, 8.0F, 2.0F, 1.0F, 0.0F, false);
//
//		cube_r18 = new ModelRenderer(this);
//		cube_r18.setPos(0.0F, -4.5F, 7.05F);
//		base.addChild(cube_r18);
//		setRotationAngle(cube_r18, 0.0F, 3.1416F, 0.0F);
//		cube_r18.texOffs(102, 30).addBox(-4.0F, -1.5F, -0.35F, 8.0F, 2.0F, 1.0F, 0.0F, false);
//		cube_r18.texOffs(75, 26).addBox(-4.0F, -0.5F, -0.55F, 8.0F, 2.0F, 1.0F, 0.0F, false);
//
//		head = new ModelRenderer(this);
//		head.setPos(1.5F, -10.6F, -5.4F);
//		base.addChild(head);
//		head.texOffs(0, 18).addBox(-3.0F, -2.3F, -2.6F, 3.0F, 3.0F, 3.0F, -0.6F, false);
//
//		cube_r19 = new ModelRenderer(this);
//		cube_r19.setPos(-1.0F, -5.7F, -5.9F);
//		head.addChild(cube_r19);
//		setRotationAngle(cube_r19, 1.6144F, 0.0F, 0.0F);
//		cube_r19.texOffs(58, 61).addBox(-2.45F, 0.548F, -0.5F, 3.0F, 1.0F, 2.0F, -0.96F, false);
//		cube_r19.texOffs(53, 6).addBox(-1.55F, 0.548F, -0.5F, 3.0F, 1.0F, 2.0F, -0.96F, false);
//
//		cube_r20 = new ModelRenderer(this);
//		cube_r20.setPos(-1.0F, -5.5F, -5.9F);
//		head.addChild(cube_r20);
//		setRotationAngle(cube_r20, 1.6144F, 0.0F, 0.0F);
//		cube_r20.texOffs(58, 65).addBox(-2.45F, 0.548F, -0.5F, 3.0F, 1.0F, 2.0F, -0.96F, false);
//		cube_r20.texOffs(40, 64).addBox(-1.55F, 0.548F, -0.5F, 3.0F, 1.0F, 2.0F, -0.96F, false);
//
//		cube_r21 = new ModelRenderer(this);
//		cube_r21.setPos(-1.0F, -5.3F, -5.9F);
//		head.addChild(cube_r21);
//		setRotationAngle(cube_r21, 1.6144F, 0.0F, 0.0F);
//		cube_r21.texOffs(0, 68).addBox(-2.45F, 0.548F, -0.5F, 3.0F, 1.0F, 2.0F, -0.96F, false);
//		cube_r21.texOffs(67, 39).addBox(-1.55F, 0.548F, -0.5F, 3.0F, 1.0F, 2.0F, -0.96F, false);
//
//		cube_r22 = new ModelRenderer(this);
//		cube_r22.setPos(-1.1F, -3.7F, -7.8F);
//		head.addChild(cube_r22);
//		setRotationAngle(cube_r22, 1.789F, 0.0F, 0.0F);
//		cube_r22.texOffs(40, 58).addBox(-1.45F, -0.452F, -0.5F, 2.0F, 3.0F, 2.0F, -0.8F, false);
//
//		cube_r23 = new ModelRenderer(this);
//		cube_r23.setPos(-1.1F, -5.1F, -6.1F);
//		head.addChild(cube_r23);
//		setRotationAngle(cube_r23, 1.6144F, 0.0F, 0.0F);
//		cube_r23.texOffs(17, 84).addBox(-1.45F, 0.548F, -0.5F, 2.0F, 1.0F, 2.0F, -0.8F, false);
//
//		cube_r24 = new ModelRenderer(this);
//		cube_r24.setPos(-1.0F, -5.1F, -5.9F);
//		head.addChild(cube_r24);
//		setRotationAngle(cube_r24, 1.6144F, 0.0F, 0.0F);
//		cube_r24.texOffs(58, 69).addBox(-2.45F, 0.548F, -0.5F, 3.0F, 1.0F, 2.0F, -0.96F, false);
//		cube_r24.texOffs(69, 43).addBox(-1.55F, 0.548F, -0.5F, 3.0F, 1.0F, 2.0F, -0.96F, false);
//
//		cube_r25 = new ModelRenderer(this);
//		cube_r25.setPos(-1.0F, -4.9F, -5.9F);
//		head.addChild(cube_r25);
//		setRotationAngle(cube_r25, 1.6144F, 0.0F, 0.0F);
//		cube_r25.texOffs(72, 0).addBox(-2.45F, 0.548F, -0.5F, 3.0F, 1.0F, 2.0F, -0.96F, false);
//		cube_r25.texOffs(0, 72).addBox(-1.55F, 0.548F, -0.5F, 3.0F, 1.0F, 2.0F, -0.96F, false);
//
//		cube_r26 = new ModelRenderer(this);
//		cube_r26.setPos(-0.1F, -4.7F, -5.9F);
//		head.addChild(cube_r26);
//		setRotationAngle(cube_r26, 1.6144F, 0.0F, 0.0F);
//		cube_r26.texOffs(72, 4).addBox(-2.45F, 0.548F, -0.5F, 3.0F, 1.0F, 2.0F, -0.96F, false);
//		cube_r26.texOffs(72, 8).addBox(-3.35F, 0.548F, -0.5F, 3.0F, 1.0F, 2.0F, -0.96F, false);
//
//		cube_r27 = new ModelRenderer(this);
//		cube_r27.setPos(-1.5F, -5.2F, -6.3F);
//		head.addChild(cube_r27);
//		setRotationAngle(cube_r27, 1.6144F, 0.0F, 0.0F);
//		cube_r27.texOffs(72, 34).addBox(-1.5F, 0.548F, -0.5F, 3.0F, 1.0F, 2.0F, -0.5F, false);
//
//		cube_r28 = new ModelRenderer(this);
//		cube_r28.setPos(-1.5F, -5.3F, -6.2F);
//		head.addChild(cube_r28);
//		setRotationAngle(cube_r28, 1.6144F, 0.0F, 0.0F);
//		cube_r28.texOffs(0, 9).addBox(-1.5F, 0.548F, -1.5F, 3.0F, 3.0F, 3.0F, -0.41F, false);
//
//		cube_r29 = new ModelRenderer(this);
//		cube_r29.setPos(-1.5F, -4.6F, -6.8F);
//		head.addChild(cube_r29);
//		setRotationAngle(cube_r29, 1.789F, 0.0F, 0.0F);
//		cube_r29.texOffs(36, 26).addBox(-1.5F, 0.548F, -1.5F, 3.0F, 3.0F, 2.0F, -0.4F, false);
//
//		cube_r30 = new ModelRenderer(this);
//		cube_r30.setPos(-1.5F, -4.4F, -7.4F);
//		head.addChild(cube_r30);
//		setRotationAngle(cube_r30, 1.789F, 0.0F, 0.0F);
//		cube_r30.texOffs(32, 39).addBox(-1.5F, 0.548F, -1.5F, 3.0F, 3.0F, 2.0F, -0.4F, false);
//
//		cube_r31 = new ModelRenderer(this);
//		cube_r31.setPos(-1.5F, -4.2F, -7.9F);
//		head.addChild(cube_r31);
//		setRotationAngle(cube_r31, 1.789F, 0.0F, 0.0F);
//		cube_r31.texOffs(48, 43).addBox(-1.5F, 0.548F, -1.5F, 3.0F, 3.0F, 2.0F, -0.4F, false);
//
//		cube_r32 = new ModelRenderer(this);
//		cube_r32.setPos(-1.5F, -4.0F, -8.4F);
//		head.addChild(cube_r32);
//		setRotationAngle(cube_r32, 1.789F, 0.0F, 0.0F);
//		cube_r32.texOffs(48, 49).addBox(-1.5F, 0.548F, -1.5F, 3.0F, 3.0F, 2.0F, -0.4F, false);
//
//		cube_r33 = new ModelRenderer(this);
//		cube_r33.setPos(-1.5F, -5.4F, -7.5F);
//		head.addChild(cube_r33);
//		setRotationAngle(cube_r33, 0.1745F, 0.0F, 0.0F);
//		cube_r33.texOffs(89, 30).addBox(-1.5F, 1.548F, -0.5F, 3.0F, 2.0F, 1.0F, -0.46F, false);
//
//		cube_r34 = new ModelRenderer(this);
//		cube_r34.setPos(-1.5F, -2.7F, -3.8F);
//		head.addChild(cube_r34);
//		setRotationAngle(cube_r34, -1.3963F, 0.0F, 0.0F);
//		cube_r34.texOffs(0, 0).addBox(-1.5F, -1.452F, -2.5F, 3.0F, 5.0F, 3.0F, -0.42F, false);
//
//		cube_r35 = new ModelRenderer(this);
//		cube_r35.setPos(-1.5F, -2.1F, -3.8F);
//		head.addChild(cube_r35);
//		setRotationAngle(cube_r35, -1.5708F, 0.0F, 0.0F);
//		cube_r35.texOffs(0, 50).addBox(-1.5F, -1.452F, -1.5F, 3.0F, 3.0F, 2.0F, -0.61F, false);
//
//		cube_r36 = new ModelRenderer(this);
//		cube_r36.setPos(-1.5F, -1.7F, -3.6F);
//		head.addChild(cube_r36);
//		setRotationAngle(cube_r36, -1.2217F, 0.0F, 0.0F);
//		cube_r36.texOffs(53, 0).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 2.0F, -0.6F, false);
//
//		cube_r37 = new ModelRenderer(this);
//		cube_r37.setPos(-1.5F, -1.3F, -3.2F);
//		head.addChild(cube_r37);
//		setRotationAngle(cube_r37, -0.9163F, 0.0F, 0.0F);
//		cube_r37.texOffs(0, 56).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 2.0F, -0.6F, false);
//
//		cube_r38 = new ModelRenderer(this);
//		cube_r38.setPos(-1.5F, -1.0F, -2.8F);
//		head.addChild(cube_r38);
//		setRotationAngle(cube_r38, -0.6981F, 0.0F, 0.0F);
//		cube_r38.texOffs(56, 17).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 2.0F, -0.6F, false);
//
//		cube_r39 = new ModelRenderer(this);
//		cube_r39.setPos(-1.5F, -0.9F, -2.3F);
//		head.addChild(cube_r39);
//		setRotationAngle(cube_r39, -0.3927F, 0.0F, 0.0F);
//		cube_r39.texOffs(56, 23).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 2.0F, -0.6F, false);
//
//		cube_r40 = new ModelRenderer(this);
//		cube_r40.setPos(-1.5F, -0.8F, -1.7F);
//		head.addChild(cube_r40);
//		setRotationAngle(cube_r40, -0.2182F, 0.0F, 0.0F);
//		cube_r40.texOffs(20, 58).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 2.0F, -0.6F, false);
//
//		lear = new ModelRenderer(this);
//		lear.setPos(-3.7F, -6.1F, -6.5F);
//		head.addChild(lear);
//
//
//		cube_r41 = new ModelRenderer(this);
//		cube_r41.setPos(0.0F, -0.2F, 0.0F);
//		lear.addChild(cube_r41);
//		setRotationAngle(cube_r41, 1.6144F, 0.0F, 0.0F);
//		cube_r41.texOffs(34, 82).addBox(0.55F, 1.54F, -0.5F, 2.0F, 2.0F, 2.0F, -0.9F, false);
//		cube_r41.texOffs(68, 82).addBox(0.75F, 1.54F, -0.5F, 2.0F, 2.0F, 2.0F, -0.9F, false);
//
//		cube_r42 = new ModelRenderer(this);
//		cube_r42.setPos(0.2F, 0.0F, 0.0F);
//		lear.addChild(cube_r42);
//		setRotationAngle(cube_r42, 1.6144F, 0.0F, 0.0F);
//		cube_r42.texOffs(0, 84).addBox(0.55F, 1.548F, -0.5F, 2.0F, 2.0F, 2.0F, -0.9F, false);
//		cube_r42.texOffs(51, 84).addBox(0.35F, 1.548F, -0.5F, 2.0F, 2.0F, 2.0F, -0.9F, false);
//
//		cube_r43 = new ModelRenderer(this);
//		cube_r43.setPos(0.1F, -0.1F, 0.1F);
//		lear.addChild(cube_r43);
//		setRotationAngle(cube_r43, 1.6144F, 0.0F, 0.0F);
//		cube_r43.texOffs(0, 76).addBox(0.55F, 1.548F, -0.5F, 2.0F, 2.0F, 2.0F, -0.95F, false);
//
//		cube_r44 = new ModelRenderer(this);
//		cube_r44.setPos(0.1F, 0.0F, 0.1F);
//		lear.addChild(cube_r44);
//		setRotationAngle(cube_r44, 1.6144F, 0.0F, 0.0F);
//		cube_r44.texOffs(74, 71).addBox(0.55F, 1.548F, -0.5F, 2.0F, 2.0F, 2.0F, -0.95F, false);
//
//		cube_r45 = new ModelRenderer(this);
//		cube_r45.setPos(0.1F, 0.2F, 0.1F);
//		lear.addChild(cube_r45);
//		setRotationAngle(cube_r45, 1.6144F, 0.0F, 0.0F);
//		cube_r45.texOffs(34, 77).addBox(0.55F, 1.548F, -0.5F, 2.0F, 2.0F, 2.0F, -0.95F, false);
//
//		cube_r46 = new ModelRenderer(this);
//		cube_r46.setPos(0.1F, 0.1F, 0.1F);
//		lear.addChild(cube_r46);
//		setRotationAngle(cube_r46, 1.6144F, 0.0F, 0.0F);
//		cube_r46.texOffs(51, 79).addBox(0.55F, 1.548F, -0.5F, 2.0F, 2.0F, 2.0F, -0.95F, false);
//
//		lear2 = new ModelRenderer(this);
//		lear2.setPos(-2.6F, -6.1F, -6.5F);
//		head.addChild(lear2);
//
//
//		cube_r47 = new ModelRenderer(this);
//		cube_r47.setPos(0.0F, -0.2F, 0.0F);
//		lear2.addChild(cube_r47);
//		setRotationAngle(cube_r47, 1.6144F, 0.0F, 0.0F);
//		cube_r47.texOffs(85, 82).addBox(0.55F, 1.54F, -0.5F, 2.0F, 2.0F, 2.0F, -0.9F, false);
//		cube_r47.texOffs(17, 74).addBox(0.75F, 1.54F, -0.5F, 2.0F, 2.0F, 2.0F, -0.9F, false);
//
//		cube_r48 = new ModelRenderer(this);
//		cube_r48.setPos(0.2F, 0.0F, 0.0F);
//		lear2.addChild(cube_r48);
//		setRotationAngle(cube_r48, 1.6144F, 0.0F, 0.0F);
//		cube_r48.texOffs(74, 66).addBox(0.55F, 1.548F, -0.5F, 2.0F, 2.0F, 2.0F, -0.9F, false);
//		cube_r48.texOffs(0, 89).addBox(0.35F, 1.548F, -0.5F, 2.0F, 2.0F, 2.0F, -0.9F, false);
//
//		cube_r49 = new ModelRenderer(this);
//		cube_r49.setPos(0.1F, -0.1F, 0.1F);
//		lear2.addChild(cube_r49);
//		setRotationAngle(cube_r49, 1.6144F, 0.0F, 0.0F);
//		cube_r49.texOffs(86, 36).addBox(0.55F, 1.548F, -0.5F, 2.0F, 2.0F, 2.0F, -0.95F, false);
//
//		cube_r50 = new ModelRenderer(this);
//		cube_r50.setPos(0.1F, 0.0F, 0.1F);
//		lear2.addChild(cube_r50);
//		setRotationAngle(cube_r50, 1.6144F, 0.0F, 0.0F);
//		cube_r50.texOffs(86, 41).addBox(0.55F, 1.548F, -0.5F, 2.0F, 2.0F, 2.0F, -0.95F, false);
//
//		cube_r51 = new ModelRenderer(this);
//		cube_r51.setPos(0.1F, 0.2F, 0.1F);
//		lear2.addChild(cube_r51);
//		setRotationAngle(cube_r51, 1.6144F, 0.0F, 0.0F);
//		cube_r51.texOffs(68, 87).addBox(0.55F, 1.548F, -0.5F, 2.0F, 2.0F, 2.0F, -0.95F, false);
//
//		cube_r52 = new ModelRenderer(this);
//		cube_r52.setPos(0.1F, 0.1F, 0.1F);
//		lear2.addChild(cube_r52);
//		setRotationAngle(cube_r52, 1.6144F, 0.0F, 0.0F);
//		cube_r52.texOffs(85, 87).addBox(0.55F, 1.548F, -0.5F, 2.0F, 2.0F, 2.0F, -0.95F, false);
//	}

	@Override
	public void setupAnim(T t, float v, float v1, float v2, float v3, float v4) {

	}

//	@Override
//	public void setupAnim(Entity entity, float v, float v1, float v2, float v3, float v4) {
//
//	}

//	@Override
//	public void setupAnim(T t, float v, float v1, float v2, float v3, float v4) {
//
//	}
//	@Override
//	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
//		//previously the render function, render code was moved to a method below
//	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		tail.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		matrixStack.pushPose();
		matrixStack.mulPose(Vector3f.ZN.rotation(180));
//		this.tail.yRot = T.power;
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		tail.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		matrixStack.popPose();
	}
}