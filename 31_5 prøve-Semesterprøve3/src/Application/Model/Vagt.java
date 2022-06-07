package Application.Model;

public class Vagt {

    //Fields
    private int timer;
    private Job job;
    private Frivillig frivillig;

    //Constructors
    Vagt ( int timer, Job job, Frivillig frivillig) {
        this.timer = timer;
        this.job = job;
        this.frivillig = frivillig;
        frivillig.addVagt(this);
    }

    //Methods - Get, Set & link-methods

    public int getTimer() {
        return timer;
    }

    public Job getJob () {
        return job;
    }

    public Frivillig getFrivillig () {
        return frivillig;
    }


    //Methods - Other


    @Override
    public String toString() {
        return frivillig + " tager jobbet: "+ job + " i " + timer + "timer";
    }
}
