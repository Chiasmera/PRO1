package Opgave4;

import java.time.LocalDate;
import java.util.ArrayList;

public class SvømmerApp {
    public static void main(String[] args) {
        ArrayList<Double> mineTider = new ArrayList<Double>();
        mineTider.add(10.5);
        mineTider.add(15.7);
        mineTider.add(8.1);
        mineTider.add(2.9);
        mineTider.add(13.4);

        Svømmer julius = new Svømmer("Julius", LocalDate.of(1990,5,3),"EAAA",mineTider);

        System.out.println("Tider: ");
        System.out.println(mineTider);
        System.out.println("Bedste:");
        System.out.println(julius.bedsteTid());
        System.out.println("Gennemsnit");
        System.out.println(julius.gennemsnitAfTid());
        System.out.println("Gennemsnit, uden dårligste");
        System.out.println(julius.snitUdenDårligste());
    }
}
