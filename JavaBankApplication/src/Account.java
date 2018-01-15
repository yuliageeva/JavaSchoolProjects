public class Account {
	// Fields
	private String accountNumber;
	private double balance;	
	// Constructor
	public Account(String accountNumber)
	{
		this.accountNumber = accountNumber;
		this.balance = 0;
	}
	// Methods
	public void deposit(double amount)
	{
		if(amount > 0)
			balance += amount;
	}
	public String getAccountNumber()
	{
		return accountNumber;
	}
	public double getBalance()
	{
		return balance;
	}
	public boolean withdraw(double amount)
	{
		if (amount>balance)
		{
			return false;
		}
		else
			balance = balance -amount;
			return true;
	}
}
// End

