// Brute Force

class Solution {
    int count = 0;
    int target = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return count;
        }
        target = sum;
        outerDFS(root);
        return count;
    }
    
    public void outerDFS(TreeNode root){
        if(root != null){
            innerDFS(root, 0);
            outerDFS(root.left);
            outerDFS(root.right);
        }
    }
    
    public void innerDFS(TreeNode root, int currSum){
        if(root != null){
            currSum += root.val;
            if(currSum == target)
                count++;
            
            innerDFS(root.left, currSum);
            innerDFS(root.right, currSum);
        }
    }
}

// Optimized Using HashMap and prefix sum concept
// Not mine

class Solution {
    int count = 0;
    Map<Integer, Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int sum) {
        preorder(root, sum, 0);
        return count;
    }
    
    private void preorder(TreeNode root, int target, int currSum) {    
        if(root != null){
            currSum += root.val;
            if(currSum == target) count++;            
            if (map.containsKey(currSum - target)) 
                count += map.get(currSum - target);
            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
			
            preorder(root.left, target, currSum);
            preorder(root.right, target, currSum);
            
			map.put(currSum, map.get(currSum) - 1);
        }
    }
}
