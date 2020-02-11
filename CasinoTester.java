/**
 * @author Jorden Hodges
 * Semester Project: part A
 * 02/17/2019
 * 
 * Pseudocode for menu:
 * Main:
 * 	Initialize all variables
 * 	Repeat (program is not complete)
 * 		prompt user if they are a player or admin
 * 		if they are an admin
 * 			call adminMenu
 * 		otherwise
 * 			call playerMenu
 * adminMenu:
 * 	initialize all variables
 * 	prompt for pin
 * 	if pin matches stored pin
 * 		Repeat (adminMenu is not done)
 * 			prompt for menu option
 * 			if user chooses see balance
 * 				show casino balance
 * 			otherwise if user chooses addFunds
 * 				prompt for funds being added
 * 				add funds
 * 			otherwise if user chooses to go to previous menu
 * 				adminMenu is done
 * 			otherwise if user wants to close program 
 * 				program is done
 * playerMenu:
 * 	initialize all variables
 * 	if there is no current player
 * 		prompt user if they want to create an account or use an existing one
 * 			if user wants to create an account
 * 				prompt for name
 * 				prompt for initial balance
 * 				create an account
 * 			otherwise
 * 				prompt for name on the account
 * 				search for account
 * 		Repeat (playerMenu is not done)
 * 			prompt for menu option
 * 			if user wants to deposit money
 * 				prompt for deposit amount
 * 				deposit money
 * 			otherwise if user wants to play black jack
 * 				prompt for wager
 * 					start Black Jack
 * 			otherwise if user wants to play slots
 * 				prompt for wager
 * 					start slots
 * 			otherwise if player wants to see current balance
 * 				show current balance
 * 			otherwise if player wants to switch accounts
 * 				prompt for whether user wants to make a new account or switch to an existing one
 * 				if user wants to create an account
 * 					prompt for name
 * 					prompt for initial balance
 * 					create an account
 * 				otherwise
 * 					prompt for name on the account
 * 					search for account
 * 			oterwise if player wants to cash out
 * 				withdraw all funds in account
 * 			otherwise if player wants to logout
 * 				logout player
 * 			otherwise if player wants to exit
 * 				playerMenu is done
 * 			
 * 			
 * 
 */
import java.util.*;
public class CasinoTester {
	Menu main = new Menu();
	main.mainMenu();
}
