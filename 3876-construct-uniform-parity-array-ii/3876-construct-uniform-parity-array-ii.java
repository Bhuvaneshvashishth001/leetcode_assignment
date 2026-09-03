class Solution {
    public boolean uniformArray(int[] nums) {
        boolean even = true;
        boolean odd = true;
        for(int num : nums){
            if(num%2 != 0){
                even = false;
                break;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int num:nums){
            min = Math.min(min,num);
        }
        if(min%2 == 0){
            odd = false;
        }
        return even || odd;
    }
}