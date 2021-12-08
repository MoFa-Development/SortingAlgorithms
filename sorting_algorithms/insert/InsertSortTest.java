package sorting_algorithms.insert;

import sorting_algorithms.test.SortTest;

public class InsertSortTest {
    public static void main(String[] args) {
        System.out.println("\n### INSERT SORT TEST ###");
        SortTest sortTest = new SortTest(InsertSort.class);
        sortTest.defaultTest();
    }
}
