/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutualengine.implementations;

import mutualengine.interfaces.Player;
import mutualengine.interfaces.Area;
import mutualengine.interfaces.Link;

/**
 *
 * @author auramgold
 */
public class SimpleLink implements Link
{
	protected Area connection;
	
	public SimpleLink(Area conn)
	{
		connection = conn;
	}

	@Override
	public boolean canPlayerAccess(Player plr)
	{
		return true;
	}
	
	@Override
	public boolean canEnemyAccess()
	{
		return true;
	}

	@Override
	public Area getConnection()
	{
		return connection;
	}
	
}
