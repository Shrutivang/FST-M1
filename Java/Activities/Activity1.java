package Activities;

public class Activity1 {
	public static void main(String[] args)
{
		Car Maruti = new Car();
		Maruti.make = 2014;
		Maruti.color = "Green";
		Maruti.transmission = "Manual";
		
		Maruti.displaycharacteristics();
		Maruti.accelarate();
		Maruti.brake();
		
}
}
