package Opgave1;

public class BubbleSort {

    public void bubbleSortArray (String[] array) {
        for (int i = 0; i< array.length; i++) {
            for (int j = 0; j<array.length-1; j++) {
                if (array[j].compareTo(array[j+1]) >= 0) {
                    swap(array,j,j+1);
                }
            }
        }
    }

    private static void swap(String[] list, int i, int j) {
        String temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
