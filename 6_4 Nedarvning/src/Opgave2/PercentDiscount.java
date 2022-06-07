package Opgave2;

public class PercentDiscount extends Discount {
    //Fields
    private int discountPercentage;

    //Constructor
    public PercentDiscount (int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    //Methods

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    @Override
    public double getDiscount (double price) {
        return price / 100 * discountPercentage;
    }
}
