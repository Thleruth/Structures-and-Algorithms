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
                if (s != e) {
                    swapForArray(s, e);
                }
                s++;
                e--;
            }
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

    public void mergesort(int[] array, int s, int e) {

        // do this until array is finished (basically s = e, meaning array of 1 with last array value)
        if (e > s) {
            int m = (s + e) / 2;
            // call recursively on left part so it gets smaller
            mergesort(array, s, m);
            // same on right part
            mergesort(array, m + 1, e);

            // merging work

            // Creating temporary subarrays
            int sizeL = m - s + 1;// I will put middle in the left one
            int sizeR = e - m; //

            // Create array to sort
            int[] arrayL = new int[sizeL];
            int[] arrayR = new int[sizeR];

            // populate those array (left first)
            for (int i = 0; i < sizeL; i++) {
                arrayL[i] = array[s + i];
            }

            // then right
            for (int i = 0; i < sizeR; i++) {
                arrayR[i] = array[i + m + 1];
            }

            // merge them

            // cursors for merged array populators
            int k = 0; // from new left
            int l = 0; // from new right

            // do this until one sub array is emptied
            while (k < sizeL && l < sizeR) {
                if (arrayL[k] > arrayR[l]) {
                    array[s] = arrayR[l];
                    l++;
                } else if (arrayL[k] <= arrayR[l]) {
                    array[s] = arrayL[k];
                    k++;
                }
                s++;
            }

            // do this to empty the remaining right array
            while (l < sizeR) {
                array[s] = arrayR[l];
                l++;
                s++;
            }

            // do this to empty the remaining left array
            while (k < sizeL) {
                array[s] = arrayL[k];
                k++;
                s++;
            }
        }
    }
}




