package Application.Controller;

import Application.Model.Antal;
import Application.Model.Funktion;
import Application.Model.Medarbejder;
import Application.Model.Vagt;
import Storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {

    //Methods   -   Get
    public static ArrayList<Medarbejder> getMedarbejdere () {
        return Storage.getMedarbejdere();
    }

    public static ArrayList<Vagt> getVagter () {
        return Storage.getVagter();
    }

    public static ArrayList<Funktion> getFunktioner () {
        return Storage.getFunktioner();
    }
    //Methods   -   Create    ________________________________________________________________________________________
    public static Medarbejder createMedarbejder ( String navn, int antalTimerPrDag, LocalTime typiskMødeTid) {
        Medarbejder m1 = new Medarbejder(navn, antalTimerPrDag, typiskMødeTid);
        Storage.addMedarbejder(m1);
        return m1;
    }

    public static Vagt createVagt (String navn, LocalDateTime tidFra, LocalDateTime tidTil) {
        Vagt v1 = new Vagt(navn, tidFra, tidTil);
        Storage.addVagt(v1);
        return v1;
    }

    public static Funktion createFunktion (String navn) {
        Funktion f1 = new Funktion(navn);
        Storage.addFunktion(f1);
        return f1;
    }


    //Methods   -   Link    ________________________________________________________________________________________
    public static void addMedarbejderToVagt (Medarbejder medarbejder, Vagt vagt) throws RuntimeException {
        medarbejder.addVagt(vagt);
    }

    public static void addFunktionToVagt  (Funktion funktion, int antal, Vagt vagt) {
        vagt.createAntal(antal,funktion);
    }

    public static  void addFunktionToMedarbejder (Funktion funktion, Medarbejder medarbejder) {
        medarbejder.addFunktion(funktion);
    }


    //Methods   -   Other    ________________________________________________________________________________________

    /**
     * Opretter en fil og fylder den med detaljer om vagten, inklusive navn, dato, medarbejdere tilkoblet og om alle funktioner er dækkede
     * @param vagt Vagten som skrives til fil
     * @param filNavn Filens navn og path
     */
    public static void udskrivVagtplan (Vagt vagt, String filNavn) {
        File fil = new File(filNavn);

        try (PrintWriter out = new PrintWriter(fil)) {
            String titel = vagt.getTidFra() + " (" + vagt.getNavn()+")";
            for (int i = 0; i <= titel.length()+2; i++) {
                out.print("-");

            }
            out.println();
            out.println(titel);
            for (int i = 0; i <= titel.length()+2; i++) {
                out.print("-");

            }
            out.println();
            out.println();
            out.println("Funktioner:");
            for (Antal a : vagt.getAntals()) {
               out.println(a.getFunktion().getNavn()+" ("+a.getAntal() +", "+ vagt.antalMedarejdereMedFunktion(a.getFunktion())+" medarbejdere)");
            }
            out.println();
            out.print("Medarbejdere: ");
            for (Medarbejder m : vagt.getMedarbejdere()) {
                out.print(m.getNavn()+" ");
            }
            out.println();
            out.println();
            out.print("Status: ");
            out.print(vagt.status());


        } catch (FileNotFoundException fileNotFoundException) {
            throw new RuntimeException("File not found at specified path. Please check the filepath");
        }
    }

    //Methods   -   Initial    ________________________________________________________________________________________

    /**
     * Opretter en række elementer i systemet ved start
     */
    public static void initStorage () {
        Funktion f1 = createFunktion("Filetering");
        Funktion f2 = createFunktion("Grøntsager");
        Funktion f3 = createFunktion("Sovs og tilbehør");
        Funktion f4 = createFunktion("Buffetopfyldning");

        Medarbejder m1 = createMedarbejder("Peter", 6, LocalTime.of(8,0));
        Medarbejder m2 = createMedarbejder("Anne", 8, LocalTime.of(8,0));
        Medarbejder m3 = createMedarbejder("Marie", 6, LocalTime.of(10,0));
        Medarbejder m4 = createMedarbejder("Torben", 8, LocalTime.of(7,0));

        Vagt v1 = createVagt("Røgede ål til medarbejderne", LocalDateTime.of(2022,6,24,8,0), LocalDateTime.of(2022,6,24,12,30));

        addFunktionToVagt(f1,2,v1);
        addFunktionToVagt(f2,1,v1);
        addFunktionToVagt(f3,1,v1);
        addFunktionToVagt(f4,1,v1);

        addMedarbejderToVagt(m1,v1);
        addMedarbejderToVagt(m2,v1);
        addMedarbejderToVagt(m3,v1);

        addFunktionToMedarbejder(f2,m1);
        addFunktionToMedarbejder(f3,m1);
        addFunktionToMedarbejder(f4,m1);

        addFunktionToMedarbejder(f2,m2);
        addFunktionToMedarbejder(f3,m2);
        addFunktionToMedarbejder(f4,m2);

        addFunktionToMedarbejder(f1,m3);
        addFunktionToMedarbejder(f2,m3);
        addFunktionToMedarbejder(f4,m3);

        addFunktionToMedarbejder(f1,m4);
        addFunktionToMedarbejder(f3,m4);

    }
}
