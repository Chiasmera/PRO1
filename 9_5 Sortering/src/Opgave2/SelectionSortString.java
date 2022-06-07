package Opgave2;

public class SelectionSortString {

    public void selectionSortStringArray (String[] array) {
        for (int i = 0; i< array.length; i++) {
            int minPos = i;
            for (int j = i+1; j < array.length; j++ ) {
                if (array[j].compareTo(array[minPos]) <= 0) {
                    minPos = j;
                }
            }
            swapString(array, i, minPos);
        }
    }


    public void swapString (String[] array, int pos1, int pos2) {
        String temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }
}
