package neetCode150;

/*
Number of One Bits

You are given an unsigned integer n. Return the number of 1 bits in its binary representation.

You may assume n is a non-negative integer which fits within 32-bits.

Example 1:

Input: n = 00000000000000000000000000010111

Output: 4

Example 2:

Input: n = 01111111111111111111111111111101

Output: 30
 */

public class NumberOfOneBits {
    public int hammingWeight(int n) {
        // we need to count how many 1's in n where n is a 32 bit number
        int count = 0;


        while (n != 0){
            n = n & (n-1); // this will subtract a binary bit
            count++;
        }

        return count;
    }
}
