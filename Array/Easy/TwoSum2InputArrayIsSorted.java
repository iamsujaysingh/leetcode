/*
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
*/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int start = 0 , end = numbers.length-1;
        int f=0;
        
        while(start<end){
            if(numbers[start]+numbers[end] == target){
                f=1;
                break;
            }
            else if(numbers[start]+numbers[end] < target)
                start++;
            else
                end--;
        }
        int arr[] ={start+1,end+1};
        return arr;
        
    }
    
}