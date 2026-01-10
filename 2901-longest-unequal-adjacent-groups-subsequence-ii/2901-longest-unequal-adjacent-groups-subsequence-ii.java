class Solution {
    public boolean check(String s1, String s2){
        if (s1.length() != s2.length()) return false;
        int diff = 0;
        for (int i=0;i<s1.length();i++){
            if (s1.charAt(i) != s2.charAt(i)){
                diff++;
                if (diff > 1) return false;
            }
        }
        return diff == 1;
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);
        int maxLen = 1;
        int last = 0;
        for (int i=0;i<n;i++){
            for (int j=0;j<i;j++){
                if (groups[i] != groups[j] && check(words[i], words[j])) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                last = i;
            }
        }
        List<String> ans = new ArrayList<>();
        while (last != -1) {
            ans.add(words[last]);
            last = parent[last];
        }
        Collections.reverse(ans);
        return ans;
    }
}
