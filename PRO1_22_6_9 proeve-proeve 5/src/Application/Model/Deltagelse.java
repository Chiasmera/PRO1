package Application.Model;

public class Deltagelse {

    private boolean afbud;
    private String begrundelse;
    private Spiller spiller;

    Deltagelse(boolean afbud, String begrundelse, Spiller spiller) {
        this.afbud = afbud;
        this.begrundelse = begrundelse;
        this.spiller = spiller;
        spiller.addDeltagelse(this);
    }

    public boolean isAfbud() {
        return afbud;
    }

    public String getBegrundelse() {
        return begrundelse;
    }

    public Spiller getSpiller() {
        return spiller;
    }

    //Kan ikke forstå hvorfor der er brug for denne metode, da spilleren bliver sat ved oprettelse og ikke burde
    // kunne ændres, men opgavne forlanger det
    public void setSpiller(Spiller spiller) {
        if (this.spiller != spiller) {
            Spiller oldSpiller = this.spiller;
            if (oldSpiller != null) {
                oldSpiller.removeDeltagelse(this);
            }
            if (spiller != null) {
                this.spiller = spiller;
                spiller.addDeltagelse(this);
            }
        }
    }


}


