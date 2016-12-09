import javax.swing.*;

public class Player
{
	
	private int maxHealth;
	private int maxDamage;
	private int currentHealth;
	boolean continueGame;
	int lordKillcount;
	
	public Player()
	{
		maxHealth = 100;
		currentHealth = maxHealth;
		maxDamage = 3;
		continueGame = true;
		lordKillcount = 0;
	}
	
	public Player(int totalHealth, int totalDamage)
	{
		maxHealth = totalHealth;
		maxDamage = totalDamage;
		currentHealth = maxHealth;
	}
	public void addMaxhealth(int hpNumber)
	{
		maxHealth = maxHealth + hpNumber;
	}
	public void addCurrenthealth(int hpNumber)
	{
		currentHealth = currentHealth + hpNumber;
		
		if (currentHealth > maxHealth)
		{
			currentHealth = maxHealth;
		}
	}
	
	public void addDamage(int damageNumber)
	{
		maxDamage = maxDamage + damageNumber;
	}
	
	public void removeDamage(int damageNumber)
	{
		maxDamage = maxDamage - damageNumber;
	}

	public void takeDamage(int damageNumber)
	{
		currentHealth = currentHealth - damageNumber;
		if (currentHealth < 0)
		{
			currentHealth = 0;
		}
	}
	
	public void addLordkillcount(String difficulty)
	{
		if (difficulty == "Lord of Death")
			{
				lordKillcount++;
			}
	}
	
	public int getMaxhealth()
	{
		return maxHealth;
	}
	
	public int getCurrenthealth()
	{
		return currentHealth;
	}
	
	public int getMaxdamage()
	{
		return maxDamage;
	}
	
	public int getLordkillcount()
	{
		return lordKillcount;
	}
	
	public boolean getContinue()
	{
		if (currentHealth == 0)
		{
			System.out.println("Game Over");
			continueGame = false;
		}
		else
		{
			continueGame = true;
		}
		return continueGame;
	}
}