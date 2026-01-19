package Abstract;

public abstract class Shape {
	String name;
	public Shape(String name) {
		this.name = name;
	}
	
	public abstract double cal_area();
}
