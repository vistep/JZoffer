package JZoffer;

public class problem15 {
	public ListNode FindKthToTail(ListNode head,int k) {
		if (head == null || k < 1) {
			return null;
		} else {
			ListNode p1 = head;
			ListNode p2 = head;
			try {
				for(int i =0; i < k; i ++) {
					p1 = p1.next;
				}
				while (p1 != null) {
					p1 = p1.next;
					p2 = p2.next;
				}
				return p2;
			} catch (NullPointerException e) {
				return null;
			}
		}
    }
}
