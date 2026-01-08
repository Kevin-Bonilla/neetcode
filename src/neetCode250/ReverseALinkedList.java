package neetCode250;

/*
 * Reverse a Linked List
Solved

Given the beginning of a singly linked list head, reverse the list, and return the new beginning of the list.

Example 1:

Input: head = [0,1,2,3]

Output: [3,2,1,0]

Example 2:

Input: head = []

Output: []

Constraints:

    0 <= The length of the list <= 1000.
    -1000 <= Node.val <= 1000

 */

public class ReverseALinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null; // track the previous node
        ListNode current = head;
        ListNode next = null;

        while(current != null){
            next = current.next; //updating for the current loop

            //if (prev == null){ //case for the first node
            //    current.next = null; 
            //}
            //else{
            //    current.next = prev;
            //}
            current.next = prev; //no special case for first item

            //updated for the next loop
            prev = current; // when loop ends this will be the new head
            current = next;
        }
        
        return prev;
    }
}
