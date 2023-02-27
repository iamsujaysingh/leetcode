//https://leetcode.com/problems/flood-fill/description/?envType=study-plan&id=graph-i

class Solution {

    int visited[][];
    int rows [] = {-1,0,0,1};
    int cols [] = {0,-1,1,0};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        visited = new int[image.length][image[0].length];
        int color = image[sr][sc];
        helper(image,sr,sc,color,newColor);
        return image;
    }

    public void helper(int[][] image, int row, int col, int color, int newColor){
        if(image[row][col] == color){
            image[row][col] = newColor;
            visited[row][col] = 1;

            for(int i=0;i<4;i++){
                int tempI=row+rows[i],
                tempJ=col+cols[i];
                if(validate(tempI,tempJ) && visited[tempI][tempJ]!=1){
                     helper(image,tempI,tempJ,color,newColor);
                }
            }

        }
        
    }

    public boolean validate(int i, int j){
        if(i<visited.length && i>=0 && j>=0 && j<visited[0].length){
            return true;
        }
        return false;
    }
}