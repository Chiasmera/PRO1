package Opgave1;

public abstract class Ansat extends Person{
    //Fields
    private double timeLoen;


    //Constructor
    public Ansat (String navn, String adresse, double timeLoen) {
        super(navn, adresse);
        this.timeLoen = timeLoen;

    }

    //Methods
    public double ugeLoen () {
        return timeLoen * 37;
    }

    public double getTimeLoen() {
        return timeLoen;
    }

}
