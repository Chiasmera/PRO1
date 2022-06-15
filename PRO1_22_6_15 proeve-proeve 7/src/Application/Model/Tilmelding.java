package Application.Model;

public class Tilmelding {

    private boolean aktiv;
    private boolean VIPmedlem;
    private Medlem medlem;

    Tilmelding(boolean aktiv, boolean VIPmedlem, Medlem medlem) {
        this.aktiv = aktiv;
        this.VIPmedlem = VIPmedlem;
        this.medlem = medlem;
        medlem.addTilmelding(this);
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public boolean isVIPmedlem() {
        return VIPmedlem;
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

    public void setVIPmedlem(boolean VIPmedlem) {
        this.VIPmedlem = VIPmedlem;
    }

    public Medlem getMedlem() {
        return medlem;
    }

    @Override
    public String toString() {
        String status;
        if (aktiv) {
            status = "Aktiv";
        } else {
            status = "Inaktiv";
        }
        String vip = "";
        if (VIPmedlem) {
            vip = "VIP";
        }
        return medlem.getNavn() + " (" + status + "), "+vip;
    }
}
