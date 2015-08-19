package JZoffer;

public class problem24 {
    public static boolean VerifySquenceOfBST(int [] sequence) {
    	if (sequence == null) {
    		return false;
    	}
        int len = sequence.length;
        if (Core(sequence, 0, len - 1)) {
        	return true;
        } else {
        	return false;
        }
    }
    public static boolean Core(int[] seq, int begin, int end){
    	if (begin == end) {
    		return true;
    	}
    	int left = begin - 1;
    	for (int i = begin; i < end; i++) {
    		if (seq[i] < seq[end]) {
    			left++;
    		} else {
    			break;
    		}
    	}
    	for (int i = (left + 1); i < end; i++) {
    		if (seq[i] < seq[end]) {
    			return false;
    		}
    	}
    	
    	if (left == (begin - 1) || left == (end - 1)) { //only one tree left
    		return Core(seq, begin, end - 1);
    	} else {
    		return Core(seq, begin, left) && Core(seq, left + 1, end - 1);
     	}
    }
    
    public static void main(String[] args) {
    	int[] A = {5,7,6,9,11,10,8};
//    	int[] A = {7,4,2,1,6,5};
    	if(VerifySquenceOfBST(A)) {
    		System.out.println("Yes");
    	} else {
    		System.out.println("No");
    	}
    }
}
