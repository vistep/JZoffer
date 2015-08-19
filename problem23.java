package JZoffer;
import java.util.*;
public class problem23 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    	if (root == null) {
    		return null;
    	}
        ArrayList<Integer> result = new ArrayList<Integer>();
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
        	TreeNode cur = queue.pollFirst();
        	result.add(cur.val);
        	if (cur.left != null) {
        		queue.addLast(cur.left);
        	}
        	if (cur.right != null) {
        		queue.addLast(cur.right);
        	}
        }
        return result;
    }
}
