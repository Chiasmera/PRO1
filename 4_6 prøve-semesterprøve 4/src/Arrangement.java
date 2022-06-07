import java.time.LocalDate;
import java.time.LocalTime;

public class Arrangement {
    //Fields
    private String titel;
    private LocalDate date;
    private LocalTime startTid;
    private LocalTime slutTid;
    private double pris;

    //Constructors
    public Arrangement ( String titel, LocalDate date, LocalTime startTid, LocalTime slutTid, double pris) {
        this.titel = titel;
        this.date = date;
        this.startTid = startTid;
        this.slutTid = slutTid;
        this.pris = pris;
    }

    //Methods - Get, Set, add & remove

    public String getTitel() {
        return titel;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTid() {
        return startTid;
    }

    public LocalTime getSlutTid() {
        return slutTid;
    }

    public double getPris() {
        return pris;
    }


    //Methods - other

}
