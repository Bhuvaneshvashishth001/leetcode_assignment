class Solution {

    public boolean isPossible(int arr[], int cap, int d) {

        int count = 0;
        int temp = cap;

        for (int val : arr) {

            if (val <= temp) {
                temp -= val;
            } 
            else {
                count++;
                temp = cap;
                temp -= val;
            }
        }

        return count < d;
    }

    public int shipWithinDays(int[] w, int d) {

        int max = 0;
        int sum = 0;

        for (int num : w) {
            max = Math.max(max, num);
            sum += num;
        }

        int start = max;
        int end = sum;

        int ans = end;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (isPossible(w, mid, d)) {
                ans = mid;
                end = mid - 1;
            } 
            else {
                start = mid + 1;
            }
        }

        return ans;
    }
}