class Solution {
    String[][] res;
    int height;
    public List<List<String>> printTree(TreeNode root) {
        int level = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(q.size() > 0){
            level++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
        }
        int n = (int)(Math.pow(2, level) - 1);
        res = new String[level][n];
        height = level - 1;
        for(String[] dp : res){
            Arrays.fill(dp, "");
        }
        populate(root, 0, (n - 1) / 2);
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i < res.length; i++){
            List<String> list = new ArrayList<>();
            for(int j = 0; j < res[i].length; j++){
                list.add(res[i][j]);
            }
            ans.add(list);
        }
        return ans;
    }
    
    public void populate(TreeNode root, int r, int c){
        if(root == null){
            return;
        }
        
        res[r][c] = String.valueOf(root.val);
        int leftPos =  (int) (Math.pow(2, height - r - 1));
        populate(root.left, r + 1, c - leftPos);
        populate(root.right, r + 1, c + leftPos);
    }
}
