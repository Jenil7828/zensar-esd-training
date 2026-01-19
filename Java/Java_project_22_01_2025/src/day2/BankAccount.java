package day2;

import java.util.Scanner;

public class BankAccount {
	String AccountHolder;
	float balance;
	float base_amount;
	Scanner scan = new Scanner(System.in);
	public BankAccount() {
		AccountHolder = "Anonymus";
		balance = 5000.00f;
		base_amount = 1000.00f;
	}
	public BankAccount(String AccountHolder, float balance, float base_amount) {
		this.AccountHolder= AccountHolder;
		this.balance=balance;
		this.base_amount=base_amount;
	}
	
	String Deposit() {
		System.out.println("Enter the amount you wanna Depsoit: ");
		float amount = scan.nextFloat();
		if (amount > 0.00) {
			balance += amount;
			return "Amount_Depsotited";
		}
		else {
			return "Amount shoulder be greater than 0.00";
		}	
	}
	
	String Withdrawal() {
		System.out.println("Enter the amount you wanna Withdraw: ");
		float amount = scan.nextFloat();
		if (balance - amount >= base_amount) {
			balance -= amount;
			return "Amount Withdrawn";
		}
		else {
			return "Amount Withdrawn";
		}
	}
	
	void displayDetails() {
		System.out.println("Account Holder: "+AccountHolder);
		System.out.println("Balance: "+balance);
		System.out.println("Base Amount: "+base_amount);
	}
}
