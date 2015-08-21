package JZoffer;

public class problem38 {
    public static int GetNumberOfK(int [] array , int k) {
    	if (array == null) {
    		return -1;
    	}
        int len = array.length;
        if (len == 0) {
        	return -1;
        }
        int index1 = getFirstK(array, k, 0 ,len - 1);
        int index2 = getLastK(array, k, len, 0, len - 1);
        if (index1 != -1 && index2 != -1) {
        	return index2 - index1 + 1;
        } else {
        	return -1;
        }
    }
    
    public static int getFirstK(int[] array, int k, int begin, int end) {
    	if (begin > end) {
    		return -1;
    	}
    	int middle = (begin + end) >> 1;
    	if (array[middle] < k) {
			return getFirstK(array, k, middle + 1, end);
		} else if (array[middle] > k) {
			return getFirstK(array, k, begin, middle - 1);
		} else {
			try {
				if (array[middle - 1] == k) {
					return getFirstK(array, k, begin, middle - 1);
				} else {
					return middle;
				}
			} catch (IndexOutOfBoundsException e) {
				return 0;
			}
		}
    }
    
    public static int getLastK(int[] array, int k, int length, int begin, int end) {
    	if (begin > end) {
    		return -1;
    	}
    	int middle = (begin + end) >> 1;
    	if (array[middle] < k) {
			return getLastK(array, k, length, middle + 1, end);
		} else if (array[middle] > k) {
			return getLastK(array, k, length, begin, middle - 1);
		} else {
			try {
				if (array[middle + 1] == k) {
					return getLastK(array, k, length, middle + 1, end);
				} else {
					return middle;
				}
			} catch (IndexOutOfBoundsException e) {
				return length - 1;
			}
		}
    }
    
    public static void main(String[] args) {
    	int[] input = {1,2,3,3,3,3,4,5};
    	System.out.println(GetNumberOfK(input,7));
    }
    

}
