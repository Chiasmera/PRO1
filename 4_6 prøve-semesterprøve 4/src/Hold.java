import java.util.ArrayList;

public class Hold {
    //Fields
    private String betegnelse;
    private String holdleder;
    private Uddannelse uddannelse;
    private ArrayList<Tutor> tutorer = new ArrayList<>();

    //Constructors
    public Hold (String betegnelse, String holdleder, Uddannelse uddannelse) {
        this.betegnelse = betegnelse;
        this.holdleder = holdleder;
        this.uddannelse = uddannelse;
    }

    //Methods - Get, Set, add & remove

    public String getBetegnelse() {
        return betegnelse;
    }

    public String getHoldleder() {
        return holdleder;
    }

    public ArrayList<Tutor> getTutorer() {
        return new ArrayList<>(tutorer);
    }

    public void addTutor (Tutor tutor) {
        if (!tutorer.contains(tutor)) {
            tutorer.add(tutor);
            tutor.setHold(this);
        }
    }

    public void removeTutor (Tutor tutor) {
        if (tutorer.contains(tutor)) {
            tutorer.remove(tutor);
            tutor.setHold(null);
        }
    }

    //Methods - other

}
