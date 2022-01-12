/*
 * https://leetcode.com/problems/sort-colors/
 * Now this approach is basically based on the concept of The Dutch National Flag Problem. 
 * This is basically an approach where we divide our array into partitions which are :
 * array[0 to low-1] = 0 is present
 * array[low to mid-1] = 1 is present
 * array[mid to end - 1] = unknown
 * arrayendto n(size of array)] = 2 is present
*/

class Solution {
    
    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        
        int low =0,mid =0,end = nums.length-1;
        
        while(mid<=end){
            
            if(nums[mid]==0){
                swap(nums,low,mid);
                low++;
                mid++;
            }
            
            else if(nums[mid]==1)
                mid++;
            
            else{
                swap(nums,mid,end);
                end--;
            }
        }
        
    }
}