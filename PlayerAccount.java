/**
 * class PlayerAccount - holds player account information
 * @author Jorden Hodges
 *
 *Associtated Classes
 *		PlayerAccount inherits from Account. I chose this relationship because playerAccount needs to perform many of the same functions as CasinoAccount
 */
public class PlayerAccount extends Account{
	private String name;
	
	public PlayerAccount()
	{
		super();
		name = "";
	}
	
	public PlayerAccount(String name)
	{
		this.name = name;
	}
	
	public PlayerAccount(String name, double initialBalance)
	{
		super(initialBalance);
		this.name = name;
	}
	
	/**
	 * method getName - retrieves name on account
	 * @param none
	 * @return name of player
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * method setName
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * method toString
	 */
	public String toString()
	{
		return String.format("Name: " + getName()) + ".\n" + super.toString();
	}
}
