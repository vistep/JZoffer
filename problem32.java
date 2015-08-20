package JZoffer;

public class problem32 {
    public static int NumberOf1Between1AndN_Solution(int n) {
        if (n < 1) {
        	return 0;
        }
        String s = String.valueOf(n);
        int m = s.length();
        char[] bits = s.toCharArray();
        if (m == 1) {
        	return 1;
        }
//        System.out.println("m= " + m);
        int sum;
        if (bits[0] == '1') {
        	sum = n%(int)Math.pow(10, m - 1) + 1;
        } else {
        	sum = (int)Math.pow(10, m - 1);
        }
        for (int i = 1; i < m; i++) {
//        	System.out.println("enter loop");
        	if (bits[i] == '0') {
        		sum = sum + n/(int)Math.pow(10, m - i) * (int)Math.pow(10, m - 1 - i);
        	} else if(bits[i] == '1') {
        		sum = sum + n/(int)Math.pow(10, m - i) * (int)Math.pow(10, m - 1 - i) + n%(int)Math.pow(10, m - 1 - i) + 1;
        	} else {
        		sum = sum + n/(int)Math.pow(10, m - i) * (int)Math.pow(10, m - 1 - i) + (int)Math.pow(10, m - 1 - i);
        	}
        }
        return sum;
    }
    
    public static void main(String[] args) {
    	int number = 21345;
    	System.out.println(NumberOf1Between1AndN_Solution(number));
    }
}
