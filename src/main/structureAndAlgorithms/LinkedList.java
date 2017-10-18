package main.structureAndAlgorithms;

/**
 * Created by Thomas Leruth on 10/17/17
 */
 public class LinkedList {

    LinkedNode start;

    public LinkedList() {
        start = null;
    }

    public void add(String a) {
        if (start == null) { //first element it is
            start = new LinkedNode(a, start);
        }
        else {
            LinkedNode adder = start;
            while (adder.next != null) {
                adder = adder.next; // moving till we find the last node
            }
            adder.next = new LinkedNode(a, null); // create a new node (with value of string and null pointer pointed by old one)
        }
    }

    public void retrieve(String a){

        int counter = 0;
        LinkedNode searcher = start; // create a searcher
        if (searcher == null) {
            System.out.println("LinkedList is empty");
            return;
        }
        while (true) {
            if (searcher.item.equals(a)) { // check on first element
                System.out.println(a + " found at position " + counter);
                return;
            }
            else {
                searcher = searcher.next; //move it to next
                counter++;
            }
            if (searcher == null) { // make sure it is not null as it would mean there is nothing after (would be an exception)
                System.out.println(a + " Not found");
                return;
            }
        }

    }

    private class LinkedNode {

        private String item;
        private LinkedNode next;

        public LinkedNode(String item, LinkedNode next) {
            this.item = item;
            this.next = next;
        }
    }


 }

