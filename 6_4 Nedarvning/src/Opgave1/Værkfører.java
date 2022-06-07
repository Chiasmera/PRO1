package Opgave1;

public class Værkfører extends Mekaniker{

    //Fields
    private int udnævnelsesÅr;
    private double ugetillæg;

    //Constructor
    public Værkfører (String navn, String adresse, int svendeprøveÅr, double timeløn, int udnævnelsesÅr, double ugetillæg) {
        super(navn, adresse, svendeprøveÅr, timeløn);
        this.udnævnelsesÅr = udnævnelsesÅr;
        this.ugetillæg = ugetillæg;
    }

    //Methods

    public int getUdnævnelsesÅr() {
        return udnævnelsesÅr;
    }

    public double getUgetillæg() {
        return ugetillæg;
    }

    @Override
    public double beregnLoen () {
        return super.beregnLoen() +ugetillæg;
    }
}
