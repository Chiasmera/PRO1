package measure;

import java.util.ArrayList;

public class SortTester {

    public static void main(String[] args) {

        int testSize = 1000;
        ArrayList<String> bigList = ListGenerator.generateString(testSize, 15);
        String[] bigArray1 = bigList.toArray(new String[0]);
        String[] bigArray2 = bigList.toArray(new String[0]);
        String[] bigArray3 = bigList.toArray(new String[0]);

        // Bubble Sort Test
        for (int i = 0; i < 5; i++) {
            testSize = testSize * 2;
            bigList = ListGenerator.generateString(testSize, 15);

            bigArray1 = bigList.toArray(new String[0]);

            Measurer.start();
            SortMethods.bubbleSort(bigArray1);
            Measurer.stop();
            System.out.println(String.format("BubbleSort (%d) -- Total time in milliseconds: %d",
                    testSize, Measurer.durationMilliSeconds()));
        }

        testSize = 1000;
        System.out.println();

        // Insertion Sort Test
        for (int i = 0; i < 5; i++) {
            testSize = testSize * 2;
            bigList = ListGenerator.generateString(testSize, 15);

            bigArray2 = bigList.toArray(new String[0]);
            Measurer.start();
            SortMethods.insertionSort(bigArray2);
            Measurer.stop();
            System.out.println(String.format("InsertionSort (%d) -- Total time in milliseconds: %d",
                    testSize, Measurer.durationMilliSeconds()));
        }

        testSize = 1000;
        System.out.println();

        // Selection Sort Test
        for (int i = 0; i < 5; i++) {
            testSize = testSize * 2;
            bigList = ListGenerator.generateString(testSize, 15);

            bigArray3 = bigList.toArray(new String[0]);
            Measurer.start();
            SortMethods.selectionSort(bigArray3);
            Measurer.stop();
            System.out.println(String.format("SelectionSort (%d) -- Total time in milliseconds: %d",
                    testSize, Measurer.durationMilliSeconds()));

        }


    }

}
