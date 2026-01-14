class Solution {
    public long perfectPairs(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];
        for (int i=0;i<n;i++) {
            arr[i] = Math.abs((long)nums[i]);
        }
        Arrays.sort(arr);
        long ans = 0;
        int l = 0;
        for(int i=0;i< n;i++){
            while (l<i && arr[i]>2*arr[l]) {
                l++;
            }
            ans += (i-l);
        }
        return ans;
    }
}
