
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0){
            List<TreeNode> node = new ArrayList<>();
            return node;
        }
        return helper(1, n);
    }
    
    public List<TreeNode> helper(int start, int end){
        List<TreeNode> list = new ArrayList<>(); 
        if(start > end){
            list.add(null);
            return list;
        }
        // always start from "start" and end at "end"
        for(int i = start; i <= end; i++){
            // keep faith in recursion and call left and get all the combinations
            List<TreeNode> left = helper(start, i - 1);
            // call right and get all possible combinations
            List<TreeNode> right = helper(i + 1, end);
            // after getting all possible combinations of left and right add node value as top
            for(var l : left){
                for(var r : right){
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    list.add(node);
                }
            }
        }
        return list;
    }
}
