package neetCode250;

/*
Majority Element

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times in the array. You may assume that the majority element always exists in the array.

Example 1:

Input: nums = [5,5,1,1,1,5,5]

Output: 5

Example 2:

Input: nums = [2,2,2]

Output: 2

Constraints:

    1 <= nums.length <= 50,000
    -1,000,000,000 <= nums[i] <= 1,000,000,000

Follow-up: Could you solve the problem in linear time and in O(1) space?
 */

import java.util.HashMap;

public class MajorityElement {

    // my solution
    public int majorityElement(int[] nums) {
        // this is the number that we are looking for, once we find this many occurances of a num we can return it as the majority
        int majoritySize;
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length % 2 == 0){
            // for divisible by 2 numbers
            majoritySize = nums.length / 2;
        } else{
            // for not divisible by two numbers
            majoritySize = nums.length / 2;
            majoritySize++;
        }


        HashMap<Integer, Integer> numToOccurenceMap = new HashMap<>();

        for (int num : nums){
            if (numToOccurenceMap.containsKey(num)){
                int currentOccurrences = numToOccurenceMap.get(num) + 1;
                if (currentOccurrences >= majoritySize){
                    return num;
                }
                numToOccurenceMap.put(num, currentOccurrences);
            } else{
                numToOccurenceMap.put(num, 1);
            }
        }

        // shouldnt get here but just in case
        return nums[0];
    }

    // most optimal solution after looking to ai for some help
    public int majorityElementMostOptimal(int[] nums){
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
