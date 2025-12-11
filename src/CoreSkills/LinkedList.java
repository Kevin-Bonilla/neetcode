package CoreSkills;

/*
Design Singly Linked List

Design a Singly Linked List class.

Your LinkedList class should support the following operations:

    LinkedList() will initialize an empty linked list.
    int get(int i) will return the value of the ith node (0-indexed). If the index is out of bounds, return -1.
    void insertHead(int val) will insert a node with val at the head of the list.
    void insertTail(int val) will insert a node with val at the tail of the list.
    bool remove(int i) will remove the ith node (0-indexed). If the index is out of bounds, return false, otherwise return true.
    int[] getValues() return an array of all the values in the linked list, ordered from head to tail.

Example 1:

Input:
["insertHead", 1, "insertTail", 2, "insertHead", 0, "remove", 1, "getValues"]

Output:
[null, null, null, true, [0, 2]]

Example 2:

Input:
["insertHead", 1, "insertHead", 2, "get", 5]

Output:
[null, null, -1]

Note:

    The index int i provided to get(int i) and remove(int i) is guaranteed to be greater than or equal to 0.


 */

import java.util.ArrayList;

public class LinkedList {

    // nested class for our Node
    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }

        Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        // LinkedList() will initialize an empty linked list.
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int get(int index) {
        // int get(int i) will return the value of the ith node (0-indexed). If the index is out of bounds, return -1.

        // if the linked list is empty
        if (head == null){
            return -1;
        }

        // traverse the linked list to the index
        int indexCounter = 0;
        Node currentNode = head;
        while(currentNode != null){
            if (indexCounter == index){
                return currentNode.val;
            }

            currentNode = currentNode.next;
            indexCounter++;
        }

        // if we went out of bounds and exited the while loop before finding the passed in index
        return -1;
    }

    public void insertHead(int val) {
        this.head = new Node(val, head);
        // if this is the only node in the linked list
        if (size == 0){
            this.tail = head;
        }
        this.size++;
    }

    public void insertTail(int val) {
        Node newTail = new Node(val);
        if (size == 0){
            // if only node in the linked list
            this.tail = newTail;
            this.head = tail;
        }
        else{
            this.tail.next = newTail;
            this.tail = newTail;
        }
        this.size++;
    }

    public boolean remove(int index) {
        // bool remove(int i) will remove the ith node (0-indexed). If the index is out of bounds, return false, otherwise return true.

        // if the linked list is empty, or index is out of bounds
        if (head == null || index < 0 || index >= size){
            return false;
        }

        // case for removing head
        if (index == 0){
            this.head = head.next;
            // if our previous head was the only node in the linked list
            if(head == null){
                tail = null;
            }
            return true;
        }

        // traverse the linked list to the index
        int indexCounter = 0;
        int indexBefore = index - 1;
        Node currentNode = head;
        while(currentNode != null){
            if (indexCounter == indexBefore){
                // setting node before deletion to have node after deletion as its next
                currentNode.next = currentNode.next.next;
                if (index == size - 1){
                    // if we are deleting the tail
                    tail = currentNode;
                }
                this.size--;
                return true;
            }

            currentNode = currentNode.next;
            indexCounter++;
        }

        // if we went out of bounds and exited the while loop before finding the passed in index
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> returnList = new ArrayList<Integer>(size);

        Node currentNode = head;
        while(currentNode != null){
            returnList.add(currentNode.val);
            currentNode = currentNode.next;
        }

        return returnList;
    }
}
