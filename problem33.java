package JZoffer;

public class problem33 {
    public static String PrintMinNumber(int [] numbers) {
    	if (numbers == null) {
    		return null;
    	}
    	int len = numbers.length;
    	if (len == 0) {
    		return "";
    	}
    	int[] asist = new int[len];
    	int m = 0;
    	//detect the length of longest number
    	for (int i = 0; i < len; i++) {
    		int tmp = String.valueOf(numbers[i]).length();
    		if (tmp > m) {
    			m = tmp;
    		}
    	}
    	//build asist array
    	for (int i = 0; i < len; i++) {
    		StringBuffer realD = new StringBuffer(String.valueOf(numbers[i]));
    		int diff = m - realD.length();
    		char last = realD.charAt(realD.length() - 1);
    		for (int j = 0; j < diff; j++) {
    			realD.append(last);
    		}
    		asist[i] = Integer.parseInt(realD.toString());
//    		System.out.print(asist[i] + " ");
    	}
    	//sort with respect to aisit
    	sort(numbers, asist, 0, len - 1);
//    	for (int i = 0; i < len; i++) {
//    		System.out.print(asist[i] + " ");
//    	}
//    	System.out.println();
//    	for (int i = 0; i < len; i++) {
//    		System.out.print(numbers[i] + " ");
//    	}
    	StringBuffer result = new StringBuffer();
    	for (int i = 0; i < len; i++) {
    		result.append(String.valueOf(numbers[i]));
    	}
    	return result.toString();
    }
    
    public static void sort(int[] real, int[] asist, int begin, int end) {
//    	System.out.println("Enter sort");
    	if (begin < end) {
        	int index = partition(real, asist, begin, end);
        	sort(real, asist, begin, index - 1);
        	sort(real, asist, index + 1, end);
    	}
    }
    
    public static int partition(int[] real, int[] asist, int begin, int end) {
//    	System.out.println("enter partition");
//    	System.out.println("begin " + begin + "  end " + end);
    	int i = begin;
    	for (int j = begin + 1; j <= end; j++) {
//    		System.out.println("enter loop");
    		if (asist[j] < asist[begin]) {
//    			System.out.println("change data");
    			i++;
    			int tmp = asist[i];
    			asist[i] = asist[j];
    			asist[j] = tmp;
    			tmp = real[i];
    			real[i] = real[j];
    			real[j] = tmp;
    		}
    	}
    	int tmp = asist[begin];
		asist[begin] = asist[i];
		asist[i] = tmp;
		tmp = real[begin];
		real[begin] = real[i];
		real[i] = tmp;
    	return i;
    }
    
    public static void main(String[] args) {
    	int[] input = {3,32,321};
    	System.out.println(PrintMinNumber(input));
    }

}
