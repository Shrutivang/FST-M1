package Activities;

public class Activity3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double Seconds = 1000000000;
		double EarthSeconds = 31557600;
		double MercurySeconds = 0.2408467;
		double VenusSeconds = 0.61519726;
		double MarsSeconds = 1.8808158;
		double JupiterSeconds = 11.862615;
		double SaturnSeconds = 29.447498;
		double UranusSeconds = 84.016846;
		double NeptuneSeconds = 164.79132;
		System.out.println("Age on Mercury: " + Seconds / EarthSeconds / MercurySeconds);
        System.out.println("Age on Venus: " + Seconds / EarthSeconds / VenusSeconds);
        System.out.println("Age on Earth: " + Seconds / EarthSeconds);
        System.out.println("Age on Mars: " + Seconds / EarthSeconds / MarsSeconds);
        System.out.println("Age on Jupiter: " + Seconds / EarthSeconds / JupiterSeconds);
        System.out.println("Age on Saturn: " + Seconds / EarthSeconds / SaturnSeconds);
        System.out.println("Age on Uranus: " + Seconds / EarthSeconds / UranusSeconds);
        System.out.println("Age on Neptune: " + Seconds / EarthSeconds / NeptuneSeconds);

	}

}
