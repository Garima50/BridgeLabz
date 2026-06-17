
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// class representing a product in the inventory
class Product {

    int productId;
    String productName;
    int stock;
    double price;
    boolean expired;

    Product(int productId, String productName, int stock, double price, boolean expired) {
        this.productId = productId;
        this.productName = productName;
        this.stock = stock;
        this.price = price;
        this.expired = expired;
    }

    // to display product info
    public void display(){
        System.out.println(productId + ", " + productName + ", Stock: " + stock + ", Price: " + price);
    }
}

// public management class
public class ProductInventoryManagement {
    public static void main(String[] args) {
        
        // arraylist to store products
        ArrayList<Product> products = new ArrayList<>();

        // add products to inventory
        products.add(new Product(001, "Laptop", 15, 85000, false));
        products.add(new Product(002, "Mouse", 5, 700, false));
        products.add(new Product(003, "Keyboard", 2, 1500, false));
        products.add(new Product(004, "Pc", 7, 15000, true));

        System.out.println("Initial Inventory: ");
        displayProducts(products);

        //updating stock qty
        updateStock(products, 002, 20);

        // remove expired products
        removeExpired(products);

        System.out.println("Updated Inventory: ");
        displayProducts(products);

        // find products whose stock is below 4
        findLowStock(products, 4);

        // sort products
        sortByPrice(products);

        System.out.println("Products after sorting: ");
        displayProducts(products);

    }

    // display all products
    public static void displayProducts(ArrayList<Product> products) {
            for(Product product: products){
                product.display();
            }
        }

    // update stock with id
    public static void updateStock(ArrayList<Product> products, int productId, int newStock) {
        // to search products with product id
        for(Product product: products) {

            if(product.productId == productId) {

                // update stock qty
                product.stock = newStock;

                System.out.println("Updated stock for Pid: " + productId);
            }
        }
    }
    
    // removing expired products
    public static void removeExpired(ArrayList<Product> products) {
        for(int i = 0; i < products.size(); i++){
            // checking current prod is expired
            if(products.get(i).expired) {
                
                // remove expired product
                products.remove(i);
                // move index back as one product is removed
                i--;
            }
        }
    }

    // find products with stock lesser than the min limit 
    public static void findLowStock(ArrayList<Product> products, int t) {

        for(Product product: products) {
            // checking stock with min limit
            if(product.stock < t) {
                product.display();
            }
        }
    }

    // sort products in order of price
    public static void sortByPrice(ArrayList<Product> products) {
        // compares products using their price 
        Collections.sort(products, Comparator.comparingDouble(product -> product.price));
    }


}