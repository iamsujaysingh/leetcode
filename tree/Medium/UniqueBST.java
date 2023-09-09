//https://leetcode.com/problems/unique-binary-search-trees/
//https://www.baeldung.com/cs/get-number-of-binary-search-trees-n-distinct-elements

class Solution {
    public int numTrees(int n) {
        int sol[] = new int[n+1];
        sol[0]=1;

        for(int i=1;i<=n;i++){
            int count =0;
            for(int j=1;j<=i;j++){
                count+=sol[j-1]*sol[i-j];
            }
            sol[i]=count;
        }
        return sol[n];
        
    }
}