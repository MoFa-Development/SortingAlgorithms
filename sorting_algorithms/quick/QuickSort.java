package sorting_algorithms.quick;

import java.util.ArrayList;

import sorting_algorithms.Sort;
import sorting_algorithms.test.SortTest;

public class QuickSort extends Sort {

    public QuickSort() {
        super();
    }

    public QuickSort(SortTest callbackSortTest) {
        super(callbackSortTest);
    }

    @Override
    public boolean givesReports() {
        return true;
    }

    public int[] sort(int[] inputArr) {
        
        ArrayList<Integer> inputArrList = new ArrayList<>();
        
        for(int i = 0; i < inputArr.length; i++) {
            inputArrList.add(inputArr[i]);
        }
        
        ArrayList<Integer> outputArrList = this.sort(inputArrList);
        
        // Convert List<Integer> to int[]
        int[] outputArr = new int[outputArrList.size()];

        for (int i = 0; i < outputArr.length; i++) {
            outputArr[i] = outputArrList.get(i);
        }

        return outputArr;
    }

    private ArrayList<Integer> sort(ArrayList<Integer> inputList) {
        if(inputList.size() <= 1) {
            return inputList;
        }
        
        int sortNum = inputList.get(0);
        reportRead();

        ArrayList<Integer> smallerList = new ArrayList<>(); 
        ArrayList<Integer> biggerList = new ArrayList<>();

        for(int i = 1; i < inputList.size(); i++) {
            int number = inputList.get(i);
            reportRead();

            reportCompare();
            if(number < sortNum) {
                smallerList.add(number);
            } else {
                biggerList.add(number);
            }
            reportWrite();
        }

        smallerList = this.sort(smallerList);
        biggerList = this.sort(biggerList);


        // System.out.print("input: ");
        // System.out.println(inputList.toString());
        // System.out.print("smaller: ");
        // System.out.println(smallerList.toString());
        // System.out.print("bigger: ");
        // System.out.println(biggerList.toString());

        //! SMALLER LIST IS NOT ONLY SMALLER AFTER THIS
        ArrayList<Integer> outputList = smallerList;
        outputList.add(sortNum);
        outputList.addAll(biggerList);

        return outputList;
    }
}