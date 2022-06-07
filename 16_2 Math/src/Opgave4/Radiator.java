package Opgave4;

public class Radiator {
//Fields
    int temperature;

    //Constructors
    public Radiator () {
        temperature = 20;
    }

    public Radiator (int temperature) {
        this.temperature = temperature;
    }

    //Method
    public int getTemperature () {
        return temperature;
    }

    public  void skruOp (int grader) {
        temperature = temperature + grader;
    }

    public void skruNed (int grader) {
        temperature = temperature - grader;
    }

}
