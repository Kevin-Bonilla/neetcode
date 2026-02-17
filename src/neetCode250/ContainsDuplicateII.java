package neetCode250;

/*
Contains Duplicate II
Easy Company Tags

You are given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array
such that nums[i] == nums[j] and abs(i - j) <= k, otherwise return false.

Example 1:

Input: nums = [1,2,3,1], k = 3

Output: true

Example 2:

Input: nums = [2,1,2], k = 1

Output: false

Constraints:

    1 <= nums.length <= 100,000
    -1,000,000,000 <= nums[i] <= 1,000,000,000
    0 <= k <= 100,000
 */

import java.util.HashSet;

public class ContainsDuplicateII {
    // this is a sliding window problem
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // for this question k is the max distance the two duplicate values can be apart.
        // if a pair of dupes does not meet this req then we are returning false

        // our sliding window is going to have a size of k + 1
        // we are going to use a hashset to represent our sliding windows data
        HashSet<Integer> slidingWindow = new HashSet<>();

        // base case for 1 size array, there will be no dupe
        if (nums.length == 1){
            return false;
        }

        for (int i = 0; i < nums.length; i++){
            // if we find our element in the sliding window, we found our dupe that meets our needs
            // if not we add to our sliding window
            if (slidingWindow.contains(nums[i])){
                return true;
            } else{
                slidingWindow.add(nums[i]);
            }

            //update sliding window if needed
            if(slidingWindow.size() > k){
                slidingWindow.remove(nums[i - k]);
            }
        }

        return false;
    }
}
