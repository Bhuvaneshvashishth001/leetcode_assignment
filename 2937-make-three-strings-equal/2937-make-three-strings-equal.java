class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int i=0,j=0,k=0;
        int n = s1.length();
        int m = s2.length();
        int s = s3.length();
        while(i<n && j<m && k<s){
            if(s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k)){
                i++;
                j++;
                k++;
            }
            else{
                break;
            }
        }
        if((n-i)+(m-j)+(s-k) == n+m+s){
            return -1;
        }
        return (n-i)+(m-j)+(s-k);
    }
}