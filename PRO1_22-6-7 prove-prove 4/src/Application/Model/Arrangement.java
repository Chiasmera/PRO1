package Application.Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Arrangement {
    private String titel;
    private LocalDate date;
    private LocalTime startTid;
    private LocalTime slutTid;
    private double price;

    public Arrangement (String titel, LocalDate date, LocalTime startTid, LocalTime slutTid, double price) {
        this.titel = titel;
        this.date = date;
        this.startTid = startTid;
        this.slutTid = slutTid;
        this.price = price;
    }

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

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return titel + "\t" + date + "\t" + startTid + " - " + slutTid;
    }
}
