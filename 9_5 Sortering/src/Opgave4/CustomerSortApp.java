package Opgave4;

import Opgave3.Customer;

import java.util.ArrayList;
import java.util.Collections;

public class CustomerSortApp {
        public static void main(String[] args) {

            //Test af udleveret kode:
            ArrayList<String> list = new ArrayList<String>();
            list.add("Jan");
            list.add("Bent");
            list.add("Thomas");
            list.add("Karsten");
            list.add("Dan");
            System.out.println(list);
            Collections.sort(list);
            System.out.println(list);

            //Oprettelse af Customer liste og sorteren af listen:
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

            System.out.println("Customerarray før: " + customerarray);
            Collections.sort(customerarray);
            System.out.println("Customerarray efter: " + customerarray);
        }
    }

