import java.util.*;

class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int n = nums.size();
        TreeSet<Integer> set = new TreeSet<>();
        int ans = Integer.MAX_VALUE;

        for (int i = x; i < n; i++) {
            // add valid index
            set.add(nums.get(i - x));

            int curr = nums.get(i);

            Integer floor = set.floor(curr);
            if (floor != null) {
                ans = Math.min(ans, Math.abs(curr - floor));
            }

            Integer ceil = set.ceiling(curr);
            if (ceil != null) {
                ans = Math.min(ans, Math.abs(curr - ceil));
            }

            if (ans == 0) return 0; // best possible
        }
        return ans;
    }
}
