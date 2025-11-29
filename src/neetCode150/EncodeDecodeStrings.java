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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeStrings {
    public String encode(List<String> strs) {
        // we need to encode the strings into a single string and return that
        // gets tricky bc delimiter can be in the string so maybe we need to keep track of how long a string is as well as the delimiter?
        // the method that we can use is <stringLength>#<string> and append these all to one string

        StringBuilder encodedString = new StringBuilder();

        for (String s : strs){
            int length = s.length();
            String encodedSegment = length + "#" + s;
            encodedString.append(encodedSegment);
        }

        return encodedString.toString();
    }

    public List<String> decode(String str) {
        // we need to take that single string and change it back to the list of strings
        List<String> decodedList = new ArrayList<>();

        while(!str.isEmpty()){
            // look at the beginning of the string for the length of the next String we enter into the decoded list
            int i = 0;
            while (str.charAt(i) != '#'){
                i++;
            }

            int length = Integer.parseInt(str.substring(0,i));
            int startIndexForString = i + 1;
            String strToAdd = str.substring(startIndexForString, startIndexForString+length);
            decodedList.add(strToAdd);

            str = str.substring(startIndexForString+length);
        }

        return decodedList;
    }
}
