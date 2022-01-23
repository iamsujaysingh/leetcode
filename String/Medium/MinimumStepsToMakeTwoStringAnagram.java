/*
* https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
*/

class Solution {
    public int minSteps(String s, String t) {
        
        int array1 [] = assign();
        int array2 [] = assign();
        
        //fill(array1,s);
        for(int i=0;i<s.length();i++){
            array1[s.charAt(i)-'a']+=1;
            array2[t.charAt(i)-'a']+=1;
        }
        
        //calculate
        int diff=0,sum=0;
        for(int i=0;i<26;i++){
            diff = array1[i]-array2[i];
            if(diff>0){
                sum+=diff;
            }
                
        }
        
        return sum;
        
    }
    
    public int[] assign(){
        int arr [] = new int[26];
        for(int i=0;i<26;i++){
            arr[i]=0;
        }
        return arr;
    }
}