package src.selection.test;

import java.util.Arrays;

import src.selection.SelectionSort;

public class SelectionSortTest {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};

        int[] sorted = SelectionSort.sort(arr);

        System.out.println(Arrays.toString(sorted));

    }
}