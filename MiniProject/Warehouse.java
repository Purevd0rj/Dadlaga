import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Warehouse {
    private int id;
    private String name;
    private List<Location> locations = new ArrayList<>();

    public Warehouse(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Add location to warehouse
    public void addLocation(Location location) {
        locations.add(location);
        System.out.println("Added location: " + location.getName() + " to " + this.name);
    }

    // Add product to specific location
    public void addProduct(Product product, Location location) {
        validateLocation(location);
        location.addProduct(product, 0);  // Default quantity = 0
        System.out.println("Added " + product.getName() + " to " + location.getName());
    }

    // Remove product from location by SKU
    public void removeProduct(String sku, Location location) {
        validateLocation(location);
        
        Optional<Product> product = location.getProductBySku(sku);
        
        if (product.isPresent()) {
            location.removeProductFromInventory(product.get());
            System.out.println("Removed " + product.get().getName() + 
                              " from " + location.getName());
        } else {
            throw new IllegalArgumentException(
                "Product with SKU " + sku + " not found in " + location.getName()
            );
        }
    }

    // Validate location belongs to warehouse
    private void validateLocation(Location location) {
        if (!locations.contains(location)) {
            throw new IllegalArgumentException(
                location.getName() + " doesn't belong to " + this.name
            );
        }
    }

    // Helper to add product with quantity
    public void addProductWithQuantity(Product product, Location location, int quantity) {
        addProduct(product, location);
        location.addProduct(product, quantity);
    }

    // Getters
         public int getId() { return id; }
        public void setID(int id){this.id=id;}

        public String getName() { return name; }
        public void setName(String name){this.name=name;}

        public List<Location> getLocations() { return locations; }
        public void setList(List<Location> locations){this.locations=locations;}
}