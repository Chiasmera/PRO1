package App.Model;

import java.util.ArrayList;

public class Parkeringshus {

    //Fields
    private String adresse;
    private double saldo;

    private ArrayList<Parkeringsplads> parkeringspladser = new ArrayList<>();

    //Constructor
    public Parkeringshus(String adresse) {
        this.adresse = adresse;
    }

    //Methods - Get & Set
    public String getAdresse() {
        return adresse;
    }

    /**
     * Returnerer en kopi af listen med parkeringspladser
     *
     * @return Kopi af liste med parkeringspladser
     */
    public ArrayList<Parkeringsplads> getParkeringspladser() {
        return new ArrayList<>(parkeringspladser);
    }

    public double getSaldo() {
        return saldo;
    }

    /**
     * Tilføjer et beløb til saldoen
     *
     * @param beløb beløb som skal tilføjes til saldoen
     */
    public void addToSaldo(double beløb) {
        this.saldo += beløb;
    }

    //Methods - other

    /**
     * Opretter en ny almindelig parkeringsplads og tilføjer til listen over parkeringspladser
     *
     * @param nummer Det nummer som skal identificere parkeringspladsen
     * @return Den nyligt oprettede parkeringsplads
     */
    public Parkeringsplads createParkeringsplads(int nummer) {
        Parkeringsplads nyParkeringsplads = new Parkeringsplads(nummer, this);
        parkeringspladser.add(nyParkeringsplads);
        return nyParkeringsplads;
    }

    /**
     * Opretter en ny Model.Invalideplads og tilføjer til listen over parkeringspladser
     *
     * @param nummer Det nummer som skal identificere Invalidepladsen
     * @return Den nyligt oprettede Model.Invalideplads
     */
    public Parkeringsplads createInvalideplads(int nummer, double areal) {
        Parkeringsplads nyInvalideplads = new Invalideplads(nummer, this, areal);
        parkeringspladser.add(nyInvalideplads);
        return nyInvalideplads;
    }

    /**
     * Fjerner en parkeringsplads fra listen over parkeringspladser
     *
     * @param parkeringsplads Den plads som skal fjernes
     */
    public void removeParkeringsplads(Parkeringsplads parkeringsplads) {
        if (parkeringspladser.contains(parkeringsplads)) {
            parkeringspladser.remove(parkeringsplads);
        }
    }

    /**
     * Returnerer antallet af ledige pladser i parkeringshuset
     *
     * @return Antallet af ledige pladser
     */
    public int antalLedigePladser() {
        int antal = 0;
        for (Parkeringsplads plads : parkeringspladser) {
            if (plads.getBil() == null) {
                antal++;
            }
        }
        return antal;
    }

    /**
     * Returnerer pladsen på en bil, givet registreringsnummeret på bilen.
     *
     * @param regNummer Registreringsnummer på bilen der skal findes
     * @return nummer på pladsen hvorpå bilen er parkeret. -1 hvis bilen ikke findes.
     */
    public int findPladsMedBil(String regNummer) {
        int pladsNr = -1;
        int i = 0;
        boolean found = false;
        while (i < parkeringspladser.size() && !found) {
            if (parkeringspladser.get(i).getBil().getRegNr().equals(regNummer.trim())) {
                found = (true);
                pladsNr = parkeringspladser.get(i).getNummer();
            }
        }
        return pladsNr;
    }

    /**
     * Finder antal biler af et givent mærke i parkeringshuset
     *
     * @param mærke Mærket der søges efter
     * @return Antallet af biler med givent mærke
     */
    public int findAntalBiler(Mærke mærke) {
        int antal = 0;
        for (Parkeringsplads plads : parkeringspladser) {
            if (plads.getBil() != null) {
                if (plads.getBil().getMærke() == mærke) {
                    antal++;
                }
            }
        }
        return antal;
    }

    /**
     * Finder alle optagede pladser og returnerer en liste med information om pladserne
     * @return En liste indeholdende pladsnr, registreringsnummer på bilen og bilens mærke
     */
    public ArrayList<String> optagnePladser() {
        ArrayList<String> optagnePladser = new ArrayList<>();
        for (Parkeringsplads plads : parkeringspladser) {
            if (plads.getBil() != null) {
                String info = "Plads Nr:" + plads.getNummer() + "\t:\t" + plads.getBil().getRegNr() + ", " + plads.getBil().getMærke();
                optagnePladser.add(info);
            }
        }
        return optagnePladser;
    }


}
