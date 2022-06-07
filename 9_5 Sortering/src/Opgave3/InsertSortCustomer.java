package Opgave3;

import java.util.ArrayList;

public class InsertSortCustomer {

    public void insertSortCustomer (ArrayList<Customer> list) {
        for (int i = 1; i < list.size(); i++) {
            Customer next = list.get(i);
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.compareTo(list.get(j-1)) > 0) {
                    found = true;
                } else {
                    list.set(j, list.get(j-1));
                    j--;
                }
            }
            list.set(j, next);
        }
    }
}
