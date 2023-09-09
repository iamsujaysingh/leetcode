/**
https://leetcode.com/problems/validate-binary-search-tree
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
    List<Integer> list = new ArrayList();
    

    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true; 

        helper(root);

        for(int i=1;i<list.size();i++){
            if(list.get(i-1)>=list.get(i))
                return false;
        }

        return true;
    }

    public void helper(TreeNode root){
       
       boolean left=false,right=false;

        if(root.left!=null)
            helper(root.left);
   
        list.add(root.val);

        if(root.right!=null)
            helper(root.right); 

    }
}