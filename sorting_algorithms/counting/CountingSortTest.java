package sorting_algorithms.counting;

import java.util.stream.Stream;

import sorting_algorithms.test.SortTest;

public class CountingSortTest {
    public static void main(String[] args) {
        System.out.println("\n### INSERT SORT TEST ###");

        SortTest sortTest = null;
        
        if (args.length > 0) {
            int [] intArr = Stream.of(args)
                        .mapToInt(Integer::parseInt)
                        .toArray();

            
            if(intArr.length > 0) {
                sortTest = new SortTest(CountingSort.class, intArr);
            }
        } else {
            sortTest = new SortTest(CountingSort.class);
        }

        sortTest.defaultTest();
    }
}