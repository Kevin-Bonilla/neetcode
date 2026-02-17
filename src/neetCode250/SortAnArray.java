package neetCode250;

/*
Sort an Array
Medium Topics Company Tags

You are given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.

Example 1:

Input: nums = [10,9,1,1,1,2,3,1]

Output: [1,1,1,1,2,3,9,10]

Example 2:

Input: nums = [5,10,2,1,3]

Output: [1,2,3,5,10]

Constraints:

    1 <= nums.length <= 50,000.
    -50,000 <= nums[i] <= 50,000

 */


public class SortAnArray {
    public int[] sortArray(int[] nums) {
        // we want to use merge sort here
        // merge sort is going to be recursive

        // call our mergeSort function with our nums as an argument with left as 0 and right as length - 1
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right){
        // we take our array and split it into halves and sort them that way
        // base case: similar to a binary search base case
        if (left >= right){
            return;
        }

        int mid = left + (right - left) / 2;

        // recursively sort left half
        mergeSort(nums, left, mid);
        // recursively sort right half
        mergeSort(nums, mid + 1, right);

        // merge the two sorted halves
        merge(nums, left, mid, right);
    }

    public void merge(int[] nums, int left, int mid, int right){
        // calculate the sizes of our arrays
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        // create our temp arrays
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        // copy left half of nums to left array
        for (int i = 0; i < leftSize; i++){
            leftArray[i] = nums[left + i];
        }

        // copy right half of nums to right array
        for (int i = 0; i < rightSize; i++){
            rightArray[i] = nums[mid + i + 1];
        }

        // take our two arrays and merge them
        int leftPointer = 0;
        int rightPointer = 0;
        int writePos = left;

        while (leftPointer < leftSize && rightPointer < rightSize){
            int currentLeftVal = leftArray[leftPointer];
            int currentRightVal = rightArray[rightPointer];

            if (currentLeftVal < currentRightVal){
                // if our val from left array is smaller than the one from the right
                nums[writePos] = currentLeftVal;
                leftPointer++;
            } else{
                // if our val from right is smaller than the one from the left or they are equal
                nums[writePos] = currentRightVal;
                rightPointer++;
            }
            writePos++;
        }

        // take any remaining elements and transfer them to nums
        while (leftPointer < leftSize){
            nums[writePos] = leftArray[leftPointer];
            leftPointer++;
            writePos++;
        }
        while(rightPointer < rightSize){
            nums[writePos] = rightArray[rightPointer];
            rightPointer++;
            writePos++;
        }
    }
}
