import java.util.ArrayList;

class ShoppingCart {
    protected ArrayList<String> cart = new ArrayList<>();
    protected double shippingCost;
    public void addItem(String item){
        cart.add(item);
    }
    public double calculateTotal(){
        double total = 0;
        for (String item : cart){
            String[] parts = item.split(":");
            total += Double.parseDouble(parts[1])*Double.parseDouble(parts[2]);
        }
        return total;
    }
    public void addDeliveryFee(int fee){
        shippingCost = fee;
    }

    public double getDeliveryFee(){
        return this.shippingCost;
    }

    public double getDiscountTotal(){
        return this.calculateTotal();
    }

    public double getNetPrice(){
        return this.getDiscountTotal() + shippingCost;
    }
}

class ShoppingCartDecorator extends ShoppingCart{
    public ShoppingCart decoratedCart;
    public ShoppingCartDecorator(ShoppingCart decoratedCart){
        this.decoratedCart = decoratedCart;
    }

    public double calculateTotal(){
        return decoratedCart.calculateTotal();
    }
    
    public double getDeliveryFee(){
        return decoratedCart.getDeliveryFee();
    }

    public double getDiscountTotal(){
        return decoratedCart.calculateTotal();
    }
    public double getNetPrice(){
        return this.getDiscountTotal() + decoratedCart.getDeliveryFee();
    }
}

class DiscountByPercentDecorator extends ShoppingCartDecorator{
    private int percentTimesApplied = 0;
    private double discountPercent;
    public DiscountByPercentDecorator(ShoppingCart decoratedCart, double discountPercent){
        super(decoratedCart);
        this.discountPercent = discountPercent;
        this.percentTimesApplied += 1;
    }

    public double getDiscountTotal() {
        if (percentTimesApplied <= 1) {
            return this.decoratedCart.getDiscountTotal()*(1-(discountPercent/100));
        }
        else{
            return this.decoratedCart.getDiscountTotal();
        }
    }
}

class DiscountByAmountDecorator extends ShoppingCartDecorator{
    private double amountTimesApplied = 0;
    private double discountAmount;
    public DiscountByAmountDecorator(ShoppingCart decoratedCart, double discountAmount){
        super(decoratedCart);
        this.discountAmount = discountAmount;
        this.amountTimesApplied += 1;
    }
    public double getDiscountTotal() {
        if (amountTimesApplied <= 1) {
            return this.decoratedCart.getDiscountTotal()-discountAmount;
        }
        else{
            return this.decoratedCart.getDiscountTotal();
        }
    }
}

class FreeDeliveryDecorator extends ShoppingCartDecorator{
    public FreeDeliveryDecorator(ShoppingCart decoratedCart){
        super(decoratedCart);
        shippingCost = 0.0;
    }
    public double getDiscountTotal(){
        return this.decoratedCart.getDiscountTotal();
    }
    public double getNetPrice(){
        return this.decoratedCart.getDiscountTotal();
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        // Create a shopping cart
        ShoppingCart cart = new ShoppingCart();

        // Add items to the cart
        cart.addItem("Item1:2:50.0"); // net price is 100.0
        cart.addItem("Item2:1:30.0"); // net price is 130.0

        // Add delivery fee
        cart.addDeliveryFee(10); // Add a $10 delivery fee

        // Apply coupons using decorators
        cart = new DiscountByPercentDecorator(cart, 10.0); // Apply a 10% discount, net price should be 127.0 (130*0.9+10)
        cart = new FreeDeliveryDecorator(cart); // Apply free delivery, net price now is 117.0

        // Calculate and display the total price and net price
        double total = cart.calculateTotal();
        double netPrice = cart.getNetPrice();
        System.out.println("Total Price: $" + total);
        System.out.println("Net Price: $" + netPrice);

        ShoppingCart cart2 = new ShoppingCart();

        cart2.addItem("Item3:1:40.0"); // net price is 40.0
        cart2.addItem("Item4:3:10.0"); // net price is 70.0
        cart2.addItem("Item5:2:30.0"); // net price is 130.0
        
        cart2.addDeliveryFee(20);

        cart2 = new DiscountByAmountDecorator(cart2, 30); // Apply $30 discount, net price should be 100 + 20
        cart2 = new DiscountByPercentDecorator(cart2, 10); // Apply 10% discount, net price should be 90 + 20
        
        double total2 = cart2.calculateTotal();
        double netPrice2 = cart2.getNetPrice();
        System.out.println("Total Price: $" + total2);
        System.out.println("Net Price: $" + netPrice2); //net price is 110
    }
}