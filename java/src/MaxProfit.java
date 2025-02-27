/**
 * 121. Best Time to Buy and Sell Stock
 * 
 * Determines the maximum profit achievable from a single stock transaction
 * given daily prices.
 * 
 * Given an array of integers prices where prices[i] represents the stock price
 * on the ith day,
 * this method calculates the maximum profit possible by buying the stock on one
 * day and selling
 * it on a later day. The transaction must follow chronological order (buy
 * before sell). If no
 * profit can be achieved, returns 0.
 *
 * Examples:
 * 1. Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1), sell on day 5 (price = 6), profit = 6
 * - 1 = 5.
 * Selling before buying (e.g., day 1 to day 2) is not permitted.
 * 
 * 2. Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: Prices decrease continuously, making profitable transactions
 * impossible.
 *
 * Constraints:
 * - Array length: 1 <= prices.length <= 10^5
 * - Price range: 0 <= prices[i] <= 10^4
 *
 * @param prices array of integers representing daily stock prices
 * @return maximum profit achievable from one buy-sell transaction, or 0 if no
 *         profit possible
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
