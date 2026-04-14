class Solution {
    public int divisorSubstrings(int num, int k) {
        String s = String.valueOf(num);
        String str = "";
        int count = 0;
        for(int i=0;i<s.length();i++){
            str += s.charAt(i);
            if(str.length() == k){
                int n = Integer.parseInt(str);
                if(n!= 0 && num%n ==0 ){
                    count++;
                }
                str = str.substring(1);
            }
        }
        return count;
    }
}