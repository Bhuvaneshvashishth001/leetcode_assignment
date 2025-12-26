class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int n  = nums.size();
        TreeSet<Integer> set = new TreeSet<>();
        int ans = Integer.MAX_VALUE;
        for(int i=x;i<n;i++){
            set.add(nums.get(i-x));
            int num = nums.get(i);
            Integer floor = set.floor(num);
            if(floor != null){
                ans = Math.min(ans,Math.abs(num-floor));
            }
            Integer ceil = set.ceiling(num);
            if(ceil != null){
                ans = Math.min(ans,Math.abs(num-ceil));
            }
            if(ans ==0){
                break;
            }
        }
        return ans;
    }
}