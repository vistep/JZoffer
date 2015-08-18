package JZoffer;

import JZoffer.node;

public class buildTree {
	public node construct(int[] preorder, int[] medorder, int length) {
		if (preorder == null || medorder == null || length < 1) {
			return null;
		} else {
			return constructCore(preorder, medorder, 0, length - 1, 0, length - 1);
		}
	}

	public node constructCore(int[] preorder, int[] medorder, int pbegin,
			int pend, int mbegin, int mend) {
		System.out.print("pbegin " + pbegin + "  ");
		System.out.print("pend " + pend + "  ");
		System.out.print("mbegin " + mbegin + "  ");
		System.out.print("mend " + mend + " ");
		System.out.println();
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
			System.out.println("i = " + i);
			cur.left = constructCore(preorder, medorder, pbegin + 1, pbegin + i
					- mbegin, mbegin, i - 1);
			cur.right = constructCore(preorder, medorder, pbegin + i - mbegin
					+ 1, pend, i + 1, mend);
			return cur;
		}
	}
}
