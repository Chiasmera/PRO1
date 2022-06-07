package GUI;

import Application.Model.Hund;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Hund> hundeTilUdstilling = new ArrayList<>();
        Hund h1 = new Hund("Spot", true,1000, Hund.Race.TERIER);
        Hund h2 = new Hund("Zeus", false,500, Hund.Race.PUDDEL);
        Hund h3 = new Hund("Batman", true,900, Hund.Race.BOKSER);
        Hund h4 = new Hund("Svend", false,300, Hund.Race.PUDDEL);
        Hund h5 = new Hund("Hackles", true,1200, Hund.Race.BOKSER);

        hundeTilUdstilling.add(h1);
        hundeTilUdstilling.add(h2);
        hundeTilUdstilling.add(h3);
        hundeTilUdstilling.add(h4);
        hundeTilUdstilling.add(h5);

        System.out.println(samletPris(hundeTilUdstilling, Hund.Race.TERIER));
    }

    public static int samletPris (ArrayList<Hund> hunde, Hund.Race race) {
        int sum = 0;
        for (Hund h : hunde) {
            if (h.getRace() == race) {
                sum += h.getPrice();
            }
        }
        return sum;
    }
}
