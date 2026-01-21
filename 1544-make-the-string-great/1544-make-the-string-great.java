class Solution {
    public String makeGood(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<n;i++){
            while(i<s.length() && !stack.isEmpty() && (stack.peek() == s.charAt(i)-32 || stack.peek() == s.charAt(i)+32)){
                stack.pop();
                i++;
            }
            if(i<s.length()){
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
        sb.append(stack.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}