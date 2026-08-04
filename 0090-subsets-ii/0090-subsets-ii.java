class Solution {
    public void subset(int nums[],Set<List<Integer>> set,List<Integer> ans,int idx){
        if(idx >= nums.length){
            set.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[idx]);
        subset(nums,set,ans,idx+1);
        ans.remove(ans.size()-1);
        subset(nums,set,ans,idx+1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        subset(nums,set,ans,0);
        return new ArrayList<>(set);
    }
}