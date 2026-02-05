/**
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
    public ListNode doubleIt(ListNode head) {
        ListNode newHead = new ListNode(0);
        ListNode dummy = newHead;
        ListNode temp = head;
        while(temp!= null){
            int val = temp.val*2;
            if(val<10){
                dummy.next = new ListNode(val);
            }
            else{
                dummy.val = dummy.val+1;
                dummy.next = new ListNode(val%10);
            }
            dummy = dummy.next;
            temp = temp.next;
        }
        if(newHead.val ==0){
            return newHead.next;
        }
        return newHead;
    }
}