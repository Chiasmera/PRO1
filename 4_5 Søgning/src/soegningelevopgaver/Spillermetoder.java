package soegningelevopgaver;

import java.util.ArrayList;

public class Spillermetoder {
    /**
     * Finder den første spiller med det givne antal mål i en liste
     *
     * @param spillere Liste med spillere
     * @param score    Antal mål som ledes efter
     * @return Første spiller med samme antal mål som det der ledes efter
     */
    public Spiller findScoreLinear(ArrayList<Spiller> spillere, int score) {
        Spiller result = null;
        int i = 0;
        while (result == null && i < spillere.size()) {
            Spiller k = spillere.get(i);
            if (k.getMaal() == score) {
                result = k;
            } else {
                i++;
            }
        }
        return result;
    }

    /**
     * Finder den første spiller med det givne antal mål i en liste
     *
     * @param spillere Liste med spillere
     * @param score    Antal mål som ledes efter
     * @return Første spiller med givne antal mål
     */
    public Spiller findScoreBinaer(ArrayList<Spiller> spillere, int score) {
        Spiller result = null;
        int left = 0;
        int right = spillere.size()-1;
        while (result == null && left <= right) {
            int middle = (left + right) / 2;
            Spiller k = spillere.get(middle);
            if (k.getMaal() == score) {
                result = k;
            } else if (k.getMaal() > score) {

                left = middle+1;
            } else {
                right = middle-1;
            }
        }
        return result;
    }

    /**
     * Finder navnet på en spiller under 170 cm med over 50 mål
     * @param spillere Liste med spillere
     * @return Navn på spiller under 170 cm og har over 50 mål
     */
    public String godSpiller (ArrayList<Spiller> spillere) {
        String result = "";
        int i = 0;
        while (result.equals("") && i < spillere.size()) {
            Spiller k = spillere.get(i);
            if (k.getHoejde() < 170 && k.getMaal() > 50) {
                result = k.getNavn();
            } else {
                i++;
            }
        }
        return result;
    }

    // Her tilføjes metoder der løser opgve 4.2 og 4.3

    public static void main(String[] args) {
        Spillermetoder metoder = new Spillermetoder();

        // Her afprøves opgave 4.1
        ArrayList<Spiller> spillerListe = new ArrayList<>();
        spillerListe.add(new Spiller("Hans", 196, 99, 45));
        spillerListe.add(new Spiller("Bo", 203, 89, 60));
        spillerListe.add(new Spiller("Jens", 188, 109, 32));
        spillerListe.add(new Spiller("Finn", 194, 102, 12));
        spillerListe.add(new Spiller("Lars", 192, 86, 35));
        spillerListe.add(new Spiller("Mads", 200, 103, 37));

        System.out.println("Linær:");
        System.out.println("Spiller der har scoret 35 mål: " + metoder.findScoreLinear(spillerListe, 35));
        System.out.println("Spiller der har scoret 30 mål: " + metoder.findScoreLinear(spillerListe, 30));


        // Tilføj kode der afprøver opgaver 4.2 og 4.3
        ArrayList<Spiller> spillerListeSorteret = new ArrayList<>();
        spillerListeSorteret.add(new Spiller("Bo", 203, 89, 60));
        spillerListeSorteret.add(new Spiller("Hans", 196, 99, 45));
        spillerListeSorteret.add(new Spiller("Mads", 200, 103, 37));
        spillerListeSorteret.add(new Spiller("Lars", 192, 86, 35));
        spillerListeSorteret.add(new Spiller("Jens", 188, 109, 32));
        spillerListeSorteret.add(new Spiller("Finn", 194, 102, 12));


        System.out.println("Binær:");
        System.out.println("Spiller der har scoret 35 mål: " + metoder.findScoreBinaer(spillerListeSorteret, 35));
        System.out.println("Spiller der har scoret 30 mål: " + metoder.findScoreBinaer(spillerListeSorteret, 30));

        System.out.println("Høj, god spiller:");
        System.out.println("Spiller over 170 med over 50 mål: " + metoder.godSpiller(spillerListeSorteret));



    }

}
