package Application.Model;

public class Hund {

    //Fields
    private String name;
    private boolean stamtavle;
    private int price;
    private Race race;

    //Constructor
    public Hund (String name, boolean stamtavle, int price, Race race) {
        this.name = name;
        this.stamtavle = stamtavle;
        this.price = price;
        this.race = race;
    }

    //Enums
    public enum Race {PUDDEL,BOKSER,TERIER};

    //Methods

    public Race getRace() {
        return race;
    }

    public int getPrice() {
        return price;
    }
}
