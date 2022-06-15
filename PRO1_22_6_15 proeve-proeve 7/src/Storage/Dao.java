package Storage;

import Application.Model.Hold;
import Application.Model.Medlem;

import java.util.ArrayList;

public class Dao {

    private static ArrayList<Medlem> medlemmer = new ArrayList<>();
    private  static ArrayList<Hold> alleHold = new ArrayList<>();

    public static ArrayList<Medlem> getMedlemmer() {
        return new ArrayList<>(medlemmer);
    }

    public static ArrayList<Hold> getHold() {
        return new ArrayList<>(alleHold);
    }

    public static void addHold (Hold hold) {
        if (!alleHold.contains(hold)) {
            alleHold.add(hold);
        }
    }

/*    public   static void addMedlem (Medlem medlem) {
        if (!medlemmer.contains(medlem)) {
            medlemmer.add(medlem);
        }
    }*/

    /**
     * indsætter et medlem sådan at listen er sorteret efter indsættelsen
     * @param medlem medlemmet som skal indsættes
     */
    public static void indsætMedlem (Medlem medlem) {
        if (medlemmer.size() == 0) {
            medlemmer.add(medlem);
        } else if (!medlemmer.contains(medlem)) {
            for (int i = 1; i < medlemmer.size(); i++) {
                int j = i;
                boolean found = false;
                while (!found && j > 0) {
                    if (medlem.compareTo(medlemmer.get(j-1)) >= 0) {
                        found = true;
                    } else {
                        j--;
                    }
                }
                medlemmer.add(medlem);
            }
        }

    }
}
