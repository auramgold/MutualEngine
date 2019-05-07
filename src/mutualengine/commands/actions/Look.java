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
import mutualengine.interfaces.Area;
import mutualengine.interfaces.Item;
import mutualengine.interfaces.Player;

/**
 *
 * @author auramgold
 */
public class Look extends AbstractCommand
{
	public static final ArgumentFormat format = new ArgumentFormat((ArgumentType)null);

	public Look(String... aliasList)
	{
		super(aliasList);
	}
	
	@Override
	public boolean doAction(List<String> arguments, Player player)
	{
		System.out.println("Look");
		ArgumentData dat = CommandRunner.parseArguments(format, player, arguments);
		if(dat.errored)
		{
			return false;
		}
		Area currArea = (Area) player.getLocation();
		MutualEngine.logLine(currArea.getDescription());
		if(!currArea.getAccessibleItems().isEmpty())
			MutualEngine.logLine("There are items here:");
		for(Item itm : currArea.getAccessibleItems())
		{
			MutualEngine.logLine("  " + itm.getShortDescription());
		}
		return false;
	}
}
