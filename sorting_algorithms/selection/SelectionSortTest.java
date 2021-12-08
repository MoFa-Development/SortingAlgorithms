package sorting_algorithms.selection;

import sorting_algorithms.test.SortTest;

public class SelectionSortTest {
    public static void main(String[] args) {
        System.out.println("\n### SELECTION SORT TEST ###");
        SortTest sortTest = new SortTest(SelectionSort.class);
        sortTest.defaultTest();
    }
}
