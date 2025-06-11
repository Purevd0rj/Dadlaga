public class LocationTest {
    public static void main(String[] args) {
        Location warehouse = new Location("Main Warehouse",1,"Storage");
        Product laptop = new Product("Laptop", "LP-100", 999.99, 20, "123456");
        
        // Add products
        warehouse.addProduct(laptop, 50);
        
        // Test quantity methods
        System.out.println("Quantity by product: " + warehouse.getProductQuantity(laptop));  // 50
        System.out.println("Quantity by SKU: " + warehouse.getProductBySku("LP-100"));  // 50
        
        // Test with non-existent product
        Product unknown = new Product("Unknown", "UN-001", 0, 20, "000000");
        System.out.println("Unknown product quantity: " + warehouse.getProductQuantity(unknown));  // 0
        System.out.println("Unknown SKU quantity: " + warehouse.getProductBySku("UN-001"));  // 0
    }
}