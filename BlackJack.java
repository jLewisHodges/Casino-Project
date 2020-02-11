/**
 * simulates how a Black Jack game would operate.
 * 
 * 	Associated Classes:
 * 		Game - BlackJack inherits from Game. I did this because BlackJack has similar functionality to Slots which also inherits from game.
 */
import java.util.*;
public class BlackJack extends Game{
	public BlackJack(Account player, double wager)
	{
		super(player, wager);
	}
	
	public BlackJack()
	{
		super();
	}
	
	/**
	 * method playBlkJack - carries out Black Jack game
	 * @param none
	 * @return final winnings
	 */
	public double play(double wager)
	{
		String playerHand = "";
		String dealerHand = "";
		boolean playerDone = false;
		boolean done = false;
		boolean surrender = false;
		boolean dealerDone = false;
		int menu = 0;
		Scanner in = new Scanner(System.in);
		
		dealerHand += draw();
		playerHand += draw() + ", " + draw();
		printDealer(dealerHand);
		printPlayer(playerHand);
		
		while(!done)
		{
			if(!playerDone)
			{
				//menu for player
				System.out.println("Choose an option 1 = Hit, 2 = Surrender, 3 = stand");
				menu = in.nextInt();
				switch(menu)
				{
					case 1:
						playerHand += ", " + draw();
						break;
					case 2:
						surrender = true;
						done = true;
						break;
					case 3:
						playerDone = true;	
						break;
				}
			}//while !playerDone
			if(countHand(playerHand) > 21)
			{
				done = true;
				printDealer(dealerHand);
				printPlayer(playerHand);
				System.out.println("You busted.");
				break; // breaks out of the loop so dealer does not draw
			}
			if(countHand(playerHand) == 21)
			{
				done = true;
				System.out.println("The player got a Black Jack.");
			}
			//dealer drawing instructions
			if(countHand(dealerHand) < 16)
				dealerHand += ", " + draw();
			else if(countHand(dealerHand) > 21)
			{
				System.out.println("The Dealer is busted.");
				done = true;
			}
			else if(countHand(dealerHand) == 21)
			{
				done = true;
			}
			else
				dealerDone = true;
			if(dealerDone && playerDone == true)
				done = true;
			printDealer(dealerHand);
			printPlayer(playerHand);
		}//while !done
			if(countHand(playerHand) > 21)
				return super.calcWinnings(0);
			else if(countHand(dealerHand) > 21)
				return super.calcWinnings(2);
			else if(countHand(playerHand) == 21)
				return super.calcWinnings(2.5);
			else if(countHand(dealerHand) == 21)
				return super.calcWinnings(0);
			else if(countHand(dealerHand) > countHand(playerHand))
				return super.calcWinnings(0);
			else if(countHand(playerHand) > countHand(dealerHand))
				return super.calcWinnings(2);
			else if(countHand(playerHand) == countHand(dealerHand))
				return super.calcWinnings(1);
			else if(surrender)
				return super.calcWinnings(.5);
			else
				return super.calcWinnings(0);
	}
	
	/**
	 * method draw - draws a random card
	 * @param none
	 * @return card that is drawn
	 */
	private String draw()
	{
		int num;
		
		num = (int)(Math.random()*((12-0)+1))+0;
	
		if(num == 0)
			return "Ace";
		else if(num == 1)
			return "2";
		else if(num == 2)
			return "3";
		else if(num == 3)
			return "4";
		else if(num == 4)
			return "5";
		else if(num == 5)
			return "6";
		else if(num == 6)
			return "7";
		else if(num == 7)
			return "8";
		else if(num == 8)
			return "9";
		else if(num == 9)
			return "10";
		else if(num == 10)
			return "Jack";
		else if(num == 11)
			return "Queen";
		else if(num == 12)
			return "King";
		else
			return "";
	}
	
	/**
	 * method printDealer - prints the dealers hand and value of hand
	 * @param dealerHand - String with dealers hand
	 * @return none
	 */
	private void printDealer(String dealerHand)
	{
		System.out.println("Dealers hand: " + dealerHand);
		System.out.println("Dealers hands value: " + countHand(dealerHand));
	}
	
	/**
	 * method printPlayer - prints the players hand and value of hand
	 * @param dealerHand - String with players hand
	 * @return none
	 */
	private void printPlayer(String playerHand)
	{
		System.out.println("Players hand: " + playerHand);
		System.out.println("Players hands value: " + countHand(playerHand));
	}
	
	/**
	 * method countHand - counts the value of a hand
	 * @param hand - String with cards
	 * @return value of hand
	 */
	private int countHand(String hand)
	{
		hand = hand.toLowerCase();
		Scanner parser = new Scanner(hand);
		parser.useDelimiter(", ");
		String card = "";
		boolean ace = false;
		int total = 0;
		
		while(parser.hasNext())
		{
			card = parser.next();
			
			if(card.equals("ace"))
			{
				ace = true;
				total += 1;
			}
			else if(card.equals("2"))
				total += 2;
			else if(card.equals("3"))
				total += 3;
			else if(card.equals("4"))
				total += 4;
			else if(card.equals("5"))
				total += 5;
			else if(card.equals("6"))
				total += 6;
			else if(card.equals("7"))
				total += 7;
			else if(card.equals("8"))
				total += 8;
			else if(card.equals("9"))
				total += 9;
			else if(card.equals("10"))
				total += 10;
			else if(card.equals("jack"))
				total += 10;
			else if(card.equals("queen"))
				total += 10;
			else if(card.equals("king"))
				total += 10;	
		}
		if(ace) //this is to account for the fact that an ace can be used as an 11 if it helps the hand
		{
			if((total + 10) <= 21)
				total += 10;
		}
		return total;
	}
	
}
