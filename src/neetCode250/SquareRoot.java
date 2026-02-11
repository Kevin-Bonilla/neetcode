package neetCode250;

/*
Sqrt(x)
Easy Topics Company Tags

You are given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.

You must not use any built-in exponent function or operator.

    For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

Example 1:

Input: x = 9

Output: 3

Example 2:

Input: x = 13

Output: 3

Constraints:

    0 <= x <= ((2^31)-1)


 */

public class SquareRoot {
    public int mySqrt(int x) {
        // this is a binary search question, so we are going to use binary search to find out square root
        int left = 0;
        int right = x / 2;
        int fallback = 0;

        if (x < 2){
            return x;
        }

        while (left <= right){
            int mid = left + (right - left) / 2;
            long midSq = (long)mid * mid; // we have to do this bc integer overflow

            if (midSq == x){
                // we found our square root
                return mid;
            } else if (midSq > x){
                //mid was too big
                right = mid - 1;
            } else{
                // mid was too small
                left = mid + 1;
                fallback = mid;
            }
        }
        return fallback; // couldn't find exact square root
    }
}
