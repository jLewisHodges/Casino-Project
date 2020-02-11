/**
 * class CasinoAccount - holds information for the Casino's account
 * @author Jorden Hodges
 * 
 *Associated classes:
 *		Game - CasinoAccount inherits from Account. I chose this relationship because CasinoAccount needs to perform many of the same functions as PlayerAccount
 */
public class CasinoAccount extends Account{
	
	public CasinoAccount()
	{
		super();
	}
	
	
	public CasinoAccount(double initialBalance)
	{
		super(initialBalance);
	}
}
