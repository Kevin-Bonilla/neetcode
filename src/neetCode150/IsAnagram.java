package neetCode150;

/*
 * Is Anagram
Solved

Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.

An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

Example 1:

Input: s = "racecar", t = "carrace"

Output: true

Example 2:

Input: s = "jar", t = "jam"

Output: false

Constraints:

    s and t consist of lowercase English letters.

 */

import java.util.Arrays;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        boolean valid = false;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        System.out.println("sArr: " + sArr);
        System.out.println("tArr: " + tArr);

        s = new String(sArr);
        t = new String(tArr);

        if (s.equals(t)){
            valid = true;
        }

        return valid;
    }
}
