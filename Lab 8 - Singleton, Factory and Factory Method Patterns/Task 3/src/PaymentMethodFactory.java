interface PaymentMethodFactory {
    public PaymentMethod createPaymentMethod();
}

class CreditCardPaymentFactory implements PaymentMethodFactory{
    public PaymentMethod createPaymentMethod() {
        return new CreditCardPayment();
    }
}

class PayPalPaymentFactory implements PaymentMethodFactory{
    public PaymentMethod createPaymentMethod() {
        return new PayPalPayment();
    }
}

class CryptoPaymentFactory implements PaymentMethodFactory{
    public PaymentMethod createPaymentMethod() {
        return new CryptoPayment();
    }
}