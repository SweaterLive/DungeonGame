import java.util.Random;

public class Monster 
{	
	private static int monsterHealth;
	private static int monsterDamage;
	private static int currentMhealth;
	private static String monsterName;
	Die monsterDie = new Die(6);
	
	public Monster()
	{
		monsterHealth = 0;
		currentMhealth = 0;
		monsterDamage = 0;
		monsterName = "Select a Difficulty";
	}
	public Monster(String difficulty)
	{		
		int rollValue = 0;
		monsterDie.roll();
		rollValue = monsterDie.getValue();
		Random damage = new Random();
		
		if (difficulty == "easy")
		{
				switch (rollValue)
				{
					case 1: monsterHealth = 5;
							monsterName = "Rat";
							monsterDamage = damage.nextInt(3)+3;
					break;
					case 2: monsterHealth = 10;
							monsterName = "Giant Spider";
							monsterDamage = damage.nextInt(3)+3;
					break;
					case 3: monsterHealth = 12;
							monsterName = "Skeleton";
							monsterDamage = damage.nextInt(3)+3;
					break;		
					case 4: monsterHealth = 15;
							monsterName = "Zombie";
							monsterDamage = damage.nextInt(3)+3;
					break;
					case 5: monsterHealth = 20;
							monsterName = "Mummy";
							monsterDamage = damage.nextInt(3)+3;
					break;
					case 6: monsterHealth = 25;
							monsterName = "Ghoul";
							monsterDamage = damage.nextInt(3)+3;
					break;
					default:monsterHealth = 0;
							monsterName = "Error";
							monsterDamage = 0;
				}
		}
			
		if (difficulty == "medium")
		{
				switch (rollValue)
				{
				case 1 :monsterHealth = 50;
						monsterName = "Mummy";
						monsterDamage = damage.nextInt(3)+3;
				break;
				case 2 :monsterHealth = 75;
						monsterName = "Ghoul";
						monsterDamage = damage.nextInt(3)+3;
				break;
				case 3 :monsterHealth = 100;
						monsterName = "Elf";
						monsterDamage = damage.nextInt(3)+3;
				break;		
				case 4 :monsterHealth = 125;
						monsterName = "Vampire";
						monsterDamage = damage.nextInt(3)+3;
				break;
				case 5 :monsterHealth = 150;
						monsterName = "Dwarf";
						monsterDamage = damage.nextInt(3)+3;
				break;
				case 6 :monsterHealth = 200;
						monsterName = "Giant";
						monsterDamage = damage.nextInt(3)+3;
				break;
				default:monsterHealth = 0;
						monsterName = "Error";
						monsterDamage = 0;
				}
		}
				
		if (difficulty == "hard")
		{
				switch (rollValue)
				{
						case 1 : monsterHealth = 1000;
								 monsterName = "Dwarf";
							   	 monsterDamage = damage.nextInt(3)+3;
						break;
						case 2 : monsterHealth = 2000;
								 monsterName = "Giant";
								 monsterDamage = damage.nextInt(3)+3;
						break;
						case 3 : monsterHealth = 2500;
								 monsterName = "Banshee";
								 monsterDamage = damage.nextInt(3)+3;
						break;		
						case 4 : monsterHealth = 3000;
								 monsterName = "Centaur";
								 monsterDamage = damage.nextInt(3)+3;
						break;
						case 5 : monsterHealth = 3500;
								 monsterName = "Ogre";
								 monsterDamage = damage.nextInt(3)+3;
						break;
						case 6 : monsterHealth = 4000;
								 monsterName = "Basilisk";
								 monsterDamage = damage.nextInt(3)+3;
						break;
						default :monsterHealth = 0;
								 monsterName = "Error";
								 monsterDamage = 0;
						}
				}
				
				if (difficulty == "nightmare")
				{
					switch (rollValue)
					{
						case 1 : monsterHealth = 5000;
						 		 monsterName = "Air Elemental";
						 		 monsterDamage = damage.nextInt(3)+3;;
						break;
						case 2 : monsterHealth = 6000;
						 		 monsterName = "Earth Elemental";
						 		 monsterDamage = damage.nextInt(3)+3;;
						break;
						case 3 : monsterHealth = 7000;
						 		 monsterName = "Water Elemental";
						 		 monsterDamage = damage.nextInt(3)+3;;
						break;		
						case 4 : monsterHealth = 8000;
						 		 monsterName = "Fire Elemental";
						 		 monsterDamage = damage.nextInt(3)+3;;
						break;
						case 5 : monsterHealth = 9000;
								 monsterName = "Hydra";
								 monsterDamage = damage.nextInt(3)+3;;
						break;
						case 6 : monsterHealth = 10000;
								 monsterName = "Dragon";
								 monsterDamage = damage.nextInt(3)+3;
						break;
						default :monsterHealth = 0;
								 monsterName = "Error";
								 monsterDamage = 0;
					}
				}
				currentMhealth = monsterHealth;
	}
	public Monster(int totalHealth, int totalDamage)
	{
		monsterHealth = totalHealth;
		monsterDamage = totalDamage;
		currentMhealth = monsterHealth;
		monsterName = "";
	}

	public void monsterTakedamage(int damageNumber)
	{
		currentMhealth = currentMhealth - damageNumber;
	}
	
	public int getMonsterhealth()
	{
		return monsterHealth;
	}
	
	public int getCurrentmhealth()
	{
		return currentMhealth;
	}
	
	public int getMonsterdamage()
	{
		return monsterDamage;
	}
	public void setMonsterdamage(int damage)
	{
		monsterDamage = damage;
	}
	public void setMonsterhealth(int health)
	{
		monsterHealth = health;
	}
	public void setCmonsterhealth(int health)
	{
		currentMhealth = health;
	}
	public void setMonstername(String name)
	{
		monsterName = name;
	}
	public String getMonsterName()
	{
		return monsterName;
	}
}
