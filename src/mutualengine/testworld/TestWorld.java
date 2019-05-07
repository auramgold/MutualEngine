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

import java.util.ArrayList;
import java.util.List;
import mutualengine.interfaces.Area;
import mutualengine.interfaces.World;

/**
 *
 * @author auramgold
 */
public class TestWorld implements World
{
	public List<Area> areaList = new ArrayList<>();
	
	public TestWorld()
	{
		areaList.add(new TestAreaSouth("TEST_AREA_SOUTH", this));
		areaList.add(new TestAreaNorth("TEST_AREA_NORTH", this));
		areaList.forEach((area) ->
		{
			area.instantiateConnections();
		});
	}

	@Override
	public Area getAreaById(String id)
	{
		for(Area area : areaList)
		{
			if(area.getAreaId().equals(id))
			{
				return area;
			}
		}
		return null;
	}

	@Override
	public Area getSpawnArea()
	{
		return getAreaById("TEST_AREA_NORTH");
	}
	
}
