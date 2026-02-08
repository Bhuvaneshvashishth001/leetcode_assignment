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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next ==null){
            return head;
        }
        int count =0;
        ListNode temp = head;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        if(count<k){
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        int c = 0;
        while(curr != null && c<k){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            c++;
        }
        head.next = reverseKGroup(next,k);
        return prev;
    }
}