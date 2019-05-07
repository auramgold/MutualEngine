/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutualengine.implementations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import mutualengine.interfaces.Item;
import mutualengine.interfaces.ItemContainer;

/**
 *
 * @author auramgold
 */
public abstract class AbstractItem implements Item
{
	protected static Set<String> names = new HashSet<>();
	protected ItemContainer location;
	
	public AbstractItem(String... nameArr)
	{
		names.addAll(Arrays.asList(nameArr));
	}
	
	@Override
	public boolean isNameValid(String name)
	{
		return names.contains(name.toLowerCase());
	}

	@Override
	public ItemContainer getLocation()
	{
		return location;
	}

	@Override
	public void setLocation(ItemContainer store)
	{
		location = store;
	}
	
}
