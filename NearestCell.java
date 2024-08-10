import java.util.*;

public class NearestCell {
    public static ArrayList<Integer> dfs_rec(int[] graph, ArrayList<Integer> visited, int vertex) {
        if(!visited.contains(vertex)){
            visited.add(vertex);
        }
        if(graph[vertex] == -1 || visited.contains(graph[vertex])){
            return visited;
        }
        else{
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
        Scanner scanner = new Scanner(System.in);
        //int size = scanner.nextInt();
        int[] graph = {4, 4, 1, 4, 13, 8, 8, 8, 0, 8, 14, 9, 15, 11, -1, 10, 15, 22, 22, 22, 22, 22, 21};
       /* for(int i = 0; i < graph.length; i++){
            graph[i] = scanner.nextInt();
        }*/
        int c1 = 9;
        int c2 = 2;
        if(graph[c1] == c2){
            System.out.println(c2);
        }
        else if(graph[c2] == c1){
            System.out.println(c1);
        }
        else{
            ArrayList<Integer> paths1 = dfs(graph, c1);
            ArrayList<Integer> paths2 = dfs(graph, c2);
            int curdistance = -1;
            int vertex = 0;
            for(int i = 0; i < paths1.size(); i++){
                for(int j = 0; j < paths2.size(); j++){
                    int cur_path1 = paths1.get(i);
                    int cur_path2 = paths2.get(j); 
                    if(cur_path1==cur_path2 && cur_path2!=c1){
                        if((i + j) < curdistance || curdistance == -1){
                        curdistance = i + j;
                        vertex = paths1.get(i);
                        }
                    }
                }
            }
            System.out.println(vertex);
        }
    }
}
