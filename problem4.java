package JZoffer;

public class problem4 {
	public static String replace(String s) {
		char[] chArr = s.toCharArray();
		int num = 0;
		for (int i = 0; i < chArr.length; i++) {
			if (chArr[i] == ' ') {
				num++;
			}
		}
		System.out.println("num is " + num);
		char[] newArr = new char[chArr.length + num * 2];
		int i, j;
		for (i = 0, j = 0; i < newArr.length && j < chArr.length; ) {
			if(chArr[j] == ' ') {
				newArr[i++] = '%';
				newArr[i++] = '2';
				newArr[i++] = '0';
				j++;
			} else {
				newArr[i++] = chArr[j++];
			}
		}
		System.out.println("newArr.length " + newArr.length);
		System.out.println("chArr.length " + chArr.length);
		System.out.println("i = " + i);
		System.out.println("j = " + j);
		if (i != newArr.length || j != chArr.length) {
			System.err.println("An error happened!");
			return "";
		} else {
			String tmp = new String(newArr);
			return tmp;
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = " We are Happy. ";
		String replaced = replace(s);
		System.out.println(replaced);		
	}

}
