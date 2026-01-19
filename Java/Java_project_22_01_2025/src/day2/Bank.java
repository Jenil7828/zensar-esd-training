package day2;

public class Bank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount person1 = new BankAccount();
		System.out.println(person1.Deposit());
		System.out.println(person1.Withdrawal());
		person1.displayDetails();
	}

}
