/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
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
     int maxHeight=0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        
        helperDiameter(root,0);
        return maxHeight;
    }
   
    public int helperDiameter(TreeNode root, int height){
        if(root==null){
            return 0;
        }
        else{
            int left = helperDiameter(root.left,height+1);
            int right = helperDiameter(root.right,height+1);
            maxHeight = Math.max(left+right,maxHeight);
            return 1+Math.max(left,right);
        }
    }
}