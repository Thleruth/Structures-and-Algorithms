package main.structureAndAlgorithms;

/**
 * Created by Thomas Leruth on 10/13/17
 */

public class SortingMethodsGen<T extends Comparable> {

    private T[] array;

    public void swapForArray(int first, int second) {
        T temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    // I am guessing I do not need this again <>
    public void bubbleSort(T[] array) {

        this.array = array;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swapForArray(j, j + 1);
                }

            }
        }
    }
}
