package Application.Model;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Modelerer en medarbejder som kan opfylde visse funktioner og sættes på vagter
 */
public class Medarbejder {

    //Fields    ________________________________________________________________________________________
    private String navn;
    private int antalTimerPrDag;
    private LocalTime typiskMødetid;
    private ArrayList<Funktion> funktioner = new ArrayList<>();
    private ArrayList<Vagt> vagter = new ArrayList<>();

    //Constructors    ________________________________________________________________________________________
    public Medarbejder(String navn, int antalTimerPrDag, LocalTime typiskMødetid) {
        this.navn = navn;
        this.antalTimerPrDag = antalTimerPrDag;
        this.typiskMødetid = typiskMødetid;
    }

    //Methods   -   Get & Set    ________________________________________________________________________________________
    public String getNavn() {
        return navn;
    }

    public int getAntalTimerPrDag() {
        return antalTimerPrDag;
    }

    public LocalTime getTypiskMødetid() {
        return typiskMødetid;
    }

    public ArrayList<Funktion> getFunktioner() {
        return new ArrayList<>(funktioner);
    }

    public ArrayList<Vagt> getVagter() {
        return new ArrayList<>(vagter);
    }

    //Methods - Add & Remove    ________________________________________________________________________________________
    public void addFunktion(Funktion funktion) {
        if (!funktioner.contains(funktion)) {
            funktioner.add(funktion);
        }
    }

    public void removeFunktion(Funktion funktion) {
        if (funktioner.contains(funktion)) {
            funktioner.remove(funktion);
        }
    }

    /*
    public void addVagt (Model.Vagt vagt) {
        if(!vagter.contains(vagt)) {
            vagter.add(vagt);
            vagt.addMedarbejder(this);
        }
    }
     */

    /**
     * Tilføjer en medarbejder til en vagt. Kaster en runtimeerror hvis medarbejderen allerede har en vagt på tidspunktet
     *
     * @param vagt Vagten som medarbejderen skal tilføjes til
     */
    public void addVagt(Vagt vagt) {
        int i = 0;
        while (i < vagter.size()) {
            if (vagt.getTidFra().isAfter(vagter.get(i).getTidtil()) || vagt.getTidtil().isBefore(vagter.get(i).getTidFra())) {
                i++;
            } else {
                throw new RuntimeException(navn + " har allerede vagten \"" + vagter.get(i).getNavn() + "\" på dette tidspunkt");
            }
        }
        vagter.add(vagt);
        vagt.addMedarbejder(this);
    }

    public void removeVagt(Vagt vagt) {
        if (vagter.contains(vagt)) {
            vagter.remove(vagt);
            vagt.removeMedarbejder(this);
        }
    }

    //toString & compareTo    ________________________________________________________________________________________
    @Override
    public String toString() {
        return navn + ", (Mødetid: " + typiskMødetid + ")";
    }
}
