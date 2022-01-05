/*
https://leetcode.com/problems/single-number/

Some more rules related to XOR (now i will just represent XOR by ‘^’).

a^a = 0

0^a = a

*/
class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        for(int i : nums){
            a = a^i;
        }
        return a;
        
    }
}