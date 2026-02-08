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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head.next;
        ListNode dummy = head;
        while(temp != null){
            if(dummy.val != temp.val){
                dummy.next = temp;
                dummy = dummy.next;
            }
            temp = temp.next;
        }
        dummy.next = null;
        return head;
    }
}