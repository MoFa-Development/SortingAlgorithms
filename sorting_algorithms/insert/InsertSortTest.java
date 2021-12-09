package sorting_algorithms.insert;

import java.util.stream.Stream;

import sorting_algorithms.test.SortTest;

public class InsertSortTest {
    public static void main(String[] args) {
        System.out.println("\n### INSERT SORT TEST ###");

        SortTest sortTest;
        
        int [] intArr = Stream.of(args)
                    .mapToInt(Integer::parseInt)
                    .toArray();

        if(intArr.length > 0)
            sortTest = new SortTest(InsertSort.class, intArr);
        else
            sortTest = new SortTest(InsertSort.class);
        
        sortTest.defaultTest();
    }
}
