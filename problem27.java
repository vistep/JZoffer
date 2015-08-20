package JZoffer;

class lastNode {
	TreeNode node = null;
}

public class problem27 {

    public static TreeNode Convert(TreeNode pRootOfTree) {
       if (pRootOfTree == null) {
    	   return null;
       }
       lastNode last = new lastNode();
       Core(pRootOfTree, last);
       TreeNode p = last.node;
       while (p.left != null) {
    	   p = p.left;
       }
       return p;
    }
    
    public static void Core(TreeNode cur, lastNode last) {
    	if (cur == null) {
    		return;
    	} 
    	
//    	if (cur.left != null) {
    		Core(cur.left, last);
//    	}
    	
    	cur.left = last.node;
    	if(last.node != null) {
    		last.node.right = cur;
    	}
    	last.node = cur;
    	
//    	if (cur.right != null) {
    		Core(cur.right, last);
//    	}
    }
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(10);
    	root.left = new TreeNode(6);
    	root.left.left = new TreeNode(4);
    	root.left.right = new TreeNode(8);
    	root.right = new TreeNode(14);
    	root.right.left = new TreeNode(12);
    	root.right.right = new TreeNode(16);
    	
    	TreeNode p = Convert(root);
    	while (p != null) {
    		System.out.print(p.val + " ");
    		p = p.right;
    	}
//    	System.
    	
    }

}
