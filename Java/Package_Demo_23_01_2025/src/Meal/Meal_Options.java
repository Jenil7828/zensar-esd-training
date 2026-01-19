package Meal;
import java.util.Scanner;

import Dinner.Dinner_Menu;
import Lunch.Lunch_Menu;


public class Meal_Options {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("1. Lunch\n2.Dinner\nEnter choice: ");
		int ch = scan.nextInt();
		if(ch==1) {
			Lunch_Menu lunch = new Lunch_Menu();
			lunch.accept();
			lunch.display();
		}
		else if(ch==2) {
			Dinner_Menu dinner = new Dinner_Menu();
			dinner.accept();
			dinner.display();
		}
		scan.close();

	}

}
