package Opgave3;

public class Car {
    //Fields
    private String license;
    private double pricePerDay;
    private int purchaseYear;

    //constructor
    public Car (String license, int purchaseYear) {
        this.license = license;
        this.purchaseYear = purchaseYear;
        this.pricePerDay = 0;
    }

    //Methods
    public void setDayPrice (double price) {
        this.pricePerDay = price;
    }

    public double getDayPrice () {
        return pricePerDay;
    }

    public String getLicense() {
        return license;
    }

    public int getPurchaseYear() {
        return purchaseYear;
    }


}
