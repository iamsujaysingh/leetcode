//https://leetcode.com/problems/number-of-provinces/description/?envType=study-plan-v2&envId=graph-theory
class Solution {
    boolean visited[];
    public int findCircleNum(int[][] isConnected) {
        visited = new boolean[isConnected.length];
        int count=0;

        for(int i=0;i<isConnected.length;i++){
           if(!visited[i]){
               helper(isConnected,i);
               count++;
           }
        }

        return count;
        
    }

    public void helper(int[][] isConnected,int row){
       visited[row]=true;

       for(int j=0;j<isConnected[row].length;j++){
           if(isConnected[row][j]==1 && !visited[j]){
               helper(isConnected,j);
           }
       }
        
    }
}