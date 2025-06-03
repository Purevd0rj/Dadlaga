
class Vehicle {
    public void drive() {
        System.out.println("Repairing a vehicle");
    }
} 

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        Car car = new Car();
        Truck truck=new Truck();
        vehicle.drive(); 
        car.drive(); 
        truck.drive();
    }
} 


class Car extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Repairing a car");
    }
} 

class Truck extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Repairing a truck");
    }
}
