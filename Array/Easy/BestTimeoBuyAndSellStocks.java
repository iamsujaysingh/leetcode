/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*/
class Solution {
    public int maxProfit(int[] prices) {
        
        int minBuy = prices[0];
        int minIndex =0;
        int profit = 0;

            for(int i=minIndex+1;i<prices.length;i++){
                if(prices[i]>minBuy){
                    int tempProfit = prices[i]-minBuy;
                    profit = (profit<tempProfit)?tempProfit:profit;
                }
                else if(prices[i]<minBuy){
                    minBuy = prices[i];
                    minIndex = i;
                }
            }
        return profit;
        
        
    }
}