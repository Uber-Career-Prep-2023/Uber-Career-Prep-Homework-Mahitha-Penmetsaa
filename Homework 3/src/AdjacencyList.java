import java.util.*;
public class AdjacencyList {
    public Map<Integer, Set<Integer>> adjacencySet(int[][] edges) {
        if (edges == null) {
            throw new IllegalArgumentException("Edges array cannot be null");
        }
        // Build the graph
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            addEdge(edge, graph);
        }
        return graph;
    }
    private void addEdge(int[] edge, Map<Integer, Set<Integer>> graph) {
        int from = edge[0];
        int to = edge[1];
        if (from == to) {
            throw new IllegalArgumentException("Edges cannot connect vertexes to themselves");
        }
        // Add the edge to the graph
        Set<Integer> edgesTo = graph.computeIfAbsent(from, k -> new HashSet<>());
        if (edgesTo.contains(to)) {
            throw new IllegalArgumentException("Directed edge connecting these 2 vertices already exists");
        }
        edgesTo.add(to);
    }
    public boolean bfs(int target, Map<Integer, Set<Integer>> graph) {
        if (graph == null) {
            throw new IllegalArgumentException("Graph cannot be null");
        }
        Set<Integer> visited = new HashSet<>();
        for (int start : graph.keySet()) {

            LinkedList<Integer> queue = new LinkedList<>();

            // Mark the current node as visited and enqueue it
            visited.add(start);
            queue.offer(start);

            while(!queue.isEmpty()) {
                int from = queue.poll();
                if (from == target) {
                    return true;
                }
                // If this vertex is not directly connected to any other vertices, continue to the next vertex.
                if (!graph.containsKey(from)) {
                    continue;
                }
                // Add all vertices connected directly from this vertex, which have not yet been visited
                for (int to : graph.get(from)) {
                    if (!visited.contains(to)) {
                        visited.add(to);
                        queue.offer(to);
                    }
                }
            }
        }
        return false;
    }
    public int[] topologicalSort(Map<Integer, Set<Integer>> graph) {
        if (graph == null) {
            throw new IllegalArgumentException("Graph cannot be null");
        }

        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        for (int start : graph.keySet()) {
            if (!visited.contains(start)) {
                topologicalSortUtil(start, visited, stack, graph);
            }
        }

        // Add the vertices to the return array
        int len = stack.size();
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            // System.out.print(stack.peek());
            ans[i] = stack.pop();
        }
        return ans;
    }

    private void topologicalSortUtil(int vertex, Set<Integer> visited, Stack<Integer> stack, Map<Integer, Set<Integer>> graph){
        visited.add(vertex);
        if (graph.containsKey(vertex)) {
            // explore all its children first
            for (int neighbor : graph.get(vertex)) {
                if (!visited.contains(neighbor))
                    topologicalSortUtil(neighbor, visited, stack, graph);
            }
        }

        // Push the current vertex to the stack
        stack.push(vertex);
    }
}
