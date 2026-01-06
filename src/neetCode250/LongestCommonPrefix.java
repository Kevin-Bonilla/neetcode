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

        // base case where strs[] has a length of 1 we just return the word
        if(strs.length == 1){
            return strs[0];
        }

        String baseString = strs[0]; // our base string is going to be our first string in the strs[]
        int baseStrLength = baseString.length();

        // case where our base string is an empty string
        if (baseStrLength == 0){
            return lcpSb.toString();
        }

        boolean matchingSoFar = true;
        // this for loop iterates through the characters in the base string
        for (int charNum = 0; charNum < baseStrLength; charNum++){
            // grab our character that we are going to be looking for in each string in strs[]
            char charToMatch = baseString.charAt(charNum);

            // look through every word and see if the char at our current index matches, if not break
            for (int wordNum = 0; wordNum < strs.length; wordNum++){
                String currentString = strs[wordNum];
                // need to make sure we don't have an out of bounds exception so we check current string length compared to our current char index on our base string
                if (currentString.length() <= charNum || currentString.isEmpty()){
                    matchingSoFar = false;
                    break;
                }
                char currentWordChar = strs[wordNum].charAt(charNum);
                // check if our chars do not match
                if (currentWordChar != charToMatch){
                    matchingSoFar = false;
                    break;
                }
            }

            // if there was a match for all strings add to our string builder if not we need to break out the loop and return what we currently have.
            if (matchingSoFar){
                lcpSb.append(charToMatch);
            }
            else{
                return lcpSb.toString();
            }
        }

        return lcpSb.toString();
    }
}
