import java.util.Random;

public class Die 
{

	private int sides;
	private int value;
	
	public Die()
	{
		sides = 6;
		roll();
	}
	public Die(int numSides)
	{
		sides = numSides;
		roll();
	}
public void roll()
	{
	Random generator = new Random();
	value = generator.nextInt(sides)+1;
	}

public int getValue()
	{
	return value;
	}
}