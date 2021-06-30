import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Oliver_And_The_Game {
 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) {
				System.out.println(0);
			}
			int[] arr = new int[n];
			for(int i = 0; i < n; i++) {
				arr[i] = i + 1;
			}
			
			if(n % 2 == 0) {
				for(int i = 0; i < n; i+=2) {
					swap(i, i + 1, arr);
				}
				for(int i = 0; i < n; i++) {
					System.out.print(arr[i] + " ");
				}
			}else {
				for(int i = 0; i < n - 1; i+=2) {
					swap(i, i + 1, arr);
				}
//				swap(arr[n - 2], arr[n - 1], arr);
				for(int i = 0; i < n - 2; i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.print(arr[n - 1] + " " + arr[n - 2]);
			}
			
			
			System.out.println();
		}
	}
	
	public static void swap(int a, int b, int[] arr) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
 
}
