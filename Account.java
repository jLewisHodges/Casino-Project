/**
 * Account abstract class - carries similar functions of two different classes
 * @author Jorden Hodges
 *
 *Semester Project Part B: 
 * 		Related Classes:
 * 			PlayerAccount - PlayerAccount inherits from Account. I chose this relationship because playerAccount needs to perform many of the same functions as CasinoAccount
 * 			CasinoAccount - CasinoAccount inherits from Account. I chose this relationship because CasinoAccount needs to perform many of the same functions as PlayerAccount
 * 			Casino - Casino is dependent on Account
 */
public class Account {
	private double balance;
	
	public Account()
	{
		balance = 0;
	}
	
	public Account(double initialBalance)
	{
		balance = initialBalance;
	}
	
	/**
	 * method getBalance - retrieves account balance
	 * @param none
	 * @return current balance
	 */
	public double getBalance()
	{
		return balance;
	}
	
	/**
	 * method deposit - adds funds to users account
	 * @param aDeposit - amount the user is depositing
	 * @return none
	 */
	public void deposit(double aDeposit)
	{
		balance += aDeposit;
	}
	
	/**
	 * method withdraw - subtracts funds from Casino Funds
	 * @param value - funds being subtracted
	 * @return none
	 */
	public void withdraw(double value)
	{
		if(fundsValidator(value) == true)
			balance -= value;
		else
			System.out.println("We are sorry. The Casino is currently bankrupt.");
	}
	
	/**
	 * method validateFunds
	 * @param value - funds being validated
	 * @return whether there is enough funds
	 */
	public boolean fundsValidator(double value)
	{
		if(balance - value >= 0)
			return true;
		else
			return false;
	}
	
	/**
	 * method toString
	 * @param none
	 * @return string of data
	 */
	public String toString()
	{
		return String.format("Balance: $%.2f.\n", balance);
	}
}
