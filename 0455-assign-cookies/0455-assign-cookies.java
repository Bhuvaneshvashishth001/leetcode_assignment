class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;
        int j = 0;
        int i = 0;
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(i<n && j<m){
            if(g[i]<= s[j]){
                count++;
                i++;
            }
            j++;
        }
        return count;
    }
}