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
        switch (carType) {
            case 1 -> {
                if (bigSlots > 0) {
                    bigSlots--;
                    return true;
                }
            }
            case 2 -> {
                if (mediumSlots > 0) {
                    mediumSlots--;
                    return true;
                }
            }
            case 3 -> {
                if (smallSlots > 0) {
                    smallSlots--;
                    return true;
                }
            }
            default -> {
            }
        }
        return false;
    }
}
