import java.time.LocalDate;
public class StockMove {
    private int id;
    private LocalDate date;
    private Location fromLocation;
    private Location toLocation;
    private Product product;
    private int quantity;

    // Constructor
    public StockMove(int id, LocalDate date, Location fromLocation, 
                    Location toLocation, Product product, int quantity) {
        this.id = id;
        this.date = date;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.product = product;
        this.quantity = quantity;
    }
       
    public void executeTransfer() throws InsufficientStockException {
        // Get current quantity in fromLocation
        int availableQuantity = fromLocation.getProductQuantity(product);
        
        // Validate stock availability
        if (availableQuantity < quantity) {
            throw new InsufficientStockException(
                "Insufficient stock for " + product.getName() + 
                " in " + fromLocation.getName() + 
                " (Available: " + availableQuantity + 
                ", Requested: " + quantity + ")"
            );
        }
        
        // Perform transfer
        fromLocation.removeProduct(product, quantity);
        toLocation.addProduct(product, quantity);
        
        System.out.println("Successfully transferred " + quantity + " units of " + 
                          product.getName() + " from " + fromLocation.getName() + 
                          " to " + toLocation.getName());
    }
    // Getters
    public int getId() { return id; }
    public void setID(int id){this.id=id;}

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date){this.date=date;}

    public Location getFromLocation() { return fromLocation; }
    public void setFromLocation(Location fromLocation){this.fromLocation=fromLocation;}

   
    public Location getToLocation() { return toLocation; } 
    public void setToLocation(Location toLocation){this.toLocation=toLocation;}

    public Product getProduct() { return product; }
    public void setProduct(Product product){this.product=product;}

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity){this.quantity=quantity;}
}