package day1;

public class Operations {
	int no1 = 5;
	int no2 = 6;
	void add() {
		
		System.out.println("Addition of 2 number: "+ (no1+no2));
	}
	void sub() {
		System.out.println("Subtraction of 2 number: "+ (no1-no2));
	}
	void mul() {
		System.out.println("Multiplication of 2 number: "+ (no1*no2));
	}
	void div() {
		System.out.println("Division of 2 number: "+ (no1/no2));
	}
	public static void main(String[] args) {
		Operations a = new Operations();
		a.add();
		a.sub();
		a.mul();
		a.div();
	}
	
}
