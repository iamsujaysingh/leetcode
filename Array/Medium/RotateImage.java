/*
* https://leetcode.com/problems/rotate-image/submissions/
*/
class Solution {
    public void rotate(int[][] matrix) {
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<i;j++){
                swap(matrix,i,j,j,i);
            }
        }
        int col = matrix[0].length-1;
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length/2;j++){
                swap(matrix,i,j,i,col-j);
                
            }
        }
        
    }
    
    public void swap(int[][] matrix,int i1,int j1,int i2,int j2){
        int temp = matrix[i1][j1];
        matrix[i1][j1]=matrix[i2][j2];
        matrix[i2][j2]=temp;
    }
}