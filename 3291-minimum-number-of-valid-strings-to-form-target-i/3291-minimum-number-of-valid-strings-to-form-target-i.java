class Solution {
    public boolean isValid(String words[],String pre){
        for(String word:words){
            if(word.startsWith(pre)){
                return true;
            }
        }
        return false;
    }
    public int minValidStrings(String[] words, String target) {
        int n = target.length();
        int count[] = new int[n+1];
        int i=0;
        int j=1;
        while(j<=n){
            if(i == j){
                return -1;
            }
            else if(isValid(words,target.substring(i,j))){
                count[j] = count[i]+1;
                j++;
            }
            else{
                i++;
            }
        }
        return count[n];
    }
}