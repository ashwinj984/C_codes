class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        helper(root, map, ans);
        return ans;
    }
    
    public String helper(TreeNode root, HashMap<String, Integer> map, List<TreeNode> ans){
        if(root == null){
            return "X";
        }
        
        String left = helper(root.left, map, ans);
        String right = helper(root.right, map, ans);
        String temp = root.val + " " + left + right;
        map.put(temp, map.getOrDefault(temp, 0) + 1);
        if(map.get(temp) == 2){
            ans.add(root);
        }
        return temp;
    }
}
