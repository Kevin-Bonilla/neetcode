package neetCode250;

/*
Merge Sorted Array
Easy Company Tags

You are given two integer arrays nums1 and nums2, both sorted in non-decreasing order, along with two integers m and n, where:

    m is the number of valid elements in nums1,

    n is the number of elements in nums2.

The array nums1 has a total length of (m+n), with the first m elements containing the values to be merged, and the last n elements set to 0 as placeholders.

Your task is to merge the two arrays such that the final merged array is also sorted in non-decreasing order and stored entirely within nums1.
You must modify nums1 in-place and do not return anything from the function.

Example 1:

Input: nums1 = [10,20,20,40,0,0], m = 4, nums2 = [1,2], n = 2

Output: [1,2,10,20,20,40]

Example 2:

Input: nums1 = [0,0], m = 0, nums2 = [1,2], n = 2

Output: [1,2]

Constraints:

    0 <= m, n <= 200
    1 <= (m + n) <= 200
    nums1.length == (m + n)
    nums2.length == n
    -1,000,000,000 <= nums1[i], nums2[i] <= 1,000,000,000

 */

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // nums1 is our big array that everything needs to be sorted into
        // nums2 is our small array that everything needs to be added into nums1 and sorted
        // m is our valid amount of elements in nums1
        // n is our amount of elements in nums2

        // this is a two pointer problem so we should think of it in that way

        // we want to start the merge backwards because there is empty spots at the end that we can override with no consequence
        // we are going to use three pointers, starting at end of nums 1, ends of nums 2, and our write position (m+n -1)

        int num1Pointer = m - 1;
        int num2Pointer = n - 1;
        int writePos = m + n - 1;

        // we loop through, comparing num1Pointer vs num2Pointer, write the greater of the two in the writePos
        // whichever we wrote from we move the pointer back 1.
        while (num1Pointer >= 0 && num2Pointer >= 0){
            int num1Digit = nums1[num1Pointer];
            int num2Digit = nums2[num2Pointer];

            if (num2Digit >= num1Digit){
                // if they're equal we just take num2Digit
                // and we move num2pointer back 1
                nums1[writePos] = num2Digit;
                num2Pointer--;
            }
            else{
                // if num1Digit is greater than num2Digit
                // write our digit and move the num1pointer back 1
                nums1[writePos] = num1Digit;
                num1Pointer--;
            }

        }

        // if num2Pointer is not at 0 by the time we go through num1Pointer, then we just copy the rest of num2s digits
        // if num2Pointer goes to -1 and we still haven't traversed through num1, its fine because we are already sorted at that point



    }

}
