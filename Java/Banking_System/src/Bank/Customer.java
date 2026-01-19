package Bank;

import java.util.Scanner;

public class Customer {
	String Name;
	String email;
	int max_account_count=5;
	BankAccount [] accounts;
	int account = 0;
	
	public Customer(){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Customer Name: ");
		Name = scan.next();
		System.out.print("Enter Customer E-mail: ");
		email = scan.next();
		accounts = new BankAccount[max_account_count];
	}
	void createSavingsAccount(String accountNumber, double initialBalance){
		SavingsAccount savings = new SavingsAccount(accountNumber, initialBalance, Name);
		if(account < max_account_count) {
			accounts[account] = savings;
			account++;
			System.out.println("Account with Acccount No.: "+accountNumber+" created...");
		}
		else {
			System.out.println("Maximum amount Formed. Cannot Form new account");
		}
	}
	
	void createCurrentAccount(String accountNumber, double initialBalance){
		CurrentAccount current = new CurrentAccount(accountNumber, initialBalance, Name);
		if(account < max_account_count) {
			accounts[account] = current;
			account++;
		}
		else {
			System.out.println("Maximum amount Formed. Cannot Form new account");
		}
	}
	
	void displayCustomerAccounts() {
		System.out.println("Customer: "+ Name+" has accounts: ");
		for (int i = 0; i < account; i++) {
			System.out.println("Account: "+(i+1));
			accounts[i].displayAccountDetails();
		}
	}
	
	BankAccount[] getAccounts() {
		return accounts;
	}
}
