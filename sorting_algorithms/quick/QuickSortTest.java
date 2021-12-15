package sorting_algorithms.quick;

import java.util.stream.Stream;

import sorting_algorithms.test.SortTest;

public class QuickSortTest {
    public static void main(String[] args) {
        System.out.println("\n### QUICK SORT TEST ###");

        SortTest sortTest = null;
        
        if (args.length > 0) {
            int [] intArr = Stream.of(args)
                        .mapToInt(Integer::parseInt)
                        .toArray();

            
            if(intArr.length > 0) {
                sortTest = new SortTest(QuickSort.class, intArr);
            }
        } else {
            sortTest = new SortTest(QuickSort.class);
        }

        sortTest.defaultTest();
    }
}
