class Solution {

    public boolean compare(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                return true;
            }
            if (s1.charAt(i) > s2.charAt(i)) {
                return false;
            }
        }
        return false;
    }
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        int i = 0;
        int count = 0;
        int len = Integer.MAX_VALUE;
        String ans = "";
        for (int j = 0; j < n; j++){
            if(s.charAt(j) == '1'){
                count++;
            }
            while(count>=k){
                int currLen = j-i+1;
                if(currLen<len){
                    ans = s.substring(i,j+1);
                    len = currLen;
                } 
                else if(currLen == len){
                    String temp = s.substring(i,j+1);
                    if (ans.equals("")||compare(temp, ans)){
                        ans = temp;
                    }
                }
                if(s.charAt(i) == '1'){
                    count--;
                }
                i++;
            }
        }
        return ans;
    }
}