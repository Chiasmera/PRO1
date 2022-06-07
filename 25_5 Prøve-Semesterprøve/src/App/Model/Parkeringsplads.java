package App.Model;

import java.time.LocalTime;

public class Parkeringsplads {

    //Fields
    private int nummer;
    private LocalTime ankomst;

    private Parkeringshus parkeringshus;
    private Bil bil;

    //Constructor
    Parkeringsplads(int nummer, Parkeringshus parkeringshus) {
        this.nummer = nummer;
        this.ankomst = null;
        this.parkeringshus = parkeringshus;
        this.bil = null;
    }

    //Methods - Get & Set
    public int getNummer() {
        return nummer;
    }

    public LocalTime getAnkomst() {
        return ankomst;
    }

    public void setAnkomst(LocalTime ankomst) {
        this.ankomst = ankomst;
    }

    public Parkeringshus getParkeringshus() {
        return parkeringshus;
    }

    public Bil getBil() {
        return bil;
    }

    /**
     * Sætter en bil som hørende til pladsen og sætter ankomsttidspunktet til det aktuelle tidspunkt. Hvis Model.Bil er null sættes ankomst til null.
     * @param bil Den bil som er parkeret. Kan være null.
     */
    public void setBil(Bil bil) {
        this.bil = bil;
        if (bil == null) {
            this.ankomst = null;
        } else {
            this.ankomst = LocalTime.now();
        }
    }

    //Methods - other

    /**
     * Beregner prisen for en en parkering, givet et sluttidspunkt for parkeringen. Pris er beregnet med 6 kr pr påbegyndte 10. minut.
     * @param sluttidspunkt Tidspunktet hvor parkeringen slutter
     * @return
     */
    public double beregnPrisForParkering (LocalTime sluttidspunkt) {
        int hours = sluttidspunkt.getHour() - ankomst.getHour();
        int minutter = (hours * 60) + sluttidspunkt.getMinute() - ankomst.getMinute();
        double pris = minutter / 10 * 6;
        return pris;
    }

    /**
     * Fjerner en bil fra parkeringspladsen og opdaterer opdaterer parkeringshusets saldo. Returnerer prisen for parkeringen.
     * @param afhentningstidspunkt Tidspunktet bilen fjernes fra parkeringspladsen
     * @return prisen for parkeringsperioden
     */
    public double hentbil (LocalTime afhentningstidspunkt) {
        double pris = this.beregnPrisForParkering(afhentningstidspunkt);
        parkeringshus.addToSaldo(pris);
        this.setBil(null);
        return pris;
    }

}
