package measure;

public class SortMethods {
    
    public static void bubbleSort(String[] array) {
        for (int i = 0; i< array.length; i++) {
            for (int j = 0; j<array.length-1; j++) {
                if (array[j].compareTo(array[j+1]) >= 0) {
                    bubbleSwap(array,j,j+1);
                }
            }
        }
    }
    
    public static void insertionSort(String[] array) {
        for (int i = 1; i < array.length; i++) {
            String next = array[i];
            int j = i;
            boolean found = false;
            while (j > 0 && !found) {
                if (next.compareTo(array[j-1]) >= 0) {
                    found = true;
                } else {
                    array[j] = array[j-1];
                    j--;
                }
            }
            array[j] = next;
        }
    }
    
    public static void selectionSort(String[] array) {
        for (int i = 0; i< array.length; i++) {
            int minPos = i;
            for (int j = i+1; j < array.length; j++ ) {
                if (array[j].compareTo(array[minPos]) <= 0) {
                    minPos = j;
                }
            }
            selectionSwap(array, i, minPos);
        }
    }

    private static void bubbleSwap(String[] list, int i, int j) {
        String temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
    public static void selectionSwap (String[] array, int pos1, int pos2) {
        String temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }

    
}
