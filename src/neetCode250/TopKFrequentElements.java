package neetCode250;

/*
Top K Frequent Elements

Given an integer array nums and an integer k, return the k most frequent elements within the array.

The test cases are generated such that the answer is always unique.

You may return the output in any order.

Example 1:

Input: nums = [1,2,2,3,3,3], k = 2

Output: [2,3]

Example 2:

Input: nums = [7,7], k = 1

Output: [7]

Constraints:

    1 <= nums.length <= 10^4.
    -1000 <= nums[i] <= 1000
    1 <= k <= number of distinct elements in nums.

 */

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        // k is the number of items we need to return
        int[] returnElements = new int[k];

        // we have a map for the integer from nums and then how many times its appearing
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums){
            // if we have never seen the number before we add it to the map with a frequency of 1
            // if we have seen it before we increment its frequency by 1
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // we will use a min heap to store numbers based on their frequency and only keep the top k frequent numbers
        //((a, b) -> a[1] - b[1]) sorts in ascending order based on frequency only compares the second element of array (freq)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // now we need to add all of freqmap to the min heap
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            int number = entry.getKey();
            int freq = entry.getValue();

            minHeap.add(new int[]{number, freq}); // adding to minheap as [number, freq]

            // if we are above k we need to poll
            // poll will take away the smallest number bc this is a minheap
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }

        // cycle through size k and insert minHeap items
        for (int i = 0; i < k; i++){
            returnElements[i] = Objects.requireNonNull(minHeap.poll())[0]; // pull only the number into i
        }

        return returnElements;
    }
}
