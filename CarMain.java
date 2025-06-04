class Vehicle {
    protected int fuel;

    public Vehicle() {
        this.fuel = 0;
    }

    public void drive() {
        if (fuel > 0) {
            System.out.println("Driving a vehicle");
            fuel--;
        } else {
            System.out.println("Out of fuel!");
        }
    }

    public void refuel(int liters) {
        fuel += liters;
        System.out.println("Refueled " + getClass().getSimpleName() + " with " + liters + " liters. Total fuel: " + fuel + " liters.");
    }
}

class Car extends Vehicle {
    @Override
    public void drive() {
        if (fuel > 0) {
            System.out.println("Driving a car");
            fuel--;
        } else {
            System.out.println("Car out of fuel!");
        }
    }
}

class Truck extends Vehicle {
    @Override
    public void drive() {
        if (fuel > 0) {
            System.out.println("Driving a truck");
            fuel -= 2; // Trucks consume more fuel
        } else {
            System.out.println("Truck out of fuel!");
        }
    }
}

public class CarMain {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        Car car = new Car();
        Truck truck = new Truck();

        vehicle.refuel(10);
        car.refuel(20);
        truck.refuel(50);

        vehicle.drive();
        car.drive();
        truck.drive();
    }
}
