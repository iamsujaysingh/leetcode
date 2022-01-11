/*
* https://leetcode.com/problems/binary-gap/submissions/
*/
class Solution {
    public int binaryGap(int n) {
        
        int gap = 0, tempGap =0;
        int mult = 0;
        
        while(n>0){
            mult = n & 1; // getting the last digit
            n = n>>1;
            
            if(mult == 0 && tempGap>=1){
                tempGap++;
            }
            if(mult == 1){
                gap = (gap<tempGap)?tempGap:gap;
                tempGap = 1;
            }
            
        }
        return gap;
        
    }
}