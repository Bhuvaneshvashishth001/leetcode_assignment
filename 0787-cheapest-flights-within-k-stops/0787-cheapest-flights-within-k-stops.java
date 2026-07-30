import java.util.*;

class Solution {
    class Pair {
        int node;
        int price;
        int stop;
        public Pair(int node, int price, int stop) {
            this.node = node;
            this.price = price;
            this.stop = stop;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge : flights) adj.get(edge[0]).add(new Pair(edge[1], edge[2], 0));
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.price - b.price);
        pq.add(new Pair(src, 0, 0));
        int[][] dist = new int[n][k + 2]; 
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[src][0] = 0;
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int node = cur.node;
            int price = cur.price;
            int stops = cur.stop;
            if (node == dst) return price;
            if (stops <= k) {
                for (Pair nei : adj.get(node)) {
                    int newPrice = price + nei.price;
                    if (newPrice < dist[nei.node][stops + 1]) {
                        dist[nei.node][stops + 1] = newPrice;
                        pq.add(new Pair(nei.node, newPrice, stops + 1));
                    }
                }
            }
        }
        return -1;
    }
}
