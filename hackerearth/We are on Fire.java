import java.io.*;
public class We_Are_On_Fire {
	static int sum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = br.readLine().split(" ");
		int n = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);
		int q = Integer.parseInt(parts[2]);
		int[][] graph = new int[n + 1][m + 1];
		int count = 0;
		for(int i = 1; i < graph.length; i++) {
			String[] part = br.readLine().split(" ");
			for(int j = 1; j < graph[0].length; j++) {
				graph[i][j] = Integer.parseInt(part[j - 1]);
				count+=graph[i][j];
			}
		}
		boolean[][] visited = new boolean[n + 1][m + 1];
		for(int i = 0; i < q; i++) {
			String[] some = br.readLine().split(" ");
			dfs(graph, visited, Integer.parseInt(some[0]), Integer.parseInt(some[1]));
			System.out.println(count - sum);
			
		}
		
	}
	private static void dfs(int[][] graph, boolean[][] visited, int i, int j) {
		if(i < 0 || i > graph.length - 1 || j < 0 || j > graph[0].length - 1 || visited[i][j] || graph[i][j] == 0) {
			return;
		}
		
		sum++;
		visited[i][j] = true;
		dfs(graph,visited,i-1,j);
		dfs(graph,visited,i+1,j);
		dfs(graph,visited,i,j-1);
		dfs(graph,visited,i,j+1);
	}

}
