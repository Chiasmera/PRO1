package Application.Model;

import java.util.ArrayList;

public class Hold {
    private  String navn;
    private  String disciplin;
    private int maxAntal;

    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    public Hold(String navn, String disciplin, int maxAntal) {
        this.navn = navn;
        this.disciplin = disciplin;
        this.maxAntal = maxAntal;
    }

    public String getNavn() {
        return navn;
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    public String getDisciplin() {
        return disciplin;
    }

    public int getMaxAntal() {
        return maxAntal;
    }

    public Tilmelding createTilmelding (boolean aktiv, boolean VIPmedlem, Medlem medlem) {
        Tilmelding t1 = new Tilmelding(aktiv, VIPmedlem, medlem);
        tilmeldinger.add(t1);
        return t1;
    }

    public void removeTilmelding (Tilmelding tilmelding) {
        if (tilmeldinger.contains(tilmelding)) {
            tilmeldinger.remove(tilmelding);
        }
    }

    /**
     * Returnerer antallet af tilmelde medlemmer fra en specifik adresse
     * @param adresse adressen som søges på
     * @return antallet af medlemmer på adressen
     */
    public int getAntalTilmeldinger (String adresse) {
        int sum = 0;
        for (Tilmelding t : tilmeldinger) {
            if (t.getMedlem().getAdresse().equalsIgnoreCase(adresse)) {
                sum++;
            }
        }
        return sum;
    }

    /**
     * Returnerer det første medlem som er VIP. Returnerer null hvis ingen findes blandt tilmeldinger
     * @return Model.Medlem som er VIP eller null hvis ingen findes
     */
    public Medlem findVIPMedlem () {
        int i = 0;
        Medlem vip = null;
        while (i < tilmeldinger.size() && vip == null) {
            if (tilmeldinger.get(i).isVIPmedlem()) {
                vip = tilmeldinger.get(i).getMedlem();
            }
            i++;
        }
        return vip;
    }

    @Override
    public String toString() {
        return navn + " ("+disciplin+"), Max: "+maxAntal;
    }
}
