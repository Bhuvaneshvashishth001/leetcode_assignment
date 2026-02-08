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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode temp = head;
        if(head == null || head.next == null){
            return head;
        }
        
        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        k=k%len;
        if(k==0){
            return head;
        }
        int till = len-k;
        int count = 1;
        temp = head;
        while(count <till){
            count++;
            temp = temp.next;
        }
        ListNode dummy = temp.next;
        temp.next = null;
        ListNode temp1 = dummy;
        while(temp1.next!=null){
            temp1 = temp1.next;
        }
        temp1.next = head;
        return dummy;
    }
}