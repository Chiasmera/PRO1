package Opgave5;

public class HøjesteKvadratrod {

    public int højesteKvadrattalLinaer(int måleelement) {
        int result = 0;
        int kandidat = 0;
        while (kandidat * kandidat <= måleelement) {
                result = kandidat;
                kandidat++;
        }
        return result;
    }

    public int højesteKvadrattalBinaer (int måleelement) {
        int result = 0;
        int left = 0;
        int right = måleelement;

        while (left <= right) {
            int middle = (left + right) / 2;
            if (middle*middle == måleelement) {
                result = middle;
                return result;
            } else if (middle*middle > måleelement) {
                right = middle-1;
            } else {
                left = middle +1;
                result = middle;
            }
        }
        return result;
    }


    public static void main(String[] args) {

        HøjesteKvadratrod kvadratrod1 = new HøjesteKvadratrod();

        System.out.println("Linaer:");
        System.out.println("Søger efter højeste kvadrattal for 27: " + kvadratrod1.højesteKvadrattalLinaer(27));
        System.out.println("Søger efter højeste kvadrattal for 30: " + kvadratrod1.højesteKvadrattalLinaer(30));
        System.out.println("Søger efter højeste kvadrattal for 75: " + kvadratrod1.højesteKvadrattalLinaer(75));
        System.out.println("Søger efter højeste kvadrattal for 100: " + kvadratrod1.højesteKvadrattalLinaer(100));
        System.out.println("Søger efter højeste kvadrattal for 92: " + kvadratrod1.højesteKvadrattalLinaer(92));

        System.out.println("Binaer:");
        System.out.println("Søger efter højeste kvadrattal for 27: " + kvadratrod1.højesteKvadrattalBinaer(27));
        System.out.println("Søger efter højeste kvadrattal for 30: " + kvadratrod1.højesteKvadrattalBinaer(30));
        System.out.println("Søger efter højeste kvadrattal for 75: " + kvadratrod1.højesteKvadrattalBinaer(75));
        System.out.println("Søger efter højeste kvadrattal for 100: " + kvadratrod1.højesteKvadrattalBinaer(100));
        System.out.println("Søger efter højeste kvadrattal for 92: " + kvadratrod1.højesteKvadrattalBinaer(92));
    }
}
