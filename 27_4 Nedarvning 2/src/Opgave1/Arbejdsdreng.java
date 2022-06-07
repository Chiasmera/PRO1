package Opgave1;

public class Arbejdsdreng extends Ansat{

    //Fields

    //Constructor
    public Arbejdsdreng (String navn, String adresse, double timeLoen) {
        super(navn, adresse,timeLoen);
    }

    //Methods
    @Override
    public double ugeLoen () {
        return getTimeLoen() * 25;
    }
}
