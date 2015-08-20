package JZoffer;

public class problem31 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null) {
        	System.out.println("Null Pointer!");
        	return 0;
        }
        int len = array.length;
        if (len == 0) {
        	System.out.println("Array is empty!");
        	return 0;
        }
        int[] f = new int[len];
        int maxvalue;
        f[0] = array[0];
        maxvalue = f[0];
        for (int i = 1; i < len; i++) {
        	if (f[i-1] < 0) {
        		f[i] = array[i];
        	} else {
        		f[i] = f[i-1] + array[i];
        	}
        	if (f[i] > maxvalue) {
        		maxvalue = f[i];
        	}
        }
        return maxvalue;
    }
}
