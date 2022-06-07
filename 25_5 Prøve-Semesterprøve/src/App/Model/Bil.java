package App.Model;

/**
 * Test documentation
 * @return somthing dlsnfn
 */
public class Bil {

    //Fields
    private String regNr;
    private Mærke mærke;

    //Constructor
    public Bil (String regNr, Mærke mærke) {
        this.regNr = regNr;
        this.mærke = mærke;
    }

    //Methods - Get & Set
    public String getRegNr() {
        return regNr;
    }

    public Mærke getMærke() {
        return mærke;
    }

    public void setMærke(Mærke mærke) {
        this.mærke = mærke;
    }

    //Methods - other

}
