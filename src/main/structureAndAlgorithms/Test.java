package main.structureAndAlgorithms;

import java.util.Random;

/**
 * Created by Thomas Leruth on 10/13/17
 */

public class Test {

    public static void main(String[] args) {

        int size = 1000;
        int[] array = new int[size];

        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(500)-250;
            // array[i] = i * 3;
        }

        for (int i : array) {
            System.out.println(i);
        }

        System.out.println("#####################");


        SortingMethods methods = new SortingMethods();
        long start = System.currentTimeMillis();
        methods.quickSort(array,0,array.length-1);

        for (int i : array) {
            System.out.println(i);
        }


//        SearchingMethods search = new SearchingMethods();
//        for (int i = 0; i < size; i++) {
//            int index = search.binarySearch(array,0,array.length-1,i);
//            System.out.println(index);
//        }
//


        long end = System.currentTimeMillis();
        long timing = end - start;
        System.out.println("this method took " + timing);

        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array [i+1]) {
                System.out.println("failed");
                return;
            }
        }
        System.out.println("winning");
    }

}