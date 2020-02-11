/**
 * class Game - carries methods that every game object will use
 * @author Jorden Hodges
 * 
 * 	Associate Classes
 * 		Slots - Slots inherits from Game. I did this because Slots has similar functionality to BlackJack which also inherits from game.
 * 		BlackJack - BlackJack inherits from Game. I did this because BlackJack has similar functionality to Slots which also inherits from game.
 * 		
 */
public abstract class Game {
	private Account player;
	private double wager;
	
	/**
	 * constructor method - instantiates a Game object under players name
	 * @param name - name of the player
	 * @return none
	 */
	public Game(Account player, double wager)
	{
		this.player = player;
		this.wager = wager;
	}
	
	/**
	 * 
	 */
	public Game()
	{
		player = new PlayerAccount();
		wager = 0;
	}
	
	/**
	 * method calcWinnings
	 * @param multipier - multiplier the player won
	 * @return amount the player won
	 */
	public double calcWinnings(double multiplier)
	{
		System.out.println("You have won " + multiplier + "X your money.");
		return wager * multiplier;
	}
	
	/**
	 * abstract method play
	 */
	public abstract double play(double wager);
	
	/**
	 * method toString - displays game result
	 * @param  none
	 * @return string of data
	 */
	public String toString()
	{
		return String.format("Wager: $%.2f.\n", wager);
	}
}
