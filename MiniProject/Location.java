import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
public class Location {
    private int id;
    private String name;
    private String type; // e.g., "Shelf", "Bin", "Receiving"
    private Map<Product, Integer> inventory = new HashMap<>();
    

    public Location(String name, int id ,String type) {
        this.name = name;
        this.id=id;
        this.type=type;
    }

    // Add product with quantity
    public void addProduct(Product product, int quantity) {
        inventory.put(product, inventory.getOrDefault(product, 0) + quantity);
    }

    // Remove product completely from location
    public void removeProduct(Product product, int quantity) {
        if (!inventory.containsKey(product)) {
            throw new IllegalArgumentException("Product not found: " + product.getName());
        }
        
        int currentQty = inventory.get(product);
        if (currentQty < quantity) {
            throw new IllegalArgumentException(
                "Cannot remove " + quantity + " of " + product.getName() + 
                ". Only " + currentQty + " available."
            );
        }
        
        inventory.put(product, currentQty - quantity);
    }

    public void reduceProductQuantity(Product product, int quantity) {
        if (!inventory.containsKey(product)) {
            throw new IllegalArgumentException("Product not found: " + product.getName());
        }
        
        int currentQty = inventory.get(product);
        if (currentQty < quantity) {
            throw new IllegalArgumentException(
                "Cannot remove " + quantity + " of " + product.getName() + 
                ". Only " + currentQty + " available."
            );
        }
        
        inventory.put(product, currentQty - quantity);
    }

    // Remove entire product (for deletion)
    public void removeProductFromInventory(Product product) {
        if (!inventory.containsKey(product)) {
            throw new IllegalArgumentException("Product not found: " + product.getName());
        }
        inventory.remove(product);
    }

    // Get product by SKU
    public Optional<Product> getProductBySku(String sku) {
        return inventory.keySet().stream()
            .filter(p -> p.getSku().equals(sku))
            .findFirst();
    }

    // Get product quantity
    public int getProductQuantity(Product product) {
        return inventory.getOrDefault(product, 0);
    }


    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

      public int getID() { return id; }
    public void setID(int id) { this.id = id; }

      public String getType() { return type; }
    public void setType(String type) { this.type = type; }


    public void setInventory(Map<Product, Integer> inventory) {
        this.inventory = inventory;
    }

    
}   

