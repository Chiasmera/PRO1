package Opgave2;

import java.time.LocalDate;

/**
 * Modelerer en udlejning af en genstand.
 */
public class Rental {

    //Fields
    int number;
    int days;
    LocalDate startDate;
    double price;

    //-----------------------------------------------
    //Constructors

    /**
     * Instantierer en ny udlejning
     * @param number genstandens id-nummer
     * @param days antal dage for lejeperioden
     * @param price pris pr. dag for udlejningen
     * @param startDate startdatoen for udlejning
     */
    public Rental (int number, int days, double price, LocalDate startDate) {
        this.number = number;
        this.days = days;
        this.price = price;
        this.startDate = startDate;
    }

    //-----------------------------------------------
    //Methods

    /**
     * Returnerer prisen for en enkelt dags udlejning
     * @return pris pr. dag
     */
    public double getPricePerDay() {
        return price;
    }

    /**
     * Registrerer varigheden på lejeperioden i dage
     * Pre: days > 0
     * @param days antal dage lejeperioden varer
     */
    public void setDays(int days) {
        this.days = days;
    }

    /**
     * Returnerer varigheden af lejeperioden
     * @return Antal dage lejeperioden varer
     */
    public int getDays() {
        return days;
    }

    /**
     * Returnerer startdatoen for udlejningen
     * @return Dato for første dag i perioden
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Returnerer slutdatoen for udlejningen
     * @return Dato for sidste dag i perioden
     */
    public LocalDate getEndDate () {
        LocalDate endDate= startDate.plusDays(days);
        return endDate;
    }

    /**
     * Returnerer prisen for hele lejeperioden
     * @return Total pris for lejeperiode
     */
    public double getTotalPrice() {
        double totalPrice = days * price;
        return totalPrice;
    }
}
