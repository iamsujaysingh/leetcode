/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        ArrayList<String> list = new ArrayList();
        helperSerialize(root,list);
        return String.join(",",list);
        
    }
    
    public void helperSerialize(TreeNode root,ArrayList<String> list){
        
        if(root==null){
            list.add(")");
            return;
        }
        
        list.add(Integer.toString(root.val));
        
        helperSerialize(root.left,list);
        helperSerialize(root.right,list);
        
    }
    

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String[] tokens = data.split(",");
        return helperDeserialize(tokens);
        
    }
    int index=0;
    public TreeNode helperDeserialize(String tokens[]){
        if(index==tokens.length || tokens[index].equals(")")){
            index+=1;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(tokens[index]));
        index+=1;
        TreeNode leftTree = helperDeserialize(tokens);
        TreeNode rightTree = helperDeserialize(tokens);
        
        root.left=leftTree;
        root.right=rightTree;
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));