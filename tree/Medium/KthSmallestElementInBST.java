/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/submissions/
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
    int count;
    public int kthSmallest(TreeNode root, int k) {
        count=k;
       TreeNode mynode = helperTree(root);
        if(mynode==null)
            return -1;
        return mynode.val;
    }
    
    public TreeNode helperTree(TreeNode root){
        if(root==null)
            return null;
        TreeNode left = helperTree(root.left);
        if(left!=null)
            if(count==1)
                return left;
            else
                count--;
        
        if(count==1)
            return root;
        else
            count--;
        
        TreeNode right = helperTree(root.right);
        return right;
        
    }
}