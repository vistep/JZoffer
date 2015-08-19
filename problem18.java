package JZoffer;

public class problem18 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        try {
        	if (root1.val == root2.val) {
        		result = DoesTree1HasTree2(root1, root2);
        	}
        	if (!result) {
        		result = HasSubtree(root1.left, root2);
        	}
        	if (!result) {
        		result = HasSubtree(root1.right, root2);
        	}
        } catch (NullPointerException e){
        	return false;
        }
        return result;
    }
    public boolean DoesTree1HasTree2(TreeNode root1, TreeNode root2) {
    	if (root2 == null) {
    		return true;
    	}
    	try {
    		if (root1.val == root2.val) {
    			return DoesTree1HasTree2(root1.left, root2.left) && DoesTree1HasTree2(root1.right, root2.right);
    		} else {
    			return false;
    		}
    	} catch (NullPointerException e) {
    		return false;
    	}
    }
}
