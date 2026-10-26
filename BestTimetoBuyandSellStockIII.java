// 123. Best Time to Buy and Sell Stock III

class Solution {
    public int maxProfit(int[] prices) {
        int firstBuy = -prices[0];
        int firstSell = 0;
      
        int secondBuy = -prices[0];
      
        int secondSell = 0;
      
        for (int i = 1; i < prices.length; i++) {
            firstBuy = Math.max(firstBuy, -prices[i]);
          
            firstSell = Math.max(firstSell, firstBuy + prices[i]);
          
            secondBuy = Math.max(secondBuy, firstSell - prices[i]);
          
            secondSell = Math.max(secondSell, secondBuy + prices[i]);
        }
      
        return secondSell;
    }
}
