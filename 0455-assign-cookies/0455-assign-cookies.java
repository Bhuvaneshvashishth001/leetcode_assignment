class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int j=0;
        for(int i=0;i<s.length ;i++){
            if(j<g.length && s[i]>=g[j]){
                ans++;
                j++;
            }
        }
        return ans;
    }
}