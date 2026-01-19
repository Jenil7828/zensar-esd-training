package day7;

import java.util.Scanner;

public class String_Operations {
	boolean is_name(String name) {
		if (name.contains(" ") && name.matches("^[^0-9]*$")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	boolean is_email(String email) {
		if ((email.contains("@")) && (((email.charAt(email.length() - 4)) == '.') || (email.charAt(email.length() - 4) == '.'))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	boolean is_phone(String phone) {
		if(phone.length() == 10) {
			return false;
		}
		else {
			return true;
		}
	}
	
	boolean is_address(String address) {
		if (address != null && address.matches("[a-zA-Z0-9\\s,.-]+")){
			return true;
		}
		else {
			return false;
		}		
	}
	
	boolean is_blood_group(String blood) {
		if((blood.charAt(blood.length() - 1) == '+') || (blood.charAt(blood.length() - 1) == '-') && (blood.length()<3)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Name: ");
		String name = scan.nextLine();
		System.out.print("Enter Phone Number: ");
		String phone = scan.nextLine();
		System.out.print("Enter E-mail: ");
		String email = scan.nextLine();
		System.out.print("Enter Address: ");
		String address = scan.nextLine();
		System.out.print("Enter Blood Group: ");
		String blood = scan.nextLine();
		String_Operations s = new String_Operations();
		do{
			if(s.is_name(name)) {
				System.out.println("Name is correct");
			}
			else {
				System.out.println("Incorrect format. re-enter");
				System.out.print("Enter Name: ");
				name = scan.nextLine();
			}
			
			if(s.is_phone(phone)) {
				System.out.println("Phone number Group is correct");
			}
			else {
				System.out.println("Incorrect format. re-enter");
				System.out.print("Enter Phone number: ");
				phone = scan.nextLine();
			}
			
			if(s.is_email(email)) {
				System.out.println("Email is correct");
			}
			else {
				System.out.println("Incorrect format. re-enter");
				System.out.print("Enter E-mail: ");
				email = scan.nextLine();
			}
				
			if(s.is_address(address)) {
				System.out.println("Address is correct");
			}
			else {
				System.out.println("Incorrect format. re-enter");
				System.out.print("Enter Address: ");
				address = scan.nextLine();
			}
			
			if(s.is_blood_group(blood)) {
				System.out.println("Blood Group is correct");
			}
			else {
				System.out.println("Incorrect format. re-enter");
				System.out.print("Enter Blood Group: ");
				blood = scan.nextLine();
			}
		}while(!s.is_name(name) && !s.is_address(address) && !s.is_blood_group(blood) && !s.is_email(email) && !s.is_phone(phone));
		scan.close();
	}
}
