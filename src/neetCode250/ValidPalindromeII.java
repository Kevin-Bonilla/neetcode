package neetCode250;

/*
Valid Palindrome II

You are given a string s, return true if the s can be a palindrome after deleting at most one character from it.

A palindrome is a string that reads the same forward and backward.

Note: Alphanumeric characters consist of letters (A-Z, a-z) and numbers (0-9).

Example 1:

Input: s = "aca"

Output: true

Explanation: "aca" is already a palindrome.

Example 2:

Input: s = "abbadc"

Output: false

Explanation: "abbadc" is not a palindrome and can't be made a palindrome after deleting at most one character.

Example 3:

Input: s = "abbda"

Output: true

Explanation: "We can delete the character 'd'.

Constraints:

    1 <= s.length <= 100,000
    s is made up of only lowercase English letters.

 */

public class ValidPalindromeII {

    // this was my solution but it was incorrect
    public boolean validPalindrome(String s) {
        // for this question we are going to return true if we can make a palindrome from deleting one character or if its already a palindrome
        // this is a two pointer question so we need to take account for this

        // case for when s.length is 1, always going to be a palindrome if the length is 1
        int stringLength = s.length();
        if (stringLength == 1){
            return true;
        }

        int frontPointer = 0;
        int backPointer = stringLength - 1;
        boolean haveWeAccountedForADelete = false;

        while (frontPointer < backPointer){
            char frontChar = s.charAt(frontPointer);
            char backChar = s.charAt(backPointer);

            // signs of not being a palindrome or needing to delete, chars at our pointers dont match
            if (frontChar != backChar){
                // if we have already accounted for a delete and have a non-palindrome this is not a valid string
                if(haveWeAccountedForADelete){
                    return false;
                }

                // testing to see if we can delete a char by skipping it
                char frontPlusChar = s.charAt(frontPointer + 1);
                char backMinusChar = s.charAt(backPointer - 1);
                // MAIN PROBLEM here because we greedily take the left string
                if (frontPlusChar == backChar){
                    frontPointer = frontPointer + 2;
                    backPointer--;
                    haveWeAccountedForADelete = true;
                } else if (backMinusChar == frontChar){
                    backPointer -= 2;
                    frontPointer++;
                    haveWeAccountedForADelete = true;
                } else {
                    // needs more than one delete
                    return false;
                }

            } else{
                // loop updates
                frontPointer++;
                backPointer--;
            }
        }

        return true;
    }


    // better answer
    public boolean validPalindromeCorrect(String s) {
        int leftPointer = 0;
        int rightPointer = s.length() - 1;

        while (leftPointer < rightPointer) {
            if (s.charAt(leftPointer) != s.charAt(rightPointer)) {
                // if both palidromes fail then we need more than one deletion
                return isPalindrome(s, leftPointer + 1, rightPointer)
                        || isPalindrome(s, leftPointer, rightPointer - 1);
            }
            leftPointer++;
            rightPointer--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int leftPointer, int rightPointer) {
        while (leftPointer < rightPointer) {
            if (s.charAt(leftPointer) != s.charAt(rightPointer)) {
                return false;
            }
            leftPointer++;
            rightPointer--;
        }
        return true;
    }
}
