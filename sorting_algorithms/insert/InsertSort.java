package sorting_algorithms.insert;

import java.util.ArrayList;

import sorting_algorithms.Sort;

public class InsertSort implements Sort {

    public int[] sort(int[] inputArr) {
        
        // Convert inputArr to List<Integer>
        ArrayList<Integer> list = new ArrayList<>();

        // Insert integers
        for (int i = 0; i < inputArr.length; i ++) {
            for (int k= 0; k < list.size(); k++) {
                if(list.get(k) < inputArr[i]) {
                    list.add(k+1, inputArr[i]);
                    continue;
                }
            }
            list.add(inputArr[i]);
        }

        // Convert List<Integer> to int[]
        int[] arr = new int[list.size()];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }
}