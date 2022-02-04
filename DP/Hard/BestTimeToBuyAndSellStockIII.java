/*
* https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
*/
class Solution {
    int dp[][][];
    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2][3];
        //return useDp(prices,0,0,1);
        return useBottomUp(prices,2);
    }
    
    public int useDp(int[] prices,int day,int own,int k){
        if(day>=prices.length || k==-1)
            return 0;
        if(dp[day][own][k]!=0)
            return dp[day][own][k];
        else if(own==0){
            int op1 = useDp(prices,day+1,1,k)-prices[day];
            int op2 = useDp(prices,day+1,0,k);
            dp[day][own][k] = Math.max(op1,op2);
            return dp[day][own][k];
        }
        else {
            int op1 = prices[day]+useDp(prices,day+1,0,k-1);
            int op2 = useDp(prices,day+1,1,k);
            dp[day][own][k] = Math.max(op1,op2);
            return dp[day][own][k];  
        }
    }
    
    public int useBottomUp(int[] prices,int trans){
        for(int day=prices.length-1;day>=0;day--){
            for(int j=0;j<=trans;j++){
                if(day==prices.length-1){
                    dp[day][0][j]=0;
                    dp[day][1][j]=(j>=1)?prices[day]:0;
                }
                else{
                    dp[day][0][j] = Math.max(dp[day+1][1][j]-prices[day],dp[day+1][0][j]);
                    dp[day][1][j] = Math.max((j>=1)?prices[day]+dp[day+1][0][j-1]:0,dp[day+1][1][j]);
                }
            }
        }
        
        return dp[0][0][2];
    }
}