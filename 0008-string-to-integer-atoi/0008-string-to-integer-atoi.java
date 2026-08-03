class Solution {
    public int myAtoi(String s) {

        int j = 0;
        int k = 0;

        Set<Character> set = new HashSet<>();

        for(char c='0'; c<='9'; c++){
            set.add(c);
        }

        String str = "";

        while(j < s.length()){

            if(j == k && (s.charAt(j) == '-' || s.charAt(j)=='+')){
                str += s.charAt(j);
            }
            else if(j == k && s.charAt(j) == ' '){
                k++;
                j++;
                continue;
            }
            else if(set.contains(s.charAt(j))){
                str += s.charAt(j);
            }
            else{
                break;
            }

            j++;
        }

        if(str.length()==0 || str.equals("-") || str.equals("+")){
            return 0;
        }

        long ans = 0;
        int idx = 0;
        int sign = 1;

        if(str.charAt(0)=='-'){
            sign = -1;
            idx++;
        }
        else if(str.charAt(0)=='+'){
            idx++;
        }

        while(idx < str.length()){

            ans = ans*10 + (str.charAt(idx)-'0');

            if(sign==1 && ans>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if(sign==-1 && -ans<Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            idx++;
        }

        return (int)(sign*ans);
    }
}