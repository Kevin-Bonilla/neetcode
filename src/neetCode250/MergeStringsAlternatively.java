package neetCode250;

/*
Merge Strings Alternately
Easy Company Tags

You are given two strings, word1 and word2. Construct a new string by merging them in alternating order, starting with word1 — take one character from word1, then one from word2, and repeat this process.

If one string is longer than the other, append the remaining characters from the longer string to the end of the merged result.

Return the final merged string.

Example 1:

Input: word1 = "abc", word2 = "xyz"

Output: "axbycz"

Example 2:

Input: word1 = "ab", word2 = "abbxxc"

Output: "aabbbxxc"

Constraints:

    1 <= word1.length, word2.length <= 100
    word1 and word2 consist of lowercase English letters.

 */

public class MergeStringsAlternatively {

    public String mergeAlternately(String word1, String word2) {
        // to sum up the question, you are building a new string by taking 1 character from word1, then word2 alternating until 1 of them runs out, then you dump
        // the rest from the remaining string to our new string

        // our stringbuilder is going to hold our new string and help us build it
        StringBuilder sb = new StringBuilder();

        // get lengths for both of our words
        int word1Length = word1.length();
        int word2Length = word2.length();

        // find the shorter length of the two, or they can be equal
        int shorterLength = Math.min(word1Length, word2Length);

        // for loop that goes until our shorter length
        for (int i = 0; i < shorterLength; i++){
            char word1Char = word1.charAt(i);
            char word2Char = word2.charAt(i);

            sb.append(word1Char);
            sb.append(word2Char);
        }

        // at this point we have used all of 1 of the words (or both if the words have equal lengths)
        if (word1Length != word2Length){
            // if lengths are not equal find which word we need to dump remaining
            if (word1Length > word2Length){
                sb.append(word1, shorterLength, word1Length);
            }
            else {
                sb.append(word2, shorterLength, word2Length);
            }
        }

        return sb.toString();
    }

}
