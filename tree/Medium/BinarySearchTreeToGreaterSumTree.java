/**
https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree
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
    List<TreeNode> list = new ArrayList();

    public TreeNode bstToGst(TreeNode root) {
        recurse(root);
        update();
        return root;
    }

    public void recurse(TreeNode root){
        if(root == null)
            return;
        if(root.right!=null){
            recurse(root.right);
        }
        list.add(root);
        recurse(root.left);      
    }

    public void update(){
        for(int i = 1;i<list.size();i++){
            TreeNode temp = list.get(i);
            temp.val += list.get(i-1).val;
        }
    }
}