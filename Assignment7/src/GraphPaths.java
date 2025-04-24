import java.util.*;

public class GraphPaths {
    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static Map<Integer, List<Edge>> graph = new HashMap<>();

    // DFS function to find all simple paths of exactly 7 edges from current to target
    static void dfs(int current, int target, List<Integer> path, int length) {
        if (length == 7) {  // Reached 7 edges
            if (current == target) {  // If at target, print the path
                System.out.println(path);
            }
            return;  // Stop searching
        }

        if (!graph.containsKey(current)) {  // No neighbors, stop
            return;
        }

        for (Edge edge : graph.get(current)) {
            // Allow visiting target again ONLY at the end
            if (!path.contains(edge.to) || edge.to == target) {
                path.add(edge.to);
                dfs(edge.to, target, path, length + 1);  // Move forward (count edges)
                path.remove(path.size() - 1);  // Backtrack
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int edges = sc.nextInt();  // Number of edges

        // Build the graph
        for (int i = 0; i < edges; i++) {
            int u = sc.nextInt();  // From node
            int v = sc.nextInt();  // To node
            int w = sc.nextInt();  // Weight (used for completeness, but not for path length)

            if (!graph.containsKey(u)) {
                graph.put(u, new ArrayList<Edge>());
            }
            graph.get(u).add(new Edge(v, w));
        }

        int start = sc.nextInt();  // Start node (u)
        int end = sc.nextInt();    // End node (w)

        List<Integer> path = new ArrayList<>();
        path.add(start);  // Start path with the starting node

        dfs(start, end, path, 0);  // Start DFS search

        // Optional: If no path found, print a message (add a flag if you'd like)
    }
}
