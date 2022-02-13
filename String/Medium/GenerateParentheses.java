/*
* https://leetcode.com/problems/generate-parentheses/submissions/
*/
class Solution {
    List<String> list = new ArrayList();
    public List<String> generateParenthesis(int n) {
        helper(n,1,0,"(");
        return list;
    }
    
    public void helper(int n,int open,int close,String str){
        if(open==n && close==n){
            list.add(str);
            return;
        }else{
            if(open>close){
                helper(n,open,close+1,str+")");
                if(open<n)
                    helper(n,open+1,close,str+"(");
            }else if(open==close){
                helper(n,open+1,close,str+"(");
            }
        }
    }
}