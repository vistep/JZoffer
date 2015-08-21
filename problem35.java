package JZoffer;
import java.util.*;
public class problem35 {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str == "") {
        	return -1;
        }
        char[] chArr = str.toCharArray();
        //initial
        Map<Character,Integer> table = new HashMap<Character,Integer>();
        for (int c = (int)'a'; c <= (int)'z'; c++) {
        	table.put(Character.valueOf((char)c), Integer.valueOf(0));
        }
        for (int c = (int)'A'; c <= (int)'Z'; c++) {
        	table.put(Character.valueOf((char)c), Integer.valueOf(0));
        }
        //count
        for (int i = 0; i < chArr.length; i++) {
        	Character key = Character.valueOf(chArr[i]);
        	table.put(key, table.get(key) + Integer.valueOf(1));
        }
        //search
        for (int i = 0; i < chArr.length; i++) {
        	if (table.get(Character.valueOf(chArr[i])) == Integer.valueOf(1)) {
        		return i;
        	}
        }
        //no one appears exactly once
        return -1;
    }

}
