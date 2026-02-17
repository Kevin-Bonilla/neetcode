package neetCode250;

/*
Reverse String

You are given an array of characters which represents a string s. Write a function which reverses a string.

You must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Input: s = ["n","e","e","t"]

Output: ["t","e","e","n"]

Example 2:

Input: s = ["r","a","c","e","c","a","r"]

Output: ["r","a","c","e","c","a","r"]

Constraints:

    1 <= s.length < 100,000
    s[i] is a printable ascii character.

 */

public class ReverseString {

    public void reverseString(char[] s) {
        // we are going to try to do this O(1)
        // this is a two pointer problem
        int frontIndex = 0;
        int backIndex = s.length - 1;
        int midpoint = s.length / 2;

        while(frontIndex < midpoint){
            char frontChar = s[frontIndex];
            char backChar = s[backIndex];

            s[frontIndex] = backChar;
            s[backIndex] = frontChar;

            frontIndex++;
            backIndex--;
        }
    }

    public void optimalReverseStringToStudy (char[] s){
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

}
