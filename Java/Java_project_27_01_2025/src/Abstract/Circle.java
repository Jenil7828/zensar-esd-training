package Abstract;

class Circle extends Shape{
	int radius;
	public Circle(String name, int radius) {
		super(name);
		this.radius =  radius;
	}
	
	public double cal_area() {
		return 3.14*radius*radius;
	}
}