package neetCode150;

/*
Products of Array Except Self

Given an integer array nums, return an array output where output[i] is the product of all the elements of nums except nums[i].

Each product is guaranteed to fit in a 32-bit integer.

Follow-up: Could you solve it in O(n)O(n) time without using the division operation?

Example 1:

Input: nums = [1,2,4,6]

Output: [48,24,12,8]

Example 2:

Input: nums = [-1,0,1,2,3]

Output: [0,-6,0,0,0]

Constraints:

    2 <= nums.length <= 1000
    -20 <= nums[i] <= 20

 */

public class ProductsOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        // so essentially we are multiplying everything in n except for n[i] and making a new array and returning that

        // we need to get size of nums array so that we know what size to make our answer array
        int size = nums.length;
        int[] productsToReturn = new int[size];

        // first for loop is going to be running the multiplication for every number in our original array
        // second loop will find out the product for nums[i]
        for (int i = 0; i < size; i++){
            // we are going to find the product of left side of i and right side of i and multiply those together
            // left side calculation
            int leftProduct = 1;
            for (int leftIndex = 0; leftIndex < i; leftIndex++){
                int currentNum = nums[leftIndex];
                leftProduct *= currentNum;
            }

            // right side calculation
            int rightProduct = 1;
            for(int rightIndex = size - 1; rightIndex > i; rightIndex--){
               int currentNum = nums[rightIndex];
               rightProduct *= currentNum;
            }

            productsToReturn[i] = leftProduct * rightProduct;
        }

        return productsToReturn;
    }

}
