class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int n  = nums.length;
        int maxLen = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        while(j<n){
            while(map.containsKey(nums[j]) && map.get(nums[j]) == k){
                map.put(nums[i],map.get(nums[i])-1);
                i++;
            }
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            maxLen = Math.max(maxLen,j-i+1);
            j++;
        }
        return maxLen;
    }
}