/**
 * 121. Best Time to Buy and Sell Stock
 * ------------------------------------
 * You are given an array prices where prices[i] represents the price of a given
 * stock on the ith day.
 *
 * Your goal is to maximize your profit by choosing a single day to buy one
 * stock and
 * a different day in the future to sell that stock.
 *
 * Return the maximum profit that can be achieved from this transaction.
 * If no profit can be made, return 0.
 *
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6),
 * profit = 6 - 1 = 5.
 * Note: Buying on day 2 and selling on day 1 is not allowed, as you must buy
 * before selling.
 *
 * Example 2:
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: No profitable transaction is possible, so max profit = 0.
 *
 * Constraints:
 * - 1 <= prices.length <= 10^5
 * - 0 <= prices[i] <= 10^4
 */

public class MaxProfit {
    static int solution(int[] prices) {
        int minSoFar = prices[0]; // Track the minimum price seen
        int maxProfit = 0; // Track the maximum profit possible

        for (int i = 1; i < prices.length; i++) {
            // Update minSoFar if current price is lower
            if (prices[i] < minSoFar) {
                minSoFar = prices[i];
            }
            // Calculate potential profit and update maxProfit if better
            int profit = prices[i] - minSoFar;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }
}
