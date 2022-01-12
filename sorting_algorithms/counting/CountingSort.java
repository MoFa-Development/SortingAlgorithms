package sorting_algorithms.counting;

import java.util.TreeMap;

import sorting_algorithms.Sort;
import sorting_algorithms.test.SortTest;

public class CountingSort extends Sort {

    public CountingSort() {
        super();
    }

    public CountingSort(SortTest callbackSortTest) {
        super(callbackSortTest);
    }

    @Override
    public boolean givesReports() {
        return true;
    }

    @Override
    public int[] sort(int[] inputArr) {
        TreeMap<Integer, Integer> counters = new TreeMap<>();

        for(int i = 0; i < inputArr.length; i++) {
            int key = inputArr[i];
            reportRead();

            Integer count = counters.get(key);

            if(count == null) {
                counters.put(key, 1);
            } else {
                counters.put(key, count+1);
            }
        }

        int[] oututArr = new int[inputArr.length];

        int index = 0;

        for(int key:counters.keySet()) {
            for(int i = 0; i < counters.get(key); i++) {
                oututArr[index] = key;
                reportWrite();
                index++;
            }
        }

        return oututArr;
    }
}
