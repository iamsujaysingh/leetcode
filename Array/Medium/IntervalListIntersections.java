/*
* https://leetcode.com/problems/interval-list-intersections/submissions/
*/
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        int k=0;
        List<List<Integer>> resultList = new ArrayList();
        int len = (firstList.length<=secondList.length)?firstList.length:secondList.length;
        int i=0,j=0;
        
        
        while(i<firstList.length && j<secondList.length){
            if(firstList[i][0]<=secondList[j][1] && firstList[i][1]>=secondList[j][0]){
                int max=(firstList[i][0]>=secondList[j][0])?firstList[i][0]:secondList[j][0];
                int min=(firstList[i][1]<=secondList[j][1])?firstList[i][1]:secondList[j][1];
                
                List<Integer> temp = new ArrayList(Arrays.asList(max,min));
                resultList.add(k,new ArrayList(temp));
                k++;
                
            }
            
            if(firstList[i][1]<=secondList[j][1])
                    i++;
                else 
                    j++;
        }
        
        //System.out.println(resultList);
        return convert(resultList);
        
    }
    
    public int[][] convert(List<List<Integer>> list){
        int result [][] = new int[list.size()][2];int i=0;
        for(List<Integer> temp : list){
            result[i][0]=temp.get(0);
            result[i][1]=temp.get(1);
            i++;
        }
        return result;
    }
}