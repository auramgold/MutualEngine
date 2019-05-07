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

import mutualengine.interfaces.Player;


/**
 *
 * @author auramgold
 */
public class ArgumentFormat
{
	protected ArgumentType[] format = new ArgumentType[3];
	public final int numArgs;
	
	public ArgumentFormat(ArgumentType... args)
	{
		int i = 0;
		for(; i < args.length && i < 3; ++i)
		{
			format[i] = args[i];
		}
		numArgs = i;
		for(;i < 3; ++i)
		{
			format[i] = null;
		}
	}
	
	public Object parseValid(int index, Player plr, String str)
	{
		if(index >= numArgs) throw new IndexOutOfBoundsException();
		return format[index].parseValid(plr, str);
	}
	
	public ArgumentType getTypeAt(int index)
	{
		return format[index];
	}
}
