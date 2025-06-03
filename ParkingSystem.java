class ParkingSystem {
    private int bigSlots;
    private int mediumSlots;
    private int smallSlots;

    // Constructor
    public ParkingSystem(int big, int medium, int small) {
        this.bigSlots = big;
        this.mediumSlots = medium;
        this.smallSlots = small;
    }

    // Add car to parking
    public boolean addCar(int carType) {
        if (carType == 1) {
            if (bigSlots > 0) {
                bigSlots--;
                return true;
            }
        } else if (carType == 2) {
            if (mediumSlots > 0) {
                mediumSlots--;
                return true;
            }
        } else if (carType == 3) {
            if (smallSlots > 0) {
                smallSlots--;
                return true;
            }
        }
        return false;
    }
}



public class ParkingMain {
    public static void main(String[] args) {
        ParkingSystem parking = new ParkingSystem(1, 1, 0);

        System.out.println(parking.addCar(1)); // true
        System.out.println(parking.addCar(2)); // true
        System.out.println(parking.addCar(3)); // false
        System.out.println(parking.addCar(1)); // false
    }
}
