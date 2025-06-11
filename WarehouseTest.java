
public class WarehouseTest {
    public static void main(String[] args) {
        System.out.println("=== Warehouse System Test ===");
        
        // 1. Create warehouse
        Warehouse mainWarehouse = new Warehouse(1, "Central Distribution Center");
        System.out.println("Created warehouse: " + mainWarehouse.getName());
        
        // 2. Create locations
        Location receiving = new Location("Receiving Dock", 101, "Inbound");
        Location storage = new Location("Storage Area", 102, "Storage");
        System.out.println("Created locations");
        
        // 3. Test addLocation method
        System.out.println("\n--- Testing addLocation ---");
        mainWarehouse.addLocation(receiving);
        mainWarehouse.addLocation(storage);
        
        // Verify locations were added
        System.out.println("Warehouse locations: " + mainWarehouse.getLocations().size());
        
        // 4. Test adding products
        System.out.println("\n--- Testing addProduct ---");
        Product laptop = new Product("Laptop", "LP-1001", 1200.00, 1, "123456789");
        Product monitor = new Product("Monitor", "MN-2001", 300.00, 2, "987654321");
        
        mainWarehouse.addProduct(laptop, receiving);
        mainWarehouse.addProduct(monitor, storage);
        
        // 5. Test adding with quantity
        System.out.println("\n--- Testing addProductWithQuantity ---");
        mainWarehouse.addProductWithQuantity(laptop, receiving, 100);
        mainWarehouse.addProductWithQuantity(monitor, storage, 50);
        
        // 6. Test location validation
        System.out.println("\n--- Testing Location Validation ---");
        Location external = new Location("External Location", 999, "Third Party");
        try {
            mainWarehouse.addProduct(laptop, external);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation success: " + e.getMessage());
        }
        
        // 7. Test product removal
        System.out.println("\n--- Testing removeProduct ---");
        mainWarehouse.removeProduct("LP-1001", receiving);
        
        /*  8. Final report
        System.out.println("\n=== Final Status ===");
        System.out.println("Receiving Dock products: " + receiving.getInventory().size());
        System.out.println("Storage Area products: " + storage.getInventory().size());*/
    }
}