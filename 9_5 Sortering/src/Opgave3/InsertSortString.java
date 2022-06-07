package Opgave3;

public class InsertSortString {

    public void insertSortString (String[] array) {
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
}
