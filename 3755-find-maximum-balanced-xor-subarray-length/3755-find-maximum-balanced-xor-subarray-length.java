class Solution {
    public int maxBalancedSubarray(int[] nums) {
        int n = nums.length;
        int xor = 0;
        int diff = 0;
        int ans = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("0#0", -1);
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
            if((nums[i]&1)==0){
                diff++;
            }
            else{
                diff--;
            }
            String key = xor+"#"+diff;
            if(map.containsKey(key)){
                ans=Math.max(ans,i-map.get(key));
            } 
            else{
                map.put(key,i);
            }
        }
        return ans;
    }
}
