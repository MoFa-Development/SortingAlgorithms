package sorting_algorithms.test;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import sorting_algorithms.Sort;

public class SortTest {
    private Sort algorithm;
    private int[] testArr = {1, 3, 3, 7, 4, 2, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    
    /**
     * @param algorithmClass class reference to algorithm class to use
     */
    public SortTest(Class<? extends Sort> algorithmClass) {
        super();
        try {
            this.algorithm = algorithmClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param algorithmClass class reference to algorithm class to use
     * @param arr array to use for testing
     */
    public SortTest(Class<? extends Sort> algorithmClass, int[] arr) {
        this(algorithmClass);
        this.testArr = arr;
    }


    /**
     * Default testing procedure for every algorithm
     */
    public void defaultTest() {
        int[] sortResult = algorithm.sort(testArr);
        System.out.print("Input: ");
        System.out.println(Arrays.toString(testArr));
        System.out.print("Output: ");
        System.out.println(Arrays.toString(sortResult));
        System.out.println("----");
        printAverageRuntime();
    }


    /**
     * @param arr array to sort
     * @param iterations amount of iterations of runtime test
     * @return average of runtime needed to sort `arr` 
     */
    public long testAverageRuntime(int[] arr, int iterations) {
        long averageRuntime = testRuntime(arr);
        long runtime = 0;

        for(int i = 1; i < iterations; i++) {
            runtime = testRuntime(arr);
            averageRuntime = (averageRuntime * (i-1) + runtime) / i;
        }

        return averageRuntime;
    }

    /**
     * Print result of `testAverageRuntime`
     */
    public void printAverageRuntime() {
        int iterations = 100;
        
        long averageRuntime = testAverageRuntime(testArr, iterations);
    
        System.out.print("Runtime Test Iterations: ");
        System.out.println(iterations);
        System.out.print("Average Runtime: ");
        System.out.println(averageRuntime);
    }
    

    /**
     * @param arr array to sort
     * @return runtime needed to sort `arr`
     */
    public long testRuntime(int[] arr) {
        long startTimestamp = System.nanoTime();  
        algorithm.sort(arr);
        long endTimestamp = System.nanoTime();

        return endTimestamp - startTimestamp;
    }

    /**
     * Prints result of `testRuntime`
     */
    public void printRuntime() {
        System.out.print("Runtime: ");
        System.out.println(testRuntime(testArr));
    }
}
