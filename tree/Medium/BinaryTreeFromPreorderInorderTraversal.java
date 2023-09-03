/**
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return helper(preorder,inorder,0,0,inorder.length-1);
        
        
    }

    public TreeNode helper(int preorder[],int[] inorder,int p,int start,int end){
        if(p>=preorder.length)
            return null;
        
        TreeNode root = new TreeNode(preorder[p]);
        int mid=start;
        for(int i=start;i<=end;i++){
            if(inorder[i]==preorder[p]){
                mid=i;
                break;
            }
        }

        root.left = (start<mid)?helper(preorder,inorder,p+1,start,mid-1):null;
        root.right = (end>mid)?helper(preorder,inorder,p+(mid-start)+1,mid+1,end):null;

        return root;

    }
}