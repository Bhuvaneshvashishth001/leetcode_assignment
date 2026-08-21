class Solution {
    public int decode(int idx,String s,int dp[]){
        if(idx>= s.length()){
            return 1;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        String str = "";
        int count = 0;
        for(int i=idx;i<s.length();i++){
            str += s.charAt(i);
            if(str.charAt(0) == '0'){
                return 0;
            }
            if(str.length()>3){
                break;
            }
            int val = Integer.parseInt(str);
            if(val>0 && val<=26){
                count += decode(i+1,s,dp);
            }
        }
        return dp[idx] = count;
    }
    public int numDecodings(String s) {
        if(s.charAt(0) == '0'){
            return 0;
        }
        int dp[] = new int[s.length()];
        Arrays.fill(dp,-1);
        return decode(0,s,dp);
    }
}