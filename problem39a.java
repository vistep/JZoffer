package JZoffer;

public class problem39a {
	boolean flag = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
        	return true;
        }
        TreeDepth(root);
        return flag;
    }
    public int TreeDepth(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	int left = TreeDepth(root.left);
    	int right = TreeDepth(root.right);
    	if (Math.abs(left - right) > 1) {
    		flag = false;
    	}
        return (left > right) ? (left + 1) : (right + 1);
    }
}
