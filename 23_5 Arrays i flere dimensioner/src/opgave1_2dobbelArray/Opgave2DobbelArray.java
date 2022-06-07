package opgave1_2dobbelArray;

public class Opgave2DobbelArray {

    public static void main(String[] args) {
        final int ROW = 8;
        final int COL = 8;
        int[][] values = new int[ROW][COL];
        DobbelArrayMethods da = new DobbelArrayMethods();

        //Udskriv values på tabel form
        da.udskrivArray(values);
        

        /**
         * Indsætter 5 på alle pladser
         */
        for (int row = 0; row < values.length; row++) {
            for (int col = 0; col < values[row].length; col++) {
                da.setValueAt(values,row,col,5);
            }
        }

        System.out.println();
        System.out.println("Nedenfor skulle der stå 5 på alle pladser");
        System.out.println();
        da.udskrivArray(values);


        /**
         * Indsætter 2 i lige rækker og 3 i ulige rækker
         */
        for (int row = 0; row < values.length; row++) {
            int value = 0;
            if (row % 2 == 0) {
                value = 2;
            } else {
                value = 3;
            }
            for (int col = 0; col < values[row].length; col++) {
                da.setValueAt(values,row,col,value);
            }
        }

        System.out.println();
        System.out.println("Nedenfor skulle der stå 2 og 3 på hver anden række");
        System.out.println();
        da.udskrivArray(values);
        

        /**
         * indsætter 2 i lige kolonner og 3 i ulige kolonner
         */
        for (int row = 0; row < values.length; row++) {

            for (int col = 0; col < values[row].length; col++) {
                int value = 0;
                if (col % 2 == 0) {
                    value = 2;
                } else {
                    value = 3;
                }
                da.setValueAt(values,row,col,value);
            }
        }

        System.out.println();
        System.out.println("Nedenfor skulle der stå 2 og 3 på hver anden søjle");
        System.out.println();
        da.udskrivArray(values);


        /**
         * Udfylder arrayet med skfitende 1'er og 0'er, som ppå et skakbræt
         */

        for (int row = 0; row < values.length; row++) {
            for (int col = 0; col < values[row].length; col++) {
                if (row % 2 == 0) {
                    if (col % 2 == 0) {
                        da.setValueAt(values,row,col,1);
                    } else {
                        da.setValueAt(values, row, col, 0);
                    }
                } else {
                    if (col % 2 == 0) {
                        da.setValueAt(values,row,col,0);
                    } else {
                        da.setValueAt(values, row, col, 1);
                    }
                }

            }
        }
        System.out.println();
        System.out.println("Nedenfor skulle der stå 0 og 1 på alle pladser som på skakbræt");
        System.out.println();
        da.udskrivArray(values);

        // TODO Opgave 2.5 lav ændringer så alle elementer i nederste og øverste række samt første
        // og sidste søjle er 5 og resten skal være 2.

        /**
         * Indsætter 2 i yderste rækker og kolonner
         */
        for (int row = 0; row < values.length; row++) {
            for (int col = 0; col < values[row].length; col++) {
                if ( row == 0 || row == values.length-1 || col == 0 || col == values[row].length-1) {
                    da.setValueAt(values, row, col, 5);
                } else {
                    da.setValueAt(values, row, col, 2);
                }
            }
        }

        System.out.println();
        System.out.println("Nedenfor skulle der stå 5 i kanten og 2 ellers");
        System.out.println();
        da.udskrivArray(values);


    }



}
