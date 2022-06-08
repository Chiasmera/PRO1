package Application.Model;

import java.util.ArrayList;

public class Tutor {
    private String navn;
    private String email;

    private Hold hold;
    private ArrayList<Arrangement> arrangementer = new ArrayList<>();

    public Tutor(String navn, String email) {
        this.navn = navn;
        this.email = email;
    }

    public String getNavn() {
        return navn;
    }

    public String getEmail() {
        return email;
    }

    public Hold getHold() {
        return hold;
    }

    public void setHold(Hold hold) {
        if (this.hold != hold) {
            Hold oldhold = this.hold;
            if (oldhold != null) {
                oldhold.removeTutor(this);
            }
            this.hold = hold;
            if (this.hold != null) {
                this.hold.addTutor(this);
            }
        }
    }

    public ArrayList<Arrangement> getArrangementer() {
        return new ArrayList<>(arrangementer);
    }

    public void addArrangement(Arrangement arrangement) {
        if (!arrangementer.contains(arrangement)) {
            arrangementer.add(arrangement);
        }
    }

    public void removeArrangement(Arrangement arrangement) {
        if (arrangementer.contains(arrangement)) {
            arrangementer.remove(arrangement);
        }
    }

    public double arrangementPris() {
        double sum = 0;
        for (Arrangement a : arrangementer) {
            sum += a.getPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        return navn + " (" + email + ")";
    }
}
