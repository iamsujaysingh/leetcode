/**
https://leetcode.com/problems/binary-tree-coloring-game
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

    int lCount = 0, rCount=0;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        count(root,x);
        return Math.max(Math.max(lCount,rCount),n-lCount-rCount-1)
>n/2;

        
    }

    public int count(TreeNode root,int x){
        if(root==null)
            return 0;
        int l = count(root.left,x);
        int r = count(root.right,x);

        if(root.val==x){
            lCount = l;
            rCount = r;
        }
        return l+r+1;
    }
}