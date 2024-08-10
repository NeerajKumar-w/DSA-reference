import java.util.*;

public class MaximumWeight {
    public static ArrayList<Integer> solution(int[] graph, ArrayList<Integer> weights, int sum){
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph.length; j++){
                if(j == i || graph[j] == -1){
                    continue;
                }
                else{
                    if(graph[j] == i){
                        sum += j;
                    }
                }
            }
            weights.add(sum);
            sum = 0;
        }
        System.out.println(weights);
        return weights;
    }
    public static void main(String[] args) {
        int[] graph = {4, 4, 1, 4, 1, 3, 8, 8, 8, 0, 8, 14, 9, 1, 5, 11, -1, 10, 1, 5, 22, 22, 22, 22, 22, 21};
        ArrayList<Integer> temp = new ArrayList<>();
        int sum = 0;
        ArrayList<Integer> weights = solution(graph, temp, sum);
        int maxweight = weights.indexOf(Collections.max(weights));
        System.out.println(maxweight);
    }
} 
