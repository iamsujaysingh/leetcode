class Solution {
    
    public String modify(int count){
        String s ="";
        for(int i=1;i<=count;i++){
            s+="0";
        }
        return s;
    }
    public String addStrings(String num1, String num2) {
        
        int diff = num1.length()-num2.length();
        if(diff>0){
            num2 = modify(diff)+num2;
        }
        if(diff<0){
            num1 = modify(Math.abs(diff))+num1;
        }
        
        String result ="";
        int sum=0,carry =0;
        
        for(int i=num1.length()-1;i>=0;i--){
            
            int a1 = num1.charAt(i)-'0';
            int a2 = num2.charAt(i)-'0';
            
            sum = (a1+a2+carry)%10;
            carry = (a1+a2+carry)/10;
            
            result = sum + result;
        }
        if(carry>0){
            result = carry+result;
        }
        return result;
        
    }
}