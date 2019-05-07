/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
