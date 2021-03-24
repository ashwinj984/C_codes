class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i : A){
            arr.add(i);
        }
        Collections.sort(arr);
        int j = 0;
        for(int i = 0; i < B.length; i++){
            
            int index = binarySearch(arr, B[i]);
            
            if(index != -1){
                A[j] = arr.get(index);
                arr.remove(index);
            }else{
                A[j] = arr.get(0);
                arr.remove(0);
            }
            j++;
        }
        return A;
    }
    
    public int binarySearch(ArrayList<Integer> arr , int target){
        
        int start = 0;
        int end = arr.size() - 1;
        int index = -1;
        
        while(start <= end){
            int mid = (start + end) / 2;
            int ele = arr.get(mid);
            
            if(ele <= target){
                start = mid + 1;
            }else{
                index = mid;
                end = mid - 1;
            }
        }
        return index;
    }
}
