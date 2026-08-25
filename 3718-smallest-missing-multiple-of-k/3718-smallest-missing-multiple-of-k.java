class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        for(int i=0;i<n;i++){
            set.add(nums[i]);
            max = Math.max(max,nums[i]);
        }
        int ans = 0;
        for(int i=1;i<=max/k;i++){
            if(!set.contains(k*i)){
                ans = k*i;
                break;
            }
        }
        return  ans == 0?k*(max/k+1):ans;
    }
}