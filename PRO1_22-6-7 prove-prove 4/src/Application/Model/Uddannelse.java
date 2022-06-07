package Application.Model;

import java.util.ArrayList;

public class Uddannelse {
    private String navn;
    private ArrayList<Hold> hold = new ArrayList<>();

    public Uddannelse (String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public Hold createHold (String betegnelse, String holdleder) {
        Hold hold1 = new Hold(betegnelse, holdleder, this);
        hold.add(hold1);
        return hold1;
    }

    public ArrayList<Hold> getHold() {
        return new ArrayList<>(hold);
    }

}
