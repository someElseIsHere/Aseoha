package com.code.aseoha.networking;

import com.code.aseoha.aseoha;
import com.code.aseoha.networking.Packets.SetCoords;
import com.code.aseoha.networking.Packets.TakeOffFromClient;
import com.code.aseoha.networking.Packets.ToggleLocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

/**
 * Just, important stuff, makes sure stuff works, don't fully understand it, but I understand how CTRL+C/V Works.
 */
public class Networking {
    private static final String PROTOCOL_VERSION = "1";
    private static int i = 0;
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(aseoha.MODID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );
    public static void init() {
        INSTANCE.registerMessage(iterator(), TakeOffFromClient.class, TakeOffFromClient::encode, TakeOffFromClient::decode, TakeOffFromClient::handle);
        INSTANCE.registerMessage(iterator(), ToggleLocks.class, ToggleLocks::encode, ToggleLocks::decode, ToggleLocks::handle);
        INSTANCE.registerMessage(iterator(), SetCoords.class, SetCoords::encode, SetCoords::decode, SetCoords::handle);
        //DistExecutor.safeRunWhenOn(Dist.CLIENT, () ->
    }
    public static void sendToServer(Object msg) {INSTANCE.sendToServer(msg);}
    /**
     * @return This returns the current id+1, that way we always get a unique ID
     */
    private static int iterator(){
        return i++;
    }
}