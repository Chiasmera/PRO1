package Opgave1;

public class Customer implements Comparable<Customer> {

    //Fields
    private String fornavn;
    private String efternavn;
    private int alder;

    //Constructor
    public Customer(String fornavn, String efternavn, int alder) {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.alder = alder;
    }

    //Methods - Get & set
    public String getFornavn() {
        return fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public int getAlder() {
        return alder;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    //Methods - Other
    @Override
    public int compareTo(Customer o) {
        int returnvalue;
        if (this.efternavn.compareTo(o.getEfternavn()) < 0) {
            returnvalue = -1;
        } else if (this.efternavn.compareTo(o.getEfternavn()) > 0) {
            returnvalue = 1;
        } else if (this.fornavn.compareTo(o.getFornavn()) < 0) {
            returnvalue = -1;
        } else if (this.fornavn.compareTo(o.getFornavn()) > 0) {
            returnvalue = 1;
        } else if (this.alder < o.getAlder()) {
            returnvalue = -1;
        } else if (this.alder > o.getAlder()) {
            returnvalue = 1;
        } else {
            returnvalue = 0;
        }
        return returnvalue;
    }

    @Override
    public String toString() {
        return fornavn + " " + efternavn + " (" + alder + ")";
    }
}
