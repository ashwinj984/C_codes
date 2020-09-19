import java.util.*;

public class leetcode1291 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int low = scn.nextInt();
		int high = scn.nextInt();
		ArrayList<Integer> res = new ArrayList<>();
		for(int i = low; i<= high; i++) {
			int num = i;
			String s = Integer.toString(num);
			int len = s.length();
			int[] arr = new int[len];
			for(int j = 0; j < len; j++) {
				arr[j] = num % 10;
				num = num / 10;
			}
			int count = 0;
			for(int j = arr.length - 1; j>=1; j--) {
				if(arr[j-1] - arr[j] == 1) {
					count++;
				}
			}
			if(count == arr.length - 1) {
				res.add(i);
			}
		}
		System.out.println(res);
	}
	
}
