class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int child = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int j=0;
        for(int i=0;i<s.length;i++){
            if(j<g.length && g[j]<=s[i]){
                child++;
                j++;
            }
        }
        return child;
    }
}