class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen =0;
        int i = 0;
        int j = 0;
        Map<Character,Integer> map = new HashMap<>();
        while(j<n){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j))+1,i);
            }
            map.put(s.charAt(j),j);
            maxLen = Math.max(maxLen,j-i+1);
            j++;
        }
        return maxLen;
    }
}