class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size)
    {
        int shift = segregate(arr, size);
        int[] arr2 = new int[size - shift];
        int j = 0;
        for(int i = shift; i < arr.length; i++){
            arr2[j] = arr[i];
            j++;
        }
        
        int ans = findMissingNumber(arr2, arr2.length);
        return ans;
    }
    
    static int segregate(int[] arr, int size){
        int j = 0;
        for(int i = 0; i < size; i++){
            if(arr[i] <= 0){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }
        return j;
    }
    static int findMissingNumber(int[] arr, int size){
        for(int i = 0; i < size; i++){
            int val = Math.abs(arr[i]);
            if(val - 1 < size && arr[val - 1] > 0){
                arr[val - 1] = -arr[val - 1];
            }
        }
        for(int i = 0; i < size; i++){
            if(arr[i] > 0){
                return i + 1;
            }
        }
        return size + 1;
    }
}
