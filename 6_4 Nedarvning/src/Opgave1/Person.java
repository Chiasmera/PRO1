package Opgave1;

public class Person {

    //Fields
    private String navn;
    private String adresse;

    //Constructor
    public Person (String navn, String adresse) {
        this.navn = navn;
        this.adresse = adresse;
    }

    //Methods

    public String getNavn() {
        return navn;
    }

    public String getAdresse() {
        return adresse;
    }
}
