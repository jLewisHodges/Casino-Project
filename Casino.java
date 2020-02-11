/**
 * class Casino - simulates how a Casino would operate
 * @author Jorden Hodges
 * Semester Project Part A: the class will start by creating an account for the player which will store the players information.
 * such as current balance and name. The class will be responsible for adding funds to the users account
 * and validating the funds to what the user enters for each game. The class will then create the game
 * by creating an object for that specific game. I designed the class this way so that there would
 * be no double layer to do a task (especially in the case of the account class). In other words I did
 * want to have a method in the Casino class to call another method in Account class to do an operation
 * Casino.java can do without having to go through the extra layer, but I also wanted the users
 * information to be stored in a separate location. I decided to make useFunds a helper method because
 * the tester does not need to use it at all when each game can call it to subtract the funds when the
 * user plays.
 * 
 * Semester Project Part B: 
 * 		Related Classes:
 * 			Game - Casino aggregates Game objects. I chose this relationship as the casino class needs to create multiple games such as Black Jack and Slots
 * 			Account - Casino depends on the Account class. I chose this relationship because without Account Casino would not be able to function
 */
import java.util.*;
public class Casino {
	private LinkedList playerAccounts;
	private Account mainFunds; 
	private PlayerAccount currPlayer;
	
	
	public Casino(PlayerAccount aAccount)
	{
		playerAccounts = new LinkedList();
		playerAccounts.addFirst(aAccount);
		mainFunds = new CasinoAccount(2000);
		currPlayer = aAccount;
	}
	
	public Casino()
	{
		playerAccounts = new LinkedList();
		mainFunds = new CasinoAccount(2000);
		currPlayer = null;
	}
	
	/**
	 * method playBlkJack - creates a Black Jack game object
	 * @param wager - amount of money the user wants to wager
	 * @return winnings - amount the user won.
	 */
	public void playBlkjack(double wager)
	{
		double winnings;
		if((currPlayer.fundsValidator(wager)) && mainFunds.fundsValidator((2.5 * wager) - wager))
		{
			currPlayer.withdraw(wager);
			mainFunds.deposit(wager);
			System.out.println("Starting Black Jack");
			winnings = new BlackJack(currPlayer, wager).play(wager);
			mainFunds.withdraw(winnings);
			currPlayer.deposit(winnings);
			System.out.println(currPlayer.toString());
		}
		else
		{
			if(!currPlayer.fundsValidator(wager))
			{
				System.out.println("Insufficient funds");
				System.out.println(currPlayer.toString());
			}
			else if(!mainFunds.fundsValidator((2.5 * wager) - wager))
				System.out.println("We are sorry the Casino is currently bankrupt.");
		}
	}
	
	/**
	 * method playSlots - creates a slot maching game object
	 * @param wager - amount of money the user wants to wager
	 * @return winnings - amount the user won
	 */
	public void playSlots(double wager)
	{
		if(currPlayer.fundsValidator(wager))
		{
			currPlayer.withdraw(wager);
			System.out.println("Starting Slots");
			currPlayer.deposit(new Slots(currPlayer, wager).play(wager));
			System.out.println(currPlayer.toString());
		}
		else
		{
			System.out.println("Insufficient funds");
			System.out.println(currPlayer.toString());
		}
	}
	
	/**
	 * method switchPlayerAccount - switches current player account
	 * @param name - name on the account
	 * @return none
	 */
	public PlayerAccount switchPlayerAccount(String name)
	{
		name = name.toLowerCase();
		boolean done = false;
		currPlayer = (PlayerAccount)playerAccounts.findNode(name);
		while(!done)
		{
			for(int i = 0; i < playerAccounts.size(); i++)
			{
				if(playerAccounts.getFirst(i).getName().toLowerCase().equals(name))
				{
					done = true;
					currPlayer = playerAccounts.get(i);
					System.out.println("Welcome back " + playerAccounts.get(i).getName() + ".");
					return playerAccounts.get(i);
				}
			}
		}
		System.out.println("Account not found. Accounts were not switched.");
		return currPlayer;
	}
	
	/**
	 * method addPlayer - adds a player to list of accounts
	 * @param name for account
	 * @return the new player account
	 */
	public PlayerAccount addPlayer(String name, double initialDeposit)
	{
		playerAccounts.add(new PlayerAccount(name, initialDeposit));
		currPlayer = playerAccounts.get(playerAccounts.size()-1);
		System.out.println("Welcome " + name + ".");
		return playerAccounts.get(playerAccounts.size()-1);
		
	}
	
	/**
	 * method addCasinoFunds - deposits casino funds
	 * @param aDeposit
	 * @return none
	 */
	public void addCasinoFunds(double aDeposit)
	{
		mainFunds.deposit(aDeposit);
	}
	
	/**
	 * method logout - clears current player
	 * @param none
	 * @return none
	 */
	public PlayerAccount logout()
	{
		currPlayer = null;
		return currPlayer;
	}
	
	/**
	 * toString - retrieves string of Casino Information
	 * @param none
	 * @return string of information
	 */
	public String toString()
	{
		return mainFunds.toString();
	}
	
}
