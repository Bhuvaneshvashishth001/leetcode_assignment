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
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[list.size()];
        for(int i=list.size()-1;i>=0;i--){
            while(!stack.isEmpty() && list.get(stack.peek())<= list.get(i)){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = 0;
            }
            else{
                ans[i] = list.get(stack.peek());
            }
            stack.push(i);
        }
        return ans;
    }
}