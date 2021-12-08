package sorting_algorithms.selection.test;

import sorting_algorithms.selection.SelectionSort;
import sorting_algorithms.test.SortTest;

public class SelectionSortTest {
    public static void main(String[] args) {
        SortTest sortTest = new SortTest(SelectionSort.class);
        sortTest.defaultTest();
    }
}
