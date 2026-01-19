package Bank;

import java.util.Scanner;

class SavingsAccount extends BankAccount {
	double base_amount;
	static final double INTEREST_RATE = 3.65f;
	public SavingsAccount() {
		super();
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Base Amount: ");
		base_amount = scan.nextDouble();
	}
	public SavingsAccount(String accountNumber, double balance, String accountHolderName) {
		super(accountNumber, balance, accountHolderName);
		base_amount = 2000;
	}
	void applyIntrest() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the period in years: ");
		int period = scan.nextInt();
		
		balance += (balance*period*INTEREST_RATE)/100;
		System.out.println("The amount after "+period+" years is: "+balance);
	}
	
	void Withdrawal(double amount) {
		System.out.println("Enter the amount you wanna Withdraw: ");
		if (balance - amount >= base_amount) {
			balance -= amount;
			System.out.println( "Amount Withdrawn");
		}
		else {
			System.out.println( "Amount Withdrawn");
		}
	}
	
}
