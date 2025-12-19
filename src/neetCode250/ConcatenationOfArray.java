package neetCode250;

/*
Concatenation of Array

You are given an integer array nums of length n. Create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

Specifically, ans is the concatenation of two nums arrays.

Return the array ans.

Example 1:

Input: nums = [1,4,1,2]

Output: [1,4,1,2,1,4,1,2]

Example 2:

Input: nums = [22,21,20,1]

Output: [22,21,20,1,22,21,20,1]

Constraints:

    1 <= nums.length <= 1000.
    1 <= nums[i] <= 1000
 */

public class ConcatenationOfArray {
    public int[] getConcatenation(int[] nums) {
        // so basically the task here is to double the array like take an array and repeat it so we will have an array of nums.length * 2
        // initialize an array of nums length * 2
        int numsLength = nums.length;
        int[] concatArray = new int[numsLength * 2];

        // now we need to copy over everything and duplicate where it needs to be duplicated
        // so concatArray[i] = nums[i] & concatArray [i + nums.length] = nums[i]
        // we will iterate through nums in a for loop to assign our values to concatArray
        for (int i = 0; i < numsLength; i++){
            int currentNumsVal = nums[i];
            concatArray[i] =  currentNumsVal;
            concatArray[i + numsLength] = currentNumsVal;
        }

        return concatArray;
    }
}
