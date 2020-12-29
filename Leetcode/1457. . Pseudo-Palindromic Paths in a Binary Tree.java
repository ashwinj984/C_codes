
class Solution {
    private  int ans = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int[] freq = new int[10];
        helper(root,freq);
        return ans;
    }
    
    private  void helper(TreeNode root, int[] freq){
        if(root == null){
            return;
        }
        
        freq[root.val]++;
        if(root.left == null && root.right == null){
            boolean check2 = check(freq);
            if(check2){
                ans++;
            }
        }
        
        helper(root.left,freq);
        helper(root.right,freq);
        
        freq[root.val]--;
    }
        private boolean check(int[] freq){
            boolean check = false;
            for(int val : freq){
                if(val % 2 != 0){
                    if(check == true)
                    return false;
                else{
                    check = true;
                }
             }
        }
        return true;
    }
}
