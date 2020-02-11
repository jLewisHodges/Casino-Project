import java.util.Scanner;

/**
 * resembles a simple menu
 * @author hodj6
 *
 */
public class Menu {
	private static boolean masterDone;
	private static Casino casino;
	private static PlayerAccount currPlayer;
	private static Scanner cons;
	public Menu()
	{
		masterDone = false;
		casino = new Casino();
		currPlayer = null;
		cons = new Scanner(System.in);
	}
	
	/**
	 * mainMenu - drives the main menu
	 * @param none
	 * @return none
	 */
	public static void mainMenu()
	{
		while(!masterDone)
		{
			System.out.println("Login as Administrator (1) or Player (2)");
			if(cons.nextInt() == 1)
			{
				adminMenu();	
			}
			else
			{
				playerMenu();	
			}
		}
	}
	
	/**
	 * method adminMenu - admin menu
	 * @param none
	 * @return none
	 */
	public static void adminMenu()
	{
		int pin = 0, menu = 0;
		boolean done = false;
		Scanner admin = new Scanner(System.in);
		
		pin = 9999;
		System.out.println("Please enter the pin to access this menu:");
		if(pin == admin.nextInt())
		{
			while(!done)
			{
				System.out.println("Choose Menu Option (1 = see Casino Balance, 2 = add Funds to Casino, 3 = back to previous menu, 4 = exit)");
				menu = admin.nextInt();
				switch(menu)
				{
					case 1:
						System.out.print(casino.toString());
						break;
					case 2:
						System.out.println("How much is being deposited?");
						casino.addCasinoFunds(admin.nextDouble());
						break;
					case 3:
						masterDone = false;
						done = true;
						break;
					case 4:
						masterDone = true;
						done = true;
						break;
				}
			}//while
		}//if
	}//adminMenu
	
	/**
	 * method playerMenu - player menu
	 * @param none
	 * @return none
	 */
	public static void playerMenu()
	{
		int menu = 0;
		boolean done = false;
		Scanner player = new Scanner(System.in);
		String name;
		
		if(currPlayer == null)
		{
			System.out.println("Create a new account (1)? Or login to an existing account (2)?");
			if(player.nextInt() == 1)
			{
				System.out.println("Your Name?");
				name = player.next();
				System.out.println("Initial Deposit?");
				currPlayer = casino.addPlayer(name, player.nextDouble());
			}
			else
			{
				System.out.println("Name on the account?");
				casino.switchPlayerAccount(player.next());
			}
		}
			while(!done)
			{
				System.out.println("Choose a menu option (1 = deposit funds, 2 = play Black Jack, 3 = player slots, 4 = See current balance, 5 = switch player, 6 = cash out, 7 = logout)");
				menu = player.nextInt();
				switch(menu)
				{
				case 1:
					double value = 0;
					System.out.println("What is your deposit?");
					value = player.nextDouble();
					currPlayer.deposit(value);
					break;
				case 2:
					System.out.println("What is your wager? ");
					casino.playBlkjack(player.nextDouble());
					break;
				case 3:
					System.out.println("What is your wager? ");
					casino.playSlots(player.nextDouble());
					break;
				case 4:
					System.out.println(currPlayer.toString());
					break;
				case 5:
					System.out.println("Create a new account (1)? Or login to an existing account (2)?");
					if(player.nextInt() == 1)
					{
						System.out.println("Your Name?");
						name = player.next();
						System.out.println("Initial Deposit?");
						currPlayer = casino.addPlayer(name, player.nextDouble());
					}
					else
					{
						System.out.println("Name on the account?");
						currPlayer = casino.switchPlayerAccount(player.next());
					}
					break;
				case 6:
					currPlayer.withdraw(currPlayer.getBalance());
					System.out.println("You have succesfully cashed out.");
					break;
				case 7:
					currPlayer = casino.logout();
					masterDone = false;
					done = true;
					break;
				default:
					menu = 0;
					System.out.println("Not an option");
					break;
				}//while
			}//if
		}//playerMenu
}
