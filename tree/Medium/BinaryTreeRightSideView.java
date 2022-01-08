/**
https://leetcode.com/problems/binary-tree-right-side-view/
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
    
    List<Integer> list = new ArrayList();
    Queue<TreeNode> queue = new LinkedList();
    
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> list = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();

        
        if(root!=null) {
            
            queue.offer(root);
            
            while(!queue.isEmpty()){
                
                int size = queue.size();
                
                for(int i=1;i<=size;i++){
                    
                    TreeNode node = queue.poll();
                    
                    if(i==size)
                        list.add(node.val);
                    
                    if(node.left!=null)
                        queue.offer(node.left);
                    
                    if(node.right!=null)
                        queue.offer(node.right);
                    
                }
                
            }
            
        }
        
        return list;
        
        
    }
    
}