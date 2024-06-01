package com.code.aseoha.client.models.exteriors;// Made with Blockbench 4.10.1
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.code.aseoha.client.models.consoles.CopperConsoleModel;
import com.code.aseoha.client.renderers.exteriors.CoralRenderer;
import com.code.aseoha.enums.EnumDoorTypes;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.vector.Vector3f;
import net.tardis.mod.client.models.exteriors.ExteriorModel;
import net.tardis.mod.client.renderers.boti.BOTIRenderer;
import net.tardis.mod.client.renderers.boti.PortalInfo;
import net.tardis.mod.client.renderers.exteriors.ExteriorRenderer;
//import net.tardis.mod.client.renderers.exteriors.ModernPoliceBoxExteriorRenderer;
import net.tardis.mod.enums.EnumDoorState;
import net.tardis.mod.enums.EnumMatterState;
import net.tardis.mod.helper.WorldHelper;
import net.tardis.mod.misc.IDoorType;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;

public class CoralExterior extends ExteriorModel {
    private final ModelRenderer base;
    private final ModelRenderer sides;
    private final ModelRenderer side1;
    private final ModelRenderer side2;
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
    private final ModelRenderer boti;

    public CoralExterior() {
        texWidth = 128;
        texHeight = 128;

        base = new ModelRenderer(this);
        base.setPos(0.075F, 24.0F, 0.5F);
        base.texOffs(0, 0).addBox(-8.075F, -1.0F, -8.5F, 17.0F, 1.0F, 17.0F, 0.0F, false);
        base.texOffs(-1, 17).addBox(-7.575F, -1.3F, -8.0F, 16.0F, 1.0F, 16.0F, 0.0F, false);
        base.texOffs(0, 18).addBox(-7.075F, -1.6F, -7.5F, 15.0F, 1.0F, 15.0F, 0.0F, false);

        sides = new ModelRenderer(this);
        sides.setPos(-0.075F, 0.0F, -0.5F);
        base.addChild(sides);


        side1 = new ModelRenderer(this);
        side1.setPos(-6.0F, 0.0F, 5.0F);
        sides.addChild(side1);
        side1.texOffs(72, 46).addBox(1.0F, -2.0F, 1.0F, 11.0F, 1.0F, 1.0F, 0.0F, false);
        side1.texOffs(44, 35).addBox(6.0F, -30.0F, 1.0F, 1.0F, 29.0F, 1.0F, 0.0F, false);
        side1.texOffs(23, 23).addBox(5.5F, -32.3F, 1.0F, 2.0F, 32.0F, 2.0F, -0.9F, false);
        side1.texOffs(72, 44).addBox(1.0F, -30.0F, 1.0F, 11.0F, 1.0F, 1.0F, 0.0F, false);
        side1.texOffs(64, 65).addBox(1.0F, -23.0F, 1.0F, 11.0F, 1.0F, 1.0F, 0.0F, false);
        side1.texOffs(64, 65).addBox(1.0F, -16.0F, 1.0F, 11.0F, 1.0F, 1.0F, 0.0F, false);
        side1.texOffs(64, 65).addBox(1.0F, -9.0F, 1.0F, 11.0F, 1.0F, 1.0F, 0.0F, false);
        side1.texOffs(3, 69).addBox(1.0F, -23.0F, 1.2F, 11.0F, 22.0F, 0.0F, 0.0F, false);
        side1.texOffs(75, 18).addBox(3.5F, -30.0F, 0.2F, 2.0F, 8.0F, 2.0F, -0.8F, false);
        side1.texOffs(80, 73).addBox(1.5F, -30.0F, 0.2F, 2.0F, 8.0F, 2.0F, -0.8F, false);
        side1.texOffs(52, 1).addBox(1.0F, -29.0F, 1.0F, 11.0F, 6.0F, 0.0F, 0.0F, false);
        side1.texOffs(75, 0).addBox(7.5F, -30.0F, 0.2F, 2.0F, 8.0F, 2.0F, -0.8F, false);
        side1.texOffs(64, 73).addBox(9.5F, -30.0F, 0.2F, 2.0F, 8.0F, 2.0F, -0.8F, false);
        side1.texOffs(45, 26).addBox(-0.1F, -27.0F, 0.2F, 13.0F, 2.0F, 2.0F, -0.8F, false);

        side2 = new ModelRenderer(this);
        side2.setPos(-4.7F, 0.0F, 5.8F);
        sides.addChild(side2);
        setRotationAngle(side2, 0.0F, -1.5708F, 0.0F);
        side2.texOffs(68, 16).addBox(-10.8F, -2.0F, 0.3F, 11.0F, 1.0F, 1.0F, 0.0F, false);
        side2.texOffs(44, 37).addBox(0.2F, -30.0F, 0.3F, 1.0F, 29.0F, 1.0F, 0.0F, false);
        side2.texOffs(44, 39).addBox(-5.8F, -30.0F, 0.3F, 1.0F, 29.0F, 1.0F, 0.0F, false);
        side2.texOffs(64, 67).addBox(-10.8F, -30.0F, 0.3F, 11.0F, 1.0F, 1.0F, 0.0F, false);
        side2.texOffs(64, 65).addBox(-10.8F, -23.0F, 0.3F, 11.0F, 1.0F, 1.0F, 0.0F, false);
        side2.texOffs(64, 65).addBox(-10.8F, -16.0F, 0.3F, 11.0F, 1.0F, 1.0F, 0.0F, false);
        side2.texOffs(64, 65).addBox(-10.8F, -9.0F, 0.3F, 11.0F, 1.0F, 1.0F, 0.0F, false);
        side2.texOffs(9, 71).addBox(-10.8F, -23.0F, 0.5F, 11.0F, 22.0F, 0.0F, 0.0F, false);
        side2.texOffs(0, 18).addBox(-8.4F, -30.0F, -0.5F, 2.0F, 8.0F, 2.0F, -0.8F, false);
        side2.texOffs(72, 73).addBox(-10.4F, -30.0F, -0.5F, 2.0F, 8.0F, 2.0F, -0.8F, false);
        side2.texOffs(8, 0).addBox(-4.4F, -30.0F, -0.5F, 2.0F, 8.0F, 2.0F, -0.8F, false);
        side2.texOffs(0, 0).addBox(-2.4F, -30.0F, -0.5F, 2.0F, 8.0F, 2.0F, -0.8F, false);
        side2.texOffs(45, 18).addBox(-11.9F, -27.0F, -0.5F, 13.0F, 2.0F, 2.0F, -0.8F, false);
        side2.texOffs(52, 2).addBox(-10.8F, -29.0F, 0.3F, 11.0F, 6.0F, 0.0F, 0.0F, false);
        side2.texOffs(23, 23).addBox(-6.3F, -32.3F, 0.6F, 2.0F, 32.0F, 2.0F, -0.9F, false);

        side3 = new ModelRenderer(this);
        side3.setPos(-10.6F, 0.0F, -10.5F);
        sides.addChild(side3);
        setRotationAngle(side3, 0.0F, 3.1416F, 0.0F);
        side3.texOffs(72, 36).addBox(-16.6F, -2.0F, -5.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
        side3.texOffs(44, 35).addBox(-5.6F, -30.0F, -5.5F, 1.0F, 29.0F, 1.0F, 0.0F, false);
        side3.texOffs(44, 38).addBox(-11.6F, -30.0F, -5.5F, 1.0F, 29.0F, 1.0F, 0.0F, false);
        side3.texOffs(44, 35).addBox(-17.6F, -30.0F, -5.5F, 1.0F, 29.0F, 1.0F, 0.0F, false);
        side3.texOffs(72, 34).addBox(-16.6F, -30.0F, -5.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
        side3.texOffs(64, 65).addBox(-16.6F, -23.0F, -5.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
        side3.texOffs(64, 65).addBox(-16.6F, -16.0F, -5.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
        side3.texOffs(64, 65).addBox(-16.6F, -9.0F, -5.5F, 11.0F, 1.0F, 1.0F, 0.0F, false);
        side3.texOffs(18, 35).addBox(-16.6F, -23.0F, -5.3F, 11.0F, 22.0F, 0.0F, 0.0F, false);
        side3.texOffs(64, 83).addBox(-14.1F, -30.0F, -6.3F, 2.0F, 8.0F, 2.0F, -0.8F, false);
        side3.texOffs(72, 83).addBox(-16.1F, -30.0F, -6.3F, 2.0F, 8.0F, 2.0F, -0.8F, false);
        side3.texOffs(83, 18).addBox(-10.1F, -30.0F, -6.3F, 2.0F, 8.0F, 2.0F, -0.8F, false);
        side3.texOffs(83, 0).addBox(-8.1F, -30.0F, -6.3F, 2.0F, 8.0F, 2.0F, -0.8F, false);
        side3.texOffs(45, 22).addBox(-17.6F, -27.0F, -6.3F, 13.0F, 2.0F, 2.0F, -0.8F, false);
        side3.texOffs(52, 0).addBox(-16.6F, -29.0F, -5.5F, 11.0F, 6.0F, 0.0F, 0.0F, false);
        side3.texOffs(23, 23).addBox(-12.1F, -32.4F, -5.4F, 2.0F, 32.0F, 2.0F, -0.9F, false);

        doorsleft = new ModelRenderer(this);
        doorsleft.setPos(6.2769F, -18.8308F, -5.0385F);
        sides.addChild(doorsleft);
        setRotationAngle(doorsleft, 0.0F, 1.5708F, 0.0F);
        doorsleft.texOffs(36, 49).addBox(-5.0385F, 16.8308F, -0.2769F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        doorsleft.texOffs(37, 56).addBox(-6.3385F, -12.0692F, -0.5769F, 2.0F, 30.0F, 2.0F, -0.7F, false);
        doorsleft.texOffs(37, 56).addBox(-6.3385F, -12.0692F, -1.1769F, 2.0F, 30.0F, 2.0F, -0.7F, false);
        doorsleft.texOffs(78, 34).addBox(-5.0385F, -11.1692F, -0.2769F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        doorsleft.texOffs(36, 52).addBox(-5.0385F, -4.1692F, -0.2769F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        doorsleft.texOffs(35, 49).addBox(-5.0385F, 2.8308F, -0.2769F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        doorsleft.texOffs(33, 43).addBox(-5.0385F, 9.8308F, -0.2769F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        doorsleft.texOffs(31, 34).addBox(-5.0385F, -4.1692F, -0.0769F, 5.0F, 22.0F, 0.0F, 0.0F, false);
        doorsleft.texOffs(83, 18).addBox(-4.5385F, -11.1692F, -1.0769F, 2.0F, 8.0F, 2.0F, -0.8F, false);
        doorsleft.texOffs(83, 0).addBox(-2.5385F, -11.1692F, -1.0769F, 2.0F, 8.0F, 2.0F, -0.8F, false);
        doorsleft.texOffs(51, 22).addBox(-6.0385F, -8.1692F, -1.0769F, 7.0F, 2.0F, 2.0F, -0.8F, false);
        doorsleft.texOffs(64, 1).addBox(-5.0385F, -10.1692F, -0.2769F, 5.0F, 6.0F, 0.0F, 0.0F, false);
        doorsleft.texOffs(65, 49).addBox(-5.0385F, -3.1692F, -0.5769F, 5.0F, 6.0F, 1.0F, 0.0F, false);
        doorsleft.texOffs(23, 23).addBox(-6.5385F, -13.4692F, -0.1769F, 2.0F, 32.0F, 2.0F, -0.9F, false);

        handle = new ModelRenderer(this);
        handle.setPos(-4.5385F, 1.9308F, 0.5231F);
        doorsleft.addChild(handle);
        handle.texOffs(0, 0).addBox(-1.0F, -4.0F, -0.8F, 2.0F, 4.0F, 2.0F, -0.9F, false);
        handle.texOffs(0, 0).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 2.0F, 2.0F, -0.9F, false);
        handle.texOffs(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, -0.9F, false);

        doorsright = new ModelRenderer(this);
        doorsright.setPos(6.2545F, -19.0455F, 6.7727F);
        sides.addChild(doorsright);
        setRotationAngle(doorsright, 0.0F, 1.5708F, 0.0F);
        doorsright.texOffs(36, 49).addBox(0.7727F, 17.0455F, -0.2545F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        doorsright.texOffs(44, 37).addBox(-0.2273F, -10.9545F, -0.2545F, 1.0F, 29.0F, 1.0F, 0.0F, false);
        doorsright.texOffs(78, 34).addBox(0.7727F, -10.9545F, -0.2545F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        doorsright.texOffs(35, 51).addBox(0.7727F, -3.9545F, -0.2545F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        doorsright.texOffs(35, 49).addBox(0.7727F, 3.0455F, -0.2545F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        doorsright.texOffs(33, 43).addBox(0.7727F, 10.0455F, -0.2545F, 5.0F, 1.0F, 1.0F, 0.0F, false);
        doorsright.texOffs(41, 66).addBox(0.7727F, -3.9545F, -0.0545F, 5.0F, 22.0F, 0.0F, 0.0F, false);
        doorsright.texOffs(83, 18).addBox(1.2727F, -10.9545F, -1.0545F, 2.0F, 8.0F, 2.0F, -0.8F, false);
        doorsright.texOffs(83, 0).addBox(3.2727F, -10.9545F, -1.0545F, 2.0F, 8.0F, 2.0F, -0.8F, false);
        doorsright.texOffs(51, 22).addBox(-0.2273F, -7.9545F, -1.0545F, 7.0F, 2.0F, 2.0F, -0.8F, false);
        doorsright.texOffs(63, 1).addBox(0.7727F, -10.9545F, -0.2545F, 5.0F, 7.0F, 0.0F, 0.0F, false);
        doorsright.texOffs(37, 56).addBox(5.0839F, -11.8545F, -0.5881F, 2.0F, 30.0F, 2.0F, -0.7F, false);
        doorsright.texOffs(37, 56).addBox(5.0839F, -11.8545F, -1.1881F, 2.0F, 30.0F, 2.0F, -0.7F, false);

        handle2 = new ModelRenderer(this);
        handle2.setPos(0.0F, 2.1455F, 0.8455F);
        doorsright.addChild(handle2);
        handle2.texOffs(0, 0).addBox(4.8728F, -4.0F, -0.8F, 2.0F, 4.0F, 2.0F, -0.9F, false);
        handle2.texOffs(0, 0).addBox(4.8728F, -4.0F, -1.0F, 2.0F, 2.0F, 2.0F, -0.9F, false);
        handle2.texOffs(0, 0).addBox(4.8728F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, -0.9F, false);

        corners = new ModelRenderer(this);
        corners.setPos(-0.075F, 0.0F, -0.5F);
        base.addChild(corners);
        corners.texOffs(44, 35).addBox(7.0F, -30.0F, -7.0F, 1.0F, 29.0F, 1.0F, 0.0F, false);
        corners.texOffs(44, 37).addBox(7.0F, -30.0F, 7.0F, 1.0F, 29.0F, 1.0F, 0.0F, false);
        corners.texOffs(44, 35).addBox(6.5F, -30.0F, 6.5F, 1.0F, 29.0F, 1.0F, 0.0F, false);
        corners.texOffs(44, 36).addBox(-6.5F, -30.0F, 6.5F, 1.0F, 29.0F, 1.0F, 0.0F, false);
        corners.texOffs(44, 36).addBox(-6.5F, -30.0F, -6.5F, 1.0F, 29.0F, 1.0F, 0.0F, false);
        corners.texOffs(44, 35).addBox(6.5F, -30.0F, -6.5F, 1.0F, 29.0F, 1.0F, 0.0F, false);
        corners.texOffs(44, 37).addBox(-7.0F, -30.0F, 7.0F, 1.0F, 29.0F, 1.0F, 0.0F, false);
        corners.texOffs(44, 37).addBox(-7.0F, -30.0F, -7.0F, 1.0F, 29.0F, 1.0F, 0.0F, false);

        roof = new ModelRenderer(this);
        roof.setPos(-0.075F, 0.0F, -0.5F);
        base.addChild(roof);
        roof.texOffs(0, 60).addBox(-7.0F, -32.0F, -7.0F, 15.0F, 2.0F, 15.0F, 0.0F, false);
        roof.texOffs(0, 75).addBox(-6.0F, -33.0F, -6.0F, 13.0F, 1.0F, 13.0F, 0.0F, false);
        roof.texOffs(0, 65).addBox(-5.0F, -34.0F, -5.0F, 11.0F, 1.0F, 11.0F, 0.0F, false);
        roof.texOffs(28, 82).addBox(6.2F, -32.8F, 6.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        roof.texOffs(28, 82).addBox(-6.2F, -32.8F, 6.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        roof.texOffs(28, 82).addBox(-6.2F, -32.8F, -6.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        roof.texOffs(28, 82).addBox(6.2F, -32.8F, -6.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        box = new ModelRenderer(this);
        box.setPos(1.2F, -29.0F, -0.5F);
        roof.addChild(box);
        box.texOffs(14, 67).addBox(5.9F, -3.7F, -7.0F, 2.0F, 2.0F, 16.0F, -0.9F, false);
        box.texOffs(28, 81).addBox(5.9F, -3.5F, -7.0F, 2.0F, 3.0F, 2.0F, -0.9F, false);
        box.texOffs(28, 81).addBox(5.9F, -3.5F, 7.0F, 2.0F, 3.0F, 2.0F, -0.9F, false);
        box.texOffs(14, 67).addBox(5.9F, -2.3F, -7.0F, 2.0F, 2.0F, 16.0F, -0.9F, false);
        box.texOffs(81, 33).addBox(5.8F, -3.5F, -7.0F, 2.0F, 3.0F, 16.0F, -0.9F, false);

        box2 = new ModelRenderer(this);
        box2.setPos(0.9F, 0.0F, 0.0F);
        roof.addChild(box2);
        setRotationAngle(box2, 0.0F, -1.5708F, 0.0F);
        box2.texOffs(14, 67).addBox(7.1F, -32.7F, -7.5F, 2.0F, 2.0F, 16.0F, -0.9F, false);
        box2.texOffs(28, 81).addBox(7.1F, -32.5F, -7.5F, 2.0F, 3.0F, 2.0F, -0.9F, false);
        box2.texOffs(28, 81).addBox(7.1F, -32.5F, 6.5F, 2.0F, 3.0F, 2.0F, -0.9F, false);
        box2.texOffs(14, 67).addBox(7.1F, -31.3F, -7.5F, 2.0F, 2.0F, 16.0F, -0.9F, false);
        box2.texOffs(81, 33).addBox(7.0F, -32.5F, -7.5F, 2.0F, 3.0F, 16.0F, -0.9F, false);

        box3 = new ModelRenderer(this);
        box3.setPos(2.0F, 0.0F, 1.0F);
        roof.addChild(box3);
        setRotationAngle(box3, 0.0F, 3.1416F, 0.0F);
        box3.texOffs(14, 67).addBox(8.1F, -32.7F, -7.5F, 2.0F, 2.0F, 16.0F, -0.9F, false);
        box3.texOffs(28, 81).addBox(8.1F, -32.5F, -7.5F, 2.0F, 3.0F, 2.0F, -0.9F, false);
        box3.texOffs(28, 81).addBox(8.1F, -32.5F, 6.5F, 2.0F, 3.0F, 2.0F, -0.9F, false);
        box3.texOffs(14, 67).addBox(8.1F, -31.3F, -7.5F, 2.0F, 2.0F, 16.0F, -0.9F, false);
        box3.texOffs(81, 33).addBox(8.0F, -32.5F, -7.5F, 2.0F, 3.0F, 16.0F, -0.9F, false);

        box4 = new ModelRenderer(this);
        box4.setPos(-1.0F, 0.0F, 4.0F);
        roof.addChild(box4);
        setRotationAngle(box4, 0.0F, 1.5708F, 0.0F);
        box4.texOffs(14, 67).addBox(10.1F, -32.7F, -6.5F, 2.0F, 2.0F, 16.0F, -0.9F, false);
        box4.texOffs(28, 81).addBox(10.1F, -32.5F, -6.5F, 2.0F, 3.0F, 2.0F, -0.9F, false);
        box4.texOffs(28, 81).addBox(10.1F, -32.5F, 7.5F, 2.0F, 3.0F, 2.0F, -0.9F, false);
        box4.texOffs(14, 67).addBox(10.1F, -31.3F, -6.5F, 2.0F, 2.0F, 16.0F, -0.9F, false);
        box4.texOffs(81, 33).addBox(10.0F, -32.5F, -6.5F, 2.0F, 3.0F, 16.0F, -0.9F, false);

        lamp = new ModelRenderer(this);
        lamp.setPos(0.0F, -34.0F, 0.0F);
        roof.addChild(lamp);
        lamp.texOffs(69, 1).addBox(0.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        lamp.texOffs(20, 5).addBox(-1.5F, -3.1F, -1.5F, 4.0F, 2.0F, 4.0F, -1.2F, false);
        lamp.texOffs(20, 5).addBox(-1.5F, -3.2F, -1.5F, 4.0F, 2.0F, 4.0F, -1.4F, false);
        lamp.texOffs(20, 5).addBox(-1.5F, -3.2F, -1.5F, 4.0F, 2.0F, 4.0F, -1.6F, false);
        lamp.texOffs(20, 5).addBox(-1.5F, -3.2F, -1.5F, 4.0F, 2.0F, 4.0F, -1.8F, false);
        lamp.texOffs(19, 1).addBox(0.2F, -3.0F, 0.2F, 2.0F, 4.0F, 2.0F, -0.9F, false);
        lamp.texOffs(19, 1).addBox(0.2F, -3.0F, -1.2F, 2.0F, 4.0F, 2.0F, -0.9F, false);
        lamp.texOffs(19, 1).addBox(-1.2F, -3.0F, -1.2F, 2.0F, 4.0F, 2.0F, -0.9F, false);
        lamp.texOffs(19, 2).addBox(-1.2F, -3.0F, 0.2F, 2.0F, 4.0F, 2.0F, -0.9F, false);
        lamp.texOffs(17, 0).addBox(-1.0F, -1.5F, -1.0F, 3.0F, 2.0F, 3.0F, -0.9F, false);
        lamp.texOffs(17, 0).addBox(-1.0F, -2.4F, -1.0F, 3.0F, 2.0F, 3.0F, -0.9F, false);

        boti = new ModelRenderer(this);
        boti.setPos(-1.275F, -0.8F, -1.0F);
        base.addChild(boti);
        boti.texOffs(100, 2).addBox(-1.0F, -29.0F, -4.0F, 2.0F, 28.0F, 10.0F, 0.0F, false);
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
    @Override
    public void renderBones(ExteriorTile exterior, float scale, MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float alpha) {
        matrixStack.pushPose();
        EnumDoorState state = exterior.getOpen();
        matrixStack.translate(0.0D, -0.5D, 0.0D);
        matrixStack.scale(1F, 1F, 1F);
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
        base.render(matrixStack, buffer, packedLight, packedOverlay,1,1,1, alpha);
        matrixStack.translate(-0.3,1.4,0);
//        doorsright.render(matrixStack, buffer, packedLight, packedOverlay,1,1,1, alpha);
//        doorsleft.render(matrixStack, buffer, packedLight, packedOverlay,1,1,1, alpha);
//        BOTI.render(matrixStack, buffer, packedLight, packedOverlay,1,1,1, alpha);
        matrixStack.popPose();
    }

@Override
public void renderBoti(ExteriorTile exterior, float scale, MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float alpha) {
        if (exterior.getBotiWorld() != null && exterior.getMatterState() == EnumMatterState.SOLID && exterior.getOpen() != EnumDoorState.CLOSED) {
            PortalInfo info = new PortalInfo();
            info.setPosition(exterior.getBlockPos());
            info.setWorldShell(exterior.getBotiWorld());
            info.setTranslate((matrix) -> {
                matrix.translate(-0.5, 0.0, -0.5);
                ExteriorRenderer.applyTransforms(matrix, exterior);
            });
            info.setTranslatePortal((matrix) -> {
                matrix.translate(0.0, 1.0, 0.0);
                matrix.mulPose(Vector3f.XP.rotationDegrees(180.0F));
                matrix.mulPose(Vector3f.YP.rotationDegrees(180.0F));
                matrix.mulPose(Vector3f.YP.rotationDegrees(WorldHelper.getAngleFromFacing(exterior.getBotiWorld().getPortalDirection())));
                matrix.translate(-0.5, -0.5, -0.5);
            });
            info.setRenderPortal((matrix, buf) -> {
                matrix.pushPose();
                matrix.scale(1.1F, 1.1F, 1.1F);
                this.boti.render(matrix, buf.getBuffer(RenderType.entityCutout(CoralRenderer.TEXTURE)), packedLight, packedOverlay);
                matrix.popPose();
            });
            info.setRenderDoor((matrix, buf) -> {
                matrix.pushPose();
                matrix.scale(1.1F, 1.1F, 1.1F);
                this.doorsleft.render(matrix, buf.getBuffer(RenderType.entityCutout(CoralRenderer.TEXTURE)), packedLight, packedOverlay);
                matrix.popPose();
            });
            BOTIRenderer.addPortal(info);
        }
    }
}