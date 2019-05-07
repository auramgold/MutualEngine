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
package mutualengine.enumerations;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author auramgold
 */
public enum Direction
{
	NORTH	(0),
	EAST	(1),
	SOUTH	(2),
	WEST	(3),
	UP		(4),
	DOWN	(5);
	
	private final int id;
	
	Direction(int i)
	{
		id = i;
	}
	
	public int toInt()
	{
		return id;
	}
	
	public String getAsString()
	{
		return this.toString().toLowerCase();
	}
	
	/**
     * Map for reverse look-up via id.
     */
    private final static Map<String, Direction> STRS_TO_ENUMS;

    /**
     * Static 'constructor' for filling the reverse map.
     */
    static
	{
        STRS_TO_ENUMS = new HashMap<>();
        for (Direction dir : values())
		{
			String str = dir.getAsString();
            STRS_TO_ENUMS.put(str, dir);
			STRS_TO_ENUMS.put(str.substring(0, 1), dir);
        }
    }
	
	public static Direction getFromString(String str)
	{
		Direction ret = STRS_TO_ENUMS.get(str);
		return ret;
	}
}
