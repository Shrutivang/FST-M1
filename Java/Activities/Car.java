package Activities;

public class Car {
	//car variables
	String color;
	String transmission;
	int make;
	int tyres;
	int doors;
	
	//constructor	
	Car() {
		tyres = 4;
		doors = 4;
		
	}
	//class methods
	public void displaycharacteristics()
	{
		System.out.println("colour of the car: " + color);
		System.out.println("Transmission of the car: " + transmission);
		System.out.println("Make of the car:" + make);
		System.out.println("No of tyres: " + tyres);
		System.out.println("No of doors:" + doors);
		
	}
	
	public void accelarate()
	{
		System.out.println(" Car is moving forward.");
	}
	
	public void brake()
	{
		System.out.println(" Car has stopped.");
	}
	

}
