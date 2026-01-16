class Solution {
    public int[] findOriginalArray(int[] nums) {
        int n = nums.length;
        if(n%2 != 0){
            return new int[0];
        }
        int count0 = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(nums[i] ==0){
                count0++;
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int ans[] = new int[n/2];
        int j=0;
        if(count0%2 != 0){
            return new int[0];
        }
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(map.get(nums[i]) ==0){
                continue;
            }
            if(map.getOrDefault(2*nums[i],0) == 0){
                return new int[0];
            }
            ans[j++] = nums[i];
            map.put(nums[i],map.get(nums[i])-1);
            map.put(2*nums[i],map.get(2*nums[i])-1);
        }
        return ans;
    }
}