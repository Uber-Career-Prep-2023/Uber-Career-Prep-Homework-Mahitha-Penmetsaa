import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class RoadNetworks {

    private int V; // Number of vertices in the graph.
    private boolean[] visited;
    private List<Set<Integer>> adjacencyList;
    private Map<String, Integer> stringsToIndexes;

    public int solveIt(List<String> towns, String[][] roads) {
        // Verify input.
        if (towns == null) {
            throw new IllegalArgumentException("List of towns cannot be null");
        }
        if (roads == null) {
            throw new IllegalArgumentException("List of roads cannot be null");
        }

        stringsToIndexes = buildMap(towns);
        V = stringsToIndexes.size();
        adjacencyList = getAdjacencyList(roads);
        visited = new boolean[V];
        int nRoadNetworks = 0;

        // Travers the graph using dfs.
        for (int v = 0; v < V; v++) {
            // Vertex v alreayd not been visited yet, indicating it's not an independent roadNetwork.
            // Or, Vertex was never built into the roadNetwork.
            if (visited[v] || adjacencyList.get(v).isEmpty()) {
                continue;
            }
            // Explore all connected vertices in the roadNetwork.
            dfs(v);
            nRoadNetworks++;
        }
        return nRoadNetworks;
    }

    private Map<String, Integer> buildMap(List<String> towns) {
        Map<String, Integer> stringsToIndexes = new HashMap<>();

        // Add towns to map.
        for (String town : towns) {
            if (town == null) {
                throw new IllegalArgumentException("Town cannot be null");
            }
            if (stringsToIndexes.containsKey(town)) {
                throw new IllegalArgumentException("Town is listed twice in list of towns");
            }
            stringsToIndexes.put(town, stringsToIndexes.size());
        }

        return stringsToIndexes;
    }

    private List<Set<Integer>> getAdjacencyList(String[][] roads) {
        List<Set<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjacencyList.add(new HashSet<>());
        }
        // Connect the vertices in both directions.
        for (String[] road : roads) {
            String town1 = road[0];
            String town2 = road[1];

            // Verify that towns are not identical and cyclic.
            if (town1 == town2) {
                throw new IllegalArgumentException("Vertex cycles are not permitted");
            }

            // Verify that the towns were listed in the list of towns.
            if (!stringsToIndexes.containsKey(town1)) {
                throw new IllegalArgumentException("Town was not in list of towns: " + town1);
            }
            if (!stringsToIndexes.containsKey(town2)) {
                throw new IllegalArgumentException("Town was not in list of towns: " + town2);
            }

            int idx1 = stringsToIndexes.get(town1);
            int idx2 = stringsToIndexes.get(town2);

            addEdge(idx1, idx2, adjacencyList);
            addEdge(idx2, idx1, adjacencyList);
        }
        return adjacencyList;
    }


    private void dfs(int v) {
        // Vertex has already been visited.e
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (int neighbor : adjacencyList.get(v)) {
            dfs(neighbor);
        }
    }

    private void addEdge(int vertexFrom, int vertexTo, List<Set<Integer>> adjacencyList) {
        Set<Integer> connectedTo = adjacencyList.get(vertexFrom);
        if (connectedTo.contains(vertexTo)) {
            throw new IllegalArgumentException("Edge connecting these two vertices already exists");
        }
        connectedTo.add(vertexTo);
    }

}
