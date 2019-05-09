/*
 * Copyright (C) 2019 auramgold
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package mutualengine.commands.actions;

import java.util.List;
import mutualengine.MutualEngine;
import mutualengine.commands.ArgumentData;
import mutualengine.commands.ArgumentFormat;
import mutualengine.commands.ArgumentType;
import mutualengine.commands.ArgumentWrapper;
import mutualengine.interfaces.Player;


public class Echo extends AbstractCommand
{
	public static final ArgumentFormat format = new ArgumentFormat(
		new ArgumentWrapper(ArgumentType.TEXT, false),
		new ArgumentWrapper(ArgumentType.GREEDYTEXT, true));

	public Echo(String... aliasList)
	{
		super(aliasList);
	}

	@Override
	public boolean doAction(List<String> arguments, Player player)
	{
		ArgumentData dat = CommandRunner.parseArguments(format, player, arguments);
		if(dat.errored)
		{
			return false;
		}
		
		MutualEngine.logLine(dat.objects[0].toString());
		MutualEngine.logLine();
		if(dat.objects[1] != null)
		{
			MutualEngine.logLine(dat.objects[1].toString());
		}
		else
		{
			MutualEngine.logLine("No optional text was provided");
		}
		
		return false;
	}
	
}
