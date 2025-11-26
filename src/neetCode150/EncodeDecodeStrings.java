package neetCode150;

/*
Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.

Please implement encode and decode

Example 1:

Input: ["neet","code","love","you"]

Output:["neet","code","love","you"]

Example 2:

Input: ["we","say",":","yes"]

Output: ["we","say",":","yes"]

Constraints:

    0 <= strs.length < 100
    0 <= strs[i].length < 200
    strs[i] contains only UTF-8 characters.

 */

import java.util.List;

public class EncodeDecodeStrings {
    public String encode(List<String> strs) {
        // we need to encode the strings into a single string and return that
        // gets tricky bc delimiter can be in the string so maybe we need to keep track of how long a string is as well as the delimiter?
        // the method that we can use is <stringLength>#<string> and append these all to one string

        for (String s : strs){
            int length = s.length();

        }


    }

    public List<String> decode(String str) {
        // we need to take that single string and change it back to the list of strings


    }
}
