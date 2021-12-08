package sorting_algorithms.selection;

import java.text.CollationKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Collection;

import sorting_algorithms.Sort;

public class InsertSort extends Sort {

    private InsertSort() {
        throw new IllegalStateException("Utility class");
    }

    public static int[] sort(int[] inputArr) {
        
        // Convert inputArr to List<Integer>
        ArrayList<Integer> list = new ArrayList<Integer>();

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