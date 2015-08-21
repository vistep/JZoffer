package JZoffer;

public class problem36 {
	static int count;
    public static int InversePairs(int [] array) {
    	if (array == null) {
    		return -1;
    	}
    	int len = array.length;
    	if (len == 0) {
    		return -1;
    	}
    	count = 0;
        sort(array, 0 ,len -1);
        return count;
    }
    public static void sort(int[] array, int begin, int end) {
    	if (begin < end) {
    		int middle = (begin + end) / 2;
    		sort(array, begin, middle);
    		sort(array, middle + 1, end);
    		merge(array, begin, middle, end);
    	}
    }
    public static void merge(int[] array, int begin, int middle, int end) {
    	int len = end - begin + 1;
//    	System.out.println("begin " + begin + "  middle " + middle + "  end " + end + "  len " + len);
    	int[] tmpArr = new int[len];
    	int i = middle;
    	int j = end;
    	int k;
    	for (k = len - 1; k > -1 && i >= begin && j >= middle + 1; k--) {
    		if (array[i] > array[j]) {
    			count += j - middle;
//    			System.out.println("array[i] " + array[i] + "   array[j] " + array[j]);
    			tmpArr[k] = array[i--];
    		} else {
    			tmpArr[k] = array[j--];
    		}
    	}
    	while (i >= begin) {
    		tmpArr[k--] = array[i--];
    	}
    	while (j >= middle + 1) {
    		tmpArr[k--] = array[j--];
    	}
    	for (i = begin, k = 0; k < len;) {
    		array[i++] = tmpArr[k++];
    	}
//    	System.out.println("count " + count);
    }
    
    public static void main(String[] args) {
    	int[] A = {7,5,6,4};
    	System.out.println(InversePairs(A));
    }

}
