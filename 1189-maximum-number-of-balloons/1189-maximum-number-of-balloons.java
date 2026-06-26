class Solution {
    public int maxNumberOfBalloons(String text) {
        int count[] = new int[26];
        for(int i=0;i<text.length();i++){
            count[text.charAt(i)-'a']++;
        }
        int ans = Math.min(
        count['a' - 'a'],
        Math.min(
                count['b' - 'a'],
                Math.min(
                        count['l' - 'a'] / 2,
                        Math.min(
                                count['o' - 'a'] / 2,
                                count['n' - 'a']
                        )
                )
        )
);
        return ans;
    }
}