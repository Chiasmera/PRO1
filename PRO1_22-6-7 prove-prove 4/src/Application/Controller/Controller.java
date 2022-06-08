package Application.Controller;

import Application.Model.Arrangement;
import Application.Model.Hold;
import Application.Model.Tutor;
import Application.Model.Uddannelse;
import Storage.Storage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {

    public static Arrangement createArrangement(String titel, LocalDate date, LocalTime startTid, LocalTime slutTid, double price) {
        Arrangement a1 = new Arrangement(titel, date, startTid, slutTid, price);
        Storage.addArrangement(a1);
        return a1;
    }

    public static Tutor createTutor(String navn, String email) {
        Tutor t1 = new Tutor(navn, email);
        Storage.addTutor(t1);
        return t1;
    }

    public static Uddannelse createUddannelse(String navn) {
        Uddannelse u1 = new Uddannelse(navn);
        Storage.addUddannelse(u1);
        return u1;
    }

    public static void addTutorToHold(Tutor tutor, Hold hold) {
        if (!hold.getTutorer().contains(tutor)) {
            hold.addTutor(tutor);
        } else {
            throw new RuntimeException("Denne tutor er allerede på dette hold");
        }
    }

    public static void addArrangementToTutor(Arrangement arrangement, Tutor tutor) {
        boolean found = false;
        int i = 0;
        while (i < tutor.getArrangementer().size() && !found) {
            Arrangement currentArrangement = tutor.getArrangementer().get(i);
            if (currentArrangement.getDate() == arrangement.getDate()) {
                if (currentArrangement.getStartTid().isBefore(arrangement.getSlutTid())) {
                    if (!currentArrangement.getSlutTid().isBefore(arrangement.getStartTid())) {
                        found = true;
                    }
                }

            }
            i++;
        }
        if (found) {
            throw new RuntimeException("Denne tutor har allerede et arrangement i samme tidsrum som dette arrangement");
        } else {
            tutor.addArrangement(arrangement);
        }
    }


    public static ArrayList<Hold> holdUdenTutorer() {
        ArrayList<Hold> tutorløseHold = new ArrayList<>();
        for (int i = 0; i < Storage.getUddannelser().size(); i++) {
            for (int j = 0; j < Storage.getUddannelser().get(i).getHold().size(); j++) {
                if (Storage.getUddannelser().get(i).getHold().get(j).getTutorer().size() == 0) {
                    tutorløseHold.add(Storage.getUddannelser().get(i).getHold().get(j));
                }
            }
        }
        return tutorløseHold;
    }

    public static void tutorOversigtTilFil(String filnavn) {

        File file = new File(filnavn);

        try (PrintWriter out = new PrintWriter(file)) {
            for (Uddannelse u : Storage.getUddannelser()) {
                for (String s : u.tutorOversigt()) {
                    out.println(s);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(new Exception("Trouble with the file path or name. Please make sure you have entered the correct path and file type"));
        }

    }

    public static ArrayList<Tutor> getTutorer() {
        return Storage.getTutorer();
    }

    public static ArrayList<Arrangement> getArrangementer() {
        return Storage.getArrangementer();
    }

    public static void removeArrangementFromTutor (Arrangement arrangement, Tutor tutor) {
        tutor.removeArrangement(arrangement);
    }

    public static void initStorage() {
        Uddannelse u1 = createUddannelse("DMU");
        Uddannelse u2 = createUddannelse("FINØ");

        Hold h1 = u1.createHold("1dmE17S", "Margrethe Dybdahl");
        Hold h2 = u1.createHold("1dmE17T", "kristian Dorland");
        Hold h3 = u1.createHold("1dmE17U", "Kell Ørhøj");
        Hold h4 = u2.createHold("1fiE17B", "Karen Jensen");

        Tutor t1 = createTutor("Anders Hansen", "aaa@students.eaaa.dk");
        Tutor t2 = createTutor("Peter Jensen", "ppp@students.eaaa.dk");
        Tutor t3 = createTutor("Niels Madsen", "nnn@students.eaaa.dk");
        Tutor t4 = createTutor("Lone Andersen", "lll@students.eaaa.dk");
        Tutor t5 = createTutor("Mads Miller", "mmm@students.eaaa.dk");

        Arrangement a1 = createArrangement("Rusfest", LocalDate.of(2017, 8, 31), LocalTime.of(18, 0), LocalTime.of(23, 30), 250);
        Arrangement a2 = createArrangement("Fodbold", LocalDate.of(2017, 8, 30), LocalTime.of(14, 0), LocalTime.of(17, 30), 250);
        Arrangement a3 = createArrangement("Brætspil", LocalDate.of(2017, 8, 29), LocalTime.of(12, 0), LocalTime.of(16, 30), 250);
        Arrangement a4 = createArrangement("Mindeparken", LocalDate.of(2017, 8, 30), LocalTime.of(18, 0), LocalTime.of(22, 0), 250);

        addTutorToHold(t1, h1);
        addTutorToHold(t4, h1);
        addTutorToHold(t2, h3);
        addTutorToHold(t3, h3);
        addTutorToHold(t2, h4);

        addArrangementToTutor(a1, t1);
        addArrangementToTutor(a1, t2);
        addArrangementToTutor(a1, t5);
        addArrangementToTutor(a2, t3);
        addArrangementToTutor(a3, t4);
        addArrangementToTutor(a3, t3);
        addArrangementToTutor(a4, t5);
        addArrangementToTutor(a4, t1);

    }


}
