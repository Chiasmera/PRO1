package Opgave0;

public class Person {
    //Fields
    private String navn;
    private int fødselsÅr;

    //constructor
    public Person (String navn, int fødselsÅr) {
        this.navn = navn;
        this.fødselsÅr = fødselsÅr;
    }

    //Methods - Trivielle
    public String getNavn () {
        return navn;
    }

    int getFødselsÅr () {
        return fødselsÅr;
    }

    //Methods
    public String toString() {
        return navn + ", " + fødselsÅr;
    }

}
