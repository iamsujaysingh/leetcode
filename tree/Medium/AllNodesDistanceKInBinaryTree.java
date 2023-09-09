/**
https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/submissions/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    Map<TreeNode,Integer> map = new HashMap();
    List<Integer> result = new ArrayList();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        getDistance(root,target);

        dfs(root,k,0);

        return result;
        
    }

    public void getDistance(TreeNode root,TreeNode target){
        if(root==null)
             return;
        
        if(root==target){
            map.put(root,0);
            return;
        }

        getDistance(root.left,target);
        if(map.containsKey(root.left)){
            map.put(root,map.get(root.left)+1);
            return;
        }
        getDistance(root.right,target);
        if(map.containsKey(root.right)){
            map.put(root,map.get(root.right)+1);
        }
            
    }

    public void dfs(TreeNode root,int k,int distance){

        if(root==null)
            return;
        if(map.containsKey(root)){
            distance = map.get(root);
        }
        if(distance==k)
            result.add(root.val);
        
        dfs(root.left,k,distance+1);
        dfs(root.right,k,distance+1);


    }
}

