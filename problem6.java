package JZoffer;
import java.util.*;
public class problem6 {
	
	public static void search(node T) {
		if (T == null) {
			return;
		} else {

			search(T.left);
			search(T.right);
			System.out.print(T.val);

		}
	}
	
	public static void search1(node T) {
		List<node> stack = new ArrayList<node>();
		node p = T;
		while(p != null || !stack.isEmpty()) {
			if (p != null) {
				System.out.print(p.val);
				stack.add(p);
				p = p.left;
			} else {
				
				
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

	}

}
