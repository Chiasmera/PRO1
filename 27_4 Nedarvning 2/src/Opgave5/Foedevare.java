package Opgave5;

public class Foedevare extends Vare{
    //field
    private int holdbarhed;

    //Constructor
    public Foedevare (int pris, String navn, String beskrivelse, int holdbarhed) {
        super(pris,navn,beskrivelse);
        this.holdbarhed = holdbarhed;
        setMoms(5);
    }

    //Methods
    public int getHoldbarhed() {
        return holdbarhed;
    }
}
