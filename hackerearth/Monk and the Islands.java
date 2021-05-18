// https://www.hackerearth.com/practice/algorithms/graphs/breadth-first-search/practice-problems/algorithm/monk-and-the-islands/
import java.util.*;

import java.io.*;

public class Monk_And_Islands {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] parts = br.readLine().split(" ");
			int n = Integer.parseInt(parts[0]);
			int m = Integer.parseInt(parts[1]);
			ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
			for (int i = 0; i < n + 1; i++) {
				graph.add(i, new ArrayList<>());
			}
			for (int i = 0; i < m; i++) {
				String[] part = br.readLine().split(" ");
				int u = Integer.parseInt(part[0]);
				int v = Integer.parseInt(part[1]);
				graph.get(u).add(v);
				graph.get(v).add(u);
			}
			boolean[] visited = new boolean[n + 1];
			int[] dist = new int[n + 1];
			bfs(visited, dist, 1, graph);
			System.out.println(dist[n]);
		}
	}

	public static void bfs(boolean[] visited, int[] dist, int src, ArrayList<ArrayList<Integer>> graph) {
		Queue<Integer> q = new ArrayDeque<>();
		int n = visited.length - 1;
		q.add(src);
		visited[src] = true;
		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int i : graph.get(curr)) {
				if (visited[i] == false) {
					q.add(i);
					visited[i] = true;
					dist[i] = dist[curr] + 1;
				}
			}
		}
	}

}
