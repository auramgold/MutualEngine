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
import mutualengine.interfaces.Area;
import mutualengine.interfaces.Item;

/**
 *
 * @author auramgold
 */
public class Take extends AbstractCommand
{
	public static final ArgumentFormat format = new ArgumentFormat(
			new ArgumentWrapper(ArgumentType.ITEM, false));

	public Take(String... aliasList)
	{
		super(aliasList);
	}
	
	@Override
	public boolean doAction(List<String> arguments, Player player)
	{
		System.out.println("Take");
		ArgumentData dat = CommandRunner.parseArguments(format, player, arguments);
		if(dat.errored)
		{
			return false;
		}
		Item target = (Item) dat.objects[0];
		if(!target.isCarryable())
		{
			MutualEngine.logLine("No matter how hard you try, you can't pick it up.");
			return true;
		}
		else if(!target.getLocation().equals(player.getLocation()))
		{
			MutualEngine.logLine("That item isn't on the ground!");
			return false;
		}
		else
		{
			target.getLocation().moveItemTo(target, player);
			MutualEngine.logLine("You pick up the item.");
			return true;
		}
	}
	
}
