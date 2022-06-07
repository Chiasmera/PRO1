package Opgave2;

import Opgave1.Customer;

import java.util.Arrays;

public class ArrayApp {
    public static void main(String[] args) {

        //Opretter 5 kunder
        Customer k1 = new Customer("Julius", "Seerup", 32);
        Customer k2 = new Customer("Jens", "Hansen", 16);
        Customer k3 = new Customer("Sankt", "Klaus", 1000);
        Customer k4 = new Customer("Gaius", "Caesar", 42);
        Customer k5 = new Customer("Louis", "Pasteur", 29);

        //Laver sorteret Array (10) med kunder
        Customer[] list = {k4, k2, k3, k5, k1, null, null, null, null, null};

        //Opretter ny kunde og indsætter i liste
        System.out.println("Laver ny kunde ( Frederik Finnerup (12) og indsætter i liste:");
        Customer k6 = new Customer("Frederik", "Finnerup", 12);
        indsætKunde(list, k6);
        System.out.println(Arrays.toString(list));


    }

    /**
     * Indsætter kunde i kunder. Arrayet kunder er sorteret
     * Krav: kunder er sorteret
     */
    public static void indsætKunde(Customer[] customers, Customer customer) {
        int foundPos = -1;
        int i = customers.length - 1;
        while (i > 0 && customers[i] == null) {
            i--;
        }

        while (foundPos == -1 && i >= 0) {
            if (customer.compareTo(customers[i]) < 0) {
                customers[i + 1] = customers[i];
                i--;
            } else {
                foundPos = i;
            }
        }
        customers[foundPos+1] = customer;
    }

}
