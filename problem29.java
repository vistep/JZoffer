package JZoffer;

public class problem29 {
//    public int MoreThanHalfNum_Solution(int [] array) {
//    	if (array == null) {
//    		return 0;
//    	}
//    	int len = array.length;
//    	if (len == 0) {
//    		return 0;
//    	}
//        int number = array[0];
//        int count = 1;
//        for (int i = 1; i < len; i++) {
//        	if (count == 0) {
//        		number = array[i];
//        		count++;
//        	} else {
//        		if (number == array[i]) {
//        			count++;
//        		} else {
//        			count--;
//        		}
//        	}
//        }
//        count = 0;
//        for (int i = 0; i < len; i++) {
//        	if (array[i] == number) {
//        		count++;
//        	}
//        }
//        if (count > (len>>1)) {
//        	return number;
//        } else {
//        	return 0;
//        }
//    }
	
	public int MoreThanHalfNum_Solution(int[] array) {
		if (array == null) {
			return 0;
		}
		int len = array.length;
		if (len == 0) {
			return 0;
		}
		int begin = 0;
		int end = len - 1;
		int index = partition(array, begin, end);
		int middle = len >> 1;
		while (index != middle) {
			if (index < middle) {
				begin = index + 1;
				index = partition(array, begin, end);
			} else {
				end = index - 1;
				index = partition(array, begin, end);
			}
		}
		int number = array[middle];
		int count = 0;
		for (int i = 0; i < len; i++) {
			if (array[i] == number) {
				count++;
			}
		}
		if (count > (len >> 1)) {
			return number;
		} else {
			return 0;
		}
	}
	
	public int partition(int[] array, int begin, int end) {
		if (begin == end) {
			return begin;
		}
		int i = begin;
		for (int j = begin + 1; j <= end; j++) {
			if (array[j] < array[begin]) {
				i++;
				int tmp = array[j];
				array[j] = array[i];
				array[i] = tmp; 
			}
		}
		int tmp = array[i];
		array[i] = array[begin];
		array[begin] = tmp;
		return i;
	}
}
