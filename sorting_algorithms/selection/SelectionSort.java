package sorting_algorithms.selection;

import java.util.Arrays;

import sorting_algorithms.Sort;

public class SelectionSort extends Sort {

    private SelectionSort() {
        throw new IllegalStateException("Utility class");
    }

    public static int[] sort(int[] inputArr) {
        int[] arr = inputArr.clone();
        
        int anfang = 0;
        int ende = arr.length-1;
        int bestes = 0;
        
        System.out.println(Arrays.toString(arr));

        while(anfang != ende) {
            bestes = anfang;
            for(int speicher = anfang; speicher <= ende; speicher++) {
                if(arr[speicher] < arr[bestes]) {
                    bestes = speicher;
                }
            }

            if(anfang != bestes) {
                int temp = arr[bestes];
                arr[bestes] = arr[anfang];
                arr[anfang] = temp;
            }
            
            anfang++;
        }

        return arr;
    }
}