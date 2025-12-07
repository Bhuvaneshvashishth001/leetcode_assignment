class Solution {
    public String removeTrailingZeros(String num) {
       int n = num.length()-1;
       int last = n+1;
       for(int i=n;i>=0;i--){
            if(num.charAt(i) == '0'){
                last=i;
            }
            else{
                break;
            }
       } 
       return num.substring(0,last);
    }
}