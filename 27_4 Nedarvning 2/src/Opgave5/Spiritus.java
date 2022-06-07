package Opgave5;

public class Spiritus extends Vare{
    //Fields
    private int alkoholProcent;

    //Constructor
    public Spiritus (int pris, String navn, String beskrivelse, int alkoholProcent) {
        super(pris, navn, beskrivelse);
        this.alkoholProcent = alkoholProcent;
        setMoms(80);
    }

    //Methods
    @Override
    public double beregnSalgspris() {
        double normalPris = super.beregnSalgspris();
        if (normalPris > 90) {
            return getPris()*1.2;
        } else {
            return normalPris;
        }
    }

}
