package Application.Model;

import java.util.ArrayList;

public class Uddannelse {
    private String navn;
    private ArrayList<Hold> hold = new ArrayList<>();

    public Uddannelse(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public Hold createHold(String betegnelse, String holdleder) {
        Hold hold1 = new Hold(betegnelse, holdleder, this);
        hold.add(hold1);
        return hold1;
    }

    public ArrayList<Hold> getHold() {
        return new ArrayList<>(hold);
    }

    public ArrayList<String> tutorOversigt() {
        ArrayList<String> tutorStrings = new ArrayList<>();
        for (Hold h : hold) {
            for (Tutor t : h.getTutorer()) {
                String tutorString = t.getNavn() + "\t\t" + this.navn + "\t\t" + h.getBetegnelse() + "\t\t" + t.getEmail() + "\t" + h.getHoldleder() + "\n";
                tutorStrings.add(tutorString);
            }
        }
        return tutorStrings;
    }

}
