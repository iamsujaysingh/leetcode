// https://leetcode.com/problems/split-array-largest-sum
// BACKTRACKING
class Solution {
    
    public boolean check(int nums[],int m,int min,int max){
        int tempSum=0,count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max)
                return false;
            tempSum+= nums[i];
            
            if(tempSum>max){
                count++;
                tempSum=nums[i];
            }
        }
        count++;
        if(count<=m)
            return true;
        return false;
    }
    public int splitArray(int[] nums, int m) {
        int min= nums[0],max=0;
        for(int i=0;i<nums.length;i++){
            min = Math.max(min,nums[i]);
            max+=nums[i];
        }
        int answer=0;
        
        while(min<=max){
            int mid = (max+min)/2;
            
            if(check(nums,m,min,mid)){
                answer = mid;
                max = mid-1;
            }
            else{
                min = mid+1;
            }
        }
        return answer;
    }
    
//     int ans = Integer.MAX_VALUE;
    
//     public int splitArray(int[] nums, int m) {
//         splitHelper(nums,m,0,0);
//         return ans;
//     }
    
//     public void splitHelper(int nums[],int m,int curr,int maxvalue){
//         if(m==1){
//             int sum=0;
//             for(int i=curr;i<nums.length;i++)
//                 sum+=nums[i];
//             maxvalue = Math.max(sum,maxvalue);
//             ans = Math.min(maxvalue,ans);
//         }
//         else{
//             int sum=0;
//             for(int i=curr;i<nums.length;i++){
//                 sum+=nums[i];
//                 maxvalue=Math.max(sum,maxvalue);
//                 splitHelper(nums,m-1,i+1,maxvalue);
//             }
//         }
        
//     }
    
    
}