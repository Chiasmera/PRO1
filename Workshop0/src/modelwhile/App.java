package modelwhile;

public class App {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Loekker loekker = new Loekker();

        //loekker.udskriv1_10();
        //loekker.udskriv1_10_iteration();

        //System.out.println(loekker.summer());
        // System.out.println(loekker.summer(10));
        // System.out.println(loekker.multiplum(4, 3));

		// Kald af metoder der afprøver opgave 1
        System.out.println("print summen af alle lige tal fra 0-100");
		System.out.println(loekker.summerEven());
        System.out.println("print summen af alle kvadrattal fra 0-100");
		System.out.println(loekker.summerSquare());

		// Klad af metoder der afprøver opgave 3
        System.out.println("Print 2 opløftet i alle tal fra 0-20");
        loekker.allPowers();
        System.out.println("print sum af alle ulige tal mellem 3 & 19");
        System.out.println(loekker.sumOdd(3, 19));
        System.out.println("Print sum af ulige cifre i 32677");
        System.out.println(loekker.sumOfOddDigits(32677));

    }
}
