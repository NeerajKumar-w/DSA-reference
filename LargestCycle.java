import java.util.*;

class NearestCell {
    public static ArrayList<Integer> dfs_rec(int[] graph, ArrayList<Integer> visited, int vertex) {
        if (!visited.contains(vertex)) {
            visited.add(vertex);
        }
        if (graph[vertex] == -1 || visited.contains(graph[vertex])) {
            return visited;
        } else {
            dfs_rec(graph, visited, graph[vertex]);
        }
        return visited;
    }

    public static ArrayList<Integer> dfs(int[] graph, int startVertex) {
        ArrayList<Integer> visited = new ArrayList<Integer>();
        ArrayList<Integer> stack = dfs_rec(graph, visited, startVertex);
        System.out.println(stack);
        return stack;
    }

    public static void main(String[] args) {
        ArrayList<Integer> LargestCyclePath = new ArrayList<>();
        int sumOfLargest = 0;
        int largestcycleLength = -1;
        int largestcycleNode = 0;
        int[] graph = { 4, 4, 1, 4, 13, 8, 8, 8, 0, 8, 14, 9, 15, 11, -1, 10, 15, 22, 22, 22, 22, 22, 21 };
        for (int i = 0; i < graph.length; i++) {
            ArrayList<Integer> paths = dfs(graph, i);
            if (paths.get(paths.size() - 1) == -1) {
                continue;
            } else {
                if ((paths.size() > largestcycleLength && graph[paths.size() - 1] == i) || largestcycleLength == -1) {
                    largestcycleLength = paths.size();
                    largestcycleNode = i;
                    LargestCyclePath = paths;
                }
            }
        }
        for (int i : LargestCyclePath) {
            sumOfLargest += i;
        }
        System.out.println(LargestCyclePath);
        System.out.println(largestcycleLength);
        System.out.println(largestcycleNode);
        System.out.println(sumOfLargest);
    }
}
