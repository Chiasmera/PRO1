package Opgave2;

import java.util.ArrayList;
import java.util.Arrays;

public class SelectionSortApp {
    public static void main(String[] args) {

        String[] stringarray = {"Erna", "Elly", "Laurits", "Bertha", "Christian", "August", "Marius", "John", "Tove", "Poul", "Torkild"};
        System.out.println("Stringarray før: " + Arrays.toString(stringarray));
        SelectionSortString selectionSortString = new SelectionSortString();
        selectionSortString.selectionSortStringArray(stringarray);
        System.out.println("Stringarray efter: " + Arrays.toString(stringarray));
        System.out.println();

        ArrayList<Customer> customerarray = new ArrayList<>();
        Customer c1 = new Customer("Personson", "Person", 1);
        Customer c2 = new Customer("Anderson", "Erik", 1);
        Customer c3 = new Customer("Lund", "Xavier", 1);
        Customer c4 = new Customer("Gerlev", "Anton", 1);
        Customer c5 = new Customer("Seerup", "Julius", 1);

        customerarray.add(c1);
        customerarray.add(c2);
        customerarray.add(c3);
        customerarray.add(c4);
        customerarray.add(c5);

        System.out.println("Customerarraylist før: " + customerarray);
        SelectionSortCustomer selectionSortCustomer = new SelectionSortCustomer();
        selectionSortCustomer.selectionSortCustomerArrayList(customerarray);
        System.out.println("Customerarraylist efter: " + customerarray);



    }
}
