package Application.Model;

/**
 * Modelerer både en funktion som er påkrævet for en vagt, og en matchende kompetence for en medarbejder
 */
public class Funktion {

    //Fields    ________________________________________________________________________________________
    private String navn;

    //Constructors    ________________________________________________________________________________________
    public Funktion(String navn) {
        this.navn = navn;
    }

    //Methods   -   Get & Set
    public String getNavn() {
        return navn;
    }
}
