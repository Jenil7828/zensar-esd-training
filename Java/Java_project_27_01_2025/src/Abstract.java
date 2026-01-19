
public class Abstract {
	public static void main(String[] args) {
		Vehicle Car = new Car();
		Vehicle EV = new ElectriCar();
		
		Car.startEngine();
		Car.fuelType();
		System.out.println();
		EV.startEngine();
		EV.fuelType();
		
	}
}
