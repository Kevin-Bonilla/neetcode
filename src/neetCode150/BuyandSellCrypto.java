package neetCode150;

/*
 * Buy and Sell Crypto
Solved

You are given an integer array prices where prices[i] is the price of NeetCoin on the ith day.

You may choose a single day to buy one NeetCoin and choose a different day in the future to sell it.

Return the maximum profit you can achieve. You may choose to not make any transactions, in which case the profit would be 0.

Example 1:

Input: prices = [10,1,5,6,7,1]

Output: 6

Explanation: Buy prices[1] and sell prices[4], profit = 7 - 1 = 6.

Example 2:

Input: prices = [10,8,7,5,2]

Output: 0

Explanation: No profitable transactions can be made, thus the max profit is 0.

Constraints:

    1 <= prices.length <= 100
    0 <= prices[i] <= 100

 */

public class BuyandSellCrypto {
    public int maxProfit(int[] prices) {
        int max = 0; //going to hold our maxProfit we return as the answer
        int currentLow = prices[0]; //this will hold our lowest value current 

        //edge case of 1 length array for prices
        if(prices.length == 1){
            return max;
        }

        for (int i = 1;i < prices.length; i++){
            //going to look through the prices array looking for new currentLows and maxProfit
            if(prices[i] > currentLow){
                int currentMax = prices[i] - currentLow;
                if (currentMax > max){ // if our currentmax we found is greater than our previous stored max
                    max = currentMax;
                }
            }
            else{ // if current value is less than or equal to currentLow
                currentLow = prices[i]; //if we need to replace currentLow with a lower price
            }
        }
        
        return max;
    }
}
