package Application.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Medlem {

    private String navn;
    private String mobil;
    private String mail;
    private ArrayList<Reservation> reservationer = new ArrayList<>();

    public Medlem (String navn, String mobil, String mail) {
        this.navn = navn;
        this.mobil = mobil;
        this.mail = mail;
    }

    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    public String getMail() {
        return mail;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public ArrayList<Reservation> getReservationer() {
        return new ArrayList<>( reservationer);
    }

    public Reservation createReservation (LocalDate dato, LocalTime startTid, Bane bane, Medlem makker) {
        Reservation r1 = new Reservation(dato, startTid, bane, this, makker);
        reservationer.add(r1);
        return r1;
    }

    public void addReservation (Reservation reservation) {
        if (!reservationer.contains(reservation)) {
            reservationer.add(reservation);
        }
    }

    public boolean hasAktivReservation () {
        boolean aktiv = false;
        if (reservationer.size() != 0) {
            int i = 0;
            while (!aktiv && i < reservationer.size()) {
                Reservation current = reservationer.get(i);
                if (current.getDato().compareTo(LocalDate.now()) >= 0 && current.getStartTid().compareTo(LocalTime.now()) >= 0) {
                    aktiv = true;
                }
            }
        }
        return aktiv;
    }

}
