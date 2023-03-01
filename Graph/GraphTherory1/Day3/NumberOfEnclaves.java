// https://leetcode.com/problems/number-of-enclaves/description/
class Solution {

    int visited [][];
    int rows [] = {-1,0,0,1};
    int cols [] = {0,1,-1,0};

    public int numEnclaves(int[][] grid) {
        visited = new int[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if((i*j==0 || i==grid.length-1 || j==grid[i].length-1) && visited[i][j]!=1 && grid[i][j]==1)
                    helper(grid,i,j);
            }
        }

        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                //System.out.print(grid[i][j]+" ");
                if(visited[i][j]!=1 && grid[i][j]==1)
                count++;
            }
            //System.out.println();
        }

        return count;
        
    }

    public void helper(int [][] grid,int row,int col){
        visited[row][col] = 1;
        //grid[row][col] = 0;
        
        for(int i=0;i<4;i++){
            int tempI = row+rows[i], tempJ = col+cols[i];
            if(validate(tempI,tempJ) && visited[tempI][tempJ]!=1 && grid[tempI][tempJ]==1){
                helper(grid,tempI,tempJ);
            }
        }
    }

    public boolean validate(int i, int j){
        if(i>=0 && i<visited.length && j>=0 && j<visited[i].length)
            return true;
        return false;
    }
}