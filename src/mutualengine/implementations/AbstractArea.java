/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
