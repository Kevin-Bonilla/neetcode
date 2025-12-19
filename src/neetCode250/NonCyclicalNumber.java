package neetCode250;

/*
 * Non-Cyclical Number
Solved

A non-cyclical number is an integer defined by the following algorithm:

    Given a positive integer, replace it with the sum of the squares of its digits.
    Repeat the above step until the number equals 1, or it loops infinitely in a cycle which does not include 1.
    If it stops at 1, then the number is a non-cyclical number.

Given a positive integer n, return true if it is a non-cyclical number, otherwise return false.

Example 1:

Input: n = 100

Output: true

Explanation: 1^2 + 0^2 + 0^2 = 1

Example 2:

Input: n = 101

Output: false

Explanation:
1^2 + 0^2 + 1^2 = 2
2^2 = 4
4^2 = 16
1^2 + 6^2 = 37
3^2 + 7^2 = 58
5^2 + 8^2 = 89
8^2 + 9^2 = 145
1^2 + 4^2 + 5^2 = 42
4^2 + 2^2 = 20
2^2 + 0^2 = 4 (This number has already been seen)

Constraints:

    1 <= n <= 1000

 */

import java.util.HashSet;

public class NonCyclicalNumber {
    public int squareOfSum(int n){
        System.out.println("n: " + n);
        int sum = 0;
        while(n > 0){
            int currentDig = (n % 10);
            sum += currentDig * currentDig;
            n = n / 10;
        }
        System.out.println("sum: " + sum);
        return sum;
    }

    public boolean isHappy(int n) {
        HashSet<Integer> seenSet = new HashSet<>();
        
        while(n != 1){ //while we havent seen n
            if (seenSet.contains(n)){ // this will go into infinite loop if we dont catch it
                return false;
            }

            seenSet.add(n); // add n to our seen set
            n = squareOfSum(n); //update n
        }

        return true;
    }
}
