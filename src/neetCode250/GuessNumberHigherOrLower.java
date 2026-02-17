package neetCode250;

/*
Guess Number Higher Or Lower
Easy Topics Company Tags

We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

You call a pre-defined API int guess(int num), which returns three possible results:

    0: your guess is equal to the number I picked (i.e. num == pick).
    -1: Your guess is higher than the number I picked (i.e. num > pick).
    1: Your guess is lower than the number I picked (i.e. num < pick).

Return the number that I picked.

Example 1:

Input: n = 5, pick = 3

Output: 3

Example 2:

Input: n = 15, pick = 10

Output: 10

Example 3:

Input: n = 1, pick = 1

Output: 1

Constraints:

    1 <= pick <= n <= ((2^31)-1)

 */

public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        // we are going to use binary search to have this solved efficiently
        int left = 1;
        int right = n;

        while(left <= right){
            int mid = left + (right - left) / 2;
            int guessResult = guess(mid);
            if (guessResult == 0){
                // we found our number
                return mid;
            } else if (guessResult == 1) {
                // our guess is lower than the number we are looking for
                left = mid + 1;
            } else {
                // our guess is higher than the number we are looking for
                right = mid - 1;
            }
        }
        return -1; // if we did not find it.
    }
}
