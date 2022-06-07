package Application.Model;

import java.util.ArrayList;

public class Frivillig {

    //Fields
    private String navn;
    private String mobil;
    private int maksAntalTimer;
    private ArrayList<Vagt> vagter = new ArrayList<>();

    //Constructors
    public Frivillig(String navn, String mobil, int maksAntalTimer) {
        this.navn = navn;
        this.mobil = mobil;
        this.maksAntalTimer = maksAntalTimer;
    }

    //Methods - Get, Set & link-methods
    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    public int getMaksAntalTimer() {
        return maksAntalTimer;
    }

    public ArrayList<Vagt> getVagter() {
        return new ArrayList<>(vagter);
    }

    public void addVagt(Vagt vagt) {
        if (!vagter.contains(vagt)) {
            vagter.add(vagt);
        }
    }

    public void removeVagt(Vagt vagt) {
        if (vagter.contains(vagt)) {
            vagter.remove(vagt);
        }
    }


    //Methods - Other
    public int ledigeTimer() {

            int timer = 0;
            for (Vagt vagt : vagter) {
                timer += vagt.getTimer();
            }
            return maksAntalTimer - timer;

    }

    @Override
    public String toString() {
        return navn + "\t" + 1;
    }
}
