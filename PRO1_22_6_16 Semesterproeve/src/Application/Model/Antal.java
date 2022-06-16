package Application.Model;

/**
 * Modelerer et antal af påkrævede funktioner for en vagt
 */
public class Antal {

    //Fields    ________________________________________________________________________________________
    private int antal;
    private Funktion funktion;


    //Constructors    ________________________________________________________________________________________
    Antal(int antal, Funktion funktion) {
        this.antal = antal;
        this.funktion = funktion;
    }

    //Methods   -   Get & Set
    public int getAntal() {
        return antal;
    }

    public Funktion getFunktion() {
        return funktion;
    }
}
