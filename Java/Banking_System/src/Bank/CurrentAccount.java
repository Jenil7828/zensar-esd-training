package Bank;

class CurrentAccount extends BankAccount{
	static final double OVERDRAFT_LIMIT = 100000;
	public CurrentAccount() {
		super();
	}
	public CurrentAccount(String accountNumber, double balance, String accountHolderName) {
		super(accountNumber, balance, accountHolderName);
	}
	void applyInterest() {
		
	}
	
	void withdraw(double amount) {
		if (amount > balance+OVERDRAFT_LIMIT) {
			System.out.println("Withdrawal Amount exceeds Overdraft limit");
		}
		else {
			super.Withdrawal(amount);
		}
	}
}
