// Linear Search

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        
        for(int i = 0; i < citations.length ; i++){
            int h = citations.length - i;
            
            if(citations[i] >= h){
                return h;
            }
        }
        return 0;
    }
}

// Binary Search

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        
        int lo = 0;
        int hi = citations.length - 1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            
            if(citations[mid] == citations.length - mid){
                return citations[mid];
            }else if(citations[mid] > citations.length - mid){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return citations.length - lo;
    }
}
