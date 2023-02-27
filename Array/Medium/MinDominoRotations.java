//https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/submissions/
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        int ele [] ={tops[0],bottoms[0]};
        int count[][] = new int[2][3];
        List<Integer> list = new ArrayList();
        
        for(int i=0;i<2;i++){
            for(int j=0;j<tops.length;j++){
                if(ele[i]!=tops[j] && ele[i]!=bottoms[j])
                {
                    count[i][0]++;
                    break;
                }
                else if(ele[i]!=tops[j]){
                    count[i][1]++;
                }
                else if(ele[i]!=bottoms[j]){
                    count[i][2]++;
                }
            }
        }
        
        for(int i=0;i<2;i++){
            if(count[i][0]==0){
                list.add(count[i][1]);
                list.add(count[i][2]);
            }
        }
        if(list.size()>0){
            Collections.sort(list);
            return list.get(0);
        }
        return -1;
        
        
        
    }
}
