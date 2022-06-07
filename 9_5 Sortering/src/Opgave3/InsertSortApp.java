package Opgave3;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertSortApp {
    public static void main(String[] args) {

        //Laver Stringarray
        String[] stringarray = {"Erna", "Elly", "Laurits", "Bertha", "Christian", "August", "Marius", "John", "Tove", "Poul", "Torkild"};

        //Laver customer arraylist
        ArrayList<Customer> customerarray = new ArrayList<>();
        Customer c1 = new Customer("Personson", "Person", 21);
        Customer c2 = new Customer("Anderson", "Erik", 57);
        Customer c3 = new Customer("Lund", "Xavier", 23);
        Customer c4 = new Customer("Gerlev", "Anton", 64);
        Customer c5 = new Customer("Seerup", "Julius", 12);

        customerarray.add(c1);
        customerarray.add(c2);
        customerarray.add(c3);
        customerarray.add(c4);
        customerarray.add(c5);

        //Test af kode
        System.out.println("Stringarray før: " + Arrays.toString(stringarray));
        InsertSortString insertSortString = new InsertSortString();
        insertSortString.insertSortString(stringarray);
        System.out.println("Stringarray efter: " + Arrays.toString(stringarray));
        System.out.println();

        System.out.println("Customerarraylist før: " + customerarray);
        InsertSortCustomer insertSortCustomer = new InsertSortCustomer();
        insertSortCustomer.insertSortCustomer(customerarray);
        System.out.println("Customerarraylist efter: " + customerarray);
        System.out.println();

    }
}
