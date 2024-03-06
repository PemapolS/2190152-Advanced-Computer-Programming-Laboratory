public class App {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("Widget", 3, 10.99);
        Item item2 = new Item("Gadget", 2, 19.99);
        Item item3 = new Item("Suki Sauce", 1, 9.99);
        Item item4 = new Item("Domain Name", 1, 39.99);

        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);
        cart.addItem(item4);

        // Your cart should set different discount strategies and display the total cost after discount.

        System.out.printf("Subtotal: $%.2f",cart.calculateTotal());
        cart.setDiscountStrategy(new PercentageDiscountStrategy(10.00));
        System.out.printf("\nTotal with 10%% off: $%.2f",cart.calculateTotal());
        cart.setDiscountStrategy(new FixedDiscountStrategy(20.00));
        System.out.printf("\nTotal with $20 off: $%.2f",cart.calculateTotal());
    }
}