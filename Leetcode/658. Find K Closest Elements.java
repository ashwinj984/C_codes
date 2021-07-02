class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = binarySearch(arr, x);
        
      // leftmost index possible value
        int leftbound =  index - k - 1;
      // rightmost index possible value
        int rightbound = index + k - 1;
        while(leftbound < 0){
            leftbound++;
        }
        while(rightbound > arr.length - 1){
            rightbound--;
        }
        
      // from which to which index should answer be kept
        while(rightbound - leftbound + 1 > k){
            if(Math.abs(x - arr[leftbound]) <= Math.abs(x - arr[rightbound])){
                rightbound--;
            }else{
                leftbound++;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i = leftbound; i <= rightbound; i++){
            res.add(arr[i]);
        }
        return res;
    }
    // find the index of element in the array using binarysearch to save time
    public int binarySearch(int[] arr, int x){
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(arr[mid] == x){
                return mid;
            }
            if(arr[mid] < x){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
