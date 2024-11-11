package neetCode150;

import java.util.HashMap;

/*
 * Two Integer Sum II
Solved

Given an array of integers numbers that is sorted in non-decreasing order.

Return the indices (1-indexed) of two numbers, [index1, index2], such that they add up to a given target number target and index1 < index2. Note that index1 and index2 cannot be equal, therefore you may not use the same element twice.

There will always be exactly one valid solution.

Your solution must use O(1)O(1) additional space.

Example 1:

Input: numbers = [1,2,3,4], target = 3

Output: [1,2]

Explanation:
The sum of 1 and 2 is 3. Since we are assuming a 1-indexed array, index1 = 1, index2 = 2. We return [1, 2].

Constraints:

    2 <= numbers.length <= 1000
    -1000 <= numbers[i] <= 1000
    -1000 <= target <= 1000

 */

public class TwoIntegerSumII {
    public int[] twoSum(int[] numbers, int target) {
        int[] sumIndex = new int[2]; //this will be the answer that we return at the end
        HashMap<Integer, Integer> prevMap = new HashMap<>(); //hashmap that will store our value and index

        //loop to iterate through numbers
        for(int i = 0; i < numbers.length; i++){
            int currentNum = numbers[i];
            int neededNum = target - currentNum; //number we need to make the sum target

            if(prevMap.containsKey(neededNum)){ //if the needed num is in the prevMap we have our answer
                sumIndex[0] = prevMap.get(neededNum) + 1; //get first index
                sumIndex[1] = i + 1; //second index
                return sumIndex;
            }
            else{ // needed num was not in the hashmap so we need to put this pair in the map
                prevMap.put(currentNum, i);
            }
        }

        return sumIndex;
    }
}
