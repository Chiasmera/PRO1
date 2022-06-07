package opgave4barchart;

import java.util.ArrayList;
import java.util.Scanner;

public class BarChart {
    private ArrayList<BarLine> list = new ArrayList<>();

    public ArrayList<BarLine> readValues() {
        System.out.println("Indtast dine overskrifter nu. afslut med AFSLUT.");

        Scanner in = new Scanner(System.in);
        String title = in.next();
        while (!title.equalsIgnoreCase("afslut") ) {
            BarLine barline = new BarLine(title);
            list.add(barline);
            title = in.next();
        }

        in = new Scanner(System.in);

        int n;
        int i = 0;
        while (i < list.size()) {
            System.out.println("Indtast nu en værdi for "+ list.get(i).getTitle());
            n = in.nextInt();
            list.get(i).setValue(n);

            i++;
        }

        in.close();
        return list;
    }

    /**
     * Finds and returns the max value in the list.
     *
     * @param list the list with values.
     * @return the max value found.
     */
    public int findMax(ArrayList<BarLine> list) {
        int max = list.get(0).getValue();
        for ( int i = 1; i < list.size(); i++) {
            if (list.get(i).getValue() > max) {
                max = list.get(i).getValue();
            }
        }
        return max;
    }

    /**
     * Prints out a BarChart of the values using the System.out.println method.
     */
    public void printBarChart() {
        int max = findMax(this.list);
        final int MAX_VALUE = 40;

        for (int i = 0; i < list.size(); i++) {

            int starsCount =  MAX_VALUE / max * list.get(i).getValue();
            System.out.print(list.get(i).getTitle()+ "\t");
            for (int j = 0; j < starsCount; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }
}
