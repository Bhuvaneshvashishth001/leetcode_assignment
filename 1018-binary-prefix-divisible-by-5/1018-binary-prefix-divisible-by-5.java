class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> list = new ArrayList<>();
        int n = nums.length;
        int mod =0;
        for(int i=0;i<n;i++){
            mod = (mod*2 + nums[i])%5;
            if(mod == 0){
                list.add(true);
            }
            else{
                list.add(false);
            }
        }
        return list;
    }
}