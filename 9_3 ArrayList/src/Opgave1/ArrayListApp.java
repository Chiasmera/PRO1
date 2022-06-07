package Opgave1;

import java.util.ArrayList;

public class ArrayListApp {
    public static void main(String[] args) {
        //Laver nyt liste
        System.out.println("Laver ny liste");
        ArrayList<String> liste = new ArrayList<>();

        //tilføjer 5 navne
        System.out.println("Tilføjer 5 navne");
        liste.add("Hans");
        liste.add("Viggo");
        liste.add("Jens");
        liste.add("Børge");
        liste.add("Bent");

        //Udskriver antal elementer i liste
        System.out.println("Antal elementer i liste");
        System.out.println(liste.size());

        //Tilføjer jane på plds 2
        System.out.println("tilføjer jane på plads 2");
        liste.add(2, "Jane");

        //Udskriver indhold af listen
        System.out.println("Udskrive indhold af liste");
        System.out.println(liste);

        //Fjerner element på plads 1
        System.out.println("Fjerner element på plads 1");
        liste.remove(1);

        //Tilføj pia til starten
        System.out.println("Tilføj Pia til starten");
        liste.add(0, "Pia");

        //tilføj ib til slutningen af listen
        System.out.println("Tilføj Ib til slutning");
        liste.add("Ib");

        //Udskriv antal elementer i liste
        System.out.println("udskriv antal elementer");
        System.out.println(liste.size());

        //Indsætter hansi på plads 2
        System.out.println("indsætter hansi");
        liste.set(2, "Hansi");

        //Udskriv antal elementer i liste
        System.out.println("printer elementer i liste");
        System.out.println(liste.size());

        //Udskriver indhold af listen
        System.out.println("printer indhold af liste");
        System.out.println(liste);

        //for lykke med længden på tekststrenge i listen
        System.out.println("printer længde på tekstrenge");
        for (int i = 0; i < liste.size(); i++) {
            System.out.println(liste.get(i).length() );
        }

        //foreach lykke med længden på tekststrenge i listen
        System.out.println("printer længde på tekstrenge");
        for (String s : liste) {
            System.out.println(s.length());
        }



    }
}
