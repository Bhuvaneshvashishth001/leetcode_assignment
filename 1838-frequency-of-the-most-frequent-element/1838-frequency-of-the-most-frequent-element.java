class Solution {
    public int maxFrequency(int[] nums, int k) {

        Arrays.sort(nums);

        int i = 0;
        long sum = 0;
        int maxLen = 1;

        for (int j = 0; j < nums.length; j++) {

            sum += nums[j];

            while ((long) nums[j] * (j - i + 1) - sum > k) {
                sum -= nums[i];
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen;
    }
}