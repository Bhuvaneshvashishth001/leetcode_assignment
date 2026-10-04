class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        int len = num.length();
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<num.length();i++){
            if(stack.isEmpty() && num.charAt(i)!='0'){
                stack.push((num.charAt(i)-'0'));
            }
            else{
                while(!stack.isEmpty() && (num.charAt(i)-'0') < stack.peek() && k>0){
                    k--;
                    stack.pop();
                }
                if(stack.isEmpty() && num.charAt(i)!='0'){
                    stack.push((num.charAt(i)-'0'));
                }
                else if(!stack.isEmpty()){
                    stack.push((num.charAt(i)-'0'));
                }
            }
        }
        while(!stack.isEmpty() && k>0){
            k--;
            stack.pop();
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        return sb.length()>0?sb.toString():"0";
    }
}