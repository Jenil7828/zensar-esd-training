package Abstract;

class Square extends Shape{
	double side;
	public Square(String name, double side) {
		super(name);
		this.side = side;
	}
	
	public double cal_area() {
		return side*side;
	}
}
