package Opgave5;

public class Vare {
    //Fields
    private double pris;
    private String navn;
    private String beskrivelse;
    private int moms;

    //Constructor
    public Vare(double pris, String navn, String beskrivelse) {
        this.pris = pris;
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.moms = 25;
    }

    //Methods

    public void setMoms(int moms) {
        this.moms = moms;
    }

    public String getNavn() {
        return navn;
    }

    public double getPris() {
        return pris;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public int getMoms() {
        return moms;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public double beregnSalgspris() {
        double salgspris = (pris / 100 * moms) + pris;
        return salgspris;
    }
}
