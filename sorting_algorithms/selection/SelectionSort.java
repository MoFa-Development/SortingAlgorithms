package sorting_algorithms.selection;

import java.util.Arrays;

public class SelectionSort {

    private SelectionSort() {
        throw new IllegalStateException("Utility class");
    }

    public static int[] sort(int[] inputArr) {
        int[] arr = inputArr.clone();
        
        int anfang = 0;
        int ende = arr.length-1;
        int bestes = -1;

        while(anfang != ende)
        {
            for(int i = anfang; i <= ende; i++)
            {
                if(bestes == -1 || arr[bestes] > arr[i])
                {
                    bestes = i;
                }
            }

            // Tausche besten mit Anfangselement
            int zwischenspeicher = arr[anfang];
            arr[anfang] = arr[bestes];
            arr[bestes] = zwischenspeicher;
            
            anfang++;
        }

        return arr;
    }
}