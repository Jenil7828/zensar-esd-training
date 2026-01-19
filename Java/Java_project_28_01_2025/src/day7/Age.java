package day7;

public class Age {
	static void checkAge(int age) {
		if(age<18) {
			throw new ArithmeticException("Access-denied, you be above 18");
		}
		else {
			System.out.println("Access granted, you are old enough ");
		}
	}
	public static void main(String[] args) {
		checkAge(17);
	}
}
