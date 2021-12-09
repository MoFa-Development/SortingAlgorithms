package sorting_algorithms.selection;

import java.util.stream.Stream;

import sorting_algorithms.test.SortTest;

public class SelectionSortTest {
    public static void main(String[] args) {
        System.out.println("\n### SELECTION SORT TEST ###");

        SortTest sortTest = null;
        
        if (args.length > 0) {
            int [] intArr = Stream.of(args)
                        .mapToInt(Integer::parseInt)
                        .toArray();

            
            if(intArr.length > 0) {
                sortTest = new SortTest(SelectionSort.class, intArr);
            }
        } else {
            sortTest = new SortTest(SelectionSort.class);
        }

        sortTest.defaultTest();
    }
}
