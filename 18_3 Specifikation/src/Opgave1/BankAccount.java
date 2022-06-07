package Opgave1;

/**
 *Modelerer en bankkonto
 */
public class BankAccount {
    //Fields
    static  int lastID = 0;
    int id;

    private double balance;

    /**
     * Initialiserer kontoen med en mængde penge og et unikt ID.
     * @param initialBalance startbalancen på kontoen
     */
    public BankAccount(double initialBalance) {
        balance = initialBalance;
        lastID++;
        this.id = lastID;
    }

    /**
     *Tilføjer angivet mængde penge til kontoen
     * Pre: amount >= 0
     * @param amount mængden af penge som skal indsættes
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * Fjerner angivet mængde penge fra kontoen
     * Pre: amount >= 0
     * @param amount mængden af penge som skal hæves
     */
    public void withdraw(double amount) {
        balance -= amount;
    }

    /**
     * Returnerer balancen på kontoen
     * @return kontoens balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Returnerer det unikke ID
     * @return kontoens ID
     */
    public int getId () {
        return id;
    }

    /**
     * Returnerer antallet af oprettedde kontoer
     * @return antallet af kontoer oprettet
     */
    public static int getNumOfAccounts () {
        return lastID;
    }
}