package neetCode250;

/*
Longest Common Prefix

You are given an array of strings strs. Return the longest common prefix of all the strings.

If there is no longest common prefix, return an empty string "".

Example 1:

Input: strs = ["bat","bag","bank","band"]

Output: "ba"

Example 2:

Input: strs = ["dance","dag","danger","damage"]

Output: "da"

Example 3:

Input: strs = ["neet","feet"]

Output: ""

Constraints:

    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] is made up of lowercase English letters if it is non-empty.
 */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // initialize an empty string builder that we will return our longest common prefix with
        StringBuilder lcpSb = new StringBuilder("");

        // we need to account for a base case where one of the strings is empty so we just return our empty lcpString
        // my idea for a solution is to have our first string as a basis, and check character by character on each string if basisString[i] pases all the checks add that
        // character to the string builder, if one does not match then we will return our stringbuilder.toString then and there


        return lcpSb.toString();
    }
}
