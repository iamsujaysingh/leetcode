/*
https://leetcode.com/problems/first-unique-character-in-a-string/
*/
class Solution {
    public int firstUniqChar(String s) {
        
        TreeMap<Character,Integer> map = new TreeMap();
        
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            else
                map.put(s.charAt(i),1);
        }
        
        int minIndex = Integer.MAX_VALUE,f=0;
        
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                f=1;
                int tempIndex = s.indexOf(entry.getKey());
                minIndex = (minIndex>tempIndex)?tempIndex:minIndex;
            }
                
        }
        if(f==1)
            return minIndex;
        return -1;
        
    }
}