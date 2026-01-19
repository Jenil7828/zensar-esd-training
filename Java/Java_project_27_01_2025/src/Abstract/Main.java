package Abstract;

public class Main {
	public static void main(String[] args) {
		Shape circle = new Circle("Circle", 10);
		Shape square = new Square("Square", 12);
		Shape rectangle = new Rectangle("Rectangle", 10, 4.5);
		
		System.out.println("The area of: "+circle.name+" is: "+ circle.cal_area());
		System.out.println("The area of: "+square.name+" is: "+ square.cal_area());
		System.out.println("The area of: "+rectangle.name+" is: "+ rectangle.cal_area());
		
	}
}
