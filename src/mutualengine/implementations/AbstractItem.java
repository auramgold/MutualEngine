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
