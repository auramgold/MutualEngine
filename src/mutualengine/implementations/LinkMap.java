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

import java.util.Map;
import mutualengine.enumerations.Direction;
import mutualengine.interfaces.Link;

/**
 *
 * @author auramgold
 */
public class LinkMap
{
	protected Link[] linkages = new Link[6];
	
	public LinkMap(Link... places)
	{
		if(places.length > 6)
			throw new ArrayIndexOutOfBoundsException();
		
		for(int i = 0; i < places.length; ++i)
		{
			linkages[i] = places[i];
		}
	}
	
	public LinkMap(Map<Direction,Link> places)
	{
		places.entrySet().forEach((entry) ->
		{
			linkages[entry.getKey().toInt()] = entry.getValue();
		});
	}
	
	public Link getLink(int key)
	{
		return linkages[key];
	}
	
	public Link getLink(Direction dir)
	{
		return getLink(dir.toInt());
	}
	
	public void setLink(int key, Link lin)
	{
		linkages[key] = lin;
	}
	
	public void setLink(Direction dir, Link lin)
	{
		setLink(dir.toInt(), lin);
	}
}

