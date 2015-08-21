package JZoffer;

public class problem40 {
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
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
        int remainder = 0;
        for(int i = 0; i < len; i ++) {
        	remainder ^= array[i];
        }
        System.out.printf("%x%n", remainder);
        int bits = 0;
        while (remainder != 0x01) {
        	remainder >>= 1;
            bits++;
        }
        System.out.printf("%x%n", remainder);
        remainder <<= bits;
        System.out.printf("%x%n", remainder);
        int n1 = 0;
        int n2 = 0;
        for (int i = 0; i < len; i++) {
        	if ((array[i] & remainder) == 0) {
        		System.out.print(array[i]);
        		n1 ^= array[i];
        	} else {
        		n2 ^= array[i];
        	}
        }
        num1[0] = n1;
        num2[0] = n2;
    }
    
    public static void main(String[] args) {
    	int[] input = {1,5,5,2,8,8};
    	int[] n1 = new int[1];
    	int[] n2 = new int[1];
    	FindNumsAppearOnce(input, n1, n2);
    	System.out.println();
    	System.out.println(n1[0]);
    	System.out.println(n2[0]);
    }
}
