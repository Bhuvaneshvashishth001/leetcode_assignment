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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode first = head;
        prev.next = head;
        while(first != null && first.next != null){
            ListNode second = first.next;
            ListNode future = second.next;
            prev.next = second;
            second.next = first;
            prev=second.next;
            first.next=future;
            first=future;
        }
        return dummy.next;
    }
}