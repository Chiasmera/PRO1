package Opgave1;

public class Synsmand extends Mekaniker{
    //Fields
    private int synPerUge;
    private int synstillæg = 29;


    //Constructor
    public Synsmand(String navn, String adresse, double timeLoen, int svendeproeveAar) {
        super(navn, adresse, timeLoen, svendeproeveAar);
    }

    //Methods
    public int getSynPerUge() {
        return synPerUge;
    }

    public void setSynPerUge(int synPerUge) {
        this.synPerUge = synPerUge;
    }

    public int getSynstillæg() {
        return synstillæg;
    }

    public void setSynstillæg(int synstillæg) {
        this.synstillæg = synstillæg;
    }

    @Override
    public double ugeLoen () {
        return super.ugeLoen() + synPerUge*synstillæg;
    }
}
