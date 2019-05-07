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
