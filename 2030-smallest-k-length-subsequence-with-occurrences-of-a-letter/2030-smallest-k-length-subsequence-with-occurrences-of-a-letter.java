class Solution {
    public String smallestSubsequence(String s, int k, char letter, int rep) {
        int count = 0;
        int n = s.length();
        char arr[] = s.toCharArray();
        for(char ch :arr){
            if(ch == letter){
                count++;
            }
        }
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int need = 0;
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && s.charAt(i) < s.charAt(stack.peek()) && (s.charAt(stack.peek()) != letter || need-1+count >= rep) && (stack.size()-1+(n-i))>=k){
                if(s.charAt(stack.peek()) == letter){
                    need--;
                }
                stack.pop();
            }
            if(stack.size()<k){
                if(s.charAt(i) == letter){
                    need++;
                    stack.push(i);
                }
                else if(k-stack.size()+need >rep){
                    stack.push(i);
                }
            }
            if(s.charAt(i) == letter){
                count--;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(s.charAt(stack.pop()));
        }
        sb.reverse();
        return sb.toString();
    }
}