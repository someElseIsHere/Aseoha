package com.code.aseoha.misc;

import com.code.aseoha.aseoha;
import com.code.aseoha.upgrades.EngineBoost;
import com.code.aseoha.upgrades.HADS;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.tardis.mod.entity.DoorEntity;
import net.tardis.mod.entity.TardisEntity;
import net.tardis.mod.enums.EnumDoorState;
import net.tardis.mod.tileentities.ConsoleTile;

import javax.swing.*;
import java.util.Iterator;
import java.util.Objects;

public class TARDISHelper {
//    public static void engineBooster(ConsoleTile consoleTile, EngineBoost engineBoost){
//        engineBoost.BoostThemEngines(consoleTile);
//    }

    public static boolean areDoorsOpen(ConsoleTile console){
        DoorEntity doorEntity;
        for (Iterator i = Objects.requireNonNull(console.getLevel()).getEntitiesOfClass(DoorEntity.class, (new AxisAlignedBB(console.getBlockPos())).inflate(25.0)).iterator(); i.hasNext(); doorEntity.updateExteriorDoorData()) {doorEntity = (DoorEntity) i.next();
            if (doorEntity.getOpenState() == EnumDoorState.BOTH)
                return true;

        }
        return false;
    }

    public static boolean areDoorsClosed(ConsoleTile console){
        DoorEntity doorEntity;
        for (Iterator i = Objects.requireNonNull(console.getLevel()).getEntitiesOfClass(DoorEntity.class, (new AxisAlignedBB(console.getBlockPos())).inflate(25.0)).iterator(); i.hasNext(); doorEntity.updateExteriorDoorData()) {doorEntity = (DoorEntity) i.next();
            if (doorEntity.getOpenState() == EnumDoorState.CLOSED)
                return true;

        }
        return false;
    }

    public static boolean isOneDoorOpen(ConsoleTile console){
        DoorEntity doorEntity;
        for (Iterator i = Objects.requireNonNull(console.getLevel()).getEntitiesOfClass(DoorEntity.class, (new AxisAlignedBB(console.getBlockPos())).inflate(25.0)).iterator(); i.hasNext(); doorEntity.updateExteriorDoorData()) {doorEntity = (DoorEntity) i.next();
            if (doorEntity.getOpenState() == EnumDoorState.ONE)
                return true;

        }
        return false;
    }

    public static void setDoorState(ConsoleTile console, int state){ //with state, 0 = No doors open/All Closed, 1 = One door open, 2 = Two doors open
        DoorEntity doorEntity;
        for (Iterator i = Objects.requireNonNull(console.getLevel()).getEntitiesOfClass(DoorEntity.class, (new AxisAlignedBB(console.getBlockPos())).inflate(25.0)).iterator(); i.hasNext(); doorEntity.updateExteriorDoorData()) {doorEntity = (DoorEntity) i.next();
            if (state == 0)
                doorEntity.setOpenState(EnumDoorState.CLOSED);
            if (state == 1)
                doorEntity.setOpenState(EnumDoorState.ONE);
            if (state == 2)
                doorEntity.setOpenState(EnumDoorState.BOTH);
        }
    }


//    private static boolean setConsoleChanged(boolean state, boolean overwrite){
//        aseoha.LOGGER.info("INSIDE setConsoleChanged");
//        if(overwrite || !consoleChange)
//            consoleChange = state;
//
//        return consoleChange;
//    }



    private static boolean consoleChange = false;
    private static ConsoleTile prevConsole = null;

    private static ConsoleTile getPrevConsole(ConsoleTile console, boolean overwrite){
        if(overwrite || prevConsole == null)
            prevConsole = console;
        return prevConsole;
    }


    public static boolean hasConsoleChanged(ConsoleTile console){
        ConsoleTile preConsole = getPrevConsole(console, false);
        if(preConsole != console){
            getPrevConsole(console, true);
            return true;
        }
        return false;
    }
}
