class Solution {
    Boolean dp[];
    public boolean check(int idx,String s,List<String> word){
        if(idx == s.length()){
            return true;
        }
        if(dp[idx] != null){
            return dp[idx];
        }
        for(int i=idx;i<s.length();i++){
            String str = s.substring(idx,i+1);
            if(word.contains(str)){
                if(check(i+1,s,word)){
                    return dp[idx] = true;
                }
            }
        }
        return dp[idx] = false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()+1];
        return check(0,s,wordDict);
    }
}