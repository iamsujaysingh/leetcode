/*
https://leetcode.com/problems/combinations/
*/

class Solution {
    
    List<List<Integer>> myList = new ArrayList();
    
    public List<List<Integer>> combine(int n, int k) {
        
        int arr [] = new int [n];
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }
        
        recurse(arr,0,k,0,new ArrayList<Integer>());
        return myList;
    }
    
    public void recurse(int arr[],int index,int count,int start,List<Integer> list){
        if(index==count){
           myList.add(new ArrayList(list));
            return;
        }
        else{
            for(int i = start ; i<arr.length;i++){
                list.add(arr[i]);
                recurse(arr,index+1,count,i+1,list);
                list.remove(list.size()-1);
            }
        }
    }
}