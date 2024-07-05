//package com.code.aseoha.networking;
//import com.code.aseoha.aseoha;
//import com.code.aseoha.block.ArtronBank;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.fml.network.NetworkRegistry;
//import net.minecraftforge.fml.network.simple.SimpleChannel;
//
//public class Network {
//
//    private static int ID = 0;
//    private static final String PROTOCOL_VERSION = Integer.toString(1);
//    private static final SimpleChannel NETWORK_CHANNEL = NetworkRegistry.newSimpleChannel(new ResourceLocation(aseoha.MODID, "main_channel"), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
//
//
//    public static void init() {
//        NETWORK_CHANNEL.registerMessage(nextId(), ArtronBank.class, ArtronBank::encode, ArtronBank::decode, ArtronBank::handle);
//    }
//
//    /**
//     * Sends a packet to the server.<br>
//     * Must be called Client side.
//     */
//    public static void sendToServer(Object msg) {
//        NETWORK_CHANNEL.sendToServer(msg);
//    }
//
//    public static int nextId(){
//        return ++ID;
//    }
//
//}