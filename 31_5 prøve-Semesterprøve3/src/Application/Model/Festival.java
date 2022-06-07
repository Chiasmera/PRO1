package Application.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Festival {
    //Fields
    private String navn;
    private LocalDate fraDato;
    private LocalDate tilDato;
    private ArrayList<Job> jobs = new ArrayList<>();

    //Constructors

    public Festival(String navn, LocalDate fraDato, LocalDate tilDato) {
        this.navn = navn;
        this.fraDato = fraDato;
        this.tilDato = tilDato;
    }


    //Methods - Get, Set & link-methods

    public String getNavn() {
        return navn;
    }

    public LocalDate getFraDato() {
        return fraDato;
    }

    public LocalDate getTilDato() {
        return tilDato;
    }

    public ArrayList<Job> getJobs() {
        return new ArrayList<>(jobs);
    }

    public Job createJob(String kode, String beskrivelse, LocalDate dato, int timehonorar, int antalTimer) {
        Job job = new Job(kode, beskrivelse, dato, timehonorar, antalTimer);
        jobs.add(job);
        return job;
    }

    public void removeJob(Job job) {
        if (jobs.contains(job)) {
            jobs.remove(job);
        }
    }


    //Methods - Other
    public int budgetteretJobUdgift() {
        int sum = 0;
        for (Job job : jobs) {
            sum += job.getAntalTimer() * job.getTimeHonorar();
        }
        return sum;
    }

    public int realiseretJobUdgift() {
        int sum = 0;
        for (Job job : jobs) {
            int vagttimer = 0;
            for (Vagt vagt : job.getVagter()) {
                vagttimer += vagt.getTimer();
            }
            sum += vagttimer * job.getTimeHonorar();
        }
        return sum;
    }

    public ArrayList<String> gaverTilFrivillige() {
        ArrayList<Frivillig> gaveVærdige = new ArrayList<>();
        for (Job job : jobs) {
            for (Vagt vagt : job.getVagter()) {
                if (!gaveVærdige.contains(vagt.getFrivillig())) {
                    gaveVærdige.add(vagt.getFrivillig());
                }
            }
        }

        ArrayList<String> gaveListe = new ArrayList<>();
        for (Frivillig frivillig : gaveVærdige) {
            gaveListe.add(frivillig.toString());
        }
        insertSortStringList(gaveListe);

        return gaveListe;
    }

    private ArrayList<String> insertSortStringList(ArrayList<String> list) {
        for (int i = 1; i < list.size(); i++) {
            String next = list.get(i);
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.compareTo(list.get(j - 1)) >= 0) {
                    found = true;
                } else {
                    j--;
                }
            }
            list.add(j, next);
            list.remove(i+1);
        }
        return list;
    }

    @Override
    public String toString() {
        return navn + ": " +fraDato+ " " + tilDato;
    }
}
