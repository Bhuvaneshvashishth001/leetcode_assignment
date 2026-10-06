class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int j = n-1;
        int i = n-2;
        while(i >= 0 && nums[i] >= nums[i+1]){
            i--;
        }
        if(i >= 0){
            while(nums[i] >= nums[j]){
                j--;
            }
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        int i1 = i+1;
        int j1 = n-1;
        while(i1<j1){
            int temp = nums[i1];
            nums[i1] = nums[j1];
            nums[j1] = temp;
            i1++;
            j1--;
        }
    }
}