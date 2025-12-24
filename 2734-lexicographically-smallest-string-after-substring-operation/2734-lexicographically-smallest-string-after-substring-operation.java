class Solution {
    public String smallestString(String s) {
        int i=0;
        int j=0;
        int n = s.length();
        boolean flag = true;
        StringBuilder str = new StringBuilder("");
        while(j<n){
            if(s.charAt(j) =='a' && j<n){
                if(flag == false){
                    j--;
                    break;
                }
                i++;
                j++;
            }
            else{
                flag = false;
                j++;
            }
        }
        if(flag == true){
            str.append(s.substring(0,s.length()-1)+'z');
            return str.toString();
        }
        for(int k=0;k<n;k++){
            if(k>=i && k<=j){
                str.append((char)(s.charAt(k)-1));
            }
            else{
                str.append(s.charAt(k));
            }
        }
        return str.toString();
    }
}