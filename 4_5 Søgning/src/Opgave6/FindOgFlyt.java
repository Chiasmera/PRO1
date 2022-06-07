package Opgave6;

import java.util.ArrayList;

public class FindOgFlyt {

    public int findOgFlyt(ArrayList<Integer> list, int target) {
        int result = -1;
        int i = 0;
        while (result == -1 && i < list.size()) {
            int k = list.get(i);
            if (k == target && i == 0) {
                result = i;
            } else if (k== target) {
                list.remove(i);
                list.add(i-1, k);
                result = i-1;
            } else {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        ArrayList<Integer> liste = new ArrayList<>();
        liste.add(6);
        liste.add(4);
        liste.add(8);
        liste.add(13);
        liste.add(2);


        FindOgFlyt test = new FindOgFlyt();

        System.out.println("Find nr 13, flyt og returner position: " + test.findOgFlyt(liste, 13));
        System.out.println("Find nr 13, flyt og returner position: " + test.findOgFlyt(liste, 13));
        System.out.println("Find nr 4, flyt og returner position: " + test.findOgFlyt(liste, 4));
        System.out.println("Find nr 4, flyt og returner position: " + test.findOgFlyt(liste, 4));
        System.out.println("Find nr 4, flyt og returner position: " + test.findOgFlyt(liste, 4));
        System.out.println("Find nr 4, flyt og returner position: " + test.findOgFlyt(liste, 1));
    }
}
