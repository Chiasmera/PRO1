package Application.Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Kamp implements Comparable<Kamp> {
    private String sted;
    private LocalDate dato;
    private LocalTime tid;
    private ArrayList<Deltagelse> deltagelser = new ArrayList<>();


    public Kamp(String sted, LocalDate dato, LocalTime tid) {
        this.sted = sted;
        this.dato = dato;
        this.tid = tid;
    }

    public String getSted() {
        return sted;
    }

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getTid() {
        return tid;
    }

    public Deltagelse createDeltagelse(boolean afbud, String begrundelse, Spiller spiller) {
        Deltagelse d1 = new Deltagelse(afbud, begrundelse, spiller);
        deltagelser.add(d1);
        return d1;
    }

    public ArrayList<Deltagelse> getDeltagelser() {
        return new ArrayList<>(deltagelser);
    }

    public ArrayList<String> afbud () {
        ArrayList<String> afbudsStrenge = new ArrayList<>();
        for (Deltagelse d : deltagelser) {
            if (!d.isAfbud()) {
                String afbud = d.getSpiller().getNavn() + "\t:\t" + d.getBegrundelse();
            }
        }
        return afbudsStrenge;
    }

    public void spillerHonorar (String tekstFil) {
        File fil = new File(tekstFil);

        try (PrintWriter out = new PrintWriter(fil)) {
            for (Deltagelse d : deltagelser) {
                if (!d.isAfbud()) {
                    out.println(d.getSpiller().getNavn() + "\t" + d.getSpiller().kampHonorar());
                }
            }

        } catch (FileNotFoundException fileNotFoundException) {
            throw new RuntimeException("File has not been found at the specified path");
        }

    }

    public void setSted(String sted) {
        this.sted = sted;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public void setTid(LocalTime tid) {
        this.tid = tid;
    }

    @Override
    public int compareTo(Kamp k) {
        int returnvalue = dato.compareTo(k.getDato());
        if (returnvalue == 0) {
            returnvalue = tid.compareTo(k.getTid());
        }
        if (returnvalue == 0) {
            returnvalue = sted.compareTo(k.getSted());
        }
        return returnvalue;
    }

    @Override
    public String toString() {
        return sted + "\t" + dato + "\t" + tid;
    }
}
