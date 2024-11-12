package neetCode150;

/*
 * Merge Two Sorted Linked Lists
Solved

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted linked list and return the head of the new sorted linked list.

The new list should be made up of nodes from list1 and list2.

Example 1:

Input: list1 = [1,2,4], list2 = [1,3,5]

Output: [1,1,2,3,4,5]

Example 2:

Input: list1 = [], list2 = [1,2]

Output: [1,2]

Example 3:

Input: list1 = [], list2 = []

Output: []

Constraints:

    0 <= The length of the each list <= 100.
    -100 <= Node.val <= 100

 */

public class MergeTwoSortedLinkedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode helperNode = new ListNode(); //this will be where we assign our first listnode as .next
        ListNode currentNode = helperNode; //this will help us traverse the while loop

        //while loop to traverse through both lists
        while(list1 != null && list2 != null){ 
            if( list1.val <= list2.val){
                // or list1 val is less than list2 val
                currentNode.next = list1;
                list1 = list1.next; //updating list1 for next iteration
            }
            else if(list2.val <= list1.val) { 
                currentNode.next = list2;
                list2 = list2.next; //updating list2 for next iteration
            }
            currentNode = currentNode.next;
        }

        if (list1 != null){
            currentNode.next = list1;
        }
        else if(list2 != null){
            currentNode.next = list2;
        }

        return helperNode.next;
    }
}
