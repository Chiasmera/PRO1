package Opgave1;

public class Værkfører extends Ansat{

    //Fields
    private int udnævnelsesÅr;
    private double ugetillæg;
    private int svendeproeveAar;

    //Constructor
    public Værkfører (String navn, String adresse, int svendeproeveAar, double timeLoen, int udnævnelsesÅr, double ugetillæg) {
        super(navn, adresse, timeLoen);
        this.udnævnelsesÅr = udnævnelsesÅr;
        this.ugetillæg = ugetillæg;
        this.svendeproeveAar = svendeproeveAar;
    }

    //Methods

    public int getUdnævnelsesÅr() {
        return udnævnelsesÅr;
    }

    public double getUgetillæg() {
        return ugetillæg;
    }

    @Override
    public double ugeLoen () {
        return super.ugeLoen() +ugetillæg;
    }

    public int getSvendeproeveAar() {
        return svendeproeveAar;
    }
}
