package JZoffer;

public class problem17 {
    public static ListNode Merge(ListNode list1,ListNode list2) {
    	if (list1 == null && list2 == null) {
    		return null;
    	}
    	if (list1 == null && list2 != null) {
    		return list2;
    	}
    	if (list1 != null && list2 == null) {
    		return list1;
    	}
    	ListNode p;
    	if (list1.val < list2.val) {
    		p = list1;
    		list1 = list1.next;
    	} else {
    		p = list2;
    		list2 = list2.next;
    	}
    	while (list1 != null && list2 != null) {
    		System.out.print(p.val);
    		if (list1.val < list2.val) {
    			p.next = list1;
    			list1 = list1.next;
    			p = p.next;
    		} else {
    			p.next = list2;
    			list2 = list2.next;
    			p = p.next;
    		}
    	}
    	if (list1 != null) {
    		p.next = list1;
    	}
    	if (list2 != null) {
    		p.next = list2;
    	}
        return p;
    }
    
    public static void main(String[] args) {
    	int[] a1 = {1,3,5,5,5,5,6,7};
    	int[] a2 = {2,4,9,6};
    	ListNode list1 = buildList.build(a1);
    	ListNode list2 = buildList.build(a2);
    	buildList.printList(list1);
    	buildList.printList(list2);
    	ListNode merged = Merge(list1,list2);
    	buildList.printList(merged);
    }
    
}
