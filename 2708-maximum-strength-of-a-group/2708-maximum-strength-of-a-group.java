class Solution {
    long ans = Long.MIN_VALUE;
    public void solve(int[] nums,int idx,long pro,int size){
        if(idx == nums.length){
            if(size != 0){
                ans = Math.max(ans, pro);
            }
            return;
        }
        solve(nums,idx+1,pro*nums[idx],size+1);
        solve(nums,idx+1,pro,size);
    }
    public long maxStrength(int[] nums){
        solve(nums,0,1L,0);
        return ans;
    }
}
