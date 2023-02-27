/*
* https://leetcode.com/problems/word-ladder/submissions/
*/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> set = new HashSet();
        int depth = 0, level = 1;
        Queue<String> queue = new LinkedList();
        
        //create a set of words
        for(String s : wordList){
            set.add(s);
        }
        
        queue.offer(beginWord);
        
        //iterate over all depths of the grapg
        while(!queue.isEmpty()){
            int newLevel = 0;
            //iterate over all levels of the graph
            for(int i=0;i<level;i++){
                String temp = queue.poll();
                //create all transformations for each letter
                for(int j=0;j<temp.length();j++){
                    // iterate all letters except the current character at j to create all combinations
                    for(int k=1;k<=26;k++){
                        String temp1 = transform(temp,j,k);
                        if(set.contains(temp1)){
                            if(temp1.equals(endWord))
                                return depth+2;
                            queue.offer(temp1);
                            set.remove(temp1);
                            newLevel++;
                        }
                    }
                    
                }
            }
            level = newLevel;
            depth++;
        }
        
        return 0;
        
        
    }
    
    public String transform(String word,int curr,int index){
        String newWord="";
        for(int i=0;i<word.length();i++){
            if(i!=curr)
                newWord+=word.charAt(i);
            else{
                newWord+=(char)(96+index);
            }
        }
        return newWord;
    }
}