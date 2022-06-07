import java.util.ArrayList;

public class Uddannelse {

    //Fields
    private String navn;
    private ArrayList<Hold> hold = new ArrayList<>();

    //Constructors
    public Uddannelse (String navn) {
        this.navn = navn;
    }

    //Methods - Get, Set, add & remove

    public String getNavn() {
        return navn;
    }

    public Hold createHold (String betegnelse, String holdleder) {
        Hold nythold = new Hold(betegnelse, holdleder, this);
        hold.add(nythold);
        return nythold;
    }

    public ArrayList<Hold> getHold() {
        return new ArrayList<>(hold);
    }

    public void addHold (Hold hold) {
        if (!this.hold.contains(hold)) {
            this.hold.add(hold);
        }
    }

    public void removeHold (Hold hold) {
        if (this.hold.remove(hold)) {
            this.hold.remove(hold);
        }
    }

    //Methods - other

}
