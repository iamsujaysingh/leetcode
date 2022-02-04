/*
* https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
*/
class Solution {
    int dp[][];
    public int maxProfit(int[] prices, int fee) {
        dp = new int[prices.length][2];
        if(prices.length==0){
            return 0;
        }
        else
            return useDp(0,prices,fee,0);
    }
    
    public int useDp(int day,int prices[],int fee, int own){
        if(day==prices.length){
            return 0;
        }
        if(dp[day][own]!=0){
            return dp[day][own];
        }
        else if(own==1){
            int op1 = prices[day] + useDp(day+1,prices,fee,0);
            int op2 = useDp(day+1,prices,fee,1);
            dp[day][own]=Math.max(op1,op2);
            return dp[day][own];
        }
        else {
            int op1 = useDp(day+1,prices,fee,1) - (prices[day]+fee);
            int op2 = useDp(day+1,prices,fee,0);
            dp[day][own]= Math.max(op1,op2);
            return dp[day][own];
        }
    }
}