import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Minimizing_Path_Cost {

	public static class Edge {
		int src;
		int nbr;
		int wt;

		Edge(int src, int dest, int wt) {
			this.src = src;
			this.wt = wt;
			this.nbr = dest;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		HashMap<String, Integer> map = new HashMap<>();
		String[] cities = br.readLine().split(" ");
		if (cities.length != n) {
			return;
		}

		for (int i = 0; i < n; i++) {
			map.put(cities[i], i);
		}

		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(i, new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			String[] paths = br.readLine().split(" ");
			int u = map.get(paths[0]);
			int v = map.get(paths[1]);
			int wt = Integer.parseInt(paths[2]);
			graph.get(u).add(new Edge(u, v, wt));
			graph.get(v).add(new Edge(v, u, wt));
		}
		int q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i++) {
			boolean[] visited = new boolean[n];
			String[] sd = br.readLine().split(" ");
			int src = map.get(sd[0]);
			int dest = map.get(sd[1]);
			int val = djikstra(src, dest, graph,visited);
			System.out.println(val);
		}
	}

	private static int djikstra(int src, int dest, ArrayList<ArrayList<Edge>> graph, boolean[] visited) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(src, 0));
		while(!pq.isEmpty()) {
			Pair rem = pq.remove();
			if(rem.v == dest) {
				return rem.wt;
			}
			if(visited[rem.v]) {
				continue;
			}
			
			visited[rem.v] = true;
			
			for(Edge e : graph.get(rem.v)) {
				if(!visited[e.nbr]) {
					pq.add(new Pair(e.nbr, e.wt + rem.wt));
				}
			}
		}
		return -1;
	}
	static class Pair implements Comparable<Pair>{
		int v;
		int wt;
		Pair(int v, int wt){
			this.v = v;
			this.wt = wt;
		}
		@Override
		public int compareTo(Pair o) {
			
			return this.wt - o.wt;
		}
		
	}

}
