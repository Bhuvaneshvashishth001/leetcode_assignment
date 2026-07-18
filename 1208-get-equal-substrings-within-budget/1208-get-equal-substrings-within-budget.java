class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int  i = 0;
        int i1 = 0;
        int j = 0;
        int j1 = 0;
        int n = s.length();
        int m = t.length();
        int use = 0;
        int ans = 0;
        while(i1 < n && j1 < m){
            use += Math.abs(s.charAt(i1)-t.charAt(j1));
            while(use > maxCost){
                use -= Math.abs(s.charAt(i)-t.charAt(j));
                i++;
                j++;
            }
            ans = Math.max(ans,j1-j+1);
            i1++;
            j1++;
        }
        return ans;
    }
}