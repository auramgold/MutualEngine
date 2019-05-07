/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
