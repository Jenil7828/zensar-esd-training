package Lunch;

import java.util.Scanner;

public class Lunch_Menu {
	String dish;
	int cost;
	public void accept() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Dish Name: ");
		dish = scan.next();
		System.out.print("Enter cost of the dish: ");
		cost = scan.nextInt();
	}
	
	
	public void display() {
		System.out.println("The prize of the dish: "+dish+ " is :"+cost);
	}
}
