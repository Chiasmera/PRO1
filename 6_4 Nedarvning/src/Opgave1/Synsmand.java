package Opgave1;

public class Synsmand extends Mekaniker{
    //Fields
    private int synPerUge;
    private static int synstillæg = 29;


    //Constructor
    public Synsmand(String navn, String adresse, int svendeprøveÅr, double timeløn) {
        super(navn, adresse, svendeprøveÅr, timeløn);
    }

    //Methods
    public int getSynPerUge() {
        return synPerUge;
    }

    public void setSynPerUge(int synPerUge) {
        this.synPerUge = synPerUge;
    }

    @Override
    public double beregnLoen () {
        return super.beregnLoen() + synPerUge*synstillæg;
    }
}
