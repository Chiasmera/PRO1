package Opgave3;

public class TeamApp {
    public static void main(String[] args) {
        Player julius = new Player("Julius", 31);
        Player esben = new Player("Esben", 38);
        Player nora = new Player ("Nora", 3);

        Team klasse22y = new Team("22y");

        klasse22y.addPlayer(julius);
        klasse22y.addPlayer(esben);
        klasse22y.addPlayer(nora);

        julius.addScore(50);
        julius.addScore(3);
        esben.addScore(1);
        nora.setScore(20);

        System.out.println(klasse22y.calcAverageAge());
        System.out.println(klasse22y.calcOldPlayerScore(10));
        System.out.println(klasse22y.calcTotalScore());

        System.out.println(klasse22y.maxScore());

        System.out.println(klasse22y.bestPlayer());


    }
}
