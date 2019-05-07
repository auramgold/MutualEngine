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

import mutualengine.implementations.AbstractArea;
import mutualengine.implementations.SimpleLink;
import mutualengine.interfaces.World;
import mutualengine.implementations.LinkMap;

/**
 *
 * @author auramgold
 */
public class TestAreaNorth extends AbstractArea
{

	public TestAreaNorth(String id, World world)
	{
		super(id, world);
	}
	
	@Override
	public String getDescription()
	{
		return "You are an empty, white plane, extending out as far as the eye can see.";
	}

	@Override
	public void instantiateConnections()
	{
		connections = new LinkMap
		(
			null,//N
			null,//E
			new SimpleLink(containingWorld.getAreaById("TEST_AREA_SOUTH"))//S
		);
	}

	
}
