package Opgave4;

import java.time.LocalDate;

public class Testapp {
    public static void main(String[] args) {
        Kollegie kollegie1 = new Kollegie("Første stedd", "stedsvej 1");
        Bolig bolig1 = new Bolig(18,"stedsvej1A",100,kollegie1);
        bolig1.createLejeaftale(LocalDate.now());
        Lejer jens = new Lejer("jens", "datamatiker");
        Lejer hans = new Lejer("hans", "datamatiker");


        System.out.println(kollegie1.gennemsnitligAntalDage());
        System.out.println(kollegie1.getAntalLejeaftaler());

    }
}
