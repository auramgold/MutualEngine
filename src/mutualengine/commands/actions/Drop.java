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
public class Drop extends AbstractCommand
{
	public static final ArgumentFormat format = new ArgumentFormat(
			new ArgumentWrapper(ArgumentType.ITEM, false));

	public Drop(String... aliasList)
	{
		super(aliasList);
	}
	
	@Override
	public boolean doAction(List<String> arguments, Player player)
	{
		System.out.println("Drop");
		ArgumentData dat = CommandRunner.parseArguments(format, player, arguments);
		if(dat.errored)
		{
			return false;
		}
		Item target = (Item) dat.objects[0];
		if(!target.isCarryable())
		{
			MutualEngine.logErrorLine("You're somehow carrying something you aren't allowed to carry. This shouldn't happen.");
			target.getLocation().moveItemTo(target, player.getLocation());
			return true;
		}
		else if(!target.getLocation().equals(player))
		{
			MutualEngine.logLine("That item isn't in your inventory!");
			return false;
		}
		else
		{
			target.getLocation().moveItemTo(target, player.getLocation());
			MutualEngine.logLine("You drop the item.");
			return true;
		}
	}
}
