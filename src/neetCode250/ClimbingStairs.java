package neetCode250;

/*
 * Climbing Stairs
Solved

You are given an integer n representing the number of steps to reach the top of a staircase. You can climb with either 1 or 2 steps at a time.

Return the number of distinct ways to climb to the top of the staircase.

Example 1:

Input: n = 2

Output: 2

Explanation:

    1 + 1 = 2
    2 = 2

Example 2:

Input: n = 3

Output: 3

Explanation:

    1 + 1 + 1 = 3
    1 + 2 = 3
    2 + 1 = 3

Constraints:

    1 <= n <= 30

 */

public class ClimbingStairs {
	//brute force method
    public int climbStairs(int n) {
        //n is number of steps to get to the top of staircase
        //we can move 1 or 2 steps at a time
        //find number of distinct ways to climb top of staircase

        //base case
        if (n <= 2){
            return n; //if 0 theres 0 ways, 1 theres 1 way, 2 theres 2 ways
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

}
