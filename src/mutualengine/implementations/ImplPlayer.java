/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutualengine.implementations;

/**
 *
 * @author auramgold
 */
public class ImplPlayer extends AbstractPlayer
{
	int currentHealth = 100;
	final int maxHealth = 100;
	protected String name;
	
	public ImplPlayer(String startingName)
	{
		name = startingName;
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	public void setName(String newName)
	{
		name = newName;
	}

	@Override
	public String getShortDescription()
	{
		return "A demonstration character";
	}

	@Override
	public String getLongDescription()
	{
		return "You are a demonstration character. You have "
			+ getCurrentHealth() + "/" + getMaxHealth() + " health";
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
		return isDead();
	}
	
	@Override
	public boolean damage(int amount, String attack)
	{
		setAttackType(attack);
		return damage(amount);
	}

	@Override
	public String onDestroy()
	{
		return "You were killed by: " + lastAttack;
	}
	
	@Override
	public boolean isDead()
	{
		return currentHealth <= 0;
	}

	@Override
	public void setAttackType(String what)
	{
		lastAttack = what;
	}
	
}
