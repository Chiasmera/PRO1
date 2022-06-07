package Opgave2;

public class FixedDiscount extends Discount {
    //Fields
    private int fixedDiscount;
    private int discountLimit;

    //Constructor
    public FixedDiscount (int fixedDiscount, int discountLimit) {
        this.fixedDiscount = fixedDiscount;
        this.discountLimit = discountLimit;
    }

    //Methods

    public int getFixedDiscount() {
        return fixedDiscount;
    }

    public int getDiscountLimit() {
        return discountLimit;
    }

    @Override
    public double getDiscount (double price) {
        if (price >= discountLimit) {
            return fixedDiscount;
        } else {
            return 0.0;
        }
    }
}
