package main.structureAndAlgorithms;

import java.util.ArrayList;

/**
 * Created by Thomas Leruth on 10/18/17
 */

public class BinaryTree {

    binaryNode top;

    public BinaryTree() {
        this.top = null;
    }

    public void add(int i) {

        if (top == null) {
            top = new binaryNode(i);
        }
        else {
            binaryNode adder = top;
            while (true) {
                if (adder.value > i) {
                    if (adder.left == null) {
                        adder.left = new binaryNode(i);
                        break;
                    }
                    adder = adder.left;
                } else {
                    if (adder.right == null) {
                        adder.right = new binaryNode(i);
                        break;
                    }
                    adder = adder.right;
                }
            }
        }

        rebalancing();
    }

    public ArrayList<Integer> retrieveAll(binaryNode top, ArrayList<Integer> list) {

        binaryNode searcher = top;

        if (top == null) {
            System.out.println("The tree is empty");
            return list;
        }

        if (searcher.left != null) { // go to the left
            retrieveAll(searcher.left, list);
        }
        if (searcher.right != null) {
            list.add(searcher.value);
            retrieveAll(searcher.right, list);
        }

        if (searcher.right == null && searcher.left == null) {
            list.add(searcher.value);
        }

        return list;
    }

    public void removeAll() {

//        while (top.left != null && top.right != null) {
//            binaryNode hitman = top;
//
//            while (hitman.left != null) { // go to the left
//                hitman = hitman.left;
//            }
//            while (hitman.right != null) {
//                hitman = hitman.right;
//            }
//
//            if (hitman.left == null) {
//                hitman = null;
//            }
//        }

        top = null;
    }

    private void rebalancing() {

        double difference = 3;
        int minimum = 10;

        ArrayList<Integer> listL = new ArrayList<>();
        ArrayList<Integer> listR = new ArrayList<>();

        int sizeLeft;
        int sizeRight;

        if (top.right == null) {
            sizeRight = 0;
        }
        else {
            sizeRight = retrieveAll(top.right, listR).size();
        }

        if (top.left == null) {
            sizeLeft = 0;
        }
        else {
            sizeLeft = retrieveAll(top.left, listL).size();
        }

        System.out.println("####");
        System.out.println("Left: " + sizeLeft);
        System.out.println("Right: " + sizeRight);
        if (sizeLeft > minimum || sizeRight > minimum) { // avoid dividing by 0 and small trees
            if ((double) (sizeLeft/sizeRight) > difference || (double) (sizeLeft/sizeRight) < (1/difference)) {
                System.out.println("Rebalancing needed");
                ArrayList<Integer> listF = new ArrayList<>();
                retrieveAll(top, listF); // getting the data to add back
                removeAll();
                addSortedArrayList(listF, 0, listF.size()-1);
                System.out.println("Rebalancing done");
            }
        }

    }

    public void addSortedArrayList(ArrayList<Integer> list, int start, int end) {

        if (start <= end) {
            int middle = start + (end - start) / 2;
            int b = list.get(middle);
            add(b);
            if (middle != start) {
                addSortedArrayList(list, start, middle - 1);
            }
            if (middle != end) {
                addSortedArrayList(list, middle + 1, end);
            }
        }
    }


    public class binaryNode {
        int value;
        binaryNode left;
        binaryNode right;

        public binaryNode(int value) {
            this.value = value;
        }
    }
}
