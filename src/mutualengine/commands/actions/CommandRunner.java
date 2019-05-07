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

import java.util.ArrayList;
import java.util.List;
import mutualengine.MutualEngine;
import mutualengine.commands.ArgumentData;
import mutualengine.commands.ArgumentFormat;
import mutualengine.commands.ArgumentType;
import mutualengine.interfaces.Command;
import mutualengine.interfaces.Player;

/**
 *
 * @author auramgold
 */
public class CommandRunner
{
	private List<Command> commands = new ArrayList<>();
	
	public CommandRunner(boolean useDefaultCommands)
	{
		if(useDefaultCommands)
		{
			commands.add(new Move("go","move"));
			commands.add(new Inspect("inspect"));
			commands.add(new Look("look"));
			commands.add(new Take("take"));
			commands.add(new Drop("drop"));
			commands.add(new Use("use"));
			commands.add(new Throw("throw","toss"));
			commands.add(new Inventory("inventory"));
		}
	}
	
	public void registerCommand(Command command)
	{
		commands.add(command);
	}
	
	public boolean runCommand(List<String> inputList, Player player)
	{
		String command = inputList.get(0);
		List<String> arguments = inputList.subList(1, inputList.size());
		Command comm = null;
		for(Command listCommand : commands)
		{
			if(listCommand.hasAlias(command))
			{
				comm = listCommand;
				System.out.println(comm.getClass().toGenericString());
				break;
			}
		}
		
		if(comm != null)
		{
			return comm.doAction(arguments, player);
		}
		else
		{
			MutualEngine.logErrorLine("'" + command + "' is not a command.");
			return false;
		}
	}
	
	public static ArgumentData parseArguments(ArgumentFormat format, Player plr, List<String> args)
	{
		int parseIndex = 0;
		int argsIndex = 0;
		int parseMax = format.numArgs;
		int argsMax = args.size();
		String part = "";
		Object[] ret = new Object[parseMax];
		while(argsIndex < argsMax && parseIndex < parseMax)
		{
			if(!part.equals("")) part += " ";
			part += args.get(argsIndex);
			Object parseVal = format.parseValid(parseIndex, plr, part);
			System.out.println("Current part: "+part);
			System.out.println(argsIndex+":"+parseIndex);
			if(parseVal != null)
			{
				System.out.println("Correct!");
				ret[parseIndex] = parseVal;
				part = "";
				++parseIndex;
			}
			else if(format.getTypeAt(parseIndex) != ArgumentType.ITEM)
			{
				System.out.println("No valid argument");
				MutualEngine.logErrorLine("Expected " + format.getTypeAt(parseIndex).asString() + " but found none.");
				return new ArgumentData(true, ret);
			}
			
			++argsIndex;
		}
		boolean continueBool = parseIndex != parseMax && format.getTypeAt(0) != null;
		if(continueBool)
		{
			MutualEngine.logErrorLine("Something (likely an item) is missing in the command.");
		}
		return new ArgumentData(continueBool, ret);
	}
	
}
