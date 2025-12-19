package neetCode250;

/*
 * Anagram Groups
Solved

Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.

An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

Example 1:

Input: strs = ["act","pots","tops","cat","stop","hat"]

Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]

Example 2:

Input: strs = ["x"]

Output: [["x"]]

Example 3:

Input: strs = [""]

Output: [[""]]

Constraints:

    1 <= strs.length <= 1000.
    0 <= strs[i].length <= 100
    strs[i] is made up of lowercase English letters.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AnagramGroups {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> strMap = new HashMap<>(); // this hashmap will hold our key(sorted string) and our list of anagrams
        List<List<String>> answerList = new ArrayList<>(); //this will be the value that we return as our answer

        //enhanced for loop to interate through all of our strings
        for (String s : strs){
            char[] arrS = s.toCharArray();
            Arrays.sort(arrS); //this will sort our arrS alphabetically, all anagrams will have the same sorted array
            String sortedS = new String(arrS); //using String constructor to convert arrS back to a string

            if(!strMap.containsKey(sortedS)){
                //if our sorted string has not been seen in the loop yet lets add it to our hashMap
                strMap.put(sortedS, new ArrayList<String>(Arrays.asList(s))); //put sorted string and then initialize a new arraylist with s insde
            }
            else{
                //if we have seen the sorted list
                strMap.get(sortedS).add(s); // we need to add our current s to the ArrayList
            }
        }

        for (String key : strMap.keySet()){ //iterate through hashmap
            answerList.add(strMap.get(key)); //add our List<String> to the arraylist of answers
        }

        return answerList;
    }
}
