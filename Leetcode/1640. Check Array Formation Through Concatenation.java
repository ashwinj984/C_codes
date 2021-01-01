//My Approach
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int[] list : pieces){
            map.put(list[0],new ArrayList<>());
            ArrayList<Integer> fill = new ArrayList<>();
            for(int i = 1; i < list.length; i++){
                fill.add(list[i]);
            }
            map.put(list[0],fill);
        }
        
        for(int i = 0; i < arr.length;){
            if(map.containsKey(arr[i]) == false){
                return false;
            }
            
            ArrayList<Integer> check = map.get(arr[i]);
            i++;
            for(int val : check){
                if(arr[i] != val || i >= arr.length){
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}
//Best Approach
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int[] index = new int[101];
        for(int i = 0; i < arr.length; i++){
            index[arr[i]] = i + 1;
        }
        
        for(int[] ps : pieces){
            if(index[ps[0]]  == 0){
                return false;
            }
            
            for(int i = 1; i < ps.length; i++){
                if(index[ps[i]] - index[ps[i - 1]] != 1){
                    return false;
                }
            }
        }
        
        return true;
    }
}
