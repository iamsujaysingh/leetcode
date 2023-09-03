
https://leetcode.com/problems/all-possible-full-binary-trees/
/**
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

        if(n==1)
            list.add(new TreeNode(0));
        n-=1;

        for(int i=1;i<=n;i+=2){
            List<TreeNode> leftList = allPossibleFBT(i);
            List<TreeNode> rightList = allPossibleFBT(n-i);

            for(TreeNode l:leftList){
                for(TreeNode r:rightList){
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        map.put(n+1,list);
        return list;

    }
}