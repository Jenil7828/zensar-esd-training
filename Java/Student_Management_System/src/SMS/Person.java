package SMS;

import java.util.Scanner;

public class Person {
	String Name;
	int id;
	static int count = 0; 
	public Person(String Name, int id) {
		this.id = id;
		this.Name = Name;
		count++;
	}
	public Person() {
		Scanner scan = new Scanner(System.in);
		count++;
	}
	void displayinfo() {
		System.out.println("Name: "+Name);
		System.out.println("ID: "+id);
	}
}
