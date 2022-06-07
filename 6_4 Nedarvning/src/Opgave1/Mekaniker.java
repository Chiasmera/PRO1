package Opgave1;

public class Mekaniker extends Person {

    //Fields
    private int svendeprøveÅr;
    private double timeløn;

    //Constructor
    public Mekaniker(String navn, String adresse, int svendeprøveÅr, double timeløn) {
        super(navn, adresse);
        this.svendeprøveÅr = svendeprøveÅr;
        this.timeløn = timeløn;
    }

    //Methods
    public int getSvendeprøveÅr() {
        return svendeprøveÅr;
    }

    public double getTimeløn() {
        return timeløn;
    }

    public double beregnLoen () {
        return 37 * timeløn;
    }
}
