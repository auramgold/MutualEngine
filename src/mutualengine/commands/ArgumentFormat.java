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
package mutualengine.commands;

import mutualengine.exceptions.MutualEngineIllegalDefinitionError;
import mutualengine.interfaces.Player;


/**
 *
 * @author auramgold
 */
public class ArgumentFormat
{
	protected ArgumentWrapper[] format;
	public final int numArgs;
	public final int numRequiredArgs;
	
	public ArgumentFormat(ArgumentWrapper... args)
	{
		numArgs = args.length;
		format = args;
		int requiredAccumulator = 0;
		
		boolean optionalFound = false;
		boolean greedyFound = false;
		for(ArgumentWrapper check: format)
		{
			if(check.isOptional())
			{
				optionalFound = true;
			}
			else
			{
				if(optionalFound)
				{
					throw new MutualEngineIllegalDefinitionError("A required argument can not be after an optional one.");
				}
				++requiredAccumulator;
			}
			
			// Greedy text consumers must be the very last argument
			
			if(greedyFound)
			{
				throw new MutualEngineIllegalDefinitionError("Greedy text consumers must be the very last argument.");
			}
			
			if(check.getType().getMultiBehavior() == MultipleWordBehavior.GREEDY)
			{
				greedyFound = true;
			}
		}
		
		numRequiredArgs = requiredAccumulator;
	}
	
	public Object parseValid(int index, Player plr, String str)
	{
		if(index >= numArgs) throw new IndexOutOfBoundsException();
		return format[index].parseValid(plr, str);
	}
	
	public ArgumentType getTypeAt(int index)
	{
		return format[index].getType();
	}
}
