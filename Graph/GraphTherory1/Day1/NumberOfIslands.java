//https://leetcode.com/problems/number-of-islands/description/?envType=study-plan&id=graph-i
class Solution {
    int visited[][];
    int rows [] = {-1,0,0,1};
    int cols [] = {0,-1,1,0};

    public int numIslands(char[][] grid) {
        int count = 0;
        visited = new int[grid.length][grid[0].length];
        for(int i=0;i<visited.length;i++){
            for(int j=0;j<visited[i].length;j++){

                if(visited[i][j]!=1 && grid[i][j]=='1'){
                    count++;
                    helper(grid,i,j);
                }
            }
        }

        return count;
    }

    public void helper(char[][] grid,int row,int col){
        visited[row][col] = 1;

        if(grid[row][col]=='1'){
            for(int i=0;i<4;i++){
                int tempI = row+rows[i],
                tempJ = col+cols[i];
                if(validate(tempI,tempJ) && visited[tempI][tempJ]!=1)
                    helper(grid,tempI,tempJ);
            }
        }
    }

    public boolean validate(int i, int j){
        if(i>=0 && i<visited.length && j>=0 && j<visited[0].length)
            return true;
        return false;
    }
}