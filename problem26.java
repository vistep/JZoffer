package JZoffer;

public class problem26 {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
        	return null;
        }
        naiveClone(pHead);
        relationClone(pHead);
        return seperate(pHead);
    }
    
    public void naiveClone(RandomListNode p) {
    	while (p != null) {
    		RandomListNode pNew = new RandomListNode(p.label);
    		pNew.next = p.next;
    		p.next = pNew;
    		p = pNew.next;
    	}
    }
    
    public void relationClone(RandomListNode p){
    	while (p != null) {
    		if (p.random != null) {
    			p.next.random = p.random.next;
    		}
    		p = p.next.next;
    	}
    }
    
    public RandomListNode seperate(RandomListNode p) {
    	RandomListNode newLst = p.next;
    	RandomListNode pnew = p.next;
    	while(p != null) {
    		p.next = pnew.next;
    		if (p.next != null) {
    			pnew.next = p.next.next;
    			p = p.next;
    			pnew = pnew.next;
    		} else {
    			p = p.next;
    		}
    	}
    	return newLst;
    }

}
