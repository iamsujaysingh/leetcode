/*
* https://leetcode.com/problems/rotating-the-box/
*/
class Solution {
    public char[][] rotateTheBox(char[][] box) {
        char result[][] = new char[box[0].length][box.length];
        int index=box.length;
        Queue<Integer> queue;
        
        for(int i=0;i<box.length;i++){
            queue = new LinkedList();
            for(int j=box[i].length-1;j>=0;j--){
                // case where obstacle is encountered
                if(box[i][j]=='*'){
                    queue = new LinkedList();
                }
                //case where empty
                else if(box[i][j]=='.'){
                    queue.add(j);
                }
                // case where stone is encountered
                else{
                    if(!queue.isEmpty()){

                        box[i][j]='.';
                        box[i][queue.remove()]='#';
                        queue.add(j);
                    }
                    
                }
            }
        }
        
        for(int i=0;i<box.length;i++){
            for(int j=0;j<box[0].length;j++){
                result[j][index-i-1]=box[i][j];
            }
        }
        
        return result;
        
    }
    
//      public char[][] rotateTheBox(char[][] box) {
         
//      }
}