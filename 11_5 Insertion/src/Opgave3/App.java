package Opgave3;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        //Laver 5 chilier
        Chili c1 = new Chili("Rød", 3);
        Chili c2 = new Chili("Grøn", 253);
        Chili c3 = new Chili("Gul", 745);
        Chili c4 = new Chili("Sort", 1000);
        Chili c5 = new Chili("Lilla", 2000);

        Measureable[] list = {c1, c2, c3, c4, c5};


        System.out.println("Liste med chillier: " + Arrays.toString(list));
        System.out.println("Printer max i listen: " + max(list));
        System.out.println("Printer gennemsnit i listen: " + avg(list));



    }

    public static Measureable max(Measureable[] objects) {
        Measureable largest = objects[0];
        for (int i = 1; i < objects.length; i++) {
            if (objects[i].getMeasure() > largest.getMeasure()) {
                largest = objects[i];
            }
        }
        return largest;
    }

    public static double avg(Measureable[] objects) {
        double sum = 0;
        for (Measureable o : objects) {
            sum += o.getMeasure();
        }
        return sum / objects.length;

    }

}
