package soegningelevopgaver;

public class Soegning {

    public boolean findUlige(int[] tabel) {
        boolean found = false;
        int i = 0;
        while (!found && i < tabel.length) {
            int k = tabel[i];
            if (k % 2 != 0) {
                found = true;
            } else {
                i++;
            }
        }
        return found;
    }

    /**
     * Finder første instans af et heltal mellem 10-15
     * @param tabel Liste af ints
     * @return første instans af tal mellem 10 og 15
     */
    public int find10Til15 (int[] tabel) {
        int target = -1;
        int i = 0;
        while (target == -1 && i < tabel.length) {
            int k = tabel[i];
            if (k <=15 && k >= 10) {
                target = k;
            } else {
                i++;
            }
        }
        return target;
    }

    /**
     * Returnerer true hvis to ens tal står ved siden af hinanden et sted i arrayet
     * @param tabel Tabellen som løbes igennem
     * @return True hvis to ens tal sår ved siden af hinanden i listen
     */
    public boolean findToEns (int[] tabel) {
        boolean found = false;
        int i = 0;
        while (!found && i < tabel.length-1) {
            int k = tabel[i];
            int kNext = tabel[i+1];
            if (k == kNext) {
                found = true;
            } else i++;
        }
        return found;
    }

    // her skriver du metoder til opgaverne 2,3,5,6 og 7
}
