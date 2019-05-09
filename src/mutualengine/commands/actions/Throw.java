/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutualengine.commands.actions;

import java.util.List;
import mutualengine.MutualEngine;
import mutualengine.interfaces.Player;
import mutualengine.commands.ArgumentWrapper;
import mutualengine.commands.ArgumentData;
import mutualengine.commands.ArgumentFormat;
import mutualengine.commands.ArgumentType;
import mutualengine.interfaces.Item;

/**
 *
 * @author auramgold
 */
public class Throw extends AbstractCommand
{
	public static final ArgumentFormat format = new ArgumentFormat(
			new ArgumentWrapper(ArgumentType.ITEM, false),
			new ArgumentWrapper(ArgumentType.PREPOSITION, false),
			new ArgumentWrapper(ArgumentType.ITEM, false));

	public Throw(String... aliasList)
	{
		super(aliasList);
	}
	
	@Override
	public boolean doAction(List<String> arguments, Player player)
	{
		System.out.println("Throw");
		ArgumentData dat = CommandRunner.parseArguments(format, player, arguments);
		if(dat.errored)
		{
			return false;
		}
		Item target = (Item) dat.objects[2];
		Item usage = (Item)	dat.objects[0];
		if(target.equals(usage))
		{
			MutualEngine.logLine("You can't throw an item at itself!");
			return false;
		}
		else if(!usage.isCarryable())
		{
			MutualEngine.logLine("No matter how hard you try, you can't throw that item.");
			return true;
		}
		else
		{
			MutualEngine.logLine("Throwing " + usage.getName() + " at " + target.getName());
			boolean ret = usage.interactWith(player, target);
			if(ret)
			{
				usage.getLocation().moveItemTo(usage, player.getLocation());
				MutualEngine.logLine("The item drops to the ground");
			}
			return ret;
		}
	}
}
