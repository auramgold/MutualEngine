/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutualengine.commands.actions;

import java.util.List;
import mutualengine.MutualEngine;
import mutualengine.commands.ArgumentData;
import mutualengine.commands.ArgumentFormat;
import mutualengine.commands.ArgumentType;
import mutualengine.interfaces.Item;
import mutualengine.interfaces.Player;

/**
 *
 * @author auramgold
 */
public class Use extends AbstractCommand
{
	public static final ArgumentFormat format = new ArgumentFormat(ArgumentType.ITEM,ArgumentType.PREPOSITION,ArgumentType.ITEM);

	public Use(String... aliasList)
	{
		super(aliasList);
	}
	
	@Override
	public boolean doAction(List<String> arguments, Player player)
	{
		System.out.println("Use");
		ArgumentData dat = CommandRunner.parseArguments(format, player, arguments);
		if(dat.errored)
		{
			return false;
		}
		Item target = (Item) dat.objects[2];
		Item usage = (Item)	dat.objects[0];
		if(target.equals(usage))
		{
			MutualEngine.logLine("You can't use an item on itself!");
			return false;
		}
		else
		{
			MutualEngine.logLine("Using " + usage.getName() + " on " + target.getName());
			return usage.interactWith(player, target);
		}
	}
}
