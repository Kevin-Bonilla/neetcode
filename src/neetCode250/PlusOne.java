package neetCode250;

/*
Plus One

You are given an integer array digits, where each digits[i] is the ith digit of a large integer. It is ordered from most significant to least significant digit, and it will not contain any leading zero.

Return the digits of the given integer after incrementing it by one.

Example 1:

Input: digits = [1,2,3,4]

Output: [1,2,3,5]

Explanation 1234 + 1 = 1235.

Example 2:

Input: digits = [9,9,9]

Output: [1,0,0,0]

Constraints:

    1 <= digits.length <= 100
    0 <= digits[i] <= 9

 */

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        // my take at solving the problem

        // idea here is to look at the last digit to see if only one needs to be changed or if multiple need to be changed
        // if last digit more than just the last digit needs to be changed
        int length = digits.length;

        // lets check if the last digit is a 9
        for (int i = length - 1; i >= 0; i--){
            int currentDigit = digits[i];

            // check if the current digit is 9
            if (currentDigit == 9){
                // if its not the first digit of the array then we can set to zero and carry it over
                if(i != 0){
                    digits[i] = 0;
                }
                // if we made it to the first digit of the array
                else{
                    digits[i] = 1;
                    // then need to add an extra zero to the number by copying the array and making a copy bc java is stupid and array size is fixed :)
                    digits = Arrays.copyOf(digits, digits.length + 1);
                }
            }
            // if the current digit is not 9 then we do not have to worry about carrying anything over and can just increment the current value
            else{
                digits[i] = digits[i] + 1;
                break;
            }
        }

        return digits;
    }

    public int[] plusOneOptimal(int[] digits){
        // the optimal solution
        if (digits.length == 0)
            return new int[]{1};

        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1] += 1;
            return digits;
        } else {
            int[] newDigits = new int[digits.length - 1];
            System.arraycopy(digits, 0, newDigits, 0, digits.length - 1);
            int[] result = plusOneOptimal(newDigits);
            result = java.util.Arrays.copyOf(result, result.length + 1);
            result[result.length - 1] = 0;
            return result;
        }
    }
}
