class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n  = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        long sum = 0;
        long maxS = 0;
        while(j<n){
            sum += nums[j];
            while(!map.isEmpty() && map.containsKey(nums[j]) && i<=j){
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                sum -= nums[i];
                i++;
            }
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            if(j-i+1 == k){
                maxS = Math.max(maxS,sum);
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return maxS;
    }
}