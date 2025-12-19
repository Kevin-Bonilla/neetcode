package neetCode250;

/*
 * Jump Game

You are given an integer array nums where each element nums[i] indicates your maximum jump length at that position.

Return true if you can reach the last index starting from index 0, or false otherwise.

Example 1:

Input: nums = [1,2,0,1,0]

Output: true

Explanation: First jump from index 0 to 1, then from index 1 to 3, and lastly from index 3 to 4.

Example 2:

Input: nums = [1,2,1,0,1]

Output: false

Constraints:

    1 <= nums.length <= 1000
    0 <= nums[i] <= 1000

 */

public class JumpGame {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        int farthest = 0;

        for (int i = 0; i < nums.length; i++){
            if(i > farthest){
                return false; // we cannot reach our current i through any jumps
            }

            farthest = Math.max(i + nums[i], farthest); //calculating our new farthest from i index
            if (farthest >= goal){
                return true;
            }
        }
        return false;
    }
}
