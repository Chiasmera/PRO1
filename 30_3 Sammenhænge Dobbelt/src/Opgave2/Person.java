package Opgave2;

import java.util.ArrayList;

public class Person {
    //Fields
    private String name;
    private int age;
    private ArrayList<Gift> giftsRecieved = new ArrayList<>();

    //Constructor
    public Person (String name, int age) {
        this.name = name;
        this.age = age;
    }

    //Methods

    public void setAge(int age) {
        this.age = age;
    }

    public String toString () {
        return "Name: "+name +" / "+"Age: "+age;
    }

    public ArrayList<Gift> getGiftsRecieved() {
        return giftsRecieved;
    }

    public void recieveGift (Gift gift) {
        if (!giftsRecieved.contains(gift)) {
            giftsRecieved.add(gift);
        }
    }

    public void removeGift (Gift gift) {
        if (giftsRecieved.contains(gift)) {
            giftsRecieved.remove(gift);
        }
    }


    public double totalGiftWorth () {
        double sum = 0.0;
        for (Gift g : giftsRecieved) {
            sum += g.getPrice();
        }
        return sum;
    }

    public ArrayList<Person> getGivers () {
        ArrayList<Person> givers = new ArrayList<>();
        for (Gift g : giftsRecieved) {
            if (!givers.contains(g.getGiver())) {
                givers.add(g.getGiver());
            }
        }
        return givers;
    }
}
