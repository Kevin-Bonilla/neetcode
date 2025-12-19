package neetCode250;

/*
 * Validate Parentheses
Solved

You are given a string s consisting of the following characters: '(', ')', '{', '}', '[' and ']'.

The input string s is valid if and only if:

    Every open bracket is closed by the same type of close bracket.
    Open brackets are closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.

Return true if s is a valid string, and false otherwise.

Example 1:

Input: s = "[]"

Output: true

Example 2:

Input: s = "([{}])"

Output: true

Example 3:

Input: s = "[(])"

Output: false

Explanation: The brackets are not closed in the correct order.

Constraints:

    1 <= s.length <= 1000

 */

import java.util.HashMap;
import java.util.Stack;



public class ValidateParentheses {
    public boolean isValid(String s) {
        HashMap<Character, Character> parMap = new HashMap<>(); //holds the pairs of pparentheses
        parMap.put('(',')');
        parMap.put('{','}');
        parMap.put('[',']');

        Stack<Character> stack = new Stack<>(); // we are going to use a stack to hold the opening brackets

        for(int i = 0; i < s.length(); i++){
            char currentChar = s.charAt(i); 

            if( parMap.containsKey(currentChar) ){ //if opening bracket
                stack.push(currentChar);
            }
            else if(currentChar == ']' || currentChar == '}' || currentChar == ')'){ // if we have a closing bracket as current
                
                if(!stack.isEmpty()){ 
                    char topOfStack = stack.pop();
                    if(currentChar != parMap.get(topOfStack)){
                        return false;
                    }
                }
                else{ // if stack is empty after running into a closing parentheses
                    return false;
                }
            }
            else{ //not any brackets
                return false;
            }
        }
        
        //edge case 
        if(!stack.isEmpty()){ // if there is unmatched opening parentheses
            return false;
        }

        return true;
    }
}
