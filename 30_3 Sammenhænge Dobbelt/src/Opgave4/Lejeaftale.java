package Opgave4;

import java.time.LocalDate;
import java.util.ArrayList;

public class Lejeaftale {
    //Fields
    private LocalDate fraDato;
    private LocalDate tilDato;

    private Lejer lejer1;
    private Lejer lejer2;

    //Constructor
    Lejeaftale (LocalDate fraDato) {
        this.fraDato = fraDato;
        this.tilDato = null;
    }

    //Methods
    public LocalDate getFraDato() {
        return fraDato;
    }

    public LocalDate getTilDato() {
        return tilDato;
    }

    public void setTilDato(LocalDate tilDato) {
        this.tilDato = tilDato;
    }

    public void addLejer (Lejer lejer) {
        if (lejer1 == null) {
            lejer1 = lejer;
        } else if (lejer2 == null) {
            lejer2 = lejer;
        }
    }

    public void removeLejer (Lejer lejer) {
        if (lejer1 == lejer) {
            lejer1 = null;
        } else if (lejer2 == lejer) {
            lejer2 = null;
        }
    }

    public Lejer getLejer1() {
        return lejer1;
    }

    public Lejer getLejer2() {
        return lejer2;
    }

    public ArrayList<Lejer> getAllLejere () {
        ArrayList<Lejer> lejere = new ArrayList<>();
        if (lejer1 != null) {
            lejere.add(lejer1);
        }
        if (lejer2 != null) {
            lejere.add(lejer1);
        }
        return lejere;
    }

    public void setLejer1(Lejer lejer1) {
        this.lejer1 = lejer1;
    }

    public void setLejer2(Lejer lejer2) {
        this.lejer2 = lejer2;
    }
}
