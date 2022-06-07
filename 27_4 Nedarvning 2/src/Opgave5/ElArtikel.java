package Opgave5;

public class ElArtikel extends Vare {
    //Fields
    private int energiPerTime;

    //Constructor
    public ElArtikel(int pris, String navn, String beskrivelse, int energiPerTime) {
        super(pris, navn, beskrivelse);
        this.energiPerTime = energiPerTime;
        setMoms(30);
    }

    //Methods
    @Override
    public double beregnSalgspris() {
        if (getPris() / 100 * getMoms() < 3) {
            return getPris() + 3.0;
        } else {
            return super.beregnSalgspris();
        }
    }
}
