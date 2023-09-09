/**
https://leetcode.com/problems/balance-a-binary-search-tree/submissions/
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
    List<Integer> list = new ArrayList()
;
    public TreeNode balanceBST(TreeNode root) {
        if(root==null)
            return root;
        inorder(root);
        return treeCreate(0,list.size()-1);
        
    }

    public void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    public TreeNode treeCreate(int start,int end){
        //int start = 0,end = list.size(),mid = (start+end)/2;
        if(start>end)
            return null;
        else{

            int mid = (start+end)/2;
            TreeNode temp = new TreeNode(list.get(mid));
            temp.left = treeCreate(start,mid-1);
            temp.right = treeCreate(mid+1,end);
            return temp;
        }

        
    }
}