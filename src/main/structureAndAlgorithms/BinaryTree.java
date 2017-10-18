package main.structureAndAlgorithms;

/**
 * Created by Thomas Leruth on 10/18/17
 */

public class BinaryTree {

    private binaryNode top;

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


    public class binaryNode {
        int value;
        binaryNode left;
        binaryNode right;

        public binaryNode(int value) {
            this.value = value;
        }
    }
}
