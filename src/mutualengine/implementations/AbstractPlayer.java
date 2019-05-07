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
package mutualengine.implementations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mutualengine.MutualEngine;
import mutualengine.enumerations.RawAction;
import mutualengine.interfaces.Area;
import mutualengine.interfaces.Item;
import mutualengine.interfaces.ItemContainer;
import mutualengine.interfaces.Player;
import mutualengine.interfaces.World;

/**
 *
 * @author auramgold
 */
public abstract class AbstractPlayer extends ItemContainerItem implements Player
{
	Set<Item> inventory = new HashSet<>();
	protected String lastAttack;
	protected Area currentLocation;
	protected boolean bossLock;
	protected Set<String> names = new HashSet<>
	(
		Arrays.asList(new String[]{"me","myself"})
	);
	
	@Override
	public void insertItem(Item item)
	{
		inventory.add(item);
		item.setLocation(this);
	}

	@Override
	public void removeItem(Item item)
	{
		inventory.remove(item);
	}
	
	@Override
	public boolean isNameValid(String name)
	{
		return names.contains(name.toLowerCase());
	}
	
	@Override
	public List<Item> getInventory()
	{
		List<Item> retList = new ArrayList<>(inventory);
		return retList;
	}
	
	@Override
	public List<Item> getAccessibleItems()
	{
		List<Item> retList = currentLocation.getAccessibleItems();
		retList.addAll(inventory);
		retList.add(this);
		return retList;
	}
	
	@Override
	public boolean getBossLock()
	{
		return bossLock;
	}
	
	@Override
	public void setBossLock(boolean lock)
	{
		bossLock = lock;
	}
	
	@Override
	public boolean interactWith(Player ply, Item itm, RawAction act)
	{
		MutualEngine.logLine("You can't use yourself on something!");
		return false;
	}
	
	@Override
	public ItemContainer getLocation()
	{
		return currentLocation;
	}

	@Override
	public void setLocation(ItemContainer store)
	{
		currentLocation = (Area)store;
	}
	
	@Override
	public void moveToArea(Area area)
	{
		currentLocation = area;
	}

	@Override
	public void moveToWorld(World world)
	{
		moveToArea(world.getSpawnArea());
	}
}
