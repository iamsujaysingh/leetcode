/*
* https://leetcode.com/problems/trapping-rain-water/submissions/
*/
class Solution {
    public int trap(int[] height) {
        
        return usingArray(height);
        
    }
    
    public int usingArray(int[] height){
        
        int size = height.length;
        int leftmax[] = new int[size];
        int rightmax[] = new int[size];
        int water = 0;
        
        for(int i=0;i<size;i++){
            if(i==0){
                leftmax[i]=height[i];
                rightmax[size-i-1]=height[size-i-1];
            }
            else{
                leftmax[i]= Math.max(leftmax[i-1],height[i]);
                rightmax[size-i-1] = Math.max(rightmax[size-i],height[size-i-1]);
            }
        }
        
        for(int i=0;i<size;i++){
            water+=Math.min(leftmax[i],rightmax[i])-height[i];
        }
        return water;
    }
}