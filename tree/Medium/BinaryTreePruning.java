/**
https://leetcode.com/problems/binary-tree-pruning/submissions/
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
    public TreeNode pruneTree(TreeNode root) {
        
        return recurse(root);
    }

    public TreeNode recurse(TreeNode root){
        if(root == null)
            return root;
        TreeNode l = recurse(root.left);
        TreeNode r = recurse(root.right);

        if(l==null)
            root.left=null;
        if(r==null)
            root.right=null;

        if(root.val==0 && l==null && r == null){
            root=null;
        }
        return root;
    }
}