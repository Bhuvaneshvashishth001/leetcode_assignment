class Solution {
    public int minValidStrings(String[] words, String target) {
        int left = 0;
        int right = 1;
        int n = target.length();
        int[] dp = new int[n + 1];

        while(right <= n){
            if(left == right){
                return -1;
            }
            if(isValidPrefix(words, target.substring(left, right))){
                dp[right] = dp[left] + 1;
                right++;
            }else{
                left++;
            }
        }
        return dp[n];
    }

    public boolean isValidPrefix(String words[], String prefix){
        for(String word : words){
            if(word.startsWith(prefix)){
                return true;
            }
        }
        return false;
    }
}
