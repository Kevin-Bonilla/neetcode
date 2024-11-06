package neetCode150;

/*
 * Is Palindrome
Solved

Given a string s, return true if it is a palindrome, otherwise return false.

A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.

Example 1:

Input: s = "Was it a car or a cat I saw?"

Output: true

Explanation: After considering only alphanumerical characters we have "wasitacaroracatisaw", which is a palindrome.

Example 2:

Input: s = "tab a cat"

Output: false

Explanation: "tabacat" is not a palindrome.

Constraints:

    1 <= s.length <= 1000
    s is made up of only printable ASCII characters.

 */

public class IsPalidrome {
    public boolean isPalindrome(String s) {
        //we are not paying attention to case or nonalphanumeric
        s = s.replaceAll("[^a-zA-Z0-9]", ""); //removing all nonalphanumeric
        s = s.toLowerCase(); // makes all of the characters lower case

        //edge case if string is empty
        if(s.length() == 0){
            return true;
        }

        for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--){
            // for loop where i is beginning of the string and j starts at the end of the string
            // we will use the two pointer method and continuously increase i and decrement j until we hit a half way point
            char iChar = s.charAt(i);
            char jChar = s.charAt(j);
            //System.out.println("iChar " + iChar + " jChar" + jChar); //debug

            if (iChar != jChar){ // if the chars at our two points don't match
                return false;
            }
        }

        //if we make it out the loop we have a palindrome
        return true;
    }
}
