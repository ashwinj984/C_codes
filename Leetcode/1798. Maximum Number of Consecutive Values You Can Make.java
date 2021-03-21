// Best   Code
public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int prev = 0;
        for(int i:coins) {
            if(i-prev<=1)  prev = prev+i;
            else break;
        }
        return prev+1;
    }

// Time Limit Exceeded

import java.math.BigInteger;
class Solution {
    public int getMaximumConsecutive(int[] coins) {
        
        int n = coins.length;
        List<List<Integer>> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        set.add(0);
         // Pick starting point
        int opsize = (int)Math.pow(2, n);
      
        /* Run from counter 000..1 to 111..1*/
        for (int counter = 1; counter < opsize; counter++)
        {
            List<Integer> res = new ArrayList<>();
            for (int j = 0; j < n; j++)
            {
                /* Check if jth bit in the counter is set
                    If set then print jth element from arr[] */
       
                if (BigInteger.valueOf(counter).testBit(j)){
                    res.add(coins[j]);
                }
                    
            }
            list.add(res);
            
        }
        //System.out.println(list);
        for(int i = 0; i < list.size(); i++){
            int sum = 0;
            for(int j = 0; j < list.get(i).size(); j++){
                sum += list.get(i).get(j);
            }
            set.add(sum);
        }
        //System.out.println(set);
        List<Integer> ans = new ArrayList<>(set);
        int count = 1;
        for(int i = 1; i < ans.size(); i++){
            if(ans.get(i) - ans.get(i - 1) != 1){
                break;
            }
            count++;
        }
        return count;
    }
}
