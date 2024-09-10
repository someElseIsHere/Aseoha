package com.code.aseoha.events;

import com.code.aseoha.misc.KeyboardHelper;
import com.code.aseoha.networking.Networking;
import com.code.aseoha.networking.Packets.RWFPacket;
import com.code.aseoha.networking.Packets.TardisInputMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tardis.mod.client.ClientHelper;
import net.tardis.mod.entity.TardisEntity;
import net.tardis.mod.helper.TardisHelper;
import org.lwjgl.glfw.GLFW;

import javax.net.ssl.KeyManager;

@Mod.EventBusSubscriber(modid = "aseoha", value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onJump(InputUpdateEvent update) {
        LivingEntity liv = update.getEntityLiving();

        if(liv instanceof PlayerEntity && liv.equals(ClientHelper.getClientPlayer())) {
            if(liv.getVehicle() != null) {
                TardisEntity entity = (TardisEntity)liv.getVehicle();

//                entity.setJumping(update.getMovementInput().jump);
                Networking.sendToServer(new TardisInputMessage(update.getMovementInput().jumping));
            }
        }
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onKey(InputEvent.KeyInputEvent e) {
//        if(e.getKey() == GLFW.GLFW_KEY_LEFT_SHIFT){//KeyManager.KEY_STOP_RIDE.isPressed()) {
//        if(Minecraft.getInstance().keyboardHandler)
        if (Minecraft.getInstance().level != null) {
            if (KeyboardHelper.isHoldingControl()) {
                PlayerEntity entity = ClientHelper.getClientPlayer();

                if (entity.getVehicle() != null && entity.getVehicle() instanceof TardisEntity)
                    if(((TardisEntity) entity.getVehicle()).getConsole() != null && ((TardisEntity) entity.getVehicle()).getExterior() != null)
                        Networking.sendToServer(new RWFPacket(((TardisEntity) entity.getVehicle()).getConsole().getType().getRegistryName()));
            }
        }
    }
}
