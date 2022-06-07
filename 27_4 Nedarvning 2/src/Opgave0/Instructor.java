package Opgave0;

public class Instructor extends Person {
    //fields
    private double månedsløn;

    //constructor
    public Instructor (String navn, int fødselsår, double månedsløn) {
        super(navn, fødselsår);
        this.månedsløn = månedsløn;

    }

    //Methods - Trivielle

    //Methods
    public String toString() {
        return getNavn() +", Løn: "+månedsløn+" kr.";
    }
}
