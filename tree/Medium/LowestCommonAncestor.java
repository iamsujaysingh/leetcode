/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return findLCA(root,p,q);  
    }
    
    public TreeNode findLCA(TreeNode root,TreeNode p,TreeNode q){
        
        if(root==null)
            return null; 
        
        if(root.val == p.val || root.val == q.val)
            return root;
        
        TreeNode nodeLeft = findLCA(root.left,p,q);
        TreeNode nodeRight = findLCA(root.right,p,q);
        
        if(nodeLeft!=null && nodeRight!=null)
            return root;
        else
            return (nodeLeft!=null)?nodeLeft:nodeRight;
        
    }
}