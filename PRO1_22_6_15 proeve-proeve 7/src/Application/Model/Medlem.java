package Application.Model;

import java.util.ArrayList;

public class Medlem implements Comparable<Medlem>{

    private String navn;
    private String adresse;
    private String email;
    private String mobiltlf;
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    public Medlem(String navn, String adresse, String email, String mobiltlf) {
        this.navn = navn;
        this.adresse = adresse;
        this.email = email;
        this.mobiltlf = mobiltlf;
    }

    public String getNavn() {
        return navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public String getMobiltlf() {
        return mobiltlf;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobiltlf(String mobiltlf) {
        this.mobiltlf = mobiltlf;
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    public void addTilmelding (Tilmelding tilmelding) {
        if (!tilmeldinger.contains(tilmelding)) {
            tilmeldinger.add(tilmelding);
        }
    }

    public void removeTilmelding (Tilmelding tilmelding) {
        if (tilmeldinger.contains(tilmelding)) {
            tilmeldinger.remove(tilmelding);
        }
    }

    @Override
    public int compareTo(Medlem o) {
        return this.navn.compareTo(o.getNavn());
    }
}
