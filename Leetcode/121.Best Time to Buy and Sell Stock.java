//Try by yourself yaar it was so easy
//iterative approach
class Solution {
    public int maxProfit(int[] prices) {
     
        int min_score = Integer.MAX_VALUE;
        int max_score = 0;
       for(int i = 0; i < prices.length; i++){
           min_score = Math.min(min_score,prices[i]);
           max_score = Math.max(max_score,prices[i] - min_score);
           
       }
        return max_score;
    }
}




// recursive approach

class Solution {
        public int maxProfit(int[] prices) {
            return helper(prices, 0, Integer.MAX_VALUE, 0);
        }

        private int helper(int[] prices, int i, int minStockPrice, int maxProfit) {
            if (i == prices.length)
                return maxProfit;
            maxProfit = Math.max(maxProfit, prices[i] - minStockPrice);
            minStockPrice = Math.min(minStockPrice, prices[i]);
            return helper(prices, i + 1, minStockPrice, maxProfit);
        }
    }
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
