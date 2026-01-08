package neetCode250;
/*
 * Binary Search
Solved

You are given an array of distinct integers nums, sorted in ascending order, and an integer target.

Implement a function to search for target within nums. If it exists, then return its index, otherwise, return -1.

Your solution must run in O(logn)O(logn) time.

Example 1:

Input: nums = [-1,0,2,4,6,8], target = 4

Output: 3

Example 2:

Input: nums = [-1,0,2,4,6,8], target = 3

Output: -1

Constraints:

    1 <= nums.length <= 10000.
    -10000 < nums[i], target < 10000

 */

public class BinarySearch {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = nums.length / 2;
        int answer = -1;

        if (nums.length == 1 ){ //edge case for 1 length arrays
            if (nums[0] == target){
                return 0;
            }
            else{
                return -1;
            }
        }

        //binary search loop
        while(low <= high){
            mid = (high - low) / 2 + low;
            
            if (nums[mid] == target){
                return mid;
            }
            else if (target > nums[mid]){ //target is on high side of our comparison
                low = mid + 1;
            }
            else{ // target is on our low side of our comparison
                high = mid - 1;
            }
        }


        return answer;
    }
}
