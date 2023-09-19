//https://leetcode.com/problems/max-area-of-island/?envType=study-plan-v2&envId=graph-theory
class Solution {
    int rows [] = {1,-1,0,0};
    int cols [] = {0,0,-1,1};
    int maxI,maxJ;
    boolean visited [][];

    public int maxAreaOfIsland(int[][] grid) {
        maxI = grid.length;
        maxJ=grid[0].length;
        visited = new boolean[maxI][maxJ];
        int result = 0;

        for(int i=0;i<maxI;i++){
            for(int j=0;j<maxJ;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    int val = helper(grid,i,j);
                    result = Math.max(result,val);
                }
            }
        }

        return result;

        
    }

    public int helper(int grid[][],int row,int col){
        visited[row][col]=true;
        int count = 0;
        for(int i=0;i<4;i++){
            int tempI = row+rows[i],tempJ=col+cols[i];
            if(validate(tempI,tempJ) && !visited[tempI][tempJ] && grid[tempI][tempJ]==1){
                count+=helper(grid,tempI,tempJ);
            }
        }
        return count+1;
    }

    public boolean validate(int i,int j){
        if(i>=0 && j>=0 && i<maxI && j<maxJ)
            return true;
        return false;
    }
}