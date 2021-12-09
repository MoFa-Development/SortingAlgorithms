package sorting_algorithms;

import sorting_algorithms.test.SortTest;

/**
 * Sort
 */
public abstract class Sort {
    public static boolean givesReport = false;
    protected SortTest callbackSortTest;
    
    protected Sort() {
        this.callbackSortTest = null;
    }

    protected Sort(SortTest callbackSortTest) {
        this.callbackSortTest = callbackSortTest;
    };

    public abstract int[] sort(int[] inputArr);
    
    protected void reportRead() {
        if(callbackSortTest != null) {
            callbackSortTest.reportRead();
        }
    }
    protected void reportWrite() {
        if(callbackSortTest != null) {
            callbackSortTest.reportWrite();
        }
    }
    protected void reportCompare() {
        if(callbackSortTest != null) {
            callbackSortTest.reportCompare();
        }
    }
}