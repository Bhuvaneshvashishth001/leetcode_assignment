class Solution {
    public String longestWord(String[] words) {
        int n = words.length;
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String ans = "";
        for(int i=0;i<n;i++){
            if(words[i].length() ==1){
                set.add(words[i]);
                if(words[i].length()>ans.length()){
                    ans = words[i];
                }
            }
            if(set.contains(words[i].substring(0,words[i].length()-1))){
                set.add(words[i]);
                if(words[i].length()>ans.length()){
                    ans = words[i];
                }
            }
        }
        return ans;
    }
}