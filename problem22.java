package JZoffer;
import java.util.*;
public class problem22 {
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
    	if (pushA == null || popA == null) {
    		return false;
    	}
        Stack<Integer> stack = new Stack<Integer>();
        int lenPush = pushA.length;
        int lenPop = popA.length;
        if (lenPush != lenPop) {
        	System.out.println("Lengths of two array does no equal!");
        	return false;
        }
        int i = 0;
        int j = 0;
        while (i < lenPush) {
        	if (pushA[i] == popA[j]) {
        		i++;
        		j++;
        	} else {
        		stack.push(Integer.valueOf(pushA[i]));
        		i++;
        	}
        }
//        return true;
        if (stack.empty()) {
        	return true;
        } else {
        	while (j < lenPop) {
        		if (popA[j] == stack.peek().intValue()) {
        			stack.pop();
        			j++;
        		} else {
        			return false;
        		}
        	}
        	if (stack.empty()) {
        		return true;
        	} else {
        		return false;
        	}
        }
        
    }
    
    public static void main(String[] args) {
    	int[] push = {1,2,3,4,5};
//    	int[] pop = {4,5,3,2,1};
    	int[] pop = {4,3,5,1,2};
    	if(IsPopOrder(push,pop)) {
    		System.out.println("Yes");
    	} else {
    		System.out.println("No");
    	}
    }

}
