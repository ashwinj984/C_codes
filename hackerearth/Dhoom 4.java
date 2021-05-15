import java.util.*;
import java.io.*;
class Solution{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] part = br.readLine().split(" ");
        int src = Integer.parseInt(part[0]);
        int dest = Integer.parseInt(part[1]);

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        String[] parts = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Long.parseLong(parts[i]);
        }

        Queue<Integer> q = new ArrayDeque<>();
        int[] visited = new int[100000];
        Arrays.fill(visited,-1);
        visited[src] = 0;
        q.add(src);
        
        while(!q.isEmpty())
		{
			int num=q.poll();
			if(num==dest)
				break;
			for(int i=0;i<n;i++)
			{
				long val=arr[i];
				int v=(int) ((num*val)%100000);
				
				//System.out.println(v);
				if(visited[v]==-1)
				{
					visited[v]=visited[num]+1;
					q.add(v);
				}
			}
		}
        System.out.println(visited[dest]);
    }
}
