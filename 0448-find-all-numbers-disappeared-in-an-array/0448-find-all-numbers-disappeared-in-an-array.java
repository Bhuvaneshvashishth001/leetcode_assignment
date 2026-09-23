class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        int max = 0;
        for(int num : nums){
            set.add(num);
            max = Math.max(max,num);
        }
        for(int i=0;i<nums.length;i++){
            if(!set.contains(i+1)){
                ans.add(i+1);
            }
        }
        return ans;
    }
}