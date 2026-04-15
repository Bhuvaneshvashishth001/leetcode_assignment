class Solution {
    public int closestTarget(String[] words, String target, int start) {
        int n = words.length;
        HashSet<String> set = new HashSet<>();
        for(String word:words){
            set.add(word);
        }
        if(!set.contains(target)){
            return -1;
        }
        int ans =n+1;
        for(int i=start;i<n;i++){
            if(words[i].equals(target)){
                ans = Math.min(ans,Math.min(i-start,(start+n-i)));
            }
        }
        for(int i=0;i<start;i++){
            if(words[i].equals(target)){
                ans = Math.min(ans,Math.min(start-i,(n-start+i)));
            }
        }
        return  ans;
    }
}