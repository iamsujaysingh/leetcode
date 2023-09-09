/**
https://leetcode.com/problems/add-one-row-to-tree
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

    Queue<TreeNode> q = new LinkedList();

    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        if(root==null)
             return root;
        if(depth==1){
            TreeNode rootTemp = new TreeNode(val);
            rootTemp.left = root;
            root=rootTemp;
            return root;
        }
        
        q.offer(root);
        int level = 0;
        boolean flag=false;

        while(!q.isEmpty()){
            level++;
            int size = q.size();
            if(level==depth-1)
                flag=true;

            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(flag){
                    TreeNode left = curr.left;
                    TreeNode right = curr.right;
                    TreeNode rootTemp1 = new TreeNode(val);
                    TreeNode rootTemp2 = new TreeNode(val);
                    rootTemp1.left=left;
                    rootTemp2.right=right;
                    curr.left=rootTemp1;
                    curr.right=rootTemp2;
                }
                else{
                    if(curr.left!=null)
                        q.offer(curr.left);
                    if(curr.right!=null)
                        q.offer(curr.right);
                }
            }
            if(flag==true)
                return root;
        }

        return root;
        
    }
}