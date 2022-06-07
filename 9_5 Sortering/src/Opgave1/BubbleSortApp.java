package Opgave1;

import java.util.Arrays;

public class BubbleSortApp {
    public static void main(String[] args) {


        String[] s = {"Erna", "Elly", "Laurits", "Bertha", "Christian", "August", "Marius", "John", "Tove", "Poul", "Torkild"};

        System.out.println(Arrays.toString(s));
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSortArray(s);
        System.out.println(Arrays.toString(s));


    }
}
