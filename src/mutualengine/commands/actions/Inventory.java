/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutualengine.commands.actions;

import java.util.List;
import mutualengine.MutualEngine;
import mutualengine.interfaces.Player;
import mutualengine.commands.ArgumentData;
import mutualengine.commands.ArgumentFormat;
import mutualengine.commands.ArgumentType;
import mutualengine.interfaces.Area;

/**
 *
 * @author auramgold
 */
public class Inventory extends AbstractCommand
{
	public static final ArgumentFormat format = new ArgumentFormat((ArgumentType)null);

	public Inventory(String... aliasList)
	{
		super(aliasList);
	}
	
	@Override
	public boolean doAction(List<String> arguments, Player player)
	{
		System.out.println("Inventory");
		ArgumentData dat = CommandRunner.parseArguments(format, player, arguments);
		if(dat.errored)
		{
			return false;
		}
		Area currArea = (Area) player.getLocation();
		MutualEngine.logLine("In your inventory there is:");
		if(player.getInventory().isEmpty())
			MutualEngine.logLine("    Absolutely nothing");
		player.getInventory().forEach((itm) ->
		{
			MutualEngine.logLine("   " + itm.getShortDescription());
		});
		return false;
	}
}
