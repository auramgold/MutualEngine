/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutualengine.testworld;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import mutualengine.interfaces.Player;
import mutualengine.enumerations.RawAction;
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
	public boolean interactWith(Player ply, Item itm, RawAction act)
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
