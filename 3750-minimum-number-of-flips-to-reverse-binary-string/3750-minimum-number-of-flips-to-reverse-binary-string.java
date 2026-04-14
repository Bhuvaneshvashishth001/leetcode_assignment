class Solution {
    public int minimumFlips(int n) {
        String s =  Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(sb.charAt(i) != s.charAt(i)){
                count++;
            }
        }
        return count;
    }
}