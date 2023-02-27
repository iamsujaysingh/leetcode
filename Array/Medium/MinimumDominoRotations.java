//https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/submissions/

class Solution {
    public int minDominoRotations(int[] top, int[] bottom) {
        //take both the numbers from the first column
        
        //chevk if the each number is in all the columns either first or second column
        
        // while checking keep a count of each row not hvaing the number
        int ele [] = new int[2];
        ele[0]=top[0];ele[1]=bottom[0];
        List<Integer> list = new ArrayList();
        int count [][]=new int[2][3];
        count[0][0]=0;count[1][0]=0;
       
        
        for(int i=0;i<=1;i++){
            for(int j=0;j<top.length;j++){
                if(top[j]!=ele[i] && bottom[j]!=ele[i]){
                    count[i][0]++;
                    break;
                }
                else if(top[j]!=ele[i]){
                    count[i][1]++;
                }
                else if(bottom[j]!=ele[i]){
                    count[i][2]++;
                }
            }
        }
        
        for(int i=0;i<=1;i++){
            if(count[i][0]==0){
                list.add(count[i][1]);
                list.add(count[i][2]);
            }
        }
        if(list.size()>0){
            Collections.sort(list);
            return list.get(0);
        }
        else{
            return -1;
        }
        
    }
}