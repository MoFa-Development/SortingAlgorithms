package sorting_algorithms.insert;

import java.util.ArrayList;

import sorting_algorithms.Sort;
import sorting_algorithms.test.SortTest;

public class InsertSort extends Sort {

    public InsertSort() {
        super();
    }

    public InsertSort(SortTest callbackSortTest) {
        super(callbackSortTest);
    }

    @Override
    public boolean givesReports() {
        return true;
    }

    public int[] sort(int[] inputArr) {
        
        // Convert inputArr to List<Integer>
        ArrayList<Integer> list = new ArrayList<>();

        // Insert integers
        for (int input: inputArr) {
            int k;
            for (k= 0; k < list.size(); k++) {
                reportCompare();
                reportRead();
                if (list.get(k) > input) {
                    list.add(k, input);
                    reportWrite();
                    break;
                }
            }

            reportCompare();
            if (k == list.size()) {
                list.add(input);
                reportWrite();
            }
        }

        // Convert List<Integer> to int[]
        int[] arr = new int[list.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}