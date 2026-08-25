class Solution {
    public boolean isContain(int idx,String s,String str,HashSet<String> set,Boolean dp[]){
        if(idx == s.length() && str.equals("")){
            return true;
        }
        if(idx >= s.length()){
            return false;
        }
        if(dp[idx] != null){
            return dp[idx];
        }
        for(int i=idx;i<s.length();i++){
            str += s.charAt(i);
            if(set.contains(str)){
                if(isContain(i+1,s,"",set,dp) || isContain(i+1,s,str,set,dp)){
                    return dp[i] = true;
                }
            }
        }
        return dp[idx] = false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String str : wordDict){
            set.add(str);
        }
        int n = s.length();
        Boolean dp[] = new Boolean[n+1];
        return isContain(0,s,"",set,dp);
    }
}