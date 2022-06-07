package Opgave1;

import java.util.ArrayList;

public class ArrayListApp {
    public static void main(String[] args) {

        //Opretter fem kunder
        Customer k1 = new Customer("Julius", "Seerup", 32);
        Customer k2 = new Customer("Jens", "Hansen", 16);
        Customer k3 = new Customer("Sankt", "Klaus", 1000);
        Customer k4 = new Customer("Gaius", "Caesar", 42);
        Customer k5 = new Customer("Louis", "Pasteur", 29);

        //Opretter liste og adder kunder
        ArrayList<Customer> list = new ArrayList<>();
        list.add(k1);
        list.add(k2);
        list.add(k3);
        list.add(k4);
        list.add(k5);

        //Sorterer liste
        list.sort(Customer::compareTo);
        System.out.println(list);

        //Laver ny kunde og indsætter i liste
        System.out.println("Laver ny kunde ( Frederik Finnerup (12) og indsætter i liste:");
        Customer k6 = new Customer("Frederik", "Finnerup", 12);
        indsætKunde(list,k6);
        System.out.println(list);



    }

    /**
     * Indsætter kunde i kunder. Listen kunder er sorteret
     * Krav: kunder er sorteret
     */
    public static void indsætKunde(ArrayList<Customer> customers, Customer customer) {
        int foundPos = 0;
        int i = 0;
        boolean found =false;
        while (!found && i < customers.size()) {
            if (customer.compareTo(customers.get(i)) > 0) {
                foundPos = i;
                found = true;
            } else {
                i++;
            }
        }
        customers.add(foundPos+1, customer);
    }
}
