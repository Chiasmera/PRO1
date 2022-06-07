package Opgave4;

import java.util.ArrayList;

public class SwimmerApp {
    
    public static void main(String[] args) {

        TrainingPlan planA = new TrainingPlan('A', 16,10);

        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(1.02);
        lapTimes.add(1.01);
        lapTimes.add(0.99);
        lapTimes.add(0.98);
        lapTimes.add(1.02);
        lapTimes.add(1.04);
        lapTimes.add(0.99);
        Swimmer s1 = planA.createSwimmer("Jan", 1994, "AGF", lapTimes);

        lapTimes = new ArrayList<>();
        lapTimes.add(1.05);
        lapTimes.add(1.01);
        lapTimes.add(1.04);
        lapTimes.add(1.06);
        lapTimes.add(1.08);
        lapTimes.add(1.04);
        lapTimes.add(1.02);
        Swimmer s2 = planA.createSwimmer("Bo", 1995,  "Lyseng", lapTimes);

        lapTimes = new ArrayList<>();
        lapTimes.add(1.03);
        lapTimes.add(1.01);
        lapTimes.add(1.02);
        lapTimes.add(1.05);
        lapTimes.add(1.03);
        lapTimes.add(1.06);
        lapTimes.add(1.03);
        Swimmer s3 =planA.createSwimmer("Mikkel", 1993,  "AIA-Tranbjerg", lapTimes);

        planA.removeSwimmer(s2);

        for (Swimmer s : planA.getSwimmers()) {
            System.out.println("Navn: "+s.getName());
            System.out.println("Klub: "+s.getClub());
            System.out.println();
        }





    }
    
}
