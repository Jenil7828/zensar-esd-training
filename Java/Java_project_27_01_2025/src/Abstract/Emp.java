package Abstract;

public class Emp {
	public static void main(String[] args) {
		Employee sal = new Salaried("Jenil", 1);
		Employee hour = new Hourly("Jinal", 2);
		
		System.out.println("Salary is: "+sal.calculate());
		System.out.println("Salary is: "+hour.calculate());
	}
}
