class Solution {
    public String longestNiceSubstring(String s) {
        if(s.length()<=1){
            return "";
        }
        HashSet<Character> set = new HashSet<>();
        for(char ch : s.toCharArray()){
            set.add(ch);
        }
        for(int i=0;i<s.length();i++){
            char ch  = s.charAt(i);
            char u = Character.toUpperCase(ch);
            char l = Character.toLowerCase(ch);
            if((ch == u && !set.contains(l)) || (ch==l && !set.contains(u))){
                String first = longestNiceSubstring(s.substring(0,i));
                String second = longestNiceSubstring(s.substring(i+1,s.length()));
                if(first.length()>=second.length()){
                    return first;
                }
                else{
                    return second;
                }
            }
        }
        return s;
    }
}