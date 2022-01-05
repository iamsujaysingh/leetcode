/*
https://leetcode.com/problems/subsets/submissions/
*/
class Solution {
    
    List<List<Integer>> myList = new ArrayList();
    
    public List<List<Integer>> subsets(int[] nums) {
        
        for(int i=0;i<=nums.length;i++){
            recurse(nums,0,i,0,new ArrayList<Integer>());
        }
        return myList;
        
        
    }
    
    public void recurse(int nums[],int index,int count,int start,ArrayList<Integer> list){
        if(index==count){
            myList.add(new ArrayList(list));
            return;
            
        }
        else{
            for(int i = start;i<nums.length;i++){
                list.add(nums[i]);
                recurse(nums,index+1,count,i+1,list);
                list.remove(list.size()-1);
            }
        }
    }
}