package main.structureAndAlgorithms;

/**
 * Created by Thomas Leruth on 10/13/17
 */

public class SearchingMethods {

    public int binarySearchR(int[] array, int low, int end, int searched) {

        if ((end - low) >= 0) {

            int middle = low + (end - low) / 2;

            // found at middle
            if (array[middle] == searched) {
                return middle;
            }

            // in the right part
            // +1 middle as I know it is NOT middle
            if (array[middle] < searched) {
                return binarySearch(array, middle+1, end, searched);
            }
            // in the left part
            // -1 middle as I know it is NOT middle
            if (array[middle] > searched) {
                return binarySearch(array, low, middle-1, searched);
            }

        }
        // clear that this is a invalid index
        return -1;
    }

    public int binarySearch(int[] array, int low, int end, int searched) {

        while ((end - low) >= 0) {

            int middle = low + (end - low) / 2;

            // found at middle
            if (array[middle] == searched) {
                return middle;
            }

            // in the right part
            // +1 middle as I know it is NOT middle
            if (array[middle] < searched) {
                //return binarySearch(array, middle+1, end, searched);
                low = middle+1;
            }
            // in the left part
            // -1 middle as I know it is NOT middle
            if (array[middle] > searched) {
                // return binarySearch(array, low, middle-1, searched);
                end = middle-1;
            }

        }
        // clear that this is a invalid index
        return -1;
    }
}