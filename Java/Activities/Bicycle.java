package Activities;

interface BicycleParts {
    public int tyres = 2;
    public int maxSpeed = 25;
}

interface BicycleOperations {
    public void applyBrake(int decrement);
    public void speedUp(int increment);
}

//Base class 
class Bicycle implements BicycleParts, BicycleOperations {

    public int gears;
    public int currentSpeed;

    //the Bicycle class has one constructor
    public Bicycle(int gears, int currentSpeed) {
        this.gears = gears;
        this.currentSpeed = currentSpeed;
    }

    //Bicycle class has three methods
    public void applyBrake(int decrement) {
        currentSpeed -= decrement;
        System.out.println("Current speed: " + currentSpeed);
    }

    public void speedUp(int increment) {
        currentSpeed += increment;
        System.out.println("Current speed: " + currentSpeed);
    }

    //Method to print info of Bicycle
    public String bicycleDesc() {
        return("No of gears are "+ gears + "\nSpeed of bicycle is " + maxSpeed);
    }
}

