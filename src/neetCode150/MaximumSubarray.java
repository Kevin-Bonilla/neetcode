package neetCode150;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        //greedy algorithm here
        //we will use kadanes algo
        int maxSum = nums[0]; // we are initializing max to our first element of nums
        int currentSum = maxSum; //we will hold our current sub array value here 

        for (int i = 1; i < nums.length; i++){
            // we can start this loop at 1 because we initialized maxsum as first element
            System.out.println("i: " + i + " | nums[i]: " + nums[i] + " | nums[i] + currentSum: " + (nums[i] + currentSum) + " | maxSum: " + maxSum); //debug
            currentSum = Math.max(nums[i], nums[i] + currentSum); // we take the max out of either just nums[i] or currentSum + nums[i]
            maxSum = Math.max(currentSum, maxSum); //if currentSum is greater than max sum then max sum is current sum now
        }

        return maxSum;
    }
}
