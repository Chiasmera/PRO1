package Application.Model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * Modelerer en vagt i kantinen
 */
public class Vagt {

    //Fields    ________________________________________________________________________________________
    private String navn;
    private LocalDateTime tidFra;
    private LocalDateTime tidTil;
    private ArrayList<Antal> antals = new ArrayList<>();
    private ArrayList<Medarbejder> medarbejdere = new ArrayList<>();

    //Constructors    ________________________________________________________________________________________
    public Vagt(String navn, LocalDateTime tidFra, LocalDateTime tidtil) {
        this.navn = navn;
        this.tidFra = tidFra;
        this.tidTil = tidtil;
    }

    //Methods   -   Get & Set    ________________________________________________________________________________________

    public String getNavn() {
        return navn;
    }

    public LocalDateTime getTidFra() {
        return tidFra;
    }

    public LocalDateTime getTidtil() {
        return tidTil;
    }

    public ArrayList<Antal> getAntals() {
        return new ArrayList<>(antals);
    }

    public ArrayList<Medarbejder> getMedarbejdere() {
        return new ArrayList<>(medarbejdere);
    }

    //Methods   -   Create, Add & Remove    ________________________________________________________________________________________
    public Antal createAntal(int antal, Funktion funktion) {
        Antal a1 = new Antal(antal, funktion);
        antals.add(a1);
        return a1;
    }

    /**
     * Opdaterer vagtens liste med medarbejdere. Må kun kaldes af medarbejderens addVagt metode
     *
     * @param medarbejder Medarbejderen som bliver tilføjet
     */
    public void addMedarbejder(Medarbejder medarbejder) {
        if (!medarbejdere.contains(medarbejder)) {
            medarbejdere.add(medarbejder);
        }
    }

    public void removeMedarbejder(Medarbejder medarbejder) {
        if (medarbejdere.contains(medarbejder)) {
            medarbejdere.remove(medarbejder);
            medarbejder.removeVagt(this);
        }
    }

    //Methods   -   Other    ________________________________________________________________________________________
    /**
     * Finder og returnerer en medarbejder med angivne mødetidspunkt og mindst det angivne antal timer. Returnerer null hvis ingen er fundet.
     *
     * @param tidspunkt  mødetidspunkt for medarbejderen
     * @param antalTimer minimum antal timer medarbejderen arbejder
     * @return Den fundne medarbejder. Null hvis ingen der passer kriterierne er fundet.
     */
    public Medarbejder findMedarbejder(LocalTime tidspunkt, int antalTimer) {
        int i = 0;
        Medarbejder found = null;
        while (found == null && i < medarbejdere.size()) {
            Medarbejder current = medarbejdere.get(i);
            if (current.getTypiskMødetid().compareTo(tidspunkt) == 0 && current.getAntalTimerPrDag() >= antalTimer) {
                found = current;
            } else {
                i++;
            }
        }
        return found;
    }

    /**
     * Returnerer samlet tidsforbug af vagten i timer, baseret på længden på en vagt ganget med antal medarbejdere
     *
     * @return samlet timeforbrug for vagten
     */
    public int beregnTimeForbrug() {
        long minutterIAlt = tidFra.until(tidTil, ChronoUnit.MINUTES);
        int timer = (int) minutterIAlt / 60;
        if (minutterIAlt % 60 > 0) {
            timer++;
        }

        return medarbejdere.size() * timer;
    }

    /**
     * Returnerer antaller af medarbejdere med den givne funktion
     *
     * @param funktion Funktionen som der søges på
     * @return Antallet af medarbejdere med funktionen
     */
    public int antalMedarejdereMedFunktion(Funktion funktion) {
        int sum = 0;
        for (Medarbejder m : medarbejdere) {
            int i = 0;
            boolean found = false;
            while (!found && i < m.getFunktioner().size()) {
                if (m.getFunktioner().get(i).getNavn().equalsIgnoreCase(funktion.getNavn())) {
                    found = true;
                    sum++;
                }
                i++;
            }

        }
        return sum;
    }

    /**
     * Returnerer et array med medarbejdere med en typisk mødetid senere end vagtens start tid
     *
     * @return Et array med medarbejdere
     */
    public Medarbejder[] skalAdviseresOmMødetid() {
        Medarbejder[] seneTider = new Medarbejder[medarbejdere.size()];
        int i = 0;
        for (Medarbejder m : medarbejdere) {
            if (m.getTypiskMødetid().compareTo(tidFra.toLocalTime()) > 0) {
                seneTider[i] = m;
                i++;
            }
        }
        return seneTider;
    }

    /**
     * Returnerer en streng med besked om der på vagten er tilstrækkelige ressourcer til at dække alle funktioner
     *
     * @return En String med resultat af søgningen
     */
    public String status() {
        int i = 0;
        boolean missing = false;
        while (!missing && i < antals.size()) {
            Antal current = antals.get(i);
            if (current.getAntal() > antalMedarejdereMedFunktion(current.getFunktion())) {
                missing = true;
            } else {
                i++;
            }
        }

        String returnMessage = "Ressourcer Tildelt";
        if (missing) {
            returnMessage = "Manglende ressourcer";
        }
        return returnMessage;
    }

    //Tostring & compareTo    ________________________________________________________________________________________

    @Override
    public String toString() {
        return navn;
    }
}
