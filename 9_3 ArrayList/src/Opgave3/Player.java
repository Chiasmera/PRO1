package Opgave3;

public class Player {
    //fields
    String name;
    int age;
    int score;

    //constructor
    Player (String name, int age) {
        this.name = name;
        this.age = age;
        score = 0;
    }

    //Methods - get & set


    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

    //methods - other
    public void addScore (int score) {
        this.score += score;
    }
}
