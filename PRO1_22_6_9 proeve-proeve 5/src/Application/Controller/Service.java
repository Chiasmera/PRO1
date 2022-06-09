package Application.Controller;

import Application.Model.Deltagelse;
import Application.Model.Kamp;
import Application.Model.ProfSpiller;
import Application.Model.Spiller;
import Storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Service {

    public static Kamp createKamp(String sted, LocalDate dato, LocalTime tid) {
        Kamp k1 = new Kamp(sted, dato, tid);
        Storage.addKamp(k1);
        return k1;
    }

    public static Spiller createSpiller(String navn, int aargang) {
        Spiller s1 = new Spiller(navn, aargang);
        Storage.addSpiller(s1);
        return s1;
    }

    public static ProfSpiller createProfSpiller(String navn, int aargang, double kampHonorar) {
        ProfSpiller s1 = new ProfSpiller(navn, aargang, kampHonorar);
        Storage.addSpiller(s1);
        return s1;
    }

    //Denne metoder virker ubrugelig, da spilleren bliver sat i deltagerens constructor og ikke burde kunne ændres til
    //en anden spiller (man kan ikke overtage en deltagelse i en kamp, ifølge almindelig logisk tænkning)
    //Spiller og deltagelse er altså per definition allerede linket

    /**
     * Opdaterer sammenhængen mellem spiller og deltagelse så de
     * linker til hinanden
     * precondition: spiller != null og deltagelse != null
     *
     * @param spiller
     * @param deltagelse
     */
    public static void updateSpillerDeltagelse(Spiller spiller, Deltagelse deltagelse) {
        spiller.addDeltagelse(deltagelse);
    }

    public static ArrayList<Kamp> alleKampe(ArrayList<Kamp> list1, ArrayList<Kamp> list2) {
        ArrayList<Kamp> finalList = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).compareTo(list2.get(j)) < 0) {
                finalList.add(list1.get(i));
                i++;
            } else if (list1.get(i).compareTo(list2.get(j)) > 0) {
                finalList.add(list2.get(j));
                j++;
            } else {
                finalList.add(list1.get(i));
                finalList.add(list2.get(j));
                i++;
                j++;
            }
        }

        while (i < list1.size()) {
            finalList.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            finalList.add(list1.get(i));
            i++;
        }

        return finalList;
    }

    public static ArrayList<Kamp> getKampe() {
        return Storage.getKampe();
    }

    public static void updateKamp (Kamp kamp, String sted, LocalDate dato, LocalTime tid){
        kamp.setSted(sted);
        kamp.setDato(dato);
        kamp.setTid(tid);
    }

    public static void createSpillerHonorarFile (Kamp kamp, String filePath) {
        kamp.spillerHonorar(filePath);
    }

    public static void createSomeObjects() {
        Spiller s1 = createSpiller("Jane Jensen", 1999);
        Spiller s2 = createSpiller("Lene Hansen", 2000);
        Spiller s3 = createSpiller("Mette Petersen", 1999);
        ProfSpiller ps1 = createProfSpiller("Sofia Kjeldsen", 1999, 50);
        ProfSpiller ps2 = createProfSpiller("Maria Nielsen", 2000, 55);

        Kamp k1 = createKamp("Herning", LocalDate.of(2015, 1, 26), LocalTime.of(10, 30));
        Kamp k2 = createKamp("Ikast", LocalDate.of(2015, 1, 27), LocalTime.of(13, 30));

        k1.createDeltagelse(true, "Moster Oda har fødselsdag", s1);
        k1.createDeltagelse(false, "", s2);
        k1.createDeltagelse(false, "", s3);
        k1.createDeltagelse(false, "", ps1);
        k1.createDeltagelse(false, "", ps2);

        k2.createDeltagelse(false, "", s1);
        k2.createDeltagelse(false, "", s2);
        k2.createDeltagelse(false, "", s3);
        k2.createDeltagelse(true, "Dårlig form", ps1);
        k2.createDeltagelse(false, "", ps2);
    }
}
