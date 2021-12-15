package sorting_algorithms.test;

import sorting_algorithms.insert.InsertSort;
import sorting_algorithms.selection.SelectionSort;
import sorting_algorithms.quick.QuickSort;

public class AllAlgorithmsTest {

    static final int TEST_ARR_LEN = 10_000;
    static final int TEST_ARR_VAL_MIN = 0;
    static final int TEST_ARR_VAL_MAX = 1337;

    public static void main(String[] args) {
        int[] testArr;

        if (args.length > 0) {
            long seed = Integer.parseInt(args[0]);
            testArr = SortTest.createRandomTestArr(TEST_ARR_LEN, TEST_ARR_VAL_MIN, TEST_ARR_VAL_MAX, seed);
        } else {
            testArr = SortTest.createRandomTestArr(TEST_ARR_LEN, TEST_ARR_VAL_MIN, TEST_ARR_VAL_MIN);
        }

        SortTest insert = new SortTest(InsertSort.class, testArr);
        SortTest selection = new SortTest(SelectionSort.class, testArr);
        SortTest quick = new SortTest(QuickSort.class, testArr);

        System.out.println("\n### INSERT SORT ###");
        insert.defaultTest();

        System.out.println("\n### SELECTION SORT ###");
        selection.defaultTest();

        System.out.println("\n### QUICK SORT ###");
        quick.defaultTest();
    }
}
