//https://leetcode.com/problems/max-area-of-island/description/
class Solution {

    int visited[][];
    int rows [] = {-1,0,0,1};
    int cols [] = {0,1,-1,0};

    public int maxAreaOfIsland(int[][] grid) {

        visited = new int[grid.length][grid[0].length];
        int maxArea = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
               
                if(visited[i][j]!=1 && grid[i][j]==1){
                    int area = helper(grid,i,j)+1;
                    maxArea = (maxArea<area)?area:maxArea;
                }
            }
        }

        return maxArea;
        
    }

    public int helper(int[][] grid , int row, int col){
        visited[row][col]=1;
        int count=0;
        for(int i=0;i<4;i++){
            int tempI = row+rows[i],tempJ=col+cols[i];
            if(validate(tempI,tempJ) && visited[tempI][tempJ]!=1 && grid[tempI][tempJ]==1){
                count+= 1+helper(grid,tempI,tempJ);
            }
        }

        return count;
    }

    public boolean validate(int i, int j){
        if(i>=0 && i<visited.length && j>=0 && j<visited[i].length)
            return true;
        return false;

    }
}