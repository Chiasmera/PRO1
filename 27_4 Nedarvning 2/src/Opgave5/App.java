package Opgave5;

public class App {
    public static void main(String[] args) {
        Indkøbsvogn indkøb = new Indkøbsvogn();

        //Opretter forskellige varer
        Foedevare banan = new Foedevare(7,"Banan","En banan", 6);
        System.out.println("En banan koster: "+banan.beregnSalgspris());
        Foedevare færdigpizza = new Foedevare(30,"Færdig Pizza","En klam frossen færdigret", 900);
        System.out.println("En færdigpizza koster: "+færdigpizza.beregnSalgspris());
        Spiritus tequila = new Spiritus(50,"Tequila","Den tequila med hatten",70);
        System.out.println("En tequila koster: "+tequila.beregnSalgspris());
        ElArtikel elkoger = new ElArtikel(250,"Elkoger", "En god elkoger",2000);
        System.out.println("En elkoger koster: "+elkoger.beregnSalgspris());
        Vare toiletpapir = new Vare(50,"Toiletpapir", "Toiletpapir med ekstra styrke");
        System.out.println("toiletpapir koster: "+toiletpapir.beregnSalgspris());

        //Indkøbstur starter
        System.out.println("Nu går jeg på indkøb");
        System.out.println("Jeg skal have 7 bananer og 1 fædigpizza");
        indkøb.addVare(7,banan);
        indkøb.addVare(1,færdigpizza);
        System.out.println("Jeg har nu købt for:"+indkøb.beregnSamletPris());
        System.out.println();
        System.out.println("Jeg skal også have tequila, 2 gange toiletpapir og en ny elkoger");
        indkøb.addVare(1,tequila);
        indkøb.addVare(2,toiletpapir);
        indkøb.addVare(1,elkoger);
        System.out.println("Jeg har nu købt for: "+indkøb.beregnSamletPris());

    }
}
