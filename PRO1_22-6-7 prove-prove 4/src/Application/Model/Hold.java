package Application.Model;

import java.util.ArrayList;

public class Hold {
    private String betegnelse;
    private String holdleder;
    private Uddannelse uddannelse;
    private ArrayList<Tutor> tutorer = new ArrayList<>();

    Hold(String betegnelse, String holdleder, Uddannelse uddannelse) {
        this.betegnelse = betegnelse;
        this.holdleder = holdleder;
    }

    public String getBetegnelse() {
        return betegnelse;
    }

    public String getHoldleder() {
        return holdleder;
    }

    public Uddannelse getUddannelse() {
        return uddannelse;
    }


    public ArrayList<Tutor> getTutorer() {
        return new ArrayList<>(tutorer);
    }

    public void addTutor(Tutor tutor) {
        if (!tutorer.contains(tutor)) {
            tutorer.add(tutor);
            tutor.setHold(this);
        }
    }

    public void removeTutor(Tutor tutor) {
        if (tutorer.contains(tutor)) {
            tutorer.remove(tutor);
            tutor.setHold(null);
        }
    }

    public double arrangementPris() {
        double sum = 0;
        for (Tutor t : tutorer) {
            sum += t.arrangementPris();
        }
        return sum;
    }

    public boolean harTidsoverlap(Arrangement arrangement) {
        boolean found = false;
        for (Tutor t : tutorer) {
            int i = 0;
            while (i < t.getArrangementer().size() && !found) {
                Arrangement currentArrangement = t.getArrangementer().get(i);
                if (currentArrangement.getDate() == arrangement.getDate()) {
                    if (currentArrangement.getStartTid().isBefore(arrangement.getSlutTid())) {
                        if (!currentArrangement.getSlutTid().isBefore(arrangement.getStartTid())) {
                            found = true;
                        }
                    }

                }
            i++;
            }
        }
        return found;
    }
}
