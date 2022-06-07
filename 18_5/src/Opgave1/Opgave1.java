package Opgave1;

import java.util.ArrayList;
import java.util.Collections;

public class Opgave1 {
    public static void main(String[] args) {

        ArrayList<Customer> list1 = new ArrayList<>();
        ArrayList<Customer> list2 = new ArrayList<>();

        Customer c1 = new Customer("Hansen", "Jens", 22);
        Customer c2 = new Customer("Andersen", "Adam", 45);
        Customer c3 = new Customer("Olesen", "Ole", 23);
        Customer c4 = new Customer("Bentsen", "Peter", 43);
        Customer c5 = new Customer("Jensen", "Jullius", 42);
        Customer c6 = new Customer("Troelsen", "Bent", 12);
        Customer c7 = new Customer("Seerup", "Hans", 23);
        Customer c8 = new Customer("Aarup", "Yvette", 44);
        Customer c9 = new Customer("Gudrup", "Mette", 13);
        Customer c10 = new Customer("Petersen", "Julie", 42);
        Customer c11 = new Customer("Yversen", "Grethe", 31);

        list1.add(c1);
        list1.add(c2);
        list1.add(c3);
        list1.add(c4);
        list1.add(c5);
        list1.add(c6);
        list1.add(c7);
        list2.add(c8);
        list2.add(c9);
        list2.add(c10);
        list2.add(c11);

        Collections.sort(list1);
        Collections.sort(list2);

        System.out.println(Opgave1.fletAlleKunder(list1, list2));


    }
    /**
     * Returnerer en sorteret ArrayList der indeholder alle
     * kunder fra både l1 og l2
     * Krav: l1 og l2 er sorterede
     */
    public static ArrayList<Customer> fletAlleKunder (ArrayList < Customer > l1, ArrayList < Customer > l2){
        ArrayList<Customer> finalList = new ArrayList<>();
        int lc1 = 0;
        int lc2 = 0;

        while (lc1 < l1.size() && lc2 < l2.size()) {
            if (l1.get(lc1).compareTo(l2.get(lc2)) <= 0) {
                finalList.add(l1.get(lc1));
                lc1++;
            } else {
                finalList.add(l2.get(lc2));
                lc2++;
            }
        }

        while (lc1 < l1.size()) {
            finalList.add(l1.get(lc1));
            lc1++;
        }

        while (lc2 < l2.size()) {
            finalList.add(l2.get(lc2));
            lc2++;
        }

        return finalList;
    }
}
