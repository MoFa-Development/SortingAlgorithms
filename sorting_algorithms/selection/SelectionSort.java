package sorting_algorithms.selection;

import sorting_algorithms.Sort;

public class SelectionSort implements Sort {
    
    @Override
    public int[] sort(int[] inputArr) {
        int[] arr = inputArr.clone();

        int anfang = 0;
        int ende = arr.length-1;
        int bestes = -1;

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