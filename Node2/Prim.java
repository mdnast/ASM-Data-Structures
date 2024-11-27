import java.util.*;

class Prim {
    static class Edge {
        int target, weight;
        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    static void prim(List<List<Edge>> graph) {
        int n = graph.size();
        boolean[] inMST = new boolean[n];
        int[] key = new int[n];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0; // Start from node 0
        int[] parent = new int[n];
        parent[0] = -1;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{0, 0}); // {node, key}

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];

            if (inMST[node]) continue;
            inMST[node] = true;

            for (Edge edge : graph.get(node)) {
                if (!inMST[edge.target] && edge.weight < key[edge.target]) {
                    key[edge.target] = edge.weight;
                    pq.offer(new int[]{edge.target, key[edge.target]});
                    parent[edge.target] = node;
                }
            }
        }

        System.out.println("Minimum Spanning Tree edges:");
        for (int i = 1; i < n; i++) {
            System.out.println(parent[i] + " - " + i + " (Weight: " + key[i] + ")");
        }
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

        prim(graph); // Start from node 0 (A)
    }
}
