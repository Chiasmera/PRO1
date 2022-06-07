package Opgave2;

import java.sql.SQLOutput;

public class ChristmasApp {
    public static void main(String[] args) {
        Person julemand = new Person("Julemanden", 900);
        Person lilleOle = new Person("Lille Ole", 6);

        Gift nyCykel = new Gift("Rød Cykel", julemand);
        nyCykel.setPrice(700);

        Gift ak47 = new Gift("AK47", julemand);
        ak47.setPrice(300);

        lilleOle.recieveGift(ak47);
        lilleOle.recieveGift(nyCykel);

        System.out.println("Lille ole har fået følgende gaver:");
        for (Gift g : lilleOle.getGiftsRecieved()) {
            System.out.println(g.getDescription()+" Fra: "+ g.getGiver());
        }

        System.out.println("Lille Ole har gået gaver til en værdi af: "+lilleOle.totalGiftWorth());

        System.out.println("Lille Ole har fået gaver fra: " + lilleOle.getGivers());

    }
}
