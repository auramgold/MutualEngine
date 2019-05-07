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
import mutualengine.interfaces.Damageable;
import mutualengine.interfaces.Entity;
import mutualengine.interfaces.Link;

/**
 *
 * @author auramgold
 */
public abstract class DamageableEntity extends AbstractItem implements Entity, Damageable
{
	public final int maxHealth;
	protected int currentHealth;
	protected String lastAttack;
	public DamageableEntity(int mHealth, String... aliases)
	{
		super(aliases);
		maxHealth = mHealth;
		currentHealth = mHealth;
	}
	@Override
	public int getCurrentHealth()
	{
		return currentHealth;
	}

	@Override
	public int getMaxHealth()
	{
		return maxHealth;
	}

	@Override
	public boolean damage(int amount)
	{
		currentHealth -= amount;
		return currentHealth <= 0;
	}
	
	@Override
	public boolean damage(int amount, String attack)
	{
		setAttackType(attack);
		return damage(amount);
	}
	
	@Override
	public void setAttackType(String attack)
	{
		lastAttack = attack;
	}
	
	public void follow(Player plr, Link link)
	{
		if(link.canEnemyAccess())
		{
			this.getLocation().moveItemTo(this, link.getConnection());
		}
	}
	
	protected int damagePlayer(String cause, Player plr, int baseline, int variability)
	{
		int damAmt = (int) (baseline + Math.floor(Math.random() * variability));
		plr.damage(damAmt, cause);
		return damAmt;
	}
	
	public boolean isDead()
	{
		return currentHealth <= 0;
	}
}
