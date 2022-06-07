package Opgave3;

import java.util.ArrayList;

public class Team {
    //Fields
    String name;
    ArrayList<Player> players;

    //Constructor
    Team (String name) {
        this.name = name;
        players = new ArrayList();
    }

    //methods - get & set

    public String getName() {
        return name;
    }

    //methods - other
    public void addPlayer ( Player player) {
        players.add(player);
    }

    public void printPlayers () {
        for (Player p : players) {
            System.out.println(p.name);
            System.out.println(p.age);
            System.out.println(p.score);
        }
    }

    public double calcAverageAge () {
        int ageSum = 0;
        for (Player p : players) {
            ageSum += p.age;
        }
        double average = (double) ageSum / players.size();
        return average;
    }

    public int calcTotalScore () {
        int scoreSum = 0;
        for (Player p : players) {
            scoreSum += p.score;
        }
        return scoreSum;
    }

    public int calcOldPlayerScore (int ageLimit) {
        int scoreSum = 0;
        for (Player p : players) {
            if (p.age > ageLimit) {
                scoreSum += p.score;
            }
        }
        return scoreSum;
    }

    public int maxScore () {
        int highScore = 0;
        for (Player p : players) {
            if (p.score > highScore) {
                highScore = p.score;
            }
        }
        return highScore;
    }

    public String bestPlayer ()  {
        int highScore = 0;
        String bestPlayer = "Alle er lige gode";
        for (Player p : players) {
            if (p.score > highScore) {
                highScore = p.score;
                bestPlayer = p.name;
            }
        }
        return bestPlayer;
    }
}
