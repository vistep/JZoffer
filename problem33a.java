package JZoffer;

public class problem33a {
    public static String PrintMinNumber(int [] numbers) {
    	if (numbers == null) {
    		return null;
    	}
    	int len = numbers.length;
    	if (len == 0) {
    		return "";
    	}
    	String result = String.valueOf(numbers[0]);
    	for (int i = 1; i < len; i++) {
    		result = combine(result, String.valueOf(numbers[i]));
    	}
    	return result;
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
