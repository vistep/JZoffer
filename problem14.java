package JZoffer;

public class problem14 {
	public static boolean apply(int n) {
		if ((n & 0x01) == 0x01) {
			return true; //ÆæÊý
		} else {
			return false; //Å¼Êý
		}
	}
	public static void partition(int[] A) {
		int len = A.length;
		int i = -1;
		int j;
		for (j = 0; j < len; j ++) {
			if(apply(A[j])) {
				i++;
				int tmp = A[j];
				A[j] = A[i];
				A[i] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5,6,7};
		partition(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}

	}

}
