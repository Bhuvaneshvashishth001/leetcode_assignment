class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int pre = groups[0];
        List<String> list = new ArrayList<>();
        int n = groups.length;
        list.add(words[0]);
        for(int i=1;i<n;i++){
            if(pre != groups[i]){
                list.add(words[i]);
                pre = groups[i];
            }
        }
        return list;
    }
}