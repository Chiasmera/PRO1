package Application.Model;

public class FrivilligForening extends Frivillig {
    //Fields
    private String foreningsNavn;
    private int antalPersoner;

    public FrivilligForening(String navn, String mobil, int maksAntalTimer) {
        super(navn, mobil, maksAntalTimer);
    }

    //Constructors
    public FrivilligForening(String navn, String mobil, int maksAntalTimer, String foreningsNavn, int antalPersoner) {
        super(navn, mobil, maksAntalTimer);
        this.foreningsNavn = foreningsNavn;
        this.antalPersoner = antalPersoner;
    }

    //Methods - Get, Set & link-methods
    public String getForeningsNavn() {
        return foreningsNavn;
    }

    public int getAntalPersoner() {
        return antalPersoner;
    }


    //Methods - Other

    @Override
    public String toString() {
        return getNavn() + "\t" + antalPersoner + "\t" + foreningsNavn;
    }

}
