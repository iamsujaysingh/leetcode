/*
https://leetcode.com/problems/number-of-islands/submissions
*/
class Solution {
    boolean visit[][];
    int rows [] = {0,0,-1,1};
    int cols [] = {1,-1,0,0};
    int maxI,maxJ;
    public int numIslands(char[][] grid) {
        int count=0;
        maxI=grid.length;
        maxJ=grid[0].length;
        visit = new boolean[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]=='1' && visit[i][j]==false){
                    count++;
                    mark(grid,i,j);
                }
            }
        }

        return count;
        
    }

    public void mark(char [][] grid,int row,int col){
        visit[row][col]=true;
        for(int k=0;k<4;k++){
            int tempI=row+rows[k],tempJ=col+cols[k];
            if(validate(tempI,tempJ) && grid[tempI][tempJ]=='1' && visit[tempI][tempJ]==false)
                mark(grid,tempI,tempJ);
        }
    }

    public boolean validate(int row,int col){
        if(row>=0 && row <maxI && col>=0 && col<maxJ)
            return true;
        return false;
    }
}