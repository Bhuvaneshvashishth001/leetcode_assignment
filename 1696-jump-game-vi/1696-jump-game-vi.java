class Solution {
    public int maxResult(int[] arr, int k) {
        int n = arr.length;
        int sum = arr[0];

        // max heap → best value first
        PriorityQueue<int[]> queue =
                new PriorityQueue<>((a, b) -> b[0] - a[0]);

        queue.add(new int[]{arr[0], 0});

        for (int i = 1; i < n; i++) {
            while (!queue.isEmpty() && queue.peek()[1] < i - k) {
                queue.poll();
            }

            int best = queue.peek()[0];

            arr[i] = arr[i] + best;

            queue.add(new int[]{arr[i], i});
        }

        return arr[n - 1];
    }
}
