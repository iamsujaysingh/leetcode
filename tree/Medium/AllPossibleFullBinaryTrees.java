/**
https://leetcode.com/problems/all-possible-full-binary-trees/submissions/
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

    Map<Integer,List<TreeNode>> map = new HashMap();
    public List<TreeNode> allPossibleFBT(int n) {

        if(map.containsKey(n))
            return map.get(n);

        List<TreeNode> list = new ArrayList();

        if(n==1){
            TreeNode temp = new TreeNode(0);
            list.add(temp);
        }
        n-=1;
        for(int i=1;i<=n;i+=2){
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n-i);

            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root = new TreeNode(0);
                    root.left=l;
                    root.right=r;
                    list.add(root);
                }
            }
        }
        map.put(n+1,list);
        return list;    
    }
}