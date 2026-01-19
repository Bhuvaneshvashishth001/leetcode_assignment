class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxSub = 0;
        for(int i=0;i<n;i++){
            HashSet<Integer> even = new HashSet<>();
            HashSet<Integer> odd = new HashSet<>();
            for(int j=i;j<n;j++){
                if(nums[j]%2 ==0){
                    even.add(nums[j]);
                }
                else{
                    odd.add(nums[j]);
                }
                if(even.size() == odd.size()){
                    maxSub = Math.max(maxSub,j-i+1);
                }
            }
        }
        return maxSub;
    }
}