class Solution {
        static public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, q = queries.length, start = 0, end = q - 1, mid = 0, ans = -1;
        boolean allZero = true;
        for (int num : nums) {
            if (num != 0) {
                allZero = false;
                break;
            }
        }
        if (allZero) return 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            boolean x = canBe(nums, queries, mid);
            if (x) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return ans == -1 ? -1 : ans + 1;
    }

    static boolean canBe(int[] arr, int[][] queries, int mid) {
        int n = arr.length, q = queries.length;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++)
            list.add(new ArrayList<>());
        
        for (int i = 0; i <= mid; i++) {
            int from = queries[i][0], to = queries[i][1], val = queries[i][2];

            for (int j = from; j <= to; j++) {
                list.get(j).add(val);
            }

        }
        for (int i = 0; i < n; i++) {
            int current = arr[i];
            ArrayList<Integer> temp = list.get(i);
            Boolean[][] dp = new Boolean[temp.size()][current + 1];
            boolean canBe = solve(temp.size() - 1, current, temp, dp);
            if (!canBe) return false;
        }

        return true;
    }

    static boolean solve(int i, int sum, ArrayList<Integer> l, Boolean[][] dp) {
        if (sum == 0) return true;
        if (i < 0) return false;
        if(dp[i][sum] != null) return dp[i][sum];
        int current = l.get(i);
        if (sum >= current) {
            if (solve(i - 1, sum - current, l, dp)) return dp[i][sum] = true;
        }
        if (solve(i - 1, sum, l, dp)) return dp[i][sum] = true;
        return dp[i][sum]=  false;
    }
}