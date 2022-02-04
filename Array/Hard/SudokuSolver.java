/*
* https://leetcode.com/problems/sudoku-solver/
*/
class Solution {
    public void solveSudoku(char[][] board) {
        
        solveHelper(board,0,0);
        
    }
    
    public boolean solveHelper(char[][] board,int row,int col){
        
        if(row==8 && col==9)
            return true;
        
        if(col==9){
            col=0;
            row++;
        }
        
        if(board[row][col]!='.' || Character.isDigit(board[row][col])){
            return solveHelper(board,row,col+1);
        }
            
        
        for(int k=1;k<=9;k++){
            
            if(isSafe(board,row,col,k))
            {
                board[row][col]=(char)(k+'0');
                if(solveHelper(board,row,col+1))
                    return true;
            }
            board[row][col]='.';
        }
        return false;
    }
    
    public boolean isSafe(char[][] board,int row,int col,int num){
        
        for(int i=0;i<9;i++)
            if(num==(board[row][i]-'0'))
                return false;
        
        for(int i=0;i<9;i++)
            if(num==(board[i][col]-'0'))
                return false;
        
        int startRow = row-row%3;
        int startCol = col-col%3;
        
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(num==(board[i+startRow][j+startCol]-'0'))
                    return false;
        
        return true;
    }
    
    
    
}