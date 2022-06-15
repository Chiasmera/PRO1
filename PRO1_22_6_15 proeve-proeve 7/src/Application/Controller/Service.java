package Application.Controller;

import Application.Model.Hold;
import Application.Model.Medlem;
import Storage.Dao;

import java.util.ArrayList;

public class Service {

    public static ArrayList<Hold> getHold () {
        return Dao.getHold();
    }

    public static ArrayList<Medlem> getmedlemmer () {
        return Dao.getMedlemmer();
    }

    public static void addHold (Hold hold) {
        Dao.addHold(hold);
    }

    public static void addMedlem (Medlem medlem) {
        Dao.indsætMedlem(medlem);
    }

    /**
     * Returnerer en liste med hold som kan tage mindst det angivede antal deltagere
     * @param antal minimum antal deltagere for holdet
     * @return en liste med hold
     */
    public  static ArrayList<Hold> findStoreHold (int antal) {
        ArrayList<Hold> hold = new ArrayList<>();
        for (Hold h : Dao.getHold()) {
            if (h.getMaxAntal() >= antal) {
                hold.add(h);
            }
        }
        return hold;
    }

    public static void createSomeObjects () {
        Hold h1 = new Hold("Darts Away", "Kanodart", 8);
        Hold h2 = new Hold("Brawn 'n' Brain", "Chessboxing", 2);
        Dao.addHold(h1);
        Dao.addHold(h2);

        Medlem m1 = new Medlem("Julemanden","Nordpolen", "hohoho@gmail.com", "12345678");
        Medlem m2 = new Medlem("Anders And","Andeby 1", "aa@gmail.com", "14582456");
        Medlem m3 = new Medlem("Vlad Dracul","Transylvanien", "notavampire@gmail.com", "94467276");
        Medlem m4 = new Medlem("Frikard Ellemand","Svinestien 3", "mums@gmail.com", "46319572");
        Medlem m5 = new Medlem("Antje Chrastj","Polen", "666@gmail.com", "66666666");
        Dao.indsætMedlem(m1);
        Dao.indsætMedlem(m2);
        Dao.indsætMedlem(m3);
        Dao.indsætMedlem(m4);
        Dao.indsætMedlem(m5);

        h1.createTilmelding(true,true,m2);
        h1.createTilmelding(true,true,m4);
        h1.createTilmelding(true,false,m5);
        h2.createTilmelding(true, true,m1);
        h2.createTilmelding(true,true,m3);
    }
}
