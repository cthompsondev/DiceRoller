package dev.cthompson.diceroller.messenger;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.text.TextComponentString;

public class Messenger {

		public Messenger(MinecraftServer server,Entity sender,TextComponentString message, boolean broadcast) {
			if(broadcast) {
				PlayerList players=	server.getPlayerList();
				players.sendMessage(message);
			}else {
				sender.sendMessage(message);
			}
		}
		public Messenger(MinecraftServer server,Entity sender,ArrayList<TextComponentString> messages, boolean broadcast) {
			PlayerList players=	server.getPlayerList();
			messages.forEach(message -> {
				if(broadcast) {
					players.sendMessage(message);
				}else {
					sender.sendMessage(message);
				}
			});
					
		}
		
	
}
