package neetCode250;

/*
Linked List Cycle Detection

Given the beginning of a linked list head, return true if there is a cycle in the linked list. Otherwise, return false.

There is a cycle in a linked list if at least one node in the list can be visited again by following the next pointer.

Internally, index determines the index of the beginning of the cycle, if it exists. The tail node of the list will set it's next pointer to the index-th node. If index = -1, then the tail node points to null and no cycle exists.

Note: index is not given to you as a parameter.

Example 1:

Input: head = [1,2,3,4], index = 1

Output: true

Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Example 2:

Input: head = [1,2], index = -1

Output: false

Constraints:

    1 <= Length of the list <= 1000.
    -1000 <= Node.val <= 1000
    index is -1 or a valid index in the linked list.


 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class LinkedListCycleDetection {
    public boolean hasCycle(ListNode head) {
        // we are going to use the two pointer method
        // with this we will have one pointer that is moving one node at a time and a second node that moves 2 nodes at a time
        // if these nodes ever equal eachother at any point then there is a cycle
        // if there is no cycle then the fast pointer will reach a null, at that point we need to return false because there is no cycle

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null){
            // increment the slow and fast
            slow = slow.next;
            // to stop nullpointer exception
            if (fast.next != null){
                fast = fast.next.next;
            } else{
                fast = null;
            }

            // if both are null its not a cycle
            if (slow == fast && slow != null){
                //cycle detected
                return true;
            }
            else if (fast == null){
                break;
            }
        }

        return false;
    }
}
