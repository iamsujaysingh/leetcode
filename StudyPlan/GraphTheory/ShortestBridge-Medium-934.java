// https://leetcode.com/problems/shortest-bridge/?envType=study-plan-v2&envId=graph-theory
class Solution {
    int rows[]={0,0,1,-1};
    int cols[]={1,-1,0,0};
    int m,n;

    public int shortestBridge(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int color = 2;

        bfsHelper(grid);

        while(true){
            for(int i=0;i<grid.length;i++){
                for(int j=0;j<grid[i].length;j++){
                    if(grid[i][j]==color){
                        for(int k=0;k<4;k++){
                            int row=i+rows[k],col=j+cols[k];
                            if(validate(row,col)){
                                if(grid[row][col]==1)
                                    return color-2;
                                if(grid[row][col]==0)
                                    grid[row][col]=color+1;
                            }
                        }
                    }
                }
            }
            color+=1;
        }
        
    }

    public void bfsHelper(int[][] grid){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1)
                {
                    bfs(grid,i,j);
                    return;
                }
            }
        }
    }

    public void bfs(int[][] grid,int i,int j){
        grid[i][j]=2;

        for(int k=0;k<4;k++){
            int row = i+rows[k], col = j+cols[k];
            if(validate(row,col) && grid[row][col]==1)
                bfs(grid,row,col);
        }
    }

    public boolean validate(int row,int col){
        if(row>=0 && row<m && col>=0 && col<n)
            return true;
        return false;
    }
}