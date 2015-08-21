package JZoffer;

public class problem37 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    	if (pHead1 == null || pHead2 == null) {
    		return null;
    	}
    	 ListNode p1 = pHead1;
    	 ListNode p2 = pHead2;
    	 while (p1 != null && p2!= null) {
    		 p1 = p1.next;
    		 p2 = p2.next;
    	 }
    	 ListNode p3 = null;
    	 ListNode p4 = null;
    	 if (p1 != null) {
    		 p3 = pHead1;
    		 while (p1 != null) {
    			 p1 = p1.next;
    			 p3 = p3.next;
    		 }
    		 p4 = pHead2;
    	 }
    	 if (p2 != null) {
    		 p3 = pHead2;
    		 while (p2 != null) {
    			 p2 = p2.next;
    			 p3 = p3.next;
    		 }
    		 p4 = pHead1;
    	 }
    	 while (p3 != p4) {
    		 p3 = p3.next;
    		 p4 = p4.next;
    	 }
    	 return p3;
    }
}
