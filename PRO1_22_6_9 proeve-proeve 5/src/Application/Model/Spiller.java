package Application.Model;

import java.util.ArrayList;

public class Spiller {

    private String navn;
    private int aargang;
    private ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Spiller (String navn, int aargang) {
        this.navn = navn;
        this.aargang = aargang;
    }

    public String getNavn() {
        return navn;
    }

    public int getAargang() {
        return aargang;
    }

    public ArrayList<Deltagelse> getDeltagelser() {
        return new ArrayList<>(deltagelser);
    }

    public void addDeltagelse (Deltagelse deltagelse) {
        if (!deltagelser.contains(deltagelse)) {
            deltagelser.add(deltagelse);
            deltagelse.setSpiller(this);
        }
    }

    //Denne metode virker overflødig, da man ikke bør kunne fjerne en deltagelse. Hvis en spiller har en deltagelse
    //i en kamp (afbud eller ej), så kan man ikke gå tilbage og ændre fortiden
    /**
     * Bør kun blive kaldt af setSpiller metoden
     * @param deltagelse
     */
    public void removeDeltagelse (Deltagelse deltagelse) {
        if (deltagelser.contains(deltagelse)) {
            deltagelser.remove(deltagelse);
        }
    }

    public double kampHonorar () {
        int sum = 0;
        for (Deltagelse d : deltagelser) {
            if (!d.isAfbud()) {
                sum ++;
            }
        }
        return sum * 10;
    }
}
