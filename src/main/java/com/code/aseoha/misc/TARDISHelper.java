package com.code.aseoha.misc;

import com.code.aseoha.upgrades.EngineBoost;
import net.tardis.mod.tileentities.ConsoleTile;

public class TARDISHelper {
    public static void engineBooster(ConsoleTile consoleTile, EngineBoost engineBoost){
        engineBoost.BoostThemEngines(consoleTile);
    }

}
