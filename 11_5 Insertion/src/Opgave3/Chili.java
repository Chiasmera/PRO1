package Opgave3;

public class Chili implements Measureable {
    //Fields
    private String navn;
    private int styrke;

    //Constructor
    public Chili (String navn, int styrke) {
        this.navn = navn;
        this.styrke = styrke;
    }

    //Methods - Get & Set

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getStyrke() {
        return styrke;
    }

    public void setStyrke(int styrke) {
        this.styrke = styrke;
    }



    //Methods - other
     @Override
        public double getMeasure() {
            return getStyrke();
        }

    @Override
    public String toString() {
        return navn + " ("+styrke+")";
    }
}


