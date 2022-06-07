package Application.Controller;

import Application.Model.*;
import Storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public static Festival createFestival(String navn, LocalDate fraDato, LocalDate tilDato) {
        Festival festival = new Festival(navn, fraDato, tilDato);
        Storage.addFestival(festival);
        return festival;
    }

    public static Frivillig createFrivillig(String navn, String mobil, int maksAntaltimer) {
        Frivillig frivillig = new Frivillig(navn, mobil, maksAntaltimer);
        Storage.addFrivillig(frivillig);
        return frivillig;
    }

    public static FrivilligForening createForening(String navn, String mobil, int maksAntaltimer, String foreningsnavn, int antalPersoner) {
        FrivilligForening forening = new FrivilligForening(navn, mobil, maksAntaltimer, foreningsnavn, antalPersoner);
        Storage.addFrivillig(forening);
        return forening;
    }

    public static void initStorage() {
        Festival f1 = createFestival("Northside", LocalDate.of(2020, 06, 04), LocalDate.of(2020, 06, 06));
        Frivillig fri1 = createFrivillig("Jane Jensen", "12345677", 20);
        Frivillig fri2 = createFrivillig("Lone Hansen", "78787878", 25);
        Frivillig fri3 = createFrivillig("Anders Mikkelsen", "55555555", 10);
        Frivillig fri4 = createForening("Christan Madsen", "23232323", 100, "Erhvervsakademi Aarhus", 40);

        for (int i = 1; i <= 9; i++) {
            LocalDate dato = LocalDate.of(2020, 06, 04);
            ;
            if (i <= 3) {
                LocalDate.of(2020, 06, 05);
            } else if (i <= 6) {
                LocalDate.of(2020, 06, 06);
            }
            f1.createJob("T" + i, "Rengøring af toilet", dato, 100, 5);


        }
    }

    public static Vagt tagVagt(Job job, Frivillig frivilig, int timer) {
        if (job.ikkeBesattetimer() < timer) {
            throw new RuntimeException("Der er ikke nok timer tilbage i dette job, til så stor en vagt");
        } else if (frivilig.ledigeTimer() < timer) {
            throw new RuntimeException("Denne frivillige har ikke nok timer tilbage til at udføre denne vagt");
        } else {
            Vagt vagt = job.createVagt(timer, frivilig);
            return vagt;
        }

    }

    public static boolean findFrivillig(Festival festival, String navn) {
        ArrayList<String> gaveListe = festival.gaverTilFrivillige();
        int right = gaveListe.size() - 1;
        int left = 0;
        boolean found = false;
        while (right >= left && !found) {
            int middle = right - left;
            if (gaveListe.get(middle).contains(navn.trim())) {
                found = true;
            } else if (gaveListe.get(middle).compareTo(navn.trim()) > 0) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return found;
    }

    public static ArrayList<Festival> getAllFestivaller() {
        return Storage.getFestivaller();
    }

    public static ArrayList<Frivillig> getAllFrivilige () {
        return Storage.getFrivillige();
    }


}
