package main.structureAndAlgorithms;

/**
 * Created by Thomas Leruth on 10/13/17
 */

public class SortingMethods {

    private int[] array;

    public void swapForArray(int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public void bubbleSort(int[] array) {

        this.array = array;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swapForArray(j, j + 1);
                }

            }
        }
    }

//    public void InsertSortF(int[] array) {
//
//        int maxIndex = 0;
//        this.array = array;
//
//        for(int i = 1; i < array.length; i ++){
//            // try to find a spot where it is smaller than maxIndex but not MaxIndex-1
//            while (maxIndex >= 0 && array[i] < array[maxIndex]) {
//                // we found the spot
//                if (maxIndex == 0 || array[i] > array[maxIndex-1]) {
//                    for(int j = 0; j < (i-maxIndex); j++) {
//                        swapForArray(i-j-1,i-j);
//                    }
//                    // forcing exit
//                    maxIndex = 0;
//                }
//                maxIndex--;
//            }
//            maxIndex = i;
//        }
//    }

    public void InsertSort(int[] array) {

        this.array = array;

        // no need to do it for the first one
        for (int i = 1; i < array.length; i++) {


            int pivot = i - 1;
            int b = 0;

            while (pivot >= 0 && array[pivot] > array[i - b]) {
                swapForArray(pivot, pivot + 1);
                pivot--;
                b++;
            }

        }
    }

    // not really a quick sort after testing it, it works well tho
    public void quickSort(int[] array, int start, int end) {
        this.array = array;

        int s = start;
        int e = end;
        // Could be any index really
        int middleValue = array[start + (end - start) / 2];

        // if the start value is bigger or equal to the end
        while (s <= e) {

            // if value of selected number is bigger, get the start as close to it, obvious if same, does not work
            while (array[s] < middleValue) {
                s++;
            }

            // similar with the end, get the end as close to it
            while (array[e] > middleValue) {
                e--;
            }

            // if start index is still smaller (could that those index cross with previous while) then swap
            if (s <= e) {
                swapForArray(s,e);
                s++;
                e--;
            }

//            if (s == e) {
//                s++;
//                e--;
//            }
        }

        // quicksort left part until array is of size 1 (as it would be start = e)
        if (start < e) {
            quickSort(array, start, e);
        }
        // quicksort right part
        if (s < end) {
            quickSort(array, s, end);
        }
    }
}

//class SortingMethods2 <T extends Number>{


