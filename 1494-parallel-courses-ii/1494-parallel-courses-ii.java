class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int[] prereq = new int[n];
        for (int[] r : relations) {
            int u = r[0] - 1;
            int v = r[1] - 1;
            prereq[v] |= (1 << u);
        }
        int FULL = (1 << n) - 1;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[1 << n];
        queue.offer(0);
        visited[0] = true;
        int semester = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            semester++;
            for (int s = 0; s < size; s++) {
                int mask = queue.poll();
                if (mask == FULL) return semester - 1;
                int available = 0;

                for (int i = 0; i < n; i++) {
                    if ((mask & (1 << i)) == 0 &&
                        (prereq[i] & mask) == prereq[i]) {
                        available |= (1 << i);
                    }
                }

                if (Integer.bitCount(available) <= k) {
                    int next = mask | available;
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
                else {
                    for (int sub = available; sub > 0; sub = (sub - 1) & available) {
                        if (Integer.bitCount(sub) == k) {
                            int next = mask | sub;
                            if (!visited[next]) {
                                visited[next] = true;
                                queue.offer(next);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}
