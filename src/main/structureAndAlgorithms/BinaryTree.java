package main.structureAndAlgorithms;

import java.util.ArrayList;

/**
 * Created by Thomas Leruth on 10/18/17
 */

public class BinaryTree {

    binaryNode top;
    ArrayList<Integer> list = new ArrayList<>();

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
    }

    public ArrayList<Integer> retrieveAll(BinaryTree tree, binaryNode top) {

        binaryNode searcher = top;

        if (searcher.left != null) { // go to the left
            retrieveAll(tree, searcher.left);
        }
        if (searcher.right != null) {
            list.add(searcher.value);
            retrieveAll(tree, searcher.right);
        }

        if (searcher.right == null && searcher.left == null) {
            list.add(searcher.value);
        }

        return list;
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
