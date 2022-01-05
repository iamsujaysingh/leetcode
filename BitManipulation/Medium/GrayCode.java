/*
https://leetcode.com/problems/gray-code/submissions/
https://www.youtube.com/watch?v=ciGopaVa1ZE
*/
class Solution {
    public List<Integer> grayCode(int n) {
        
        if(n==0){
            List<Integer> list = new ArrayList();
            list.add(0);
            return list;
        }
        else{
            List<Integer> list = grayCode(n-1);
            int numToAdd = (int)(Math.pow(2,n-1));
            for(int i = list.size()-1;i>=0;i--){
                list.add((numToAdd + list.get(i)));
            }
            
            return list;
        }
        
    }
}