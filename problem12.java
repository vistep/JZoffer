package JZoffer;

public class problem12 {
	public static void printTo(int n) {
		if (n <= 0) {
			System.out.println("Please input an positive number!");
		} else {
			printCore(n);
		}
	}
	public static void printCore(int n) {
		int[] array = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			array[i] = 0;
		}
		array[n] = 1;
		while (array[0] == 0) {
			print(array);
			for (int i = n; i > -1; i--) {
				if (i == n) {
					array[n]++;
				} else {
					if (array[i + 1] == 10) {
						array[i]++;
						array[i + 1] = 0;
					}
				}
			}

		}
	}
	public static void print(int[] array) {
		int len = array.length;
		boolean zeroBegin = true;
		for (int i = 0; i < len; i++) {
			if (zeroBegin && array[i] == 0) {
				continue;
			} else {
				System.out.print(array[i]);
				zeroBegin = false;
			}
		}
		System.out.println();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printTo(1);

	}

}
