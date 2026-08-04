class Solution {
    public static void subsets(int nums[],List<Integer> list,Set<List<Integer>> list1,int idx){
        if(idx==nums.length){
            list1.add(new ArrayList<>(list));
            return;
        }
        if(idx>nums.length){
            return;
        }
        list.add(nums[idx]);
        subsets(nums,list,list1,idx+1);
        list.remove(list.size()-1);
        subsets(nums,list,list1,idx+1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Set<List<Integer>> list1 = new HashSet<>();
        Arrays.sort(nums);
        subsets(nums,list,list1,0);
        return new ArrayList<>(list1);
    }
}