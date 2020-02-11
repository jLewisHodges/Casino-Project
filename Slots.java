/**
 * class Slots - simulates a standard slot machine
 * @author Jorden Hodges
 * 
 * Associate Classes:
 * 		Game - Slots inherits from Game. I did this because Slots has similar functionality to BlackJack which also inherits from game.
 */
public class Slots extends Game{
	private String slot1, slot2, slot3;
	public Slots()
	{
		super();
		slot1 = "";
		slot2 = "";
		slot3 = "";
	}
	
	public Slots(Account player, double wager)
	{
		super(player, wager);
		slot1 = "";
		slot2 = "";
		slot3 = "";
	}
	
	/**
	 * method play - carries out the Slot machine game
	 * @param none
	 * @return winnings - what the player wins
	 */
	public double play(double wager)
	{
		slot1 = rollSlot();
		slot2 = rollSlot();
		slot3 = rollSlot();
		System.out.println(toString());
		return super.calcWinnings(calcMultiplier());
	}
	
	/**
	 * method calcMultiplier - calculates the muiltiplier the player gets
	 * @param none
	 * @return the multiplier
	 */
	public double calcMultiplier()
	{
		if(slot1.equals("7") && slot2.equals("7") && slot3.equals("7"))
			return 10;
		else if(slot1.equals("7") && (slot2.equals("7") || slot3.equals("7"))) //accounts for 2 possibilites of two 7's
			return 4;
		else if(slot2.equals("7") && (slot3.equals("7") || slot1.equals("7"))) //accounts for 2 possibilites of two 7's
			return 4;
		else if(slot3.equals("7") && (slot2.equals("7") || slot1.equals("7"))) //accounts for 2 possibilites of two 7's
			return 4;
		else if(slot1.equals(slot2) && slot2.equals(slot3)) //accounts for all 3 slots being fruits if they aren't 7's
			return 7;
		else if(slot1.equals("7") || slot2.equals("7") || slot3.equals("7")) //accounts for 1 slot being a 7
			return 1;
		else
			return 0;
	}
	
	/**
	 * method rollSlot - rolls the slot and generates a random symbol
	 * @param none
	 * @return the randomly generated symbol
	 */
	private String rollSlot()
	{
		int num;
		
		num = (int)(Math.random()*((5-0)+1))+0;
		
		switch(num)
		{
			case 0:
				return "7";
			case 1:
				return "bannana";
			case 2:
				return "lemon";
			case 3:
				return "orange";
			case 4:
				return "apple";
			case 5:
				return "melon";
			default:
				System.out.println("Error in the slot Machine");
				return "";
		}
	}
	
	public String toString()
	{
		return "Results: " + slot1 + ", " + slot2 + ", " + slot3 + ".";
	}
}
