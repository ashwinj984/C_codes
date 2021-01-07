class Solution {
    public int findKthPositive(int[] arr, int k) {
        int idx = 0, value = 1;
		while (idx < arr.length && k != 0) {
			if (arr[idx] == value) {
				idx++;
			} else {
				k--;
				if (k == 0) {
					return value;
				}
			}
			value++;
		}
		return value + k - 1;
    }
}
