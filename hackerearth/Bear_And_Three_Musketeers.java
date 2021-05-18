import java.io.*;
import java.util.ArrayList;

public class Bear_And_Three_Musketeers {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = br.readLine().split(" ");
		int n = Integer.parseInt(parts[0]);
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(i, new ArrayList<>());
		}
		boolean[][] mat = new boolean[n + 1][n + 1];
		int[] recog = new int[n + 1];
		int m = Integer.parseInt(parts[1]);
		for (int i = 0; i < m; i++) {
			String[] part = br.readLine().split(" ");
			int u = Integer.parseInt(part[0]);
			int v = Integer.parseInt(part[1]);
			graph.get(u).add(v);
			graph.get(v).add(u);
			mat[u][v] = true;
			mat[v][u] = true;
			recog[u]++;
			recog[v]++;
		}
		int ans = Integer.MAX_VALUE;
		int res = 0;
		for (int i = 1; i <= n; i++) {
			if (graph.get(i).size() > 1) {
				for (int j = 1; j <= n; j++) {
					if (graph.get(j).size() > 1 && j != i && mat[i][j]) {
						for (int k = 1; k <= n; k++) {
							if (k != i && k != j && graph.get(k).size() > 1 && mat[k][j] && mat[k][i]) {
								res = recog[i] - 2 + recog[j] - 2 + recog[k] - 2;
								ans = Math.min(res, ans);
							}
						}
					}
				}
			}
		}
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
	}

}
