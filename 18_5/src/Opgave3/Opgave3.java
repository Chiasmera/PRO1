package Opgave3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Opgave3 {
    public static void main(String[] args) {
        ArrayList<Customer> list1 = new ArrayList<>();
        Customer[] list2 = new Customer[8];

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
        list1.add(c8);
        list1.add(c9);
        list1.add(c10);
        list1.add(c11);

        list2[0] = c2;
        list2[1] = c4;
        list2[2] = c5;
        list2[3] = c6;
        list2[4] = c8;
        list2[5] = c9;
        list2[6] = c10;
        list2[7] = c11;

        Collections.sort(list1);

        System.out.println(list1);
        System.out.println(Arrays.toString(list2));
        System.out.println(Opgave3.goodCustomers(list1, list2));


    }

    /**
     * Returnerer en sorteret ArrayList der indeholder alle
     * customers fra l1 der ikke er i l2
     * Krav: l1 og l2 er sorterede, indeholder ikke dubletter og
     * indeholder ikke tomme pladser
     */
    public static ArrayList goodCustomers(ArrayList<Customer> l1, Customer[] l2) {
        ArrayList<Customer> finalList = new ArrayList<>();

        int c1 = 0;
        int c2 = 0;

        while (c1 < l1.size() && c2 < l2.length) {
            if (l1.get(c1).compareTo(l2[c2]) == 0) {
                c1++;
                c2++;
            } else if (l1.get(c1).compareTo(l2[c2]) < 0) {
                finalList.add(l1.get(c1));
                c1++;
            } else {
                c2++;
            }
        }

        while (c1 < l1.size()) {
            finalList.add(l1.get(c1));
            c1++;
        }


        return finalList;

    }
}
