class Solution {

    public int subarray(int arr[], int k) {
        if (k < 0)
            return 0;

        int i = 0;
        int sum = 0;
        int count = 0;

        for (int j = 0; j < arr.length; j++) {

            sum += arr[j];

            while (sum > k) {
                sum -= arr[i];
                i++;
            }

            count += (j - i + 1);
        }

        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {

        return subarray(nums, goal) - subarray(nums, goal - 1);

    }
}