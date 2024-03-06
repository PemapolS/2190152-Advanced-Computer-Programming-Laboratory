interface PaymentMethod{
    public void processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod{
    public void processPayment(double amount){
        System.out.println("Processing credit card payment of $" + amount);
    }
}

class PayPalPayment implements PaymentMethod{
    public void processPayment(double amount){
        System.out.println("Processing PayPal payment of $" + amount);
    }
}

class CryptoPayment implements PaymentMethod{
    public void processPayment(double amount){
        System.out.println("Processing cryptocurrency payment of $" + amount);
    }
}