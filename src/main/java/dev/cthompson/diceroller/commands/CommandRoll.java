package dev.cthompson.diceroller.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import dev.cthompson.diceroller.messenger.Messenger;
import dev.cthompson.diceroller.roller.Roller;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class CommandRoll implements ICommand{

	private final List aliases;
     
  
    public CommandRoll() 
    { 
        aliases = new ArrayList(); 
        aliases.add("roll"); 
        aliases.add("Roll"); 
    } 
  
    @Override 
    public int compareTo(ICommand o)
    { 
        return 0; 
    } 

    @Override 
    public String getName() 
    { 
        return "roll"; 
    } 

    @Override         
    public String getUsage(ICommandSender var1) 
    { 
        return "/roll x'd'y ex.. roll 1d20"; 
    } 

    @Override 
    public List getAliases() 
    { 
        return this.aliases;
    } 

    @Override 
    public void execute(MinecraftServer server, ICommandSender sender, String[] argString)
    { 
        World world = sender.getEntityWorld(); 
        Roller rolls = new Roller();
        ArrayList<Integer> vals = new ArrayList<Integer>();
        String message = "";
        String rollValues ="They have Rolled ";
        int total = 0;
        message += sender.getName();
        
        
        if (argString.length == 0){
        	 message += " is rolling 1d20";
        	 vals = rolls.Roller(1, 20);
        	 
        }else {
        	if(argString[0].equals("9001")) {
        		System.out.println(argString[0]);
        		message+=" IS TRYING TO ROLL GREATER THAN 9000!!!! IS HE GONNA DO IT?";
        		
        		vals = rolls.Roller(1,9001);
        		
        	}else {
        		if(argString[0].length() <3) {
           		vals = rolls.Roller(1,Integer.parseInt(argString[0]));
           		
           	 	}else {
           	 		if(!Pattern.matches("\\d+[d]{1}\\d+", argString[0])) {
           	 		TextComponentString ERRORComponent = new TextComponentString("Needs to learn to type");
           	 		new Messenger(server, (Entity)sender, ERRORComponent, true);
           	 		return;
           	 		}
           		 String[] splitted = argString[0].split("d");
           		 
           		 vals = rolls.Roller(Integer.parseInt(splitted[0]),Integer.parseInt(splitted[1]));
           	 	}
        		message += " is rolling " +argString[0];
        	}
        	 
        	 
                     
        }
        for(int i = 0; i < vals.size(); i++) {
        	rollValues += vals.get(i);
        	total += vals.get(i);
        	if(i < vals.size() -1) {
        		rollValues += ", ";
        	}
        }
        
         	TextComponentString messageComponent = new TextComponentString(message);
         	TextComponentString rollComponent = new TextComponentString(rollValues);
         	TextComponentString totalComponent = new TextComponentString("Total is: "+total);
         	ArrayList<TextComponentString> messages = new ArrayList<TextComponentString>();
                messages.add(messageComponent);
                messages.add(rollComponent);
            	messages.add(totalComponent);
            new Messenger(server, (Entity)sender, messages, true);
                return;
            
          
    } 

   

    
    public List addTabCompletionOptions(ICommandSender var1, String[] var2) 
    { 
        // TODO Auto-generated method stub 
        return null; 
    } 

    @Override 
    public boolean isUsernameIndex(String[] var1, int var2) 
    { 
        // TODO Auto-generated method stub 
        return false;
    }



	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args,
			BlockPos targetPos) {
		// TODO Auto-generated method stub
		return null;
	} 
	
	
	
}
