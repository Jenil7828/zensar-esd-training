package Bank;

import java.util.Scanner;

public class BankAccount {
	String accountNumber;
	double balance;
	String accountHolderName;
	
	public BankAccount() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter account number: "+accountNumber);
		accountNumber = scan.next();
		System.out.print("Enter Account Holder Number: "+accountHolderName);
		System.out.println("Enter the Balance amount: ");
	}
	
	public BankAccount(String accountNumber, double balance, String accountHolderName) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.accountHolderName = accountHolderName;
	}
	void Deposit(double amount) {
		if (amount > 0.00 ) {
			balance += amount;
			System.out.println( "Amount_Depsotited");
		}
		else {
			System.out.println("Amount shoulder be greater than 0.00");
		}	
	}
	void Withdrawal(double amount) {
		if (balance - amount >= 0) {
			balance -= amount;
			System.out.println( "Amount Withdrawn");
		}
		else {
			System.out.println( "Amount Should be greater then 0.00");
		}
	}
	void displayAccountDetails() {
		System.out.println("Account Number: "+accountNumber);
		System.out.println("Account Holder: "+accountHolderName);
		System.out.println("Balance: "+balance);
		
	}
	
	double getBalace() {
		return balance;
	}
	
	void applyInterest() {
		
	}
}
