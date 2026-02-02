package neetCode250;

/*
Remove Duplicates From Sorted Array
Easy Company Tags

You are given an integer array nums sorted in non-decreasing order. Your task is to remove duplicates from nums in-place so that each element appears only once.

After removing the duplicates, return the number of unique elements, denoted as k, such that the first k elements of nums contain the unique elements.

Note:

    The order of the unique elements should remain the same as in the original array.
    It is not necessary to consider elements beyond the first k positions of the array.
    To be accepted, the first k elements of nums must contain all the unique elements.

Return k as the final result.

Example 1:

Input: nums = [1,1,2,3,4]

Output: [1,2,3,4]

Explanation: You should return k = 4 as we have four unique elements.

Example 2:

Input: nums = [2,10,10,30,30,30]

Output: [2,10,30]

Explanation: You should return k = 3 as we have three unique elements.

Constraints:

    1 <= nums.length <= 30,000
    -100 <= nums[i] <= 100
    nums is sorted in non-decreasing order.

 */

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        // most important thing here is that we need to remove these in place
        // the int (k)that we return is the number of unique elements in the array nums
        // we don't need to resize the array or anything, we just need to sort them in the first k elements of nums
        // this is a two pointer problem

        int uniqueElements = 1;

        // we are going to use two pointers here: slowPointer and fastPointer
        // slowPointer will be our write position, and fastPointer will be where we are analyzing elements and looking for unique elements

        int slowPointer = 1;
        int fastPointer = 1;

        // base case where array is only 1 so we will only ever have 1 unique element
        if (nums.length == 1){
            return uniqueElements;
        }

        while (fastPointer < nums.length){

            if (nums[fastPointer] != nums[fastPointer-1]){
                // if element at fastPointer is not a duplicate of the element before it then we will write it at our slowPointer(write pos)
                nums[slowPointer] = nums[fastPointer];
                // we increment slowPointer because we wrote here
                slowPointer++;
            }

            // we always update fastPointer
            fastPointer++;
        }



        return slowPointer;
    }

}
