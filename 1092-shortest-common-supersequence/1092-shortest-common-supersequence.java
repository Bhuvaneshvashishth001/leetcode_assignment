class Solution {
    public static String common(String text1,String text2,int idx1,int idx2,String dp[][]){
        if(idx1 == text1.length()|| idx2 == text2.length()){ 
            return "";
        }
        if(dp[idx1][idx2] != null){
            return dp[idx1][idx2];
        }
        if(text1.charAt(idx1) == text2.charAt(idx2)){
            dp[idx1][idx2] = text1.charAt(idx1) + common(text1,text2,idx1+1,idx2+1,dp);
        }
        else{
            String str1 = common(text1,text2,idx1+1,idx2,dp);
            String str2 = common(text1,text2,idx1,idx2+1,dp);
            if(str1.length()>= str2.length()){
                dp[idx1][idx2] = str1;
            }
            else{
               dp[idx1][idx2] = str2;
            }
        }
        return dp[idx1][idx2];
    }
    public String shortestCommonSupersequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        String str = "";
        String dp[][] = new String[n+1][m+1];
        String s = common(text1,text2,0,0,dp);
        StringBuilder sb = new StringBuilder();
        int i =0;
        int j = 0;
        for( char ch : s.toCharArray()){
            while(i<text1.length() && text1.charAt(i)!=ch){
                sb.append(text1.charAt(i));
                i++;
            }
            while(j<text2.length()&& text2.charAt(j)!=ch){
                sb.append(text2.charAt(j));
                j++;
            }
            sb.append(ch);
            i++;
            j++;
        }
        sb.append(text1.substring(i));
        sb.append(text2.substring(j));
        return sb.toString();
    }
}