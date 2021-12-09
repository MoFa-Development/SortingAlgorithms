package sorting_algorithms;

import sorting_algorithms.test.SortTest;

/**
 * Sort
 */
public abstract class Sort {
    protected SortTest callbackSortTest;
    
    protected Sort() {
        this.callbackSortTest = null;
    }

    protected Sort(SortTest callbackSortTest) {
        this.callbackSortTest = callbackSortTest;
    }

    /**
     * @return true if the algorithm supports operation counting
     */
    public abstract boolean givesReports();

    /**
     * @param inputArr array to sort
     * @return sorted array
     */
    public abstract int[] sort(int[] inputArr);
    
    /**
     * callback to SortTest signalling a read operation on the data 
     */
    protected void reportRead() {
        if(callbackSortTest != null) {
            callbackSortTest.reportRead();
        }
    }

    /**
     * callback to SortTest signalling a write operation on the data
     */
    protected void reportWrite() {
        if(callbackSortTest != null) {
            callbackSortTest.reportWrite();
        }
    }

    /**
     * callback to SortTest signalling a compare operation between two data fields
     */
    protected void reportCompare() {
        if(callbackSortTest != null) {
            callbackSortTest.reportCompare();
        }
    }

    /**
     * report to SortTest signalling a swap of two fields in data
     */
    protected void reportSwap() {
        if(callbackSortTest != null) {
            // store &a to temp
            reportRead();
            reportWrite();

            // store &b to a
            reportRead();
            reportWrite();

            // store &temp to b
            reportRead();
            reportWrite();
        }
    }
}