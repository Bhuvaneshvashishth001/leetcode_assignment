class Solution {
    public int maxConsecutiveAnswers(String s, int k) {
        int i = 0;
        int j = 0;
        int n = s.length();
        int t = 0;
        int f = 0;
        int maxLen = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(j<n){
            if(s.charAt(j) == 'T'){
                t++;
            }
            if(s.charAt(j) == 'F'){
                f++;
            }
            while(Math.min(t,f) > k){
                if(s.charAt(i) == 'T'){
                    t--;
                }
                if(s.charAt(i) == 'F'){
                    f--;
                }
                i++;
            }
            maxLen = Math.max(maxLen,j-i+1);
            j++;
        }
        return maxLen;
    }
}