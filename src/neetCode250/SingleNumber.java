package neetCode250;

/*
 * Single Number
Solved

You are given a non-empty array of integers nums. Every integer appears twice except for one.

Return the integer that appears only once.

You must implement a solution with O(n)O(n) runtime complexity and use only O(1)O(1) extra space.

Example 1:

Input: nums = [3,2,3]

Output: 2

Example 2:

Input: nums = [7,6,6,7,8]

Output: 8

Constraints:

    1 <= nums.length <= 10000
    -10000 <= nums[i] <= 10000

 */

public class SingleNumber {
    public int singleNumber(int[] nums) {
    	// have to use bitManupulation in the solution so we use xor
        int xorResult = 0; // going to hold the results of our xor operations ^

        for(int n: nums){
            xorResult = xorResult ^ n; //for every n we xor(^) it with our xorResult this will eventually cancel out everything but the 1 solo int
        }

        return xorResult; // this will be left with the number that only appeared once.
    }

}
