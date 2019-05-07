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
package mutualengine.interfaces;

import java.util.List;

/**
 * This interface is for the player in the world.
 *	Two implementations are provided, an abstract and a complete, though if
 *		writing your own from scratch, it is recommended to extend the abstract
 *		class ItemContainerItem
 * @author auramgold
 */
public interface Player extends Damageable, ItemContainer
{
	public List<Item> getInventory();
	
	public boolean getBossLock();
	
	public void setBossLock(boolean state);
	
	public boolean isDead();
	
	public void moveToWorld(World world);
	
	public void moveToArea(Area area);
	
	public void setName(String newName);
}
