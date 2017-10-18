package main.structureAndAlgorithms;

/**
 * Created by Thomas Leruth on 10/17/17
 */

public class ArrayList {

    private int size = 16;
    String[] array = new String[size];

    public void add(String a) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) { // if finding an empty spot
                array[i] = a;
                return;
            }
        }
        size *=2;
        String[] newArray = new String[size]; // doubling size of array
        for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i]; // copying
            }
            newArray[array.length] = a; // putting the new elements
            array = newArray;
    }

    public void retrieve(String a) {
        for (int i = 0; i < array.length; i++) {
            if(array[0] == null) {
                System.out.println("array is empty, not gonna find anything :D");
                return;
            }
            if(array[i] != null && array[i].equals(a)) {
                System.out.println(a + " found at index " + i);
                return;
            }
        }
        System.out.println(a + " not found");
    }
}
