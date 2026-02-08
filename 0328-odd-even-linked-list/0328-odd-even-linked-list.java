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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode o = new ListNode(0);
        ListNode e = new ListNode(0);
        ListNode o1 = o;
        ListNode e1 = e;
        while(odd != null && odd.next !=null){
            o1.next = new ListNode(odd.val);
            o1 = o1.next;
            odd = odd.next.next;
        }
        if(odd!= null){
            o1.next=new ListNode(odd.val);
            o1 = o1.next;
        }
        while(even != null && even.next != null){
            e1.next = new ListNode(even.val);
            e1 = e1.next;
            even = even.next.next;
        }
        if(even!= null){
            e1.next=new ListNode(even.val);
            e1 = e1.next;
        }
        ListNode temp = o.next;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = e.next;
        return o.next;
    }
}