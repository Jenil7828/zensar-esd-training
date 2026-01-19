package SMS;

import java.util.Scanner;

class Teacher extends Person {
	String []subjects;
	String department;
	int number;
	public Teacher(String Name, int id, String []subjects, String department) {
		super(Name, id);
		this.subjects= subjects;
		this.department = department;
	}
	public Teacher() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Teacher Name: ");
		Name = scan.next();
		System.out.print("Enter id: ");
		id = scan.nextInt();
		System.out.print("Enter the number of Subjects you want to Teach: ");
		number = scan.nextInt();
		subjects= new String[number];
		for(int i = 0; i < subjects.length; i++) {
			subjects[i] = new String();
			System.out.print("Enter subject "+(i+1));
			subjects[i] = scan.next();
		}
		System.out.print("Enter Department: ");
		department = scan.next();
		
	}
	void displyinfo() {
		super.displayinfo();
		for(int i = 0; i < subjects.length;i++) {
			System.out.println("Subjects Teaching "+subjects[i+1]+" : "+subjects[i]);
		}
		System.out.println("Department "+department);
	}
}
