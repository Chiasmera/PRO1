package Opgave1;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Mekaniker m1 = new Mekaniker("Julius", "Onsholtvej", 2007,187);
        Mekaniker m2 = new Mekaniker("Hans", "Svendborgvej", 2001, 165);
        Mekaniker m3 = new Mekaniker("Svend", "Sogade", 1999, 150);
        Værkfører v1 = new Værkfører("Thomas", "Helvede", 1880,200, 1990, 100);
        Værkfører v2 = new Værkfører("Troels", "Himmelen", 1975,192, 1995, 90);


        ArrayList<Ansat> ansatte = new ArrayList<>();
        ansatte.add(m1);
        ansatte.add(m2);
        ansatte.add(m3);
        ansatte.add(v1);
        ansatte.add(v2);


        System.out.println(samletUgeLoen(ansatte));

        Synsmand s1 = new Synsmand("Jens-Hansen", "Rolighedsvej", 2008, 164);
        s1.setSynPerUge(13);
        ansatte.add(s1);

        System.out.println(samletUgeLoen(ansatte));

        Arbejdsdreng a1 = new Arbejdsdreng("Kevin", "Intetvej 26", 50);
        ansatte.add(a1);
    }

    /**
     * beregner summen af ugelønnen for alle i listen
     */
    public static double samletUgeLoen (ArrayList<Ansat> ansatte) {
        double sum = 0;
        for (Ansat a : ansatte) {
            sum += a.ugeLoen();
        }
        return sum;
    }
}
