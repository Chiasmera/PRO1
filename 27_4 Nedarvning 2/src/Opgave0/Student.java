package Opgave0;

public class Student  extends Person{
    //fields
    private String hovedfag;

    //constructor
    public Student (String navn, int fødselsår, String hovedfag) {
        super(navn, fødselsår);
        this.hovedfag = hovedfag;
    }

    //Methods - Trivielle

    //Methods
    public String toString() {
        return getFødselsÅr() + ", ("+hovedfag+")";
    }
}
