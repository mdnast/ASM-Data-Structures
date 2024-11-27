import java.util.*;

class Dijkstra {
    static class Edge {
        int target, weight;
        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    static void dijkstra(List<List<Edge>> graph, int source) {
        int n = graph.size();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{source, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0], currDist = current[1];

            if (currDist > dist[node]) continue;

            for (Edge edge : graph.get(node)) {
                int newDist = currDist + edge.weight;
                if (newDist < dist[edge.target]) {
                    dist[edge.target] = newDist;
                    pq.offer(new int[]{edge.target, newDist});
                }
            }
        }

        System.out.println("Shortest distances from source " + source + ": " + Arrays.toString(dist));
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        // Add edges
        graph.get(0).add(new Edge(1, 4)); // A -> B (4)
        graph.get(0).add(new Edge(2, 1)); // A -> C (1)
        graph.get(1).add(new Edge(3, 2)); // B -> D (2)
        graph.get(2).add(new Edge(3, 5)); // C -> D (5)
        graph.get(3).add(new Edge(4, 3)); // D -> E (3)

        dijkstra(graph, 0); // Source: A (index 0)
    }
}
