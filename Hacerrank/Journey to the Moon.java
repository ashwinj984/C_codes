//https://www.hackerrank.com/challenges/journey-to-the-moon/problem

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
class Result {

    /*
     * Complete the 'journeyToMoon' function below.
     *
     * The function is expected to return an INTEGER. The function accepts following
     * parameters: 1. INTEGER n 2. 2D_INTEGER_ARRAY astronaut
     */

    public static int journeyToMoon(int n, List<List<Integer>> astronaut) {
        // Write your code here
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(i, new ArrayList<>());
        }
        for (List<Integer> list : astronaut) {
            int u = list.get(0);
            int v = list.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

//        for(int i = 0; i < graph.length; i++) {
//            System.out.println(graph[i]);
//        }
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> comp = new ArrayList<>();
            if (visited[i] == false) {
                dfs(graph, i, comp, visited);
            }
            if (comp.size() > 0) {
                comps.add(comp);
            }

        }
        int count = 0;
        int sum = 0;
        int[] ans = new int[comps.size()];
        for(int i  = 0; i < ans.length; i++) {
            ans[i] = comps.get(i).size();
            sum += ans[i];
        }
        
        for(int i = 0; i < ans.length; i++) {
            count += (ans[i]) * (sum - ans[i]);
            sum = sum - ans[i];
        }
        
        return count;

    }

    private static void dfs(ArrayList<ArrayList<Integer>> graph, int i, ArrayList<Integer> comp, boolean[] visited) {
        // TODO Auto-generated method stub
        visited[i] = true;
        comp.add(i);
        for (int val : graph.get(i)) {
            if (visited[val] == false) {
                dfs(graph, val, comp, visited);
            }
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int p = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> astronaut = new ArrayList<>();

        IntStream.range(0, p).forEach(i -> {
            try {
                astronaut.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
