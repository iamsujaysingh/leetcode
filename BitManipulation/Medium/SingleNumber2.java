/*
https://leetcode.com/problems/single-number-ii/submissions/
tutorial : https://www.youtube.com/watch?v=cOFAmaMBVps
*/
class Solution {
    public int singleNumber(int[] nums) {
        
        int ones=0,twos=0;
        for(int i:nums){
            ones = (i^ones)&(~twos);
            twos = (i^twos)&(~ones);
        }
        return ones;
        
    }
}