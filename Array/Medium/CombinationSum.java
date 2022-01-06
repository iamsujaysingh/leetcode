/*
https://leetcode.com/problems/combination-sum/
*/
class Solution {
    
    List<List<Integer>> myList = new ArrayList();
    Set<List<Integer>> set = new HashSet();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        
        recurse(candidates,0,target,0,new ArrayList<Integer>());
        convertSetToList();
        
        return myList;
        
    }
    
    public void recurse(int arr[],int sum,int target,int start,List<Integer> list){
        if(sum==target){
            set.add(new ArrayList(list));
            return;
        }else if(sum>target){
            return;
        }
        else{
            for(int i=start;i<arr.length;i++){
                list.add(arr[i]);
                int tempSum =  sum + arr[i];
                recurse(arr,tempSum,target,i+1,list);
                recurse(arr,tempSum,target,i,list);
                list.remove(list.size()-1);
            }
        }
    }
    
    public void convertSetToList(){
        for(List<Integer> tempList: set){
            myList.add(new ArrayList(tempList));
        }
    }
}