class Solution {
    public void sub(int idx,int nums[],List<Integer> list,Set<List<Integer>> ans){
        if(list.size() >= 2){
            if(!ans.contains(list)){
                ans.add(new ArrayList<>(list));
            }
        }
        if(idx >= nums.length){
            return;
        }
        if(list.size() == 0){
            list.add(nums[idx]);
            sub(idx+1,nums,list,ans);
            list.remove(list.size()-1);
        }
        if(list.size() >= 1 && nums[idx] >= list.get(list.size()-1)){
            list.add(nums[idx]);
            sub(idx+1,nums,list,ans);
            list.remove(list.size()-1);
        }
        sub(idx+1,nums,list,ans);
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        sub(0,nums,list,ans);
        return new ArrayList<>(ans);
    }
}