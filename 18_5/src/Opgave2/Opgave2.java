package Opgave2;

import java.util.Arrays;

public class Opgave2 {
    public static void main(String[] args) {
        int[] list1 = {2, 4, 6, 8, 10, 12, 14};
        int[] list2 = {1, 2, 4, 5, 6, 9, 12, 17};

        System.out.println(Arrays.toString(Opgave2.fællesTal(list1, list2)));




    }

    /**
     * Returnerer et sorteret array der indeholder alle
     * elementer l1 og l2 har til fælles
     * Krav: l1 og l2 er sorterede, indeholder ikke dubletter og
     * indeholder ikke tomme pladser
     */
    public static int[] fællesTal(int[] l1, int[] l2) {
        int[] finalArray;
        if (l1.length < l2.length) {
            finalArray = new int[l1.length];
        } else {
            finalArray = new int[l2.length];
        }

        int c1 = 0;
        int c2 = 0;
        int i = 0;

        while (c1 < l1.length && c2 < l2.length) {
            if (l1[c1] == l2[c2]) {
                finalArray[i] = l1[c1];
                i++;
                c1++;
                c2++;
            } else if (l1[c1] < l2[c2]) {
                c1++;
            } else {
                c2++;
            }
        }
        return finalArray;
    }

}
