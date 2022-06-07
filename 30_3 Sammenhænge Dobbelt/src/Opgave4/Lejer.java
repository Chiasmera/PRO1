package Opgave4;

public class Lejer {
    //Fields
    private String navn;
    private String uddannelse;

    //Constructor
    public Lejer (String navn, String uddannelse) {
        this.navn = navn;
        this.uddannelse = uddannelse;
    }

    //Methods
    public String getNavn() {
        return navn;
    }

    public String getUddannelse() {
        return uddannelse;
    }

    public void setUddannelse(String uddannelse) {
        this.uddannelse = uddannelse;
    }
}
