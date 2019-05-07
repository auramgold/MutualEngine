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
import mutualengine.enumerations.Direction;
import mutualengine.interfaces.Area;
import mutualengine.interfaces.Link;

/**
 *
 * @author auramgold
 */
public class Move extends AbstractCommand
{
	public static final ArgumentFormat format = new ArgumentFormat(ArgumentType.DIRECTION);

	public Move(String... aliasList)
	{
		super(aliasList);
	}
	
	@Override
	public boolean doAction(List<String> arguments, Player player)
	{
		System.out.println("Move");
		ArgumentData dat = CommandRunner.parseArguments(format, player, arguments);
		if(dat.errored)
		{
			return false;
		}
		Direction dir = (Direction)dat.objects[0];
		Link link = ((Area) player.getLocation()).getLinkMap().getLink(dir);
		if(link == null)
		{
			MutualEngine.logErrorLine("No link exists in that direction.");
			return false;
		}
		
		if(!link.canPlayerAccess(player))
		{
			MutualEngine.logLine("You try to go out that direction, but something keeps you here.");
		}
		else
		{
			player.moveToArea(link.getConnection());
			MutualEngine.logLine("\r\n" + link.getConnection().getDescription());
		}
		return true;
	}
	
}
