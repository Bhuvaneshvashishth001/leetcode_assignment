class Solution {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        boolean start = false;
        for(int i=0;i<n;i++){
            if(start == true && s.charAt(i) =='1' && s.charAt(i-1) != '1'){
                return false;
            }
            else if(s.charAt(i) == '1'){
                start = true;
            }
        }
        if(start == false){
            return false;
        }
        return true;
    }
}