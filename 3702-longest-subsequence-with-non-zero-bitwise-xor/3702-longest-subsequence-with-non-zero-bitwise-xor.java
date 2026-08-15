class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int non = 0;
        int x = 0;
        for(int i=0;i<n;i++){
            x = x^nums[i];
            if(x != 0){
                non++;
            }
        }
        if(x!=0){
            return n;
        }
        if(non != 0){
            return n-1;
        }
        return 0;
    }
}