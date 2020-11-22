//https://leetcode.com/contest/weekly-contest-216/problems/ways-to-make-a-fair-array/
class Solution {
    public int waysToMakeFair(int[] nums) {
        int count = 0;
        int osum = 0;
        int esum = 0;
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length;++i){
            int l = 0;
            int k = 1;
            for(int j = 0; j < nums.length;++j){
                if(i == j)
                    continue;
                else{
                    res.add(nums[j]);
                }
            }
            while(l < res.size()){
                    esum += res.get(l);
                    
                    l+=2;
                    
                }
            while( k < res.size()){
                osum += res.get(k);
                k+=2;
            }
                if(esum == osum){
                    count++;
                }
            esum = 0;
            osum = 0;
            l = 0;
            k = 1;
            res=new ArrayList<>();
        }
        return count;
    }
}
//TLE

//Better Approach

class Solution {
    public int waysToMakeFair(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int count=0,sum=0,oddSum=0,evenSum=0,tempOdd=0,tempEven=0,tempSum=0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(i%2 == 0)
            evenSum += nums[i];
            else
            oddSum += nums[i];
           }
        tempSum = sum - nums[0];
        tempEven = oddSum;
        tempOdd = tempSum - tempEven;
        if(tempEven == tempOdd)
            count++;
        for(int i=1;i<nums.length;i++){
        tempSum = sum - nums[i];
        if(i%2 == 1)
        tempEven = tempSum - tempOdd;
        else
        tempOdd = tempSum - tempEven;
        if(tempOdd == tempEven)
        count++;
        }

    return count;
}
}
