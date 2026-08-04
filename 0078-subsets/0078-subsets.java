class Solution {
    public void helper(int nums[],int idx,List<List<Integer>>ans,List<Integer> list){
        if(idx >= nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[idx]);
        helper(nums,idx+1,ans,list);
        list.remove(list.size()-1);
        helper(nums,idx+1,ans,list);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(nums,0,ans,list);
        return ans;
    }
}