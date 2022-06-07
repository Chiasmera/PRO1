package Opgave3;

import java.util.ArrayList;

public class Rental {
    //fields
    private int number;
    private int days;
    private String date;
    private ArrayList<Car> cars = new ArrayList<>();

    //constructor
    public Rental (int number, int days, String date) {
        this.number = number;
        this.date = date;
        this.days = days;
    }

    //Methods
    public void setDays(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    /**
     * Returns a copy of the list of cars
     * @return list of cars
     */
    public ArrayList<Car> getCars () {
        return new ArrayList<>(cars);
    }

    /**
     * Adds a car to the list, if it does not already exist in the list
     * @param car the car to add
     */
    public void addCar (Car car) {
        if (!cars.contains(car)) {
            cars.add(car);
        }
    }

    /**
     * Removes the car from the list of cars, if it exists in the list
     * @param car the car to remove
     */
    public void removeCar (Car car) {
        if (!cars.contains(car)) {
            cars.remove(car);
        }
    }

    /**
     * Returns the product of the sum of all the daily price of associated cars and the duration of the rental
     * @return the total price of the rental
     */
    public double getPrice () {
        double sum = 0;
        for (Car c : cars) {
            sum += c.getDayPrice();
        }
        return sum * days;
    }

}
