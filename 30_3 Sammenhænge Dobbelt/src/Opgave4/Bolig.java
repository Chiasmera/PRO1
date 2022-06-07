package Opgave4;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bolig {
    //Fields
    private int kvm;
    private String adresse;
    private int prisPerMåned;

    private Kollegie kollegie;
    private ArrayList<Lejeaftale> lejeaftaler = new ArrayList<>();

    //Constructor
    public Bolig (int kvm, String adresse, int prisPerMåned, Kollegie kollegie) {
        this.kvm = kvm;
        this.adresse = adresse;
        this.prisPerMåned = prisPerMåned;
        this.kollegie = kollegie;
    }

    //Methods
    public String getAdresse() {
        return adresse;
    }

    public int getKvm() {
        return kvm;
    }

    public int getPrisPerMåned() {
        return prisPerMåned;
    }
    public void setPrisPerMåned (int prisPerMåned) {
        this.prisPerMåned = prisPerMåned;
    }

    public Kollegie getKollegie() {
        return kollegie;
    }

    public void createLejeaftale (LocalDate fraDato) {
        Lejeaftale l = new Lejeaftale(fraDato);
        lejeaftaler.add(l);
    }

    public void removeLejeaftale (Lejeaftale lejeaftale) {
        if (lejeaftaler.contains(lejeaftale)) {
            lejeaftaler.remove(lejeaftale);
        }
    }

    public ArrayList<Lejeaftale> getLejeaftaler() {
        return new ArrayList<>(lejeaftaler);
    }
}
