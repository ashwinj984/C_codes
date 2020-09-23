import java.util.*;
public class carPooling {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		// Enter number of trips
		int n = scn.nextInt();
		// enter the number of stuffs you want to add
		// m should be 3 for all cases
		int m = scn.nextInt();
		
		int[][] trips = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				trips[i][j] = scn.nextInt();
			}
		}
		
		// enter the max capacity of the car
		int capacity = scn.nextInt();
		int[] arr = new int[1001];
		int max = 0;
		for(int i = 0; i < n ;i++) {
			// just adding the number of passengers on a given index
			arr[trips[i][1]] += trips[i][0];
			// just removing the number of passengers when they are reaching their destination
			arr[trips[i][2]] += -trips[i][0];
			// just store the last destination over here
			max = Math.max(max,trips[i][2]);
		}
		if(arr[0] > capacity )
			System.out.println(false);
		int count = 0;
		//this loop is to check whether ever the capacity has gone above limit or not if yes
		// return false
		//else true
		for(int i = 1; i <= max; i++) {
			arr[i] += arr[i-1];
			if(arr[i] > capacity) {
				System.out.println(false);
				break;
			}
			count++;
		}
		if(count == max)
		System.out.println(true);
	}
}
