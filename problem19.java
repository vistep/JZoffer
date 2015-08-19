package JZoffer;

public class problem19 {
    public void Mirror(TreeNode root) {
        if (root == null) {
        	return;
        }      
        TreeNode tmp;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
