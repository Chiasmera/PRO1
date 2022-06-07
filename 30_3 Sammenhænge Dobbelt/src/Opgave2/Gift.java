package Opgave2;

public class Gift {
    //fields
    private String description;
    private double price;
    private Person giver;

    //Constructor
    public Gift (String description, Person giver) {
        this.description = description;
        this.price = 0;
        this.giver = giver;
    }

    //Methods
    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Person getGiver() {
        return giver;
    }

    public void setGiver(Person giver) {
        this.giver = giver;
    }
}
