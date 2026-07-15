class Solution {
    public int characterReplacement(String s, int k) {
        int i=0;
        int j=0;
        int n = s.length();
        int maxFreq = 0;
        int maxLen = 0;
        int map[] = new int[26];
        while(j<n){
            map[s.charAt(j)-'A']++;
            maxFreq = Math.max(maxFreq,map[s.charAt(j)-'A']);
            if(j-i+1 - maxFreq > k){
                map[s.charAt(i)-'A']--;
                i++;
            }
            maxLen = Math.max(maxLen,j-i+1);
            j++;
        }
        return maxLen;
    }
}