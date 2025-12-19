package neetCode250;

import java.util.*;

/*
3Sum

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] where nums[i] + nums[j] + nums[k] == 0, and the indices i, j and k are all distinct.

The output should not contain any duplicate triplets. You may return the output and the triplets in any order.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]

Output: [[-1,-1,2],[-1,0,1]]

Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].

Example 2:

Input: nums = [0,1,1]

Output: []

Explanation: The only possible triplet does not sum up to 0.

Example 3:

Input: nums = [0,0,0]

Output: [[0,0,0]]

Explanation: The only possible triplet sums up to 0.

Constraints:

    3 <= nums.length <= 1000
    -10^5 <= nums[i] <= 10^5

 */

public class ThreeSum {
    public List<List<Integer>> threeSumHashmap(int[] nums) {
        // we need to go through and come up with the triplet combinations where everything sums to 0
        // output order does not matter and index must be unique

        // we can put our inital index in a hashmap pairing where we keep index and value

        // one solution is that we start with a number and search for the other two that would make zero essentially 2sum but with an extra step
        // ie, if our first number is -1, we need to search for two numbers that = 1 omitting our first number of course

        HashMap<Integer, Integer> numIndexMap = new HashMap<>(); // this will hold our values and their respective index

        for(int i = 0; i < nums.length; i++){
            int target = 0; // fix this later
            for(int j = 0; j < nums.length; j++){

            }
        }

        return new ArrayList<>(); // fix later
    }

    public List<List<Integer>> threeSumTwoPointers(int[] nums){
        // for this we will use a fixed number and then use the two pointer method to find if there is two matching numbers that can help us get to 0
        // in order to do this we need to sort the array first

        // to hold our answer
        List<List<Integer>> resultList = new ArrayList<>();

        Arrays.sort(nums); // Arrays.sort sorts in ascending order

        for(int i = 0; i < nums.length - 2; i++){
            // we need to account for skipping dupes for the first number
            // we check if i is the the same as the prev number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = 0 - nums[i]; // we need to find x + y = target
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[left] + nums[right];
                if (sum == target){
                    // make a triplet if it doesnt exist already
                    resultList.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // need to skip dupes now
                    while (left < right && nums[left] == nums[left + 1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]){
                        right--;
                    }

                    // base case need to shift the numbers
                    left++;
                    right--;
                }
                else if(sum < target){
                    // because the array is sorted if sum is less than the target then moving left up will increase the sum or keep it the same if there are dupes
                    left++;
                }
                else {
                    // same as above but we need to decrease sum so we shift right down 1
                    right--;
                }
            }
        }

        return resultList;
    }
}
