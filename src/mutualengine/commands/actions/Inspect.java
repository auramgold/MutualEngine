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
public class Inspect extends AbstractCommand
{
	public static final ArgumentFormat format = new ArgumentFormat(
			new ArgumentWrapper(ArgumentType.ITEM, false));

	public Inspect(String... aliasList)
	{
		super(aliasList);
	}
	
	@Override
	public boolean doAction(List<String> arguments, Player player)
	{
		System.out.println("Inspect");
		ArgumentData dat = CommandRunner.parseArguments(format, player, arguments);
		if(dat.errored)
		{
			return false;
		}
		Item itm = (Item) dat.objects[0];
		
		MutualEngine.logLine(itm.getLongDescription());
		return false;
	}
}
