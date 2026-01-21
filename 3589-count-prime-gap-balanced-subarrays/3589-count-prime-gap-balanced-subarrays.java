import java.util.*;

class Solution {

    int prime[] = new int[50001];

    public void sieve() {
        prime[0] = 1;
        prime[1] = 1;
        for (int i = 2; i * i < prime.length; i++) {
            if (prime[i] == 0) {
                for (int j = i * i; j < prime.length; j += i) {
                    prime[j] = 1;
                }
            }
        }
    }

    public int primeSubarray(int[] nums, int k) {

        sieve();
        int n = nums.length;
        PriorityQueue<int[]> minQ =new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> maxQ =new PriorityQueue<>((a, b) -> b[0] - a[0]);
        Deque<Integer> primeIdx = new ArrayDeque<>();
        int i = 0;
        int ans = 0;
        for (int j = 0; j < n; j++) {
            if (prime[nums[j]] == 0) {
                minQ.add(new int[]{nums[j], j});
                maxQ.add(new int[]{nums[j], j});
                primeIdx.addLast(j);
            }
            while (primeIdx.size() >= 2 &&
                   maxQ.peek()[0] - minQ.peek()[0] > k) {
                if (!primeIdx.isEmpty() && primeIdx.peekFirst() == i)
                    primeIdx.pollFirst();
                i++;
                while (!minQ.isEmpty() && minQ.peek()[1] < i)
                    minQ.poll();
                while (!maxQ.isEmpty() && maxQ.peek()[1] < i)
                    maxQ.poll();
            }
            if (primeIdx.size() >= 2) {
                int secondLast = primeIdx.peekLast();
                primeIdx.pollLast();
                int firstLast = primeIdx.peekLast();
                primeIdx.addLast(secondLast);
                ans += (firstLast - i + 1);
            }
        }
        return ans;
    }
}
