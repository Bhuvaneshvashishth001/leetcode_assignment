class Solution {
    public String convertToTitle(int num) {
        StringBuilder sb = new StringBuilder();
        while(num>26){
            int rem = num%26;
            if(rem == 0){
                sb.append('Z');
                num--;
            }
            else{
                sb.append((char)(65+(rem-1)));
            }
            num = num/26;
        }
        sb.append((char)(65+(num-1)));
        return sb.reverse().toString();
    }
}