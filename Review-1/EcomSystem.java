
// Question
// Design an E-commerce Shopping Cart system where:
// A Product class contains product details (ID, name, price).
// A Cart class allows adding/removing products.
// A Customer class contains customer details and a method to place an order.
// Apply polymorphism by defining different payment methods (CreditCard, PayPal, UPI) that override a ProcessPayment() method.


import java.util.ArrayList;

class Product {
    private int id;
    private String name;
    protected double price;

    public Product(int id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getname() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}


interface Payment {

    // ERROR:
    // public void ProcessPayment(String method);

    // Problem:
    // Passing method name is unnecessary because
    // polymorphism already tells which payment type is used.

    // CORRECT:
    public void ProcessPayment();
}


// ERROR:
// class Cart extends Product implements Payment

// Problems:
// 1. Cart is NOT a Product
// 2. Cart should NOT implement Payment

// CORRECT:
class Cart {

    // Cart should contain products
    private ArrayList<Product> products = new ArrayList<>();

    public void addProd(Product p) {

        // ERROR:
        // System.out.println("Product with price: " + p.price + " is added to your cart.");

        // Problem:
        // Direct access to protected variable is poor encapsulation.

        // CORRECT:
        products.add(p);
        System.out.println("Product with price: " + p.getPrice() + " is added to your cart.");
    }

    public void removeProd(Product p) {

        // ERROR:
        // System.out.println("Product with price: " + p.price +" is removed from your cart.");

        // CORRECT:
        products.remove(p);
        System.out.println("Product with price: " + p.getPrice() +" is removed from your cart.");
    }
}


class CreditCard implements Payment {

    @Override

    // ERROR:
    // public void ProcessPayment(String method)

    // CORRECT:
    public void ProcessPayment() {

        System.out.println("Payment Processed using CreditCard");
    }
}


class Paypal implements Payment {

    @Override

    // ERROR:
    // public void ProcessPayment(String method)

    // CORRECT:
    public void ProcessPayment() {

        System.out.println("Payment Processed using Paypal");
    }
}


class UPI implements Payment {

    @Override

    // ERROR:
    // public void ProcessPayment(String method)

    // CORRECT:
    public void ProcessPayment() {

        System.out.println("Payment Processed using UPI");
    }
}


class Customer {

    private String Cust_name;
    private String phone;

    public Customer(String Cust_name, String phone){
        this.Cust_name = Cust_name;
        this.phone = phone;
    }

    public void placeOrder() {
        System.out.println("Order placed...");
    }
}



public class EcomSystem {

    public static void main(String[] args) {

        Product p1 = new Product(1, "milk", 50);
        Product p2 = new Product(2, "tea", 150);

        Customer c1 = new Customer("Riya", "7856941236");

        // ERROR:
        // Cart cart1 = new Cart(10, "cart1", 50);

        // CORRECT:
        Cart cart1 = new Cart();

        cart1.addProd(p1);
        cart1.addProd(p2);

        c1.placeOrder();

        Payment card1 = new CreditCard();

        // ERROR:
        // card1.ProcessPayment("CreditCard");

        // CORRECT:
        card1.ProcessPayment();
    }
}