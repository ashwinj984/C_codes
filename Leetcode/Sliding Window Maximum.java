import java.util.*;

public class SlidingWindowMaximum {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int count = 0;
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		int i = 0;
		int j = k - 1;
		for (int m = 0; m < n && i <= n - k; m++) {
			if (count == n - k + 1) {
				break;
			}
			Stack<Integer> st = new Stack<>();
			st.push(arr[i]);
			while (i < j) {
				if (arr[i + 1] > st.peek()) {
					st.pop();
					// System.out.println(st.pop());
					st.push(arr[i + 1]);

				}
				i++;

			}
			System.out.println(st.peek());
			count++;
			i = i - 2;
			j++;
			st.clear();
		}
	}
}

//Not much efficient coming up with a new logic soon
