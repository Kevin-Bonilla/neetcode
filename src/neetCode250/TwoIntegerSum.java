package neetCode250;

import java.util.HashMap;

/*
 * Two Integer Sum
Solved

Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.

You may assume that every input has exactly one pair of indices i and j that satisfy the condition.

Return the answer with the smaller index first.

Example 1:

Input: 
nums = [3,4,5,6], target = 7

Output: [0,1]

Explanation: nums[0] + nums[1] == 7, so we return [0, 1].

Example 2:

Input: nums = [4,5,6], target = 10

Output: [0,2]

Example 3:

Input: nums = [5,5], target = 10

Output: [0,1]

Constraints:

    2 <= nums.length <= 1000
    -10,000,000 <= nums[i] <= 10,000,000
    -10,000,000 <= target <= 10,000,000

 */

public class TwoIntegerSum {
    public int[] twoSum(int[] nums, int target) {
        // hashmap that stores our <num[i], index>
        HashMap<Integer, Integer> numIndexMap = new HashMap<>();
        int[] solution = new int[2]; //solution we are returning

        for (int i = 0; i < nums.length; i++){ // for loop that cycles through nums
            int numberNeeded = target - nums[i]; // number we are searching to match nums[i] with

            //check if numberNeeded is currently in our HashMap
            if(numIndexMap.containsKey(numberNeeded)){
                solution = new int[]{numIndexMap.get(numberNeeded), i}; // creating a new array with the two indexes of solution
                return solution;
            }
            else{
                //if numberNeeded is not is hashmap we need to put our current nums[i] and index in hashmap
                numIndexMap.put(nums[i], i);
            }
        }


        return solution;
    }
}
