package JZoffer;

public class problem16 {
    public ListNode ReverseList(ListNode head) {
    	if (head == null) {
    		return null;
    	}
    	if (head.next == null) {
    		return head;
    	}
    	ListNode p1 = head;
    	ListNode p2 = head.next;
    	p1.next = null;
    	ListNode tmp = null;
    	while (p2 != null) {
    		tmp = p2.next;
    		p2.next = p1;
    		p1 = p2;
    		p2 = tmp;
    	}
    	return p1;
    }

}
