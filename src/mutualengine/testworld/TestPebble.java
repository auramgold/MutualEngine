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
package mutualengine.testworld;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import mutualengine.interfaces.Player;
import mutualengine.implementations.AbstractItem;
import mutualengine.interfaces.Damageable;
import mutualengine.interfaces.Item;
import mutualengine.interfaces.ItemContainer;

/**
 *
 * @author auramgold
 */
public class TestPebble extends AbstractItem
{
	static Set<String> names = new HashSet<>
	(
		Arrays.asList(new String[]{"pebble","test pebble"})
	);
	ItemContainer location;
	
	public TestPebble(ItemContainer loc)
	{
		super("pebble","test pebble");
	}
	
	@Override
	public boolean isCarryable()
	{
		return true;
	}

	@Override
	public boolean hasInventory()
	{
		return false;
	}

	@Override
	public String getName()
	{
		return "The Pebble of Testing";
	}

	@Override
	public String getShortDescription()
	{
		return "A test pebble.";
	}

	@Override
	public String getLongDescription()
	{
		return "It is a round pebble with no sharp edges. It seems to remind you of debugging, whatever that is.";
	}

	@Override
	public boolean interactWith(Player ply, Item itm)
	{
		if(itm instanceof Damageable)
		{
			((Damageable) itm).damage(1);
			mutualengine.MutualEngine.logLine("It does a little bit of damage.");
			return true;
		}
		mutualengine.MutualEngine.logLine("Nothing happens.");
		return false;
	}
	
}
