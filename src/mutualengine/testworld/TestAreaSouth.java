/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class TestAreaSouth extends AbstractArea
{

	public TestAreaSouth(String id, World world)
	{
		super(id, world);
		insertItem(new TestPebble(this));
	}

	@Override
	public String getDescription()
	{
		return "You are an empty, black plane, extending out as far as the eye can see.";
	}

	@Override
	public void instantiateConnections()
	{
		connections = new LinkMap
		(
			new SimpleLink(containingWorld.getAreaById("TEST_AREA_NORTH")) // N
		);
	}
	
	@Override
	public LinkMap getLinkMap()
	{
		return connections;
	}
	
}
