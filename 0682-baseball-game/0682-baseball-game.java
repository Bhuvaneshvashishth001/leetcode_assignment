import java.util.*;

class Solution {
    public int calPoints(String[] op) {
        Stack<Integer> stack = new Stack<>();

        for (String s : op) {
            if (s.equals("C")) {
                stack.pop();
            } 
            else if (s.equals("D")) {
                stack.push(2 * stack.peek());
            } 
            else if (s.equals("+")) {
                int first = stack.pop();
                int second = stack.peek();
                stack.push(first); // restore
                stack.push(first + second);
            } 
            else {
                stack.push(Integer.parseInt(s));
            }
        }

        // final sum
        int ans = 0;
        for (int val : stack) {
            ans += val;
        }

        return ans;
    }
}