//https://leetcode.com/problems/number-of-closed-islands/submissions/?envType=study-plan-v2&envId=graph-theory
class Solution {
    int rows [] = {0,0,-1,1};
    int cols [] = {1,-1,0,0};
    int maxI,maxJ,count=0;
    boolean visited[][];
    public int closedIsland(int[][] grid) {
        maxI = grid.length;
        maxJ = grid[0].length;
        visited = new boolean [maxI][maxJ];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==0 && !visited[i][j]){
                    boolean flag = helper(grid,i,j);
                    if(flag){
                        count++;
                       // System.out.println(i+"  "+j+" ");
                    }
                        
                }
            }
        }

        return count;
        
    }

    public boolean helper(int grid[][],int row,int col){
        visited[row][col]=true;
        boolean value = true;
        if(row*col==0 || row==maxI-1 || col==maxJ-1)
            value = false;
        
        for(int i=0;i<4;i++){
            int tempI=row+rows[i],tempJ=col+cols[i];
            if(validate(tempI,tempJ) && !visited[tempI][tempJ] && grid[tempI][tempJ]==0){
                value = helper(grid,tempI,tempJ) && value;
            }
        }
        return value;
    }

    public boolean validate(int row,int col){
        if(row>=0 && col >=0 && row<maxI && col<maxJ)
            return true;
        return false;
    }
}