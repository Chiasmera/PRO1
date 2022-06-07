package Opgave5;

public class App {
    public static void main(String[] args) {
        String teststring1 = "Awesome";
        String teststring2 = "Illicit";

        System.out.println("Tester awesome for 2 ens: "+rowOfX(teststring1,2));
        System.out.println("Tester illicit for 2 ens: "+rowOfX(teststring2,2));
    }



    public static boolean rowOfX (String string, int numberOfSames) {
        boolean rowOfSame = false;
        int i = 0;
        while (!rowOfSame && i <= string.length()-numberOfSames) {
            String substring = string.substring(i,i+numberOfSames);
            int j = 0;
            boolean isSame = true;
            while (j < substring.length()-1 && isSame) {
                if (substring.charAt(j) == substring.charAt(j+1)) {
                    j++;
                } else {
                    isSame = false;
                }
            }

            if (isSame) {
                rowOfSame = true;
            } else {
                i++;
            }
        }
        return rowOfSame;

    }
}
