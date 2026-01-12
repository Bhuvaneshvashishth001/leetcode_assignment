class Solution {
    public int longestBalanced(int[] nums) {
        int even = 0;
        int odd = 0;
        int n = nums.length;
        int max_sub= 0;
        for(int i=0 ;i<n ;i++){
            HashSet<Integer> map = new HashSet<>(); 
            HashSet<Integer> set = new HashSet<>();
            for(int j=i ;j<n ;j++){
                if(nums[j]%2==0){
                    map.add(nums[j]);
                }
                else{
                    set.add(nums[j]);
                }
                if(map.size() == set.size()){
                    max_sub = Math.max(max_sub ,j-i+1);
                }
            }
        }
        return max_sub;
    }
}