package application.model;

public class Customer {
    //Fields
    private String name;

    //Constructor
    public Customer (String name) {
        this.name = name;
    }

    //Methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
