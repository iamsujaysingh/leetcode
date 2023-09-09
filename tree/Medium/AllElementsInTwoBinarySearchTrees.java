/**
https://leetcode.com/problems/all-elements-in-two-binary-search-trees/submissions/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> l1 = new ArrayList();
    List<Integer> l2 = new ArrayList();
    List<Integer> result = new ArrayList();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        helper(root1,l1);
        helper(root2,l2);
        int i=0,j=0;

        while(i<l1.size() && j<l2.size()){
            if(l1.get(i)<l2.get(j)){
                result.add(l1.get(i));
                i++;
            }
            else{
                result.add(l2.get(j));
                j++;
            }
        }
        if(i<l1.size()){
            for(;i<l1.size();i++){
                result.add(l1.get(i));
            }
        }
        if(j<l2.size()){
            for(;j<l2.size();j++){
                result.add(l2.get(j));
            }
        }

        return result;
    


        
    }

    public void helper(TreeNode root,List<Integer> list){
        if(root==null)
            return;
        if(root.left!=null)
            helper(root.left,list);
        list.add(root.val);
        if(root.right!=null)
            helper(root.right,list);
    }
}