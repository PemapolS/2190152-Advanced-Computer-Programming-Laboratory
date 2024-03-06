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

class PaymentMethodFactory{
    public PaymentMethod createPaymentMethod(String method){
        if (method.equalsIgnoreCase("credit card")){
            return new CreditCardPayment();
        }
        else if (method.equalsIgnoreCase("paypal")){
            return new PayPalPayment();
        }
        else if (method.equalsIgnoreCase("crypto")){
            return new CryptoPayment();
        }
        return null;
    }
}


public class PaymentApp {
    public static void main(String[] args) {
        // Implement the Client Code
        PaymentMethodFactory paymentFactory = new PaymentMethodFactory();

        // Create payment objects without knowing the exact class
        PaymentMethod creditCardPayment = paymentFactory.createPaymentMethod("credit card");
        PaymentMethod payPalPayment = paymentFactory.createPaymentMethod("paypal");
        PaymentMethod cryptoPayment = paymentFactory.createPaymentMethod("crypto");

        // Test Your Implementation
        double paymentAmount = 100.0;
        creditCardPayment.processPayment(paymentAmount);
        payPalPayment.processPayment(paymentAmount);
        cryptoPayment.processPayment(paymentAmount);
    }
}