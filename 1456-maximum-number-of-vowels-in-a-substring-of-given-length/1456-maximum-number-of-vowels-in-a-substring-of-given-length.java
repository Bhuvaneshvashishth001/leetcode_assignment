class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int max = 0;
        int count = 0;
        for(int i=0;i<k;i++){
            if(set.contains(s.charAt(i))){
                count++;
            }
        }
        max = Math.max(max,count);
        for(int i = k;i<n;i++){
            if(set.contains(s.charAt(i-k))){
                count--;
            }
            if(set.contains(s.charAt(i))){
                count++;
            }
            max = Math.max(max,count);
        }
        return max;
    }
}