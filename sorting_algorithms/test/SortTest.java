package sorting_algorithms.test;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;

import sorting_algorithms.Sort;

public class SortTest {

    private Sort algorithm;
    private int[] testArr = {1, 3, 3, 7, 4, 2, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    
    private int compares;
    private int reads;
    private int writes;
    
    /**
     * @param algorithmClass class reference to algorithm class to use
     */
    public SortTest(Class<? extends Sort> algorithmClass) {        
        try {
            this.algorithm = algorithmClass.getDeclaredConstructor(this.getClass()).newInstance(this);
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
     * @param length length of the output array
     * @param min minimum of range the values are in
     * @param max maximum of range the values are in
     * @return randomly generated array accorting to given parameters
     */
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
        // int[] sortResult = algorithm.sort(testArr);
        // System.out.print("Input: ");
        // System.out.println(Arrays.toString(testArr));
        // System.out.print("Output: ");
        // System.out.println(Arrays.toString(sortResult));
        // System.out.println("----");
        System.out.print("Length of array: ");
        System.out.println(testArr.length);
        printAverageRuntime();
        printOperations();
    }


    /**
     * @param arr array to sort
     * @param sampleAmount amount of iterations of runtime test
     * @return average of runtime needed to sort `arr` 
     */
    public long testAverageRuntime(int[] arr, int sampleAmount) {
        long averageRuntime = testRuntime(arr);
        long runtime = 0;

        for(int i = 1; i < sampleAmount; i++) {
            runtime = testRuntime(arr);
            averageRuntime = (averageRuntime * (i-1) + runtime) / i;
        }

        return averageRuntime;
    }

    /**
     * Print result of `testAverageRuntime`
     */
    public void printAverageRuntime() {
        int sampleAmount = 100;
        
        long averageRuntime = testAverageRuntime(testArr, sampleAmount);
    
        System.out.print("Average Runtime: ");
        System.out.print(averageRuntime);
        System.out.print(" nanoseconds (for ");
        System.out.print(sampleAmount);
        System.out.println(" samples)");
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

    /**
     * Resets operation counts and runs sort once
     */
    public void testOperations() {
        reads = 0;
        writes = 0;
        compares = 0;
        
        algorithm.sort(testArr);
    }

    /**
     * Prints data created by `testOperations` if supported by given algorithm
     */
    public void printOperations() {
        if(algorithm.givesReports()) {
            testOperations();

            System.out.print("Reads: ");
            System.out.println(reads);
            System.out.print("Writes: ");
            System.out.println(writes);
            System.out.print("Compares: ");
            System.out.println(compares);
        } else {
            System.out.println("Operation count not implemented.");
        }
    }

    /**
     * Handles compare operation report
     */
    public void reportCompare() {
        this.compares++;
    }

    /**
     * Handles compare operation(s) report
     * @param amount amount of operations
     */
    public void reportCompare(int amount) {
        this.compares += amount;
    }

    /**
     * Handles read operation report
     */
    public void reportRead() {
        this.reads++;
    }

    /**
     * Handles read operation(s) report
     * @param amount amount of operations
     */
    public void reportRead(int amount) {
        this.reads += amount;
    }

    /**
     * Handles write operation report
     */
    public void reportWrite() {
        this.writes++;
    }

    /**
     * Handles write operation(s) report
     * @param amount amount of operations
     */
    public void reportWrite(int amount) {
        this.writes += amount;
    }
}
