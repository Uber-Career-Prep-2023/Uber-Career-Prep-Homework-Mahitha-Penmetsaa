import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;
import java.util.List;

public class PrerequisiteCourses {

    public static void main(String[] args) {


        // reqs
        ArrayList<Pair> reqs = new ArrayList<>();
        reqs.add(new Pair("Data Structures", new ArrayList<>(List.of("Intro to Programming"))));
        reqs.add(new Pair("Advanced Algorithms", new ArrayList<>(List.of("Data Structures"))));
        reqs.add(new Pair("Operating Systems", new ArrayList<>(List.of("Advanced Algorithms"))));
        reqs.add(new Pair("Databases", new ArrayList<>(List.of("Advanced Algorithms"))));
//courses

        ArrayList<String> courses = new ArrayList<>();
        courses.add("Intro to Programming");
        courses.add("Data Structures");
        courses.add("Advanced Algorithms");
        courses.add("Operating Systems");
        courses.add("Databases");
        PrerequisiteCourses p = new PrerequisiteCourses();
        System.out.println(p.findPrereqs(courses, reqs));
    }

    public static class Pair {
        private final String key;
        private final ArrayList<String> value;
        public Pair(String key, ArrayList<String> value) {
            this.key = key;
            this.value = value;
        }
        public String getKey() {
            return this.key;
        }
        public ArrayList<String> getValue() {
            return this.value;
        }
    }

    public ArrayList<String> findPrereqs(ArrayList<String> courses, ArrayList<Pair> reqs) {
        Map<String, ArrayList<String>> upperToLower = new HashMap<>();

        for (String s: courses) {
            upperToLower.put(s, new ArrayList<>());
        }

        for (Pair p : reqs) {
            String upper = p.getKey();
            ArrayList<String> lowers = p.getValue();
            for (String s : lowers) {
                upperToLower.get(upper).add(s);
            }
        }
        ArrayList<String> sortedTopo = topologicalSort(upperToLower);

 //we are gonna reverse the topo sort
        Collections.reverse(sortedTopo);

        return sortedTopo;
    }

    // returns topological sort of a graph
    public ArrayList<String> topologicalSort(Map<String, ArrayList<String>> graph) {
        ArrayList<String> visited = new ArrayList<>();
        Stack<String> s = new Stack<>();
        ArrayList<String> sorted = new ArrayList<>();

        for (String i : graph.keySet()) {
            if (!visited.contains(i)) {
                topologicalSortHelper(i, visited, s, graph);
                System.out.println(s.toString());
            }
        }

        while (!s.empty()) {
            sorted.add(s.pop());
        }
        return sorted;
    }

    public void topologicalSortHelper(String v, ArrayList<String> visited, Stack<String> s, Map<String, ArrayList<String>> graph) {
        visited.add(v);
        for (String i: graph.get(v)) {
            if (!visited.contains(i)) {
                topologicalSortHelper(i, visited, s, graph);
            }
        }
        s.push(v);
    }
}