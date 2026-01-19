
abstract class Vehicle {
	public void startEngine() {
		System.out.println("Engine Started");
	}
	public abstract void fuelType();
}

class Car extends Vehicle{
	public void fuelType() {
		System.out.println("Car runs on petrol");
	}
}

class ElectriCar extends Vehicle{
	public void fuelType() {
		System.out.println("Car runs on electricity");
	}
}