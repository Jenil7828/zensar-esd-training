package Bank;

import java.util.Scanner;

public class BankingSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 0;
		Scanner scan = new Scanner(System.in);
		Customer []cust = new Customer[10]; 
		do {
			System.out.print("\n\n1. New Customer \n2.Exisiting Customer \nEnter Choice: ");
			int ch = scan.nextInt();
			switch(ch) {
			case 1:
				cust[count] = new Customer();
				count++;
				break;
			case 2:
				System.out.print("Enter Account Holder Name: ");
				String choice = scan.next();
				int c = -1;
				for (int i = 0; i < count; i++) {
					if(cust[i].Name.equals(choice)) {
						c = i;
						break;
					}
				}
				if(c != -1) {
					System.out.print("1. Create Savings Account\n2. Create Current Account\n3.Existing Account\n4. Display all counts");
					int choi = scan.nextInt();
					switch(choi) {
						case 1:
							System.out.print("Enter Account Number: ");
							String number= scan.next();
							System.out.print("Enter initial amount");
							double bal = scan.nextDouble();
							cust[c].createSavingsAccount(number, bal);
							break;
						case 2:
							System.out.print("Enter Account Number: ");
							number= scan.next();
							System.out.print("Enter initial amount");
							bal = scan.nextDouble();
							cust[c].createCurrentAccount(number, bal);
							break;
						case 3:
							System.out.print("Enter Account Number: ");
							number= scan.next();
							int a =-1;
							for (int j = 0 ; j < cust[c].account; j++) {
								if(number.equals(cust[c].accounts[j].accountNumber)) {
									a = j;
									break;
								}
							}
							if(a != -1 ) {
								
								System.out.print("\n1.Deposit Money\n2.Withdraw Money\n3. Display Details\n4. Get Balance");
								int cho = scan.nextInt();
								switch(cho) {
								case 1:
									System.out.print("Enter amount you want to deposit: ");
									double amt = scan.nextDouble();
									cust[c].accounts[a].Deposit(amt);
									break;
								case 2:
									System.out.print("Enter amount you want to withdraw: ");
									double wit = scan.nextDouble();
									cust[c].accounts[a].Withdrawal(wit);
									break;
								case 3:
									cust[c].accounts[a].displayAccountDetails();
									break;
								case 4:
									double get = cust[c].accounts[a].getBalace();
									System.out.println("Account Balance is: "+get);
									break;
								}
								
							}
							else {
								System.out.println("No such account exists");
							}
							break;
						case 4:
							cust[c].displayCustomerAccounts();
							break;	
					}
				}else {
					System.out.println("Customer not found");
				}
				break;
			default:
				System.out.println("Invalid Entry:");
				break;	
			}
			System.out.println("Do you wannt to Continue");
			String response = scan.next();
			if(response.equalsIgnoreCase("no")) {
				break;
			}
		}while(true);
		/*Customer customer = new Customer();
		
		customer.createSavingsAccount("2215045", 10000);
		customer.createCurrentAccount("221504", 100000);
		customer.displayCustomerAccounts();
		
		for(BankAccount acc :customer.getAccounts()) {
			if(acc != null) {
				acc.displayAccountDetails();
			}
		}*/
		
		
	}

}
