import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Connected_Horses {
	static int mod = (int) 1e9 + 7;
	static int sum;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		long[] fact = new long[100001];
		fact[0] = 1;
		for (int i = 1; i < fact.length; i++) {
			fact[i] = (fact[i - 1] * i) % mod;
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] parts = br.readLine().split(" ");
			int n = Integer.parseInt(parts[0]);
			int m = Integer.parseInt(parts[1]);
			int q = Integer.parseInt(parts[2]);

			int[][] arr = new int[n + 1][m + 1];
			for (int i = 0; i < q; i++) {
				String[] part = br.readLine().split(" ");
				int u = Integer.parseInt(part[0]);
				int v = Integer.parseInt(part[1]);
				arr[u][v] = 1;
			}
//			
			boolean[][] visited = new boolean[n + 1][m + 1];

			long ans = 1;
			for (int i = 1; i < n + 1; i++) {

				for (int j = 1; j < m + 1; j++) {
					if (visited[i][j] == false && arr[i][j] == 1) {
						sum = 0;
						dfs(visited, arr, i, j);
						ans = (ans * fact[sum]) % mod;
					}

				}

			}
			System.out.println(ans);
		}

	}

	public static void dfs(boolean[][] visited, int[][] arr, int p, int q) {
		if (p < 1 || p > arr.length - 1 || q < 1 || q > arr[0].length - 1 || visited[p][q] || arr[p][q] == 0) {
			return;
		}
		sum++;
		visited[p][q] = true;
		dfs(visited, arr, p - 2, q + 1);
		dfs(visited, arr, p - 2, q - 1);
		dfs(visited, arr, p - 1, q + 2);
		dfs(visited, arr, p - 1, q - 2);
		dfs(visited, arr, p + 1, q + 2);
		dfs(visited, arr, p + 1, q - 2);
		dfs(visited, arr, p + 2, q + 1);
		dfs(visited, arr, p + 2, q - 1);

	}

}
