package neetCode250;

/*
Search Insert Position
Easy Company Tags

You are given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [-1,0,2,4,6,8], target = 5

Output: 4

Example 2:

Input: nums = [-1,0,2,4,6,8], target = 10

Output: 6

Constraints:

    1 <= nums.length <= 10,000.
    -10,000 < nums[i], target < 10,000
    nums contains distinct values sorted in ascending order.

 */

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        // we are looking for the index to put the target that we are given in a sorted nums array
        // this is a binary search problem

        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int midpoint = left + (right - left) / 2;
            int elementAtMid = nums[midpoint];

            if (elementAtMid == target){
                return midpoint;
            } else if(target > elementAtMid){
                // shift the left to the midpoint because it won't be in that portion of the array
                left = midpoint + 1;
            } else{
                // target is less than the midpoint element so shift the right to midpoint - 1 because it won't be in that portion of the array
                right = midpoint - 1;
            }
        }

        // if we did not find our element left would be where we insert it
        return left;
    }
}
