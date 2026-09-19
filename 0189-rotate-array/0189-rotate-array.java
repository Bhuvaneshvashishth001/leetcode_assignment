class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int s = 0;
        int e = nums.length-1;
        k = k%n;
        while(s<=e){
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
        s = 0;
        e = k-1;
        while(s<=e){
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
        s = k;
        e = nums.length-1;
        while(s<=e){
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }
}