/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode colide(ListNode tempA,ListNode tempB,int dis){
        while(dis>0){
            tempB = tempB.next;
            dis--;
        }
        while(tempA!=tempB){
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int n1 = 0;
        int n2 = 0;
        while(temp1 != null){
            n1++;
            temp1 = temp1.next;
        }
        while(temp2 != null){
            n2++;
            temp2 = temp2.next;
        }
        if(n2>n1){
            return colide(headA,headB,n2-n1);
        }
        return colide(headB,headA,n1-n2);
    }
}