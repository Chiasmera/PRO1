package opgave1_2dobbelArray;

public class Opgave1DobbelArray {

    public static void main(String[] args) {
        int[][] values = {
                {0,4,3,9,6},
                {1,3,5,2,2},
                {3,3,1,0,1},
                {0,0,9,7,1}
        };

        DobbelArrayMethods da = new DobbelArrayMethods();
        System.out.println("Værdien af tabellen udskrives");
        da.udskrivArray(values);

        System.out.println();
        System.out.println("Printer værdien for koordinat (1,3). Forventer resultat er 1");
        System.out.println(da.getValueAt(values, 2,4));
        System.out.println();

        System.out.println("Indsætter værdi 9 på koordinat (1,3). Printer array");
        da.setValueAt(values, 1, 3, 9);
        da.udskrivArray(values);
        System.out.println();

        System.out.println("Summerer række 3 og printer resultat. Forventer 17");
        System.out.println(da.sumRow(values,3));
        System.out.println();

        System.out.println("Summerer kolonne 1 og printer resultat. Forventer 10");
        System.out.println(da.sumCol(values,1));
        System.out.println();


        System.out.println("Summerer hele arrayet og printer resultatet. Forventet 67");
        System.out.println(da.sum(values));
        System.out.println();


    }




}
