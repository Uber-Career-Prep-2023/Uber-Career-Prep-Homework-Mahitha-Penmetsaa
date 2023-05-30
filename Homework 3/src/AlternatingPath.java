import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
public class AlternatingPath {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Integer>> redAdjList = new ArrayList<>();
        List<List<Integer>> blueAdjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            redAdjList.add(new ArrayList<>());
            blueAdjList.add(new ArrayList<>());
        }
        for (int[] edge : redEdges) {
            redAdjList.get(edge[0]).add(edge[1]);
        }
        for (int[] edge : blueEdges) {
            blueAdjList.get(edge[0]).add(edge[1]);
        }
        int[][] distance = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], -1);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        queue.offer(new int[]{0, 1});
        distance[0][0] = 0;
        distance[0][1] = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int color = curr[1];
            List<Integer> adjList = color == 0 ? blueAdjList.get(node) : redAdjList.get(node);
            for (int neighbor : adjList) {
                int nextColor = color == 0 ? 1 : 0;
                if (distance[neighbor][nextColor] == -1) {
                    distance[neighbor][nextColor] = distance[node][color] + 1;
                    queue.offer(new int[]{neighbor, nextColor});
                }
            }
        }
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            if (distance[i][0] == -1 && distance[i][1] == -1) {
                answer[i] = -1;
            } else if (distance[i][0] == -1) {
                answer[i] = distance[i][1];
            } else if (distance[i][1] == -1) {
                answer[i] = distance[i][0];
            } else {
                answer[i] = Math.min(distance[i][0], distance[i][1]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {

    }
}
