package day3;

public class Static_Demo {
	static int count;
	public Static_Demo() {
		count++;
	}
	void display() {
		System.out.println("Count: "+count);
	}
	public static void main(String[] args) {
		Static_Demo s1 = new Static_Demo();
		s1.display();
		Static_Demo s2 = new Static_Demo();
		s2.display();
		Static_Demo s3 = new Static_Demo();
		s3.display();
		Static_Demo s4 = new Static_Demo();
		s4.display();
	}
	
}
