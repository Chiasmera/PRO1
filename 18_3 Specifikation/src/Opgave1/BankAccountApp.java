package Opgave1;

public class BankAccountApp {
    public static void main(String[] args) {
        BankAccount konto1 = new BankAccount(1000);
        System.out.println("opretter ny konto med 1000 kr");

        konto1.deposit(100);
        System.out.println("sætter 100 kr ind og viser balancen");
        System.out.println(konto1.getBalance());

        System.out.println("printer kontoens ID");
        System.out.println(konto1.getId());

        System.out.println("opretter 2 nye kontoer og printer alle kontoers ID");
        System.out.println(konto1.getId());
        BankAccount konto2 = new BankAccount(100);
        System.out.println(konto2.getId());
        BankAccount konto3 = new BankAccount(500);
        System.out.println(konto3.getId());

        System.out.println("printer antallet af bankkontoer");
        System.out.println(BankAccount.getNumOfAccounts());

    }
}
