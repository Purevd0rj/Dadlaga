class ParkingSystem {
    private:
        int bigSlots;
        int mediumSlots;
        int smallSlots;
    
    public:
        // Constructor
        ParkingSystem(int big, int medium, int small) {
            bigSlots = big;
            mediumSlots = medium;
            smallSlots = small;
        }
    
        // Add car to parking
        bool addCar(int carType) {
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
    };