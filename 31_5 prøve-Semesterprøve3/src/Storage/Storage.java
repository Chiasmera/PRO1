package Storage;

import Application.Model.Festival;
import Application.Model.Frivillig;

import java.util.ArrayList;

public class Storage {

    //Lists
    private static ArrayList<Festival> festivaller = new ArrayList<>();
    private static ArrayList<Frivillig> frivillige = new ArrayList<>();

    // Add-Methods
    public static void addFestival (Festival festival) {
        if (!festivaller.contains(festival)) {
            festivaller.add(festival);
        }
    }

    public static void addFrivillig (Frivillig frivillig) {
        if (!frivillige.contains((frivillig) )) {
            frivillige.add(frivillig);
        }
    }

    //Get-Methods
    public static ArrayList<Festival> getFestivaller () {
        return new ArrayList<>(festivaller);
    }

    public static ArrayList<Frivillig> getFrivillige () {
        return new ArrayList<>(frivillige);
    }

}
