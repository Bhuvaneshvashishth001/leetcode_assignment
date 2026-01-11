class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long change = (long) k1 + k2;
        int max = 0;
        int[] freq = new int[100001];
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            freq[diff]++;
            if (diff > max) max = diff;
        }
        for (int i = max; i > 0 && change > 0; i--) {
            if (freq[i] == 0) continue;
            long used = Math.min(change, freq[i]);
            freq[i] -= used;
            freq[i - 1] += used;
            change -= used;
        }
        long ans = 0;
        for (int i = 0; i <= max; i++) {
            if (freq[i] > 0) {
                ans += (long) freq[i] * i * i;
            }
        }
        return ans;
    }
}
