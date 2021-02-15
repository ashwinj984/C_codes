class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
     HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<mat.length;i++)
        {
            int count = 0;
            for(int j=0;j<mat[i].length;j++)
            {
                if(mat[i][j]==1)
                    count++;
                else
                    break;
            }
            map.put(i,count);
        }
        
        
        int[] arr = new int[k];
        int l=0;
        int index=0;
        while(k!=0)
        {
            int min = Integer.MAX_VALUE;
            for(Map.Entry<Integer, Integer> pair:map.entrySet())
            {
                int key = pair.getKey(); // index
                int value = pair.getValue(); // number of soldier in each row
            
                if(min>value)
                {
                    min = value;
                    index = key;
                }
            }
            arr[l++] = index;
            map.put(index,Integer.MAX_VALUE);
            k--;
        }
        return arr;
    }
}


// Better Approach

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] ans = new int[k];
        int[] arr = new int[mat.length];
        for(int i = 0; i < mat.length; i++){
            int sum = 0;
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] == 0){
                    break;
                }else{
                    sum += mat[i][j];
                }
            }
            arr[i] = sum * 1000 + i;
        }
        
        Arrays.sort(arr);
        for(int i = 0; i < k; i++){
            ans[i] = arr[i] % 1000;
        }
        return ans;
    }
}
