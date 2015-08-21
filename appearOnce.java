package JZoffer;
import java.util.*;
public class appearOnce {
    public  static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null) {
        	num1[0] = 0;
        	num2[2] = 0;
        	return;
        }
        int len = array.length;
        if (len < 2) {
        	num1[0] = 0;
        	num2[0] = 0;
        	return;
        }
        Map<Integer, Integer> table = new HashMap<Integer, Integer>();
        for (int i = 0; i < len; i++) {
        	Integer key = Integer.valueOf(array[i]);
        	if (table.get(key) == null) {
        		table.put(key, Integer.valueOf(1));
        	} else {
        		table.remove(key);
        	}
        }
        if (table.size() != 2) {
        	num1[0] = 0;
        	num2[0] = 0;
        } else {
        	List<Integer> keys = new ArrayList<Integer>(table.keySet());
        	num1[0] = keys.get(0).intValue();
        	num2[0] = keys.get(1).intValue();
        }
    }
    
    public static void main(String[] args) {
    	int[] input = {1,5,5,2,8,8};
    	int[] n1 = new int[1];
    	int[] n2 = new int[1];
    	FindNumsAppearOnce(input, n1, n2);
    	System.out.println(n1[0]);
    	System.out.println(n2[0]);
    }
}
