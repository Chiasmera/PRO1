package Opgave2;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class RentalApp {
    public static void main(String[] args) {
        LocalDate førsteStart = LocalDate.now().withDayOfMonth(1).plusMonths(1);
        Rental udlejning1 = new Rental(1, 10,120,førsteStart);

        LocalDate andenStart = LocalDate.now().plusMonths(10);
        Rental udlejning2 = new Rental(2,30,120,andenStart);

        System.out.println("Første udlejning");
        System.out.println("Total pris: "+udlejning1.getTotalPrice());
        System.out.println("Dag før startdato: "+udlejning1.getStartDate().minusDays(1));
        System.out.println("Slutdato: "+udlejning1.getEndDate());
        System.out.println("______________________");
        System.out.println();

        System.out.println("anden udlejning");
        System.out.println("Total pris: "+udlejning2.getTotalPrice());
        System.out.println("Dag før startdato: "+udlejning2.getStartDate().minusDays(1));
        System.out.println("Slutdato: "+udlejning2.getEndDate());
        System.out.println("______________________");
        System.out.println();

        long årMellem = førsteStart.until(andenStart,ChronoUnit.YEARS);
        long månederMellem = førsteStart.until(andenStart,ChronoUnit.MONTHS);
        long dageMellem = førsteStart.until(andenStart, ChronoUnit.DAYS);

        System.out.println("Tid mellem de to udlejninger:");
        System.out.println("År: "+årMellem);
        System.out.println("Måneder: "+ månederMellem);
        System.out.println("Dage: "+ dageMellem);
        System.out.println("-----------------------");
        System.out.println();
    }
}
