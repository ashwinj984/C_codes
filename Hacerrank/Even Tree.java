// https://www.hackerrank.com/challenges/even-tree/problem?isFullScreen=true
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    static int ans = 0;
    // Complete the evenForest function below.
    static int evenForest(int nodes, int edges, List<Integer> from, List<Integer> to) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < nodes + 1; i++) {
            graph.add(i, new ArrayList<>());
        }
        
        for(int i = 0; i < edges; i++) {
            int u = from.get(i);
            int v = to.get(i);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        //System.out.println(graph);
        boolean[] visited = new boolean[nodes + 1];
        for(int i = 1; i < nodes + 1; i++) {
            if(visited[i] == false) {
                 int vl = dfs(i, visited, graph);
            }
        }
        if(nodes % 2 == 0) {
            return ans - 1;
        }
        return ans;

    }
    
   

    private static int dfs(int i, boolean[] visited, ArrayList<ArrayList<Integer>> graph) {
        // TODO Auto-generated method stub
        int count = 0;
        visited[i] = true;
        for(int val : graph.get(i)) {
            if(visited[val] == false) {
                count += dfs(val, visited, graph);
            }
        }
        if((count + 1) % 2 == 0) {
            ans++;
        }
        return count + 1;
        
    }



    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] tNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int tNodes = Integer.parseInt(tNodesEdges[0]);
        int tEdges = Integer.parseInt(tNodesEdges[1]);

        List<Integer> tFrom = new ArrayList<>();
        List<Integer> tTo = new ArrayList<>();

        for (int i = 0; i < tEdges; i++) {
            String[] tFromTo = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            tFrom.add(Integer.parseInt(tFromTo[0]));
            tTo.add(Integer.parseInt(tFromTo[1]));
        }

        int res = evenForest(tNodes, tEdges, tFrom, tTo);

        System.out.println(String.valueOf(res));
    }
}
