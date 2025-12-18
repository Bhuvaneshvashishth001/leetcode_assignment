class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String str = strs[0];
        int len = str.length();
        for (int i=1;i<strs.length;i++){
            String s = strs[i];
            while (s.length()<len || !s.startsWith(str.substring(0,len))){
                len--;
                if(len==0){
                    return "";
                }
            }
            str=str.substring(0,len);
        }
        return str;
    }
}