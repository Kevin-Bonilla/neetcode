package neetCode250;

/*
Sort Colors
Medium
Topics
Company Tags
You are given an array nums consisting of n elements where each element is an integer representing a color:

0 represents red
1 represents white
2 represents blue
Your task is to sort the array in-place such that elements of the same color are grouped together and arranged in the order: red (0), white (1), and then blue (2).

You must not use any built-in sorting functions to solve this problem.

Example 1:

Input: nums = [1,0,1,2]

Output: [0,1,1,2]
Example 2:

Input: nums = [2,1,0]

Output: [0,1,2]
Constraints:

1 <= nums.length <= 300.
0 <= nums[i] <= 2.
Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */

public class SortColors {
    public void sortColors(int[] nums) {
        // we are going to use the dutch national flag algorithm

        // start off with three pointers
        int low = 0; // this will mark the end of the 0's
        int mid = 0; // this will the element we are currently examining
        int high = nums.length - 1; // marks the start of the 2 section

        while(mid <= high){
            int currentElement = nums[mid];
            // case 1: current element we are on is a 0 / red
            if (currentElement == 0){
                // swap element at mid with element at low
                // we know for sure the element at mid was a zero/red so we move it back
                // now element at mid should either be a 0 or 1
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;

                // move forward mid and low pointers
                low++;
                mid++;
            }
            // case 2: current element is 1/white
            else if (currentElement == 1){
                // all we need to do is move mid forward, because the 1 is where its supposed to be
                mid++;
            }
            // case 3: current element is 2/blue
            else if(currentElement == 2){
                // swap element at mid with high
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;

                // move high pointer backwards
                high--;
                // don't move mid forward because we don't know what was at high
            }
        }
    }
}
