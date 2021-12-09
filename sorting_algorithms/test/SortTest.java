package sorting_algorithms.test;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Random;

import sorting_algorithms.Sort;

public class SortTest {
    private Random rand;

    private Sort algorithm;
    private int[] testArr = {1, 3, 3, 7, 4, 2, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    
    private int compares;
    private int reads;
    private int writes;
    
    /**
     * @param algorithmClass class reference to algorithm class to use
     */
    public SortTest(Class<? extends Sort> algorithmClass) {
        this.rand = new Random();
        
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


    public static int[] createRandomTestArr(int length, int min, int max) {
        int[] testArr = new int[length];

        for(int i = 0; i < length; i++) {
            testArr[i] = new Random().nextInt(max-min)+min;
        }

        return testArr;
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
        printOperations();
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


    public void testOperations() {
        reads = 0;
        writes = 0;
        compares = 0;

        algorithm.sort(testArr);
    }

    public void printOperations() {
        testOperations();

        System.out.print("Reads: ");
        System.out.println(reads);
        System.out.print("Writes: ");
        System.out.println(writes);
        System.out.print("Compares: ");
        System.out.println(compares);
    }

    public void reportCompare() {
        this.compares++;
    }

    public void reportRead() {
        this.reads++;
    }

    public void reportWrite() {
        this.writes++;
    }
}
