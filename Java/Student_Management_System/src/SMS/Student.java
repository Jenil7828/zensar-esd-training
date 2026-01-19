package SMS;

import java.util.Scanner;

class Student extends Person {
	String []courseList;
	float GPA;
	int number;
	public Student(String Name,int id, String []courseList, float GPA) {
		super(Name, id);
		this.courseList = courseList;
		this.GPA = GPA;
	}
	public Student() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Student Name: ");
		Name = scan.next();
		System.out.print("Enter id: ");
		id = scan.nextInt();
		System.out.print("Enter the number of Courses you want to enroll: ");
		number = scan.nextInt();
		courseList= new String [number];
		for(int i = 0; i < number; i++) {
			courseList[i] = new String();
			System.out.print("Enter course "+(i+1));
			courseList[i] = scan.next();
		}
		System.out.print("Enter GPA: ");
		GPA = scan.nextFloat();
		
	}
	void displayinfo() {
		super.displayinfo();
		for(int i = 0; i < courseList.length;i++) {
			System.out.println("Course "+(i+1)+" : "+courseList[i]);
		}
		System.out.println("GPA: "+GPA);
	}
}
