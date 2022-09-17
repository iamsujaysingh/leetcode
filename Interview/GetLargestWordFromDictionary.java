import java.util.HashMap;
public class GetLargestWordFromDictionary {
    public static void main(String args[]) {
      String[] array = {"to", "banana", "toe", "dogs", "ababcd", "elephant"};
      String input = "ogtdes";
      

      System.out.println(getLargestWordFromDictionary(array, input));
    }
    
    public static String getLargestWordFromDictionary(String[] array,String input){
        
        String result ="";
        int max = Integer.MIN_VALUE;
        
        //store in hasmap for input
        HashMap<Character,Integer> inputMap = new HashMap<>();
        for(Character c: input.toCharArray()){
            inputMap.put(c,inputMap.getOrDefault(c,0)+1);
        }
        
        //loop over all words
        for(String word:array){
            // iterate over letters and reduce count in hasmap clone
            HashMap<Character,Integer> inputClone = new HashMap<>(inputMap);
            int i;
            for(i=0;i<word.length();i++){
                if(inputClone.getOrDefault(word.charAt(i),0)>0){
                    inputClone.put(word.charAt(i),inputClone.get(word.charAt(i))-1);
                }
                else break;
            }
            // keep rack of maxlength
            if(i==word.length() && max<word.length()){
                result = word;
                max = word.length();
            }
        }
        
        return result;
            
            
        // return word
    }
}
