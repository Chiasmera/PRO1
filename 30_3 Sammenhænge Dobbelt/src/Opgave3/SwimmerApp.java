package Opgave3;

import java.util.ArrayList;

public class SwimmerApp {
    
    public static void main(String[] args) {

        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(1.02);
        lapTimes.add(1.01);
        lapTimes.add(0.99);
        lapTimes.add(0.98);
        lapTimes.add(1.02);
        lapTimes.add(1.04);
        lapTimes.add(0.99);
        Swimmer s1 = new Swimmer("Jan", 1994, lapTimes, "AGF");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.05);
        lapTimes.add(1.01);
        lapTimes.add(1.04);
        lapTimes.add(1.06);
        lapTimes.add(1.08);
        lapTimes.add(1.04);
        lapTimes.add(1.02);
        Swimmer s2 = new Swimmer("Bo", 1995, lapTimes, "Lyseng");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.03);
        lapTimes.add(1.01);
        lapTimes.add(1.02);
        lapTimes.add(1.05);
        lapTimes.add(1.03);
        lapTimes.add(1.06);
        lapTimes.add(1.03);
        Swimmer s3 = new Swimmer("Mikkel", 1993, lapTimes, "AIA-Tranbjerg");
        
        ArrayList<Swimmer> allSwimmers = new ArrayList<>();
        allSwimmers.add(s1);
        allSwimmers.add(s2);
        allSwimmers.add(s3);

        for (Swimmer s : allSwimmers) {
            System.out.println(s.getName() + "'s bedste tid: " + s.bestLapTime());

        }

        //Min kode
        TrainingPlan planA = new TrainingPlan('A',16,10);
        TrainingPlan planB = new TrainingPlan('B',10,6);

        s1.setTrainingPlan(planA);
        s2.setTrainingPlan(planB);

        s3.setTrainingPlan(planB);

        planA.addSwimmer(s2);

        for (Swimmer s : allSwimmers) {
            System.out.println(s.getName() + "'s træningsplan: " + s.getTrainingPlan().getLevel());
        }

    }
    
}
