class Solution {
    class Pair {
        int node, dist;
        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(new Pair(e[1], e[2]));
            graph.get(e[1]).add(new Pair(e[0], e[2]));
        }
        int resultCity = -1;
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = dijkstra(i, graph, n, distanceThreshold);
            if (count < minCount || (count == minCount && i > resultCity)) {
                minCount = count;
                resultCity = i;
            }
        }
        return resultCity;
    }
    private int dijkstra(int src, List<List<Pair>> graph, int n, int threshold) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.dist - b.dist
        );
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int u = cur.node;
            if (cur.dist > dist[u]) continue;
            for (Pair nei : graph.get(u)) {
                int v = nei.node;
                int w = nei.dist;
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i != src && dist[i] <= threshold) {
                count++;
            }
        }
        return count;
    }
}
