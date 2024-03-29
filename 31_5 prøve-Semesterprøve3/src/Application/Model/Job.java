package Application.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Timer;

public class Job {
    //Fields
    private String kode;
    private String beskrivelse;
    private LocalDate dato;
    private int timeHonorar;
    private int antalTimer;
    private ArrayList<Vagt> vagter = new ArrayList<>();

    //Constructors

    Job(String kode, String beskrivelse, LocalDate dato, int timeHonorar, int antalTimer) {
        this.kode = kode;
        this.beskrivelse = beskrivelse;
        this.dato = dato;
        this.timeHonorar = timeHonorar;
        this.antalTimer = antalTimer;
    }


    //Methods - Get, Set & link-methods
    public String getKode() {
        return kode;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public LocalDate getDato() {
        return dato;
    }

    public int getTimeHonorar() {
        return timeHonorar;
    }

    public int getAntalTimer() {
        return antalTimer;
    }

    public ArrayList<Vagt> getVagter () {
        return new ArrayList<>(vagter);
    }

    public Vagt createVagt (int timer, Frivillig frivillig) {
        Vagt vagt = new Vagt(timer, this, frivillig);
        vagter.add(vagt);
        return vagt;
    }

    public void removeVagt (Vagt vagt) {
        if (vagter.contains(vagt)) {
            vagter.add(vagt);
        }
    }

    //Methods - Other

    public int ikkeBesattetimer () {
        int timer = antalTimer;
        for ( Vagt vagt : vagter) {
            timer -= vagt.getTimer();
        }
        return timer;
    }

    @Override
    public String toString() {
        return kode +" - "+ dato +  " : "+ antalTimer + " timer, "+timeHonorar+" kr." ;
    }
}
