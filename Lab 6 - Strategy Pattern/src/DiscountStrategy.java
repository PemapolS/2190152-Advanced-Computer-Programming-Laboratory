public interface DiscountStrategy {
    public double applyDiscount(double amount);
}

class PercentageDiscountStrategy implements DiscountStrategy {
    private double variable;
    public PercentageDiscountStrategy(double percent) {
        double variable = ((100.00-percent)/100);
        this.variable = variable;
    }

    public double applyDiscount(double amount){
        return amount*variable;
    }
}

class FixedDiscountStrategy implements DiscountStrategy {
    private double discountAmount;
    public FixedDiscountStrategy(double discountAmount) {
        this.discountAmount = discountAmount;
    }
    public double applyDiscount(double amount){
        return amount-discountAmount;
    }
}

class SampleDiscountStrategy implements DiscountStrategy {
    public double applyDiscount(double amount){
        return amount;
    }
}
