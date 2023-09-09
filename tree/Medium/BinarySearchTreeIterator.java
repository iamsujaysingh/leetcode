/**
https://leetcode.com/problems/binary-search-tree-iterator/submissions/
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
class BSTIterator {

    Queue<TreeNode> q;

    public BSTIterator(TreeNode root) {
        this.q = new LinkedList();
        update(root);
    }
    
    public int next() {
        return this.q.poll().val;
        
    }
    
    public boolean hasNext() {
        if(!this.q.isEmpty())
            return true;
        return false;
    }

    public void update(TreeNode root){
        if(root==null)
            return;
        update(root.left);
        this.q.offer(root);
        update(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */