package neetCode150;

/*
Last Stone Weight

You are given an array of integers stones where stones[i] represents the weight of the ith stone.

We want to run a simulation on the stones as follows:

    At each step we choose the two heaviest stones, with weight x and y and smash them togethers
    If x == y, both stones are destroyed
    If x < y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.

Continue the simulation until there is no more than one stone remaining.

Return the weight of the last remaining stone or return 0 if none remain.

Example 1:

Input: stones = [2,3,6,2,4]

Output: 1

Explanation:
We smash 6 and 4 and are left with a 2, so the array becomes [2,3,2,2].
We smash 3 and 2 and are left with a 1, so the array becomes [1,2,2].
We smash 2 and 2, so the array becomes [1].

Example 2:

Input: stones = [1,2]

Output: 1

Constraints:

    1 <= stones.length <= 20
    1 <= stones[i] <= 100

 */

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones){

        // the idea here is to sort from heaviest to lightest stones and smash in that order
        // we will use a max heap that will hold the stones
        // max heap is priority queue in reverse order
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // now we need to add all the stones to the maxheap
        for (int stone : stones){
            maxHeap.add(stone);
        }

        // we need to keep smashing rocks together until one or 0 is left
        while(maxHeap.size() > 1){
            // if we make it inside this loop we will always have at least two rocks
            // stone1 is going to be bigger than stone2
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            int difference = stone1 - stone2;
            if (difference > 0){
                // if the stones weren't the same size we need to add them back to the maxHeap
                maxHeap.add(difference);
            }
        }

        // if there is a stone left return that stones weight, if not return 0
        if(maxHeap.size() == 1){
            return maxHeap.poll();
        } else{
            return 0;
        }
    }
}
