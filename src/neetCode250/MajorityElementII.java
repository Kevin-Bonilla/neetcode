package neetCode250;

/*
Majority Element II
Medium
Topics
Company Tags
You are given an integer array nums of size n, find all elements that appear more than ⌊ n/3 ⌋ times. You can return the result in any order.

Example 1:

Input: nums = [5,2,3,2,2,2,2,5,5,5]

Output: [2,5]
Example 2:

Input: nums = [4,4,4,4,4]

Output: [4]
Example 3:

Input: nums = [1,2,3]

Output: []
Constraints:

1 <= nums.length <= 50,000.
-1,000,000,000 <= nums[i] <= 1,000,000,000
Follow up: Could you solve the problem in linear time and in O(1) space?
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        // list that we will add all of our elements that appear more than n/3 times
        List<Integer> answer = new ArrayList<>();

        // hashMap that will keep track of how many times we have seen an element
        HashMap<Integer, Integer> elementToOccurence = new HashMap<>();

        // frequency goal
        int frequencyGoal = nums.length / 3;

        for (int num : nums){
            int occurrences = elementToOccurence.getOrDefault(num, 0) + 1;
            elementToOccurence.put(num, occurrences);
        }

        for(int key : elementToOccurence.keySet()){
            int occurances = elementToOccurence.get(key);
            if (occurances > frequencyGoal){
                answer.add(key);
            }
        }

        return answer;
    }
}
