package JZoffer;

public class problem33b {
    public static String PrintMinNumber(int [] numbers) {
    	if (numbers == null) {
    		return null;
    	}
    	int len = numbers.length;
    	if (len == 0) {
    		return "";
    	}
    	String[] nub = new String[len];
    	for (int i = 0; i < len; i++) {
    		nub[i] = String.valueOf(numbers[i]);
    	}
    	String result = recur(nub, 0 , len - 1);
    	return result;
    }
    
    public static String recur(String[] s, int begin, int end) {
    	if (begin == end) {
    		return s[begin];
    	} else {
    		return combine(s[begin], recur(s, begin + 1, end));
    	}
    }
    	
    		

    public static String combine(String s1, String s2) {
    	String comb1 = s1 + s2;
    	String comb2 = s2 + s1;
    	if (comb1.compareTo(s2) < 0) {
    		return comb1;
    	} else {
    		return comb2;
    	}
    }
    
    public static void main(String[] args) {
    	int[] input = {3,5,1,4,2};
    	System.out.println(PrintMinNumber(input));
    }
}
