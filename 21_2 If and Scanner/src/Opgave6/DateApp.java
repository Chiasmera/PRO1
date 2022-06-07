package Opgave6;

import java.util.Scanner;

public class DateApp {
    public static void main(String[] args) {
        Date dato = new Date();
        Scanner scan = new Scanner(System.in);

        System.out.println("What month is it?");
        int month = scan.nextInt();
        System.out.println("What day is it?");
        int day = scan.nextInt();

        System.out.println(dato.getSeason(day, month));

        scan.close();
    }
}
