package JZoffer;
import java.util.*;
public class problem21 {
	Stack<Integer> master;
	Stack<Integer> slave;
	
	public problem21() {
		master = new Stack<Integer>();
		slave = new Stack<Integer>();
	}
	
    public void push(int node) {
     Integer d = Integer.valueOf(node);
     if (master.empty()) {
    	 master.push(d);
    	 slave.push(d);
     } else {
    	 Integer preMin = slave.peek();
    	 if (d < preMin) {
    		 master.push(d);
    		 slave.push(d);
    	 } else {
    		 master.push(d);
    		 slave.push(preMin);
    	 }
     }
    }
    
    public void pop() {
        try {
        	master.pop();
        	slave.pop();
        } catch (EmptyStackException e) {
        	System.out.println("Stack is already empty!");
        }
    }
    
    public int top() {
        try {
        	return master.peek().intValue();
        } catch (EmptyStackException e) {
        	System.out.println("Stack is empty!");
        	return Integer.MAX_VALUE;
        }
    }
    
    public int min() {
        try {
        	return slave.peek().intValue();
        } catch (EmptyStackException e) {
        	System.out.println("Stack is empty!");
        	return Integer.MAX_VALUE;
        }
    }
}
