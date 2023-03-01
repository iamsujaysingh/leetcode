//https://leetcode.com/problems/count-sub-islands/description/?envType=study-plan&id=graph-i
class Solution {
    int visited[][];
    int rows [] = {-1,0,0,1};
    int cols [] = {0,1,-1,0};
    int validate = 1;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length,n = grid1[0].length;
        visited = new int [m][n];
        int count = 0 ;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                validate = 1;
                if(visited[i][j]!=1 && grid2[i][j]==1){
                    helper(grid1,grid2,i,j);
                    if(validate==1)
                        count++;
                }
            }
        }
        return count;
        
    }

    public void helper(int [][] grid1, int [][] grid2, int row, int col){
        visited[row][col]=1;
        validate *= grid1[row][col];

        for(int i=0;i<4;i++){
            int tempI = row+rows[i], tempJ = col+cols[i];
            if(isValid(tempI,tempJ) && visited[tempI][tempJ]!=1 && grid2[tempI][tempJ]==1){
                helper(grid1,grid2,tempI,tempJ);
            }
        }
    }

    public boolean isValid(int i,int j){
        if(i>=0 && i<visited.length && j>=0 && j<visited[i].length)
            return true;
        return false;
    }
}