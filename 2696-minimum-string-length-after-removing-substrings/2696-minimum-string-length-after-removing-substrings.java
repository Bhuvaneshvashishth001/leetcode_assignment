class Solution {
    public int minLength(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i=0;i<n;i++){
            int len = sb.length();
            if(len>0 && ((s.charAt(i)=='B' && sb.charAt(len-1) =='A') || (s.charAt(i)=='D' && sb.charAt(len-1) =='C')) ){
                sb.deleteCharAt(len-1);
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.length();
    }
}