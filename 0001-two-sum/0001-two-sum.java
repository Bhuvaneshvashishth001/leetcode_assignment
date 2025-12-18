class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map= new HashMap<>();
        int arr[] = new int[2];
        int n = nums.length;
        int rem = 0;
        for(int i=0;i<n;i++){
            rem = target-nums[i];
            if(map.containsKey(rem)){
                arr[0] = map.get(rem);
                arr[1] = i;
            }
            else{
                map.put(nums[i],i);
            }
        }
        return arr;
    }
}