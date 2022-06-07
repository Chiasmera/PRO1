package Opgave1;

import java.util.ArrayList;

public class Car {
    //Fields
    private String license;
    private double pricePerDay;
    private int purchaseYear;
    private ArrayList<Rental> rentals = new ArrayList<>();

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

    public ArrayList<Rental> getRentals () {
        return new ArrayList<>(rentals);
    }

    public void addRental (Rental rental) {
        if (!rentals.contains(rental)) {
            rentals.add(rental);
            rental.addCar(this);
        }
    }

    public void removeRental (Rental rental) {
        if (rentals.contains(rental)) {
            rentals.remove(rental);
            rental.removeCar(this);
        }
    }

    /**
     * returns the highest number of days this car has been rented
     * @return the highest number of days in any of this cars rentals
     */
    public int getMostDays () {
        int mostDays = 0;
        for (Rental r : rentals) {
            if (r.getDays() > mostDays) {
                mostDays = r.getDays();
            }
        }
        return mostDays;
    }
}
