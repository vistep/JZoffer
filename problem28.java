package JZoffer;

import java.util.*;

public class problem28 {
	public static ArrayList<String> Permutation(String str) {
		if (str == null) {
			return null;
		}
		char[] chArr = str.toCharArray();
		int len = chArr.length;
		ArrayList<String> result = new ArrayList<String>();
		if (len == 0) {
			return result;
		}
		permuCore(result, chArr, 0, len - 1);
		return result;
	}

	public static void permuCore(ArrayList<String> result, char[] chArr,
			int begin, int end) {
		if (begin == end) {
			result.add(new String(chArr));
			System.out.println(new String(chArr));
			return;
		}
		for (int i = begin; i <= end; i++) {
			if (chArr[begin] == chArr[i] && begin != i) {
				continue;
			} else {
				char tmp = chArr[begin];
				chArr[begin] = chArr[i];
				chArr[i] = tmp;
			}
			permuCore(result, chArr, begin + 1, end);
			char tmp = chArr[begin];
			chArr[begin] = chArr[i];
			chArr[i] = tmp;
		}
	}

	public static void main(String[] args) {
		String s = "abcc";
		Permutation(s);
	}
}
