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

import java.util.Arrays;
import java.util.HashSet;
import mutualengine.enumerations.Direction;
import mutualengine.interfaces.Item;
import mutualengine.interfaces.Player;

interface ValidCheck
{
	//returns null on invalid
	Object parseValid(Player plr, String str);
}

/**
 *
 * @author auramgold
 */
public enum ArgumentType
{
	DIRECTION	(0,
		(Player plr, String str) ->
			Direction.getFromString(str)
		),
	PREPOSITION	(1,
		(Player plr, String str) ->
		{
			boolean check;
			HashSet<String> preps = new HashSet<>
			(
				Arrays.asList(new String[]{"on","at","with","from"})
			);
			check = preps.contains(str);
			return check?str:null;
		}),
	ITEM		(2,
		(Player plr, String str) ->
		{
			for(Item listItem : plr.getAccessibleItems())
			{
				if(listItem.isNameValid(str))
				{
					return listItem;
				}
			}
			return null;
		});
	
	private final int id;
	private final ValidCheck valid;
	
	public int toInt()
	{
		return id;
	}
	
	public Object parseValid(Player plr, String str)
	{
		return valid.parseValid(plr, str);
	}
	
	public String asString()
	{
		return this.toString().toLowerCase();
	}
	
	private ArgumentType(int idNum, ValidCheck vl)
	{
		id = idNum;
		valid = vl;
	}
}
