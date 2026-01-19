package Abstract;

class Rectangle extends Shape{
	double length;
	double breadth;
	public Rectangle(String name, double length, double breadth) {
		super(name);
		this.length = length;
		this.breadth = breadth;
	}
	
	public double cal_area() {
		return length*breadth;
	}
}
