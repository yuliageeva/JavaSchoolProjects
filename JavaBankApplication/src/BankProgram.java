import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

import java.util.List;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class BankProgram {

	private static List<Account> accountList = new ArrayList<Account>();

	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choice = -1;

		while (choice != 0) {

			switch (choice) {
			case 1:
				listAccounts();
				break;
			case 2:
				addAccount();
				break;
			case 3:
				depositMoney();
				break;
			case 4:
				withdrawMoney();
				break;
			case 5:
				deleteAccount();
				break;
			}

			displayMenu();
			choice = input.nextInt();
		}

		System.out.println("\nThe program ends now. Bye!");
	}

	private static void displayMenu() {
		String line = "-----------------------------------------------------" +
			"---------------------------------------------------------------";
		System.out.println(line);
		System.out.print(" 0 = Quit | 1 = List accounts | 2 = Add an account | " +
			"3 = Deposit money | 4 = Withdraw money | 5 = Delete an account \n");
		System.out.println(line);
		System.out.print("Enter your choice: ");
	}


	private static void listAccounts() {
		
		System.out.print("\n*** Account list ***\n");
		DecimalFormat twoDecimals = new DecimalFormat("0.00");
		for(Account accountObject : accountList)
		{
			System.out.println("Number: " + accountObject.getAccountNumber() + " | Balance: "+ twoDecimals.format(accountObject.getBalance()));
		} 
	}

	private static void addAccount() {
		Scanner input = new Scanner(System.in);
		System.out.print("\n*** Add an account ***\n");
		System.out.print("Enter account number: ");
		String accountNumber = input.nextLine();
		if(accountList.isEmpty())
		{
			accountList.add(new Account(accountNumber));
			System.out.print("Account created successfully");
		}
		else
		{
			if(findAccount(accountNumber)==null)
			{
				accountList.add(new Account(accountNumber));
				System.out.print("Account created successfully");
			}
			else
				System.out.print("Account not created.Account " + accountNumber +" already exists! ");
		}
	}

	// Finds an account in accountList by given account number
	// Returns either the account object in the account list
	// OR null if the account is not found.
	private static Account findAccount(String accountNumber) {
		Account myAccount = null;
		for(int i=0; i<accountList.size();i++)
		{
			if (accountNumber.equals(accountList.get(i).getAccountNumber()))
			{
				myAccount= accountList.get(i);
			}
		}
				
		return myAccount;
	}	
	
	private static void depositMoney() {
		Scanner input = new Scanner(System.in);
		System.out.print("\n*** Deposit money to an account ***\n");
		System.out.print("Enter account number: ");
		String accountNumber = input.nextLine();
		if(findAccount(accountNumber)!=null)
		{	
			Account depositAccount = findAccount(accountNumber);
			System.out.print("Enter the amount to be deposited: ");
			double amount = input.nextDouble();
		
			if(amount > 0)
			{
				depositAccount.deposit(amount) ;
				System.out.print("Deposit completed successfully!");
			}
			else	System.out.print("Cannot deposit a negative amount!");
		}
		else
			System.out.print("Account "+ accountNumber +" does not exist!");
	}
		
	private static void withdrawMoney() {
		Scanner input = new Scanner(System.in);
		System.out.print("\n*** Withdraw money from an account ***\n");
		System.out.print("Enter account number: ");
		String accountNumber = input.nextLine();
		if(findAccount(accountNumber)!=null)
		{	
			Account withdrawnAccount = findAccount(accountNumber);
			System.out.print("Enter the amount to be withdrawn: ");
			double amount = input.nextDouble();
		
			if(amount > 0)
			{
				if (withdrawnAccount.withdraw(amount))
				System.out.print("Withdrawal completed successfully!");
				else
				System.out.print("Withdrawal not completed. Available balance is too low.");
			}
			else
				System.out.print("Cannot withdraw a negative amount!");	
		}
		else
			System.out.print("Account "+ accountNumber +" does not exist!");
		
	}
	

	private static void deleteAccount() {
		Scanner input = new Scanner(System.in);
		System.out.print("\n*** Delete an account ***\n");
		System.out.print("Enter account number: ");
		String accountNumber = input.nextLine();
		if(findAccount(accountNumber)!=null)
		{
			Account deleteAccount = findAccount(accountNumber);
			accountList.remove(deleteAccount);
			System.out.print("Account deleted successfully!");
		}
		else
		System.out.print("Nothing to delete. Account " + accountNumber +" doesn't exist!");	
	}
	
}
// End 

