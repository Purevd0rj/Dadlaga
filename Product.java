public class Product {
    private String name;
    private String sku;
    private double price;
    private int quantity;
    private String category;

    // Constructor
    public Product(String name, String sku, double price, int quantity,String category) {
        this.name = name;
        this.sku = sku;
        this.price = price;
        this.quantity = quantity;
        this.category=category;
    }

    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

      public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

      public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

      public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    
      public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    // Other getters/setters for sku/price/quantity

    @Override
    public String toString() {
        return "Product: " + name + " | SKU: " + sku + 
               " | Price: $" + price + " | Qty: " + quantity;
    }
}