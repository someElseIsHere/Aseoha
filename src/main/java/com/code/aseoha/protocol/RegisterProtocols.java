package com.code.aseoha.protocol;

import com.code.aseoha.aseoha;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.tardis.mod.protocols.Protocol;
import net.tardis.mod.registries.ProtocolRegistry;

public class RegisterProtocols extends ProtocolRegistry {

    public static final DeferredRegister<Protocol> PROTOCOLSREGISTER = DeferredRegister.create(Protocol.class, aseoha.MODID);
//    public static final RegistryObject<Protocol> HADS = PROTOCOLSREGISTER.register("hads", hads::new);

}
