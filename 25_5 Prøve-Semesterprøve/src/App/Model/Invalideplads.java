package App.Model;

import java.time.LocalTime;

public class Invalideplads extends Parkeringsplads {


    //Fields
    private double areal;

    //Constructor
    Invalideplads(int nummer, Parkeringshus parkeringshus, double areal) {
        super(nummer, parkeringshus);
    }

    //Methods - Get & Set
    public double getAreal() {
        return areal;
    }


    //Methods - other
    /**
     * Beregner prisen for en en parkering, givet et sluttidspunkt for parkeringen. Pris er 0 for invalideparkering.
     * @param sluttidspunkt Tidspunktet hvor parkeringen slutter
     * @return
     */
    @Override
    public double beregnPrisForParkering (LocalTime sluttidspunkt) {
        return 0.0;
    }

}
