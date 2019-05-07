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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mutualengine.interfaces.Area;
import mutualengine.interfaces.Item;
import mutualengine.interfaces.ItemContainer;
import mutualengine.interfaces.World;


/**
 *
 * @author auramgold
 */
public abstract class AbstractArea implements Area
{
	Set<Item> containedItems = new HashSet<>();
	public final String areaId;
	public World containingWorld;
	protected LinkMap connections;
	
	public AbstractArea(String id, World world)
	{
		areaId = id;
		containingWorld = world;
	}
	
	@Override
	public void insertItem(Item itm)
	{
		containedItems.add(itm);
		itm.setLocation(this);
	}

	@Override
	public void moveItemTo(Item itm, ItemContainer target)
	{
		removeItem(itm);
		target.insertItem(itm);
	}

	@Override
	public void removeItem(Item itm)
	{
		containedItems.remove(itm);
	}

	@Override
	public List<Item> getAccessibleItems()
	{
		return new ArrayList<>(containedItems);
	}
	
	@Override
	public String getAreaId()
	{
		return areaId;
	}
	
	@Override
	public LinkMap getLinkMap()
	{
		return connections;
	}
}
