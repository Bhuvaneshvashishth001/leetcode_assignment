class Solution {
    String merge= "";
    public String largestMerge(String word1, String word2) {
        StringBuilder merge = new StringBuilder();
        int n = word1.length();
        int m =word2.length();
        int i=0;
        int j=0;
        while(i<n && j<m){
            if(word1.substring(i).compareTo(word2.substring(j)) >0){
                merge.append(word1.charAt(i));
                i++;
            }
            else{
                merge.append(word2.charAt(j));
                j++;
            }
        }
        merge.append(word1.substring(i));
        merge.append(word2.substring(j));
        return merge.toString();
    }
}