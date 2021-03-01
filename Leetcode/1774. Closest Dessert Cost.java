// https://leetcode.com/problems/closest-dessert-cost/
class Solution {
    int result = 0;
    int min = Integer.MAX_VALUE;
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        for(int base: baseCosts){
            dfs(base, toppingCosts, 0, target);
        }
        return result;
    }
    
    public void dfs(int cost, int[] toppingCosts, int i, int target){
        if(i == toppingCosts.length){
            if(Math.abs(target - cost) < min){
                result = cost;
                min = Math.abs(target - cost);
                
            }
            return;
        }
        
        
        dfs(cost, toppingCosts, i + 1, target);
        dfs(cost + toppingCosts[i], toppingCosts, i + 1, target);
        dfs(cost + toppingCosts[i] * 2, toppingCosts, i + 1, target);
    }
}
