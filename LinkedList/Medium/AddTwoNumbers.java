/**
 * https://leetcode.com/problems/add-two-numbers/
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode pointer1, ListNode pointer2) {
        
        int carry=0,sum=0;
        ListNode answer = new ListNode(0,null) , pointer3 = answer;
        
        while(pointer1!=null || pointer2!=null){
            
            sum=((pointer1!=null)?pointer1.val:0)+((pointer2!=null)?pointer2.val:0)+carry;
            
            ListNode temp = new ListNode(sum%10,null);
            pointer3.next = temp;
            temp = null;
            pointer3=pointer3.next;
            pointer1=(pointer1!=null)?pointer1.next:null;
            pointer2=(pointer2!=null)?pointer2.next:null;
            
            carry=sum/10;
        }
        
        if(carry>0){
             ListNode temp = new ListNode(carry,null);
             pointer3.next = temp;
             pointer3 = pointer3.next;
        }
        
        return answer.next;
    }
}