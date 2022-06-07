import java.util.ArrayList;

public class Tutor {
    //Fields
    private String navn;
    private String email;
    private Hold hold;
    private ArrayList<Arrangement> arrangementer = new ArrayList<>();

    //Constructors
    public Tutor(String navn, String email) {
        this.navn = navn;
        this.email = email;
    }

    //Methods - Get, Set, add & remove

    public String getNavn() {
        return navn;
    }

    public String getEmail() {
        return email;
    }

    public Hold getHold() {
        return hold;
    }

    /**
     * Sætter holdet for denne tutor. kan være null
     *
     * @param hold det hold der skal sættes for tutoren. Kan være null
     */
    public void setHold(Hold hold) {
        if (this.hold != hold) {
            Hold oldhold = this.hold;
            if (oldhold != null) {
                oldhold.removeTutor(this);
            }
            if (hold != null) {
                hold.addTutor(this);
            }
            this.hold = hold;
        }
    }

    public ArrayList<Arrangement> getArrangementer() {
        return new ArrayList<>(arrangementer);
    }

    public void addArrangement (Arrangement arrangement) {
        if (!arrangementer.contains(arrangement)) {
            arrangementer.add(arrangement);
        }
    }

    public void removeArrangement (Arrangement arrangement) {
        if (arrangementer.contains(arrangement)) {
            arrangementer.remove(arrangement);
        }
    }

    //Methods - other

}
