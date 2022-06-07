package Opgave2;

import java.util.ArrayList;

public class SelectionSortCustomer {

    public void selectionSortCustomerArrayList (ArrayList<Customer> list) {
        for (int i = 0; i < list.size(); i++) {
            int minPos = i;
            for (int j = i+1; j< list.size(); j++) {
                if (list.get(j).compareTo(list.get(minPos)) <= 0) {
                    minPos = j;
                }
            }
            swapCustomer(list, i, minPos);
        }
    }

    public void swapCustomer (ArrayList<Customer> list, int pos1, int pos2) {
        Customer temp = list.get(pos1);
        list.set(pos1, list.get(pos2));
        list.set(pos2, temp);
    }
}
