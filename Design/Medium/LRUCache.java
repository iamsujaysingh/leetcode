/*
* https://leetcode.com/problems/lru-cache/submissions/
*/
class LRUCache {
    
    HashMap<Integer,Node> myMap;
      final Node head = new Node();
      final Node tail = new Node();
    
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        myMap = new HashMap(capacity);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        Node node = myMap.get(key);
        if(node!=null){
            remove(node);
            add(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node = myMap.get(key);
        if(node!=null){
            node.val=value;
            remove(node);
            add(node);
        }else{
            if(myMap.size()==capacity){
                myMap.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode = new Node();
            newNode.val=value;
            newNode.key=key;
            myMap.put(key,newNode);
            add(newNode);
            
        }
        
    }
    
    public void add(Node node){ 
        Node head_next = head.next;
        node.next=head_next;
        head_next.prev=node;
        head.next=node;
        node.prev=head;
        
    }
    
    public void remove(Node node){
        Node node_next=node.next;
        Node node_prev=node.prev;
        node_next.prev=node_prev;
        node_prev.next=node_next;
        
    }
    
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */