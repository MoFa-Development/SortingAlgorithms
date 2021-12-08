package sorting_algorithms.test;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import sorting_algorithms.Sort;

public class SortTest {
    private Sort algorithm;
    private int[] testArr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
    
    public SortTest(Class<? extends Sort> algorithmClass) {
        super();
        try {
            this.algorithm = algorithmClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }

    public SortTest(Class<? extends Sort> algorithmClass, int[] arr) {
        this(algorithmClass);
        this.testArr = arr;
    }

    public void defaultTest() {
        int[] sortResult = algorithm.sort(testArr);
        System.out.println(Arrays.toString(sortResult));
        System.out.println("----");
        printAverageRuntime();
    }

    public void printAverageRuntime() {
        int iterations = 100;
        
        long averageRuntime = testAverageRuntime(testArr, iterations);
    
        System.out.print("Runtime Test Iterations: ");
        System.out.println(iterations);
        System.out.print("Average Runtime: ");
        System.out.println(averageRuntime);
    }

    public long testAverageRuntime(int[] arr, int iterations) {
        long averageRuntime = testRuntime(arr);
        long runtime = 0;

        for(int i = 1; i < iterations; i++) {
            runtime = testRuntime(arr);
            averageRuntime = (averageRuntime * (i-1) + runtime) / i;
        }

        return averageRuntime;
    }

    public void printRuntime() {
        System.out.print("Runtime: ");
        System.out.println(testRuntime(testArr));
    }    

    public long testRuntime(int[] arr) {
        long startTimestamp = System.nanoTime();  
        algorithm.sort(arr);
        long endTimestamp = System.nanoTime();

        return endTimestamp - startTimestamp;
    }
}
