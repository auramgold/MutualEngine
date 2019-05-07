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

import mutualengine.interfaces.Player;
import mutualengine.interfaces.Area;
import mutualengine.interfaces.Link;

/**
 *
 * @author auramgold
 */
public class PlayerOnlyLink implements Link
{
	protected Area connection;
	
	public PlayerOnlyLink(Area conn)
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
		return false;
	}

	@Override
	public Area getConnection()
	{
		return connection;
	}
	
}
