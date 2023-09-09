/*https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
*/
class Solution
{
    public void leftBoundary(Node node,ArrayList<Integer> list){
        if(node==null)
            return;
        if(node.left!=null){
            list.add(node.data);
            leftBoundary(node.left,list);
        }
        else if(node.right!=null){
            list.add(node.data);
            leftBoundary(node.right,list);
        }
    }
    
    public void rightBoundary(Node node,ArrayList<Integer> list){
        if(node==null)
            return;
        if(node.right!=null){
            rightBoundary(node.right,list);
            list.add(node.data);
        }
        else if(node.left!=null){
            rightBoundary(node.left,list);
            list.add(node.data);
        }
    }
    public void leaves(Node node,ArrayList<Integer> list){
        if(node==null)
            return;
        if(node.left==null && node.right==null){
            list.add(node.data);
            return;
        }
        leaves(node.left,list);
        leaves(node.right,list);
    }
    
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> list = new ArrayList();
	    
	    if(node==null)
	        return list;
	   
	   if(!(node.left==null && node.right==null))
	    list.add(node.data);
	    
	    leftBoundary(node.left,list);
	    leaves(node,list);
	    rightBoundary(node.right,list);
	    
	    return list;
	    
	}
}