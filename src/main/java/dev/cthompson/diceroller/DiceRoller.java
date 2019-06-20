package dev.cthompson.diceroller;


import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import org.apache.logging.log4j.Logger;

import dev.cthompson.diceroller.commands.CommandRoll;
import dev.cthompson.diceroller.commands.CommandRollc;
import dev.cthompson.diceroller.commands.CommandRolls;
import dev.cthompson.diceroller.commands.CommandRollsc;

@Mod(modid = DiceRoller.MODID, name = DiceRoller.NAME, version = DiceRoller.VERSION, serverSideOnly = true, acceptableRemoteVersions = "*")
public class DiceRoller
{
    public static final String MODID = "diceroller";
    public static final String NAME = "Dice Roller";
    public static final String VERSION = "1.3.1";

    
    @EventHandler
    public void serverLoad(FMLServerStartingEvent event)
    {
        // register server commands

    event.registerServerCommand(new CommandRoll());
    event.registerServerCommand(new CommandRollc());
    event.registerServerCommand(new CommandRolls());
    event.registerServerCommand(new CommandRollsc());
    }

    
}
