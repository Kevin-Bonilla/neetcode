package neetCode250;

/*
Longest Consecutive Sequence
Medium
Topics
Company Tags
Hints
Given an array of integers nums, return the length of the longest consecutive sequence of elements that can be formed.

A consecutive sequence is a sequence of elements in which each element is exactly 1 greater than the previous element. The elements do not have to be consecutive in the original array.

You must write an algorithm that runs in O(n) time.

Example 1:

Input: nums = [2,20,4,10,3,4,5]

Output: 4
Explanation: The longest consecutive sequence is [2, 3, 4, 5].

Example 2:

Input: nums = [0,3,2,5,4,6,1,1]

Output: 7
Constraints:

0 <= nums.length <= 1000
-10^9 <= nums[i] <= 10^9
 */

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        int longestConsecutiveLength = 0;

        // edge case for an empty nums array
        if (nums.length == 0){
            return longestConsecutiveLength;
        }

        for (int num : nums){
            hashSet.add(num);
        }

        for (int num : nums){
            if (hashSet.contains(num - 1)){
                // num is not the lead of sequence
                continue;
            }
            else{
                int currentNum = num;
                int currentConsecutiveLength = 1;
                if (longestConsecutiveLength == 0){
                    // we haven't recorded anything yet so lets record length of 1 at least
                    longestConsecutiveLength = currentConsecutiveLength;
                }
                while(hashSet.contains(currentNum + 1)){
                    //update our variables
                    currentNum++;
                    currentConsecutiveLength++;

                    // check if we have the new longest consecutive length
                    if (currentConsecutiveLength > longestConsecutiveLength){
                        longestConsecutiveLength = currentConsecutiveLength;
                    }
                }
            }
        }

        return longestConsecutiveLength;
    }
}
