//https://leetcode.com/problems/binary-tree-tilt/

class Solution {
    public int findTilt(TreeNode root) {
          tilt(root);
        return tilt;
    }
    
    
    
     int tilt = 0;

    private  int tilt(TreeNode node) {
		if (node == null) {
			return 0;
		}

		int ls = tilt(node.left);
		int rs = tilt(node.right);

		int ltilt = Math.abs(ls - rs);
		tilt += ltilt;
		return ls + rs + node.val;
	}
    
    
}
