package JZoffer;
import java.util.*;
public class problem6 {
	
	public static void search(node T) {
		if (T == null) {
			return;
		} else {
//			System.out.print(T.val);
			search(T.left);
//			System.out.print(T.val);
			search(T.right);
			System.out.print(T.val);


		}
	}
	
	public static void search1(node T) {
		List<node> stack = new ArrayList<node>();
		node p = T;
		while(p != null || !stack.isEmpty()) {
			if (p != null) {
//				System.out.print(p.val);
				stack.add(p);
				p = p.left;
			} else {
				p = stack.get(stack.size() - 1);
				System.out.print(p.val);				
				stack.remove(stack.size() -1);
				p = p.right;				
			}
		}
	}
	
	public static void search2(node T) {
		if (T == null) {
			System.err.println("Empty tree!");
			return;
		}
		List<node> stack = new ArrayList<node>();
		node cur;
		node pre = null;
		stack.add(T);
		while (!stack.isEmpty()) {
			cur = stack.get(stack.size() - 1);
			if ((cur.left == null && cur.right == null) || 
					(pre != null && (cur.left == pre || cur.right == pre))) {
				System.out.print(cur.val);
				pre = cur;
				stack.remove(stack.size() - 1);
			} else {
				if (cur.right != null) {
					stack.add(cur.right);
				}
				if (cur.left != null) {
					stack.add(cur.left);
				}
			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] medorder = { 4, 7, 2, 1, 5, 3, 8, 6 };
		buildTree bt = new buildTree();
		node T = bt.construct(preorder, medorder, 8);
		search(T);
		System.out.println();
		search1(T);
		System.out.println();
		search2(T);

	}

}

class node {
	int val;
	node left;
	node right;
}

class buildTree {
	public node construct(int[] preorder, int[] medorder, int length) {
		if (preorder == null || medorder == null || length < 1) {
			return null;
		} else {
			return constructCore(preorder, medorder, 0, length - 1, 0, length - 1);
		}
	}

	public node constructCore(int[] preorder, int[] medorder, int pbegin,
			int pend, int mbegin, int mend) {
		if (pbegin > pend || mbegin > mend) {
			return null;
		} else {
			node cur = new node();
			cur.val = preorder[pbegin];
			int i;
			for (i = mbegin; i <= mend; i++) {
				if (medorder[i] == preorder[pbegin]) {
					break;
				}
			}
			cur.left = constructCore(preorder, medorder, pbegin + 1, pbegin + i
					- mbegin, mbegin, i - 1);
			cur.right = constructCore(preorder, medorder, pbegin + i - mbegin
					+ 1, pend, i + 1, mend);
			return cur;
		}
	}
}

