package Opgave1;

public class Mekaniker extends Ansat {

    //Fields
    private int svendeproeveAar;

    //Constructor
    public Mekaniker(String navn, String adresse, double timeLoen, int svendeproeveAar) {
        super(navn, adresse, timeLoen);
        this.svendeproeveAar = svendeproeveAar;
    }

    //Methods
    public int getSvendeproeveAar() {
        return svendeproeveAar;
    }
}
