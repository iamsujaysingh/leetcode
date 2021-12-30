/**
https://leetcode.com/problems/insert-delete-getrandom-o1
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

class RandomizedSet {
    
    List<Integer> list ;
    Map<Integer,Integer> map;
    
    

    public RandomizedSet() {
        list = new ArrayList();;
        map = new HashMap();   
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        else{
            list.add(val);
            map.put(val,list.size()-1);
            return true;
        }
        
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)){
            //swap
            int temp = list.get(list.size()-1);
            list.set(list.size()-1,val);
            list.set(map.get(val),temp);
            list.remove(list.size()-1);
            map.put(temp,map.get(val));
            map.remove(val);
            return true;
        }
        else
            return false;
        
    }
    
    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
        
    }
}

