package JZoffer;

public class buildList {
	public static ListNode build(int[] A) {
		int len = A.length;
		if (len == 0){
			return null;
		}
		if (len == 1) {
			ListNode head = new ListNode(A[0]);
			return head;
		}
		ListNode head = new ListNode(A[0]);
		ListNode p = head;
		for (int i = 1; i < len; i++) {
			p.next = new ListNode(A[i]);
			p = p.next;
		}
		return head;
	}
	
	public static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val);
			head = head.next;
		}
		System.out.println();
	}

}
