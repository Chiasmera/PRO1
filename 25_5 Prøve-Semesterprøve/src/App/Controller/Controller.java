package App.Controller;

import App.Model.Bil;
import App.Model.Mærke;
import App.Model.Parkeringshus;
import Storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Controller {

    public static Bil createBil (String regNr, Mærke mærke) {
        Bil nybil = new Bil(regNr, mærke);
        Storage.addBil(nybil);
        return nybil;
    }

    public static Parkeringshus createParkeringshus (String adresse) {
        Parkeringshus nyParkeringshus = createParkeringshus(adresse);
        Storage.addParkeringshus(nyParkeringshus);
        return nyParkeringshus;
    }

    public static void writeOptagnePladser(Parkeringshus hus, String filnavn) {
        File fil = new File(filnavn);

        try (PrintWriter out = new PrintWriter(fil);) {
            ArrayList<String> optagnePladser = hus.optagnePladser();
            for (String s : optagnePladser) {
                out.println(s);
            }

        } catch (FileNotFoundException fileException) {
            throw new RuntimeException("No file found at the given path.");
        }
    }

    public void createSomeObjects () {
        Bil b1 = createBil("AB 11 222", Mærke.TOYOTA);
        Bil b2 = createBil("EF 33 444", Mærke.SKODA);
        Bil b3 = createBil("BD 55 666", Mærke.MERCEDES);

        Parkeringshus ph1 = createParkeringshus("Havnegade 12, 8000 Aarhus");

        for (int i = 1; i <= 100; i++) {
            ph1.createParkeringsplads(i);
        }

        for (int i = 1; i <= 10; i++) {
            ph1.createInvalideplads(i, 18);
        }

        ph1.getParkeringspladser().get(17).setBil(b1);
        ph1.getParkeringspladser().get(37).setBil(b2);
        ph1.getParkeringspladser().get(99).setBil(b3);
    }
}
