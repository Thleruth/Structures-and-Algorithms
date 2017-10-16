package main.structureAndAlgorithms;

/**
 * Created by Thomas Leruth on 10/13/17
 */

public class DataStructure {

    public class HashMap {

        String[][] table;
        int size;

        public HashMap() {
            this.size = 1000000; // Could also make it dynamic but not sure how to deal with negative value then
            table = new String[size][];
        }

        void add(String a) {
            int indexA = a.hashCode() % size;
            if (table[indexA] == null) { // first element
                String[] table2 = new String[size];
                table2[0] = a;
                table[indexA] = table2;
            }
            else { // not first element
                int i = 0; // space checker
                while (table[indexA][i] != null) { //find free space
                    i++;
                }
                table[indexA][i] = a;
            }
        }

        void retrieve(String a) {
            int indexA = a.hashCode() % size;
            if (table[indexA] == null) { // no elements at all
                System.out.println(a + " not found");
            }
            else { // some elements
                int i = 0; // seeker
                while (table[indexA][i] != null) {
                    if (table[indexA][i].equals(a)) {
                        System.out.println("found at index " + indexA);
                        return;
                    }
                    i++;
                }
                System.out.println(a + " not found");
            }
        }

    }

}
